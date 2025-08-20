# Bank exercise

### Core excercise

**User Stories**

```
As a customer,
So I can safely store and use my money,
I want to create a current account.

As a customer,
So I can save for a rainy day,
I want to create a savings account.

As a customer,
So I can keep a record of my finances,
I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.

As a customer,
So I can use my account,
I want to deposit and withdraw funds.

As an engineer,
So I don't need to keep track of state,
I want account balances to be calculated based on transaction history instead of stored in memory.

As a bank manager,
So I can expand,
I want accounts to be associated with specific branches.

As a customer,
So I have an emergency fund,
I want to be able to request an overdraft on my account.

As a bank manager,
So I can safeguard our funds,
I want to approve or reject overdraft requests.

As a customer,
So I can stay up to date,
I want statements to be sent as messages to my phone.
```
**Domain Models**

| Classes    | Members           | Methods              | Scenario          | Outputs |
|------------|-------------------|----------------------|-------------------|---------|
| `Customer` | `properties`      | `getters/setters`    |                   |         |
|            | `Account account` | `createAccount`      |                   |         |
|            | `Account account` | `requestOverdraft()` | if it is accepted | true    |
|            |                   |                      | if it is rejected |         |


| Classes   | Members                              | Methods               | Scenario          | Outputs |
|-----------|--------------------------------------|-----------------------|-------------------|---------|
| `Manager` | `properties`                         | `getters/setters`     |                   |         |
|           | `Customer customer, Account account` | `decideOnOverdraft()` | if it is accepted | true    |
|           |                                      |                       | if it is rejected | false   |

| Classes   | Members                           | Methods                   | Scenario                     | Outputs |
|-----------|-----------------------------------|---------------------------|------------------------------|---------|
| `Account` | `List<Transactions> transactions` | `generateBankStatement()` | If there are any transactions | String  |
|           |                                   |                           | If there are no transactions | String  |
|           | `double amount`                   | `deposit()`               | If amount is a valid int     | String  |
|           |                                   |                           | If amount is not a valid int | String  |
|           | `List <Transaction>`              | `calculateBalance()`      | if there are no transactions | String  |
|           |                                   |                           | if there are transactions    | String  |


| Classes   | Members         | Methods      | Scenario                                                           | Outputs |
|-----------|-----------------|--------------|--------------------------------------------------------------------|---------|
| `Account` | `double amount` | `withdraw()` | If amount is a valid int                                           | String  |
|           |                 |              | If amount is a valid int                                           | String  |
|           |                 |              | If amount is greater than balance and overdraft has been accepted  | String  |
|           |                 |              | if account is greater than balance and overdraft has been rejected | String  |


| Classes       | Members      | Methods            | Scenario | Outputs |
|---------------|--------------|--------------------|----------|---------|
| `Transaction` | `properties` |  `getters/setters` |          |         |


| Classes  | Members           | Methods           | Scenario | Outputs |
|----------|-------------------|-------------------|----------|---------|
| `Branch` | `properties`      | `getters/setters` |          |         |

