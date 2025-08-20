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
```
**Domain Models**

| Classes    | Members           | Methods           | Scenario | Outputs |
|------------|-------------------|-------------------|----------|---------|
| `Customer` | `properties`      | `getters/setters` |          |         |
|            | `Account account` | `createAccount`   |          |         |

| Classes   | Members                           | Methods                   | Scenario                      | Outputs |
|-----------|-----------------------------------|---------------------------|-------------------------------|---------|
| `Account` | `List<Transactions> transactions` | `generateBankStatement()` | If there are any transactions | String  |
|           |                                   |                           | If there are no transactions  | String  |

| Classes   | Members             | Methods     | Scenario                     | Outputs |
|-----------|---------------------|-------------|------------------------------|---------|
| `Account` | `BigDecimal amount` | `deposit()` | If amount is a valid int     | String  |
|           |                     |             | If amount is not a valid int | String  |

| Classes   | Members             | Methods      | Scenario                          | Outputs |
|-----------|---------------------|--------------|-----------------------------------|---------|
| `Account` | `BigDecimal amount` | `withdraw()` | If amount is a valid int          | String  |
|           |                     |              | If amount is a valid int          | String  |
|           |                     |              | If amount is greater than balance | String  |


| Classes       | Members      | Methods            | Scenario | Outputs |
|---------------|--------------|--------------------|----------|---------|
| `Transaction` | `properties` |  `getters/setters` |          |         |
