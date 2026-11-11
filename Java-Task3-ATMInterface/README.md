# ATM Interface (Java)

OIBSIP - Java Development - Task 3

Console ATM simulation built with Object-Oriented design.

## Classes
`Main`, `ATM` (menu/UI), `Account` (balance + history), `Transaction` (record), `Bank` (accounts + authentication).

## Features
- User ID + PIN login, access denied after 3 wrong attempts
- Menu: Transaction History, Withdraw, Deposit, Transfer, Quit
- "Insufficient Funds" check on withdraw and transfer
- Transfer updates both accounts and logs on both sides
- Transactions stored in an `ArrayList` and shown in history
- Input validation for amounts and menu choices

## Demo accounts
| User ID | PIN  | Balance |
|---------|------|---------|
| user1   | 1234 | 5000    |
| user2   | 4321 | 3000    |
| user3   | 1111 | 10000   |

## Run
```
javac *.java
java Main
```
