# e-commerce

docker exec -it mongo /bin/bash
mongo -u root -p password

show dbs

## commands to search inside db
db.item.find()


## Auto generate client with openApi
openapi-generator-cli generate -g typescript-angular -i http://localhost:8082/v3/api-docs -o C:\temp\e-commerce\front-end\e-commerce-cart-client
openapi-generator-cli generate -g typescript-angular -i http://localhost:8080/v3/api-docs -o C:\temp\e-commerce\front-end\e-commerce-item-client
openapi-generator-cli generate -g typescript-angular -i http://localhost:8081/v3/api-docs -o C:\temp\e-commerce\front-end\e-commerce-catalogue-client
