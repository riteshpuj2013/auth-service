# auth-service
Authentication and authorization service for patient details


## Build
    mvn clean install

## Run
    mvn spring-boot:run

### POST /transaction
    curl -sv -H "Content-type: application/json" -d '{
            "amount" : 1000,
            "timestamp": 1525180773653
    }' 'localhost:8080/transactions/'

### GET /statistics
    curl -sv -XGET 'localhost:8080/statistics/' | json_pp <br>

### Import pharmeasydb.sql in mysqlDB

### Run application:
    "mvn spring-boot:run" 
    
### Test Application using Curl or Swagger UI:
    http://localhost:8080/swagger-ui.html

### GET /api/prescription to register request for prescription ID - 1
    curl -X GET --header 'Accept: application/json' 'http://localhost:8080/api/prescription?prescriptionID=1&requesterID=1'
    {
      "requestID": 1,
      "access": false
    }
    
### PUT /api/prescription to update the access of the prescription ID -1
    curl -X PUT --header 'Content-Type: application/json' --header 'Accept: */*' 'http://localhost:8080/api/prescription?prescriptionID=1&requesterID=1'


### GET /api/prescription to request for prescription ID - 1, since the access is available now, the prescription details will be returned
    curl -X GET --header 'Accept: application/json' 'http://localhost:8080/api/prescription?prescriptionID=1&requesterID=1'

    {
      "requestID": 1,
      "prescriptionDTO": {
        "prescriptionID": 1,
        "patientId": 1,
        "patientName": "Ritesh",
        "doctorName": "Tarla Shah",
        "medicines": [
          {
            "medicineName": "Crocin",
            "dosage": 1
          },
          {
            "medicineName": "Pan40",
            "dosage": 2
          }
        ]
      },
      "access": true
    }
