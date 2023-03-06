
## Account Service
You can lunch this service locally by running `com/anz/wholesale/Application.java`
It will run on port 8080 by default

## Run Account Service
```
./gradlew bootRun
```

## Run Account Service test
```
./gradlew clean build test
```

## Data
For this sample application as the database H2 is used with Flyway support.
Initial schema creation and sample data is inserted using below sql

resources/db/migration/V1__init.sql

## Endpoints
to retrieve accounts - http://localhost:8080/api/accounts/{customerId}
```
eg. http://localhost:8080/api/accounts/1001
```

to retrieve transactions - http://localhost:8080/api/accounts/{accountId}/transactions
```
eg. http://localhost:8080/api/accounts/1234596799/transactions?page=0&size=50
```


