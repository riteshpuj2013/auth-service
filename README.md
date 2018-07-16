# auth-service
Authentication and authorization service for patient details

### Import pharmeasydb.sql in mysqlDB

### Run application using "mvn spring-boot:run" 

### Get API to register request for prescription ID - 1
curl -X GET --header 'Accept: application/json' 'http://localhost:8080/api/prescription?prescriptionID=1&requesterID=1'

### PUT API to update the access of the prescription ID -1
curl -X PUT --header 'Content-Type: application/json' --header 'Accept: */*' 'http://localhost:8080/api/prescription?prescriptionID=1&requesterID=1'

### Get API to request for prescription ID - 1, since the access is available now, the prescription details will be returned
curl -X GET --header 'Accept: application/json' 'http://localhost:8080/api/prescription?prescriptionID=1&requesterID=1'
