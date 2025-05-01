
set shell := ["cmd.exe", "/c"]


demarrage:
    docker-compose up --build

arret:
    docker-compose down

supprime_images:
    #!powershell
    docker images | Select-String -Pattern "^discovery/*" |   Where {$_ -match "\s[a-z0-9]{12}\s"} | Foreach{ docker rmi $Matches[0].trim()}
    docker images | Select-String -Pattern "^reverseproxy/*" |   Where {$_ -match "\s[a-z0-9]{12}\s"} | Foreach{ docker rmi $Matches[0].trim()}
    docker images | Select-String -Pattern "^configurator/*" |   Where {$_ -match "\s[a-z0-9]{12}\s"} | Foreach{ docker rmi $Matches[0].trim()}
    docker images | Select-String -Pattern "^order/*" |   Where {$_ -match "\s[a-z0-9]{12}\s"} | Foreach{ docker rmi $Matches[0].trim()}
    docker images | Select-String -Pattern "^ui/*" |   Where {$_ -match "\s[a-z0-9]{12}\s"} | Foreach{ docker rmi $Matches[0].trim()}

tests_charges:
    cd loadtesting && mvn gatling:test
