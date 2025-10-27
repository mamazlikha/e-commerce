# e-commerce

docker exec -it mongo /bin/bash
mongo -u root -p password

show dbs

## commands to search inside db
db.item.find()


## Auto generate client with openApi
openapi-generator-cli generate -g typescript-angular -i http://localhost:8092/v3/api-docs -o C:\temp\e-commerce\front-end\e-commerce-cart-client --additional-properties fileNaming=kebab-case,withInterfaces=true,responseType=json,ngVersion=16.2.12
openapi-generator-cli generate -g typescript-angular -i http://localhost:8080/v3/api-docs -o C:\temp\e-commerce\front-end\e-commerce-item-client --additional-properties fileNaming=kebab-case,withInterfaces=true,responseType=json,ngVersion=16.2.12
openapi-generator-cli generate -g typescript-angular -i http://localhost:8081/v3/api-docs -o C:\temp\e-commerce\front-end\e-commerce-catalogue-client --additional-properties fileNaming=kebab-case,withInterfaces=true,responseType=json,ngVersion=16.2.12


java -jar openapi-generator-cli.jar generate ^ -g java ^ -i http://localhost:8082/v3/api-docs ^ -o C:\temp\e-commerce\back-end\cartservice-client ^ --additional-properties=java17=true,library=okhttp-gso
java -jar openapi-generator-cli.jar generate ^ -g java ^ -i http://localhost:8085/v3/api-docs ^ -o C:\temp\e-commerce\back-end\inventoryservice-client ^ --additional-properties=java17=true,library=okhttp-gson
java -jar openapi-generator-cli.jar generate -g java -i http://localhost:8089/v3/api-docs -o C:\temp\e-commerce\back-end\productsservice-client
