package org.ecommerce.loadtesting;

import com.github.javafaker.Faker;
import io.gatling.javaapi.core.CoreDsl;
import io.gatling.javaapi.core.OpenInjectionStep;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpDsl;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import java.time.Duration;
import java.util.*;
import java.util.stream.Stream;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class RestockSimulation extends Simulation {


    private static final HttpProtocolBuilder HTTP_PROTOCOL_BUILDER = setupProtocolForSimulation();

    private static final Iterator<Map<String, Object>> FEED_DATA = setupTestFeedData();

    private static final ScenarioBuilder POST_SCENARIO_BUILDER = buildPostScenario();

    public RestockSimulation() {
        setUp(POST_SCENARIO_BUILDER.injectOpen(postEndpointInjectionProfile())
                .protocols(HTTP_PROTOCOL_BUILDER)).assertions(global().responseTime()
                .max()
                .lte(10000), global().successfulRequests()
                .percent()
                .gt(90d));
    }

    private OpenInjectionStep.RampRate.RampRateOpenInjectionStep postEndpointInjectionProfile() {
        int totalDesiredUserCount = 5;//200;
        double userRampUpPerInterval = 1;//50;
        double rampUpIntervalSeconds = 1;//30;

        int totalRampUptimeSeconds = 10;//120;
        int steadyStateDurationSeconds = 10;//300;
        return rampUsersPerSec(userRampUpPerInterval / (rampUpIntervalSeconds / 60)).to(totalDesiredUserCount)
                .during(Duration.ofSeconds(totalRampUptimeSeconds + steadyStateDurationSeconds));
    }

    private static HttpProtocolBuilder setupProtocolForSimulation() {
        return HttpDsl.http.baseUrl("http://localhost:19090/ui")
                .acceptHeader("application/json")
                .maxConnectionsPerHost(10)
                .userAgentHeader("Gatling/Performance Test");
    }

    private static Iterator<Map<String, Object>> setupTestFeedData() {
        Faker faker = new Faker();
        Iterator<Map<String, Object>> iterator;
        iterator = Stream.generate(() -> {
                    Map<String, Object> stringObjectMap = new HashMap<>();
                    stringObjectMap.put("code", faker.name()
                            .fullName());
                    return stringObjectMap;
                })
                .iterator();
        return iterator;
    }

    private static ScenarioBuilder buildPostScenario() {
//        return CoreDsl.scenario("Load Test Creating User")
//                .feed(FEED_DATA)
//                .exec(http("create-employee-request").post("/api/employees")
//                        .header("Content-Type", "application/json")
//                        .body(StringBody("{ \"empName\": \"${empName}\" }"))
//                        .check(status().is(201))
//                        .check(header("Location").saveAs("location")))
//                .exec(http("get-employee-request").get(session -> session.getString("location"))
//                        .check(status().is(200)));
        var listCodes=listFeeder(Arrays.asList(
                Collections.singletonMap("code", "code01"),
                Collections.singletonMap("code", "code02"),
                Collections.singletonMap("code", "code03")
        ));
        var listQuantite=listFeeder(Arrays.asList(
                Collections.singletonMap("quantite", 1),
                Collections.singletonMap("quantite", 2),
                Collections.singletonMap("quantite", 3),
                Collections.singletonMap("quantite", 4),
                Collections.singletonMap("quantite", 5),
                Collections.singletonMap("quantite", 6),
                Collections.singletonMap("quantite", 7),
                Collections.singletonMap("quantite", 8),
                Collections.singletonMap("quantite", 9),
                Collections.singletonMap("quantite", 10)
        ));

        return CoreDsl.scenario("Load Test Creating User")
//                .feed(FEED_DATA)
                .feed(listCodes.random())
                .feed(listQuantite.random())
                .exec(http("restock-product")
                                .put("/product/#{code}/restock/#{quantite}")
                        .header("Content-Type", "application/json")
//                        .body(StringBody("{ \"empName\": \"${empName}\" }"))
                        .check(status().is(200))
//                        .check(header("Location").saveAs("location"))
                )
                .exec(http("get-all-product").get("/product")
                        .check(status().is(200)));
    }

}
