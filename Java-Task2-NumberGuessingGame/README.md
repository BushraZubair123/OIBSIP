# Number Guessing Game (Java)

OIBSIP - Java Development - Task 2

Console game: the computer picks a random number and you guess it with Too High / Too Low hints.

## Features
- Random number generated each round (`java.util.Random`)
- "Too High!", "Too Low!", "Correct!" feedback
- Attempt counter shown on every prompt
- Max attempts; "You Lost!" reveals the number
- Play Again option
- Score summary across rounds: `Round X - guessed in Y attempts`
- Bonus: difficulty levels (Easy 1-50/10, Medium 1-100/7, Hard 1-200/5)
- Input validation (non-numbers and out-of-range values rejected)

## Run
```
javac NumberGuessingGame.java
java NumberGuessingGame
```
