# EmployeeManagement

1.Add Employee

curl --location --request POST 'http://localhost:8080/api/employee/add' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName":"srkanth",
    "lastName":"m",
    "emailId":"srikanthm@gmail.com"
}'
Response:
{
    "id": 4,
    "firstName": "srkanth",
    "lastName": "m",
    "emailId": "srikanthm@gmail.com"
}



2.Delete Employee

curl --location --request DELETE 'http://localhost:8080/api/employee/delete/3' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName":"rajesh",
    "lastName":"m",
    "emailId":"gajeshm@gmail.com"
}'
Response: sucess fully deleted


3.GetEmployees

curl --location --request GET 'http://localhost:8080/api/employee'

Response:

[
    {
        "id": 4,
        "firstName": "srkanth",
        "lastName": "m",
        "emailId": "srikanthm@gmail.com"
    }
]


4.UpdateEmployee

curl --location --request PUT 'http://localhost:8080/api/employee/update/4' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName":"rajesh",
    "lastName":"m",
    "emailId":"gajeshm@gmail.com"
}'

Response:

{
    "id": 4,
    "firstName": "rajesh",
    "lastName": "m",
    "emailId": "gajeshm@gmail.com"
}


Feature
1.Exceptional Handling based on requirement
