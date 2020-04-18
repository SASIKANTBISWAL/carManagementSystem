# Car Management System
Spring Boot Rest API CRUD operation.

# Login details:
Username : user
Password : fincity

# Sample GET Requests:
GET all Cars:

curl -X GET http://127.0.0.1:8080/cars
GET car with ID = 1:

curl -X GET http://127.0.0.1:8080/cars/1
Search
GET all vehicles by Name:

curl -X GET http://127.0.0.1:8080/cars/creta
GET all cars by manufacturerName:

curl -X GET http://127.0.0.1:8080/cars/kia
GET all cars by model:

curl -X GET http://127.0.0.1:8080/cars/alpha
GET all cars by manufacturingYear:

curl -X GET http://127.0.0.1:8080/cars/2020
GET all cars by color:

curl -X GET http://127.0.0.1:8080/cars/Pearl
# Sample POST Requests:
POST new car:

curl -X POST \
  http://127.0.0.1:8080/car \
  -H 'content-type: application/json' \
  -d '{
        "carid": 4,
        "name": "Harrier",
        "manufacturerName": "TATA",
        "model": "Zxi",
        "manufacturingYear": "2018",
        "color": "Royal Blue"
  }'
# DELETE recently added car:

curl -X DELETE http://127.0.0.1:8080/cars
# Sample PUT Requests:
PUT(update data) car object:

curl -X PUT \
  http://127.0.0.1:8080/cars/5 \
  -H 'content-type: application/json' \
  -d '{
        "carid": 5,
        "name": "Compass",
        "manufacturerName": "Jeep",
        "model": "Limited edition",
        "manufacturingYear": "2017",
        "color": "Indegene Orange"
  }'
PUT(update data) car with ID = 5:

curl -X PUT \
  http://127.0.0.1:8080/cars/5 \
  -H 'content-type: application/json' \
  -d '{
        "name": "Compass",
        "manufacturerName": "Jeep",
        "model": "Limited edition",
        "manufacturingYear": "2017",
        "color": "Indegene Orange"
  }'
# Sample DELETE Requests:
DELETE car with ID = 5:

curl -X DELETE http://127.0.0.1:8080/cars/1
