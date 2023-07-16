package org.ecommerce.reverseproxy.benchmark;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled
public class BenchmarkTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(BenchmarkTest.class);

    private Random random=new Random(System.currentTimeMillis());

    @Test
    public void test1(){
        RestTemplate restTemplate=new RestTemplate();

        var produit=new ProduitTestDto();
        produit.setNom("aaaaTest"+random.nextInt());
        produit.setQuantite(5);

        var url="http://localhost:19090/ui/product";

        LOGGER.info("url={}",url);
        LOGGER.info("produit: {}",produit);

        var res=restTemplate.postForEntity(url,produit, Void.class);
        assertEquals(HttpStatus.OK,res.getStatusCode());

        try{
            Thread.sleep(500);
        }catch (Exception e){
            LOGGER.warn("erreur",e);
        }
    }

    @Test
    public void test2(){
        RestTemplate restTemplate=new RestTemplate();

        var code="code%02d".formatted(random.nextInt(3)+1);
        var quantite=random.nextInt(10)+1;

        var url="http://localhost:19090/ui/product/"+code+"/restock/"+quantite;

        LOGGER.info("url={}",url);

        var res=restTemplate.exchange(url, HttpMethod.PUT,null,Void.class);
        assertEquals(HttpStatus.OK,res.getStatusCode());

//        try{
//            Thread.sleep(500);
//        }catch (Exception e){
//            LOGGER.warn("erreur",e);
//        }
    }
}
