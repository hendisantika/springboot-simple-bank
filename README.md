# springboot-simple-bank
## This is an implementation of BH coding task

## The solution consists of three services:
- Accounts - responsible for storing Accounts
- Transactions - responsible for storing Transactions
- DataViewer - responsible for retrieving aggregated custiomer info
(accounts, transactions, balance) and displaying it via web UI.

## Implementation limitations
Due to time limitations the provided implementation is not "ideal", there is a room
for improvements. The main attention was paid for general architecture and basic scenarios.
In particular the following still can be improved:
- Input validation. For now all user input is supposed to be correct
- Proper exceptions handing by REST end-points. For now the exceptions are thrown to the
client as they are
- more tests to be added. For now only several tests implemented
(quite straightforward though - all dependencies are easily mockabe).
- fault tolerance could be designed more properly. For now, both Accounts and Transactions
service are supposed to be up and running (Accounts service depends on Transactions service)
- all data is stored in very simple memory storage (Singleton class)

## Build instructions
Maven is required to buld the project.
After Maven installed and project is check out from the repository, execute the following command:
-- mvn clean install

## Accounts
This service is responsible for storing Accounts and retrieving them.
### Run instructions:
In command line execute:
-- java -jar accounts-0.0.1-SNAPSHOT.jar
### The following REST endpoints are exposed:
    * Create account:
    
    ```
     POST /accounts?customerId=<CUSTOMER_ID>&name=<CUSTOMER_NAME>&initialCredit=<INITIAL_CREDIT>
    ```
    
    * Returns ID of created account
    - Get account by customer ID:
    
    ```
    GET /accounts?customerId=<CUSTOMER_ID>
    ```
### Configuration:
server.port - port number which this service is listening to. Default - 8082
create.transaction.service.url - URL of Transactions service for creating account transaction

## Transactions
This service is responsible for storing Transactions and retrieving them.
### Run instructions:
- In command line execute:
-- java -jar transactions-0.0.1-SNAPSHOT.jar
### The following REST endpoints are exposed:
- Create new transaction for account:
-- POST /transactions?accountId=<ACCOUNT_ID>&amount=<AMOUNT>
-- return new transation ID
- Get transactions for account. Limit defines how many last transations should be retrieved.
If TRANSACTIONS_LIMIT <= 0 - all transactions for account will be returned
-- GET /transactions/<ACCOUNT_ID>/<TRANSACTIONS_LIMIT>
-- Returns list of transactions for given account
### Configuration:
server.port - port number which this service is listening to. Default - 8083

## DataViewer
This service is responsible for retrieving aggregated data for customer - its accounts,
transactions and balances
### Run instructions:
- In command line execute:
-- java -jar DataViewer-0.0.1-SNAPSHOT.jar
### The following REST endpoint is exposed:
- Get customer data:
-- /data/<CUSTOMER_ID>
-- Returns the data structure containing:
--- Total balance for cutomer
--- List of accounts for customer
--- For each account - its balance
--- For each account - list of last transactions
### Configuration:
server.port - port number which this service is listening to. Default - 8083
transactions.limit - maximum amount of transactions which will be retrieved for each
customer's account.
get.transactions.service.url - URL of Transactions service for getting transactions
get.accounts.service.url - URL of Accounts service for getting accounts for customer

This DataViewer service also exposes Web UI to view the aggregated data. The UI is implemented
via JQuery and Bootstrap libraries. It is accessible via URL: http://localhost:8081
