# Tic Tac Toe in Java

A console-based Tic Tac Toe game with two modes: **Human vs Human** and **Human vs Computer**, written in Java using object-oriented programming.

> Published on GitHub on 15 June 2024. Built to practise Java and OOP, and to understand how game logic and backtracking-style thinking work through hands-on coding.

<!-- TODO: add a GIF or screenshot of a game, e.g. ![Demo](demo/tictactoe-demo.gif) -->

## Why I built it

I wanted to understand backtracking by building something practical, and to make something other students could learn from and enjoy. I had a lot of fun playing it myself, and building it taught me Java properly.

## Features

- Two game modes in separate programs:
  - `human-vs-human`: two players take turns
  - `human-vs-computer`: you play against a computer that picks random valid moves
- 3x3 board printed in the console after every move
- Input validation: occupied or out-of-range cells are rejected and the player is asked again
- Win detection for rows, columns and both diagonals, plus draw detection

## OOP design

| Class | Role |
|---|---|
| `TicTacToe` | Board, display, placing marks, win and tie checks |
| `Player` (abstract) | Shared name, mark and move validation |
| `HumanPlayer` | Reads row and column from the keyboard |
| `AIplayer` | Chooses a random valid cell |

This uses abstraction, inheritance and polymorphism: both player types are handled through the same `Player` reference.

## Project structure

```
Tic_Tac_Toe_in_java/
├── human-vs-human/
│   └── XandO_HTH.java
├── human-vs-computer/
│   └── XandO_HTAI.java
└── README.md
```

(Each mode lives in its own folder because both files define classes with the same names.)

## How to run

Requires JDK 8 or newer.

```bash
cd human-vs-human          # or human-vs-computer
javac XandO_HTH.java       # or XandO_HTAI.java
java XandO_HTH             # or XandO_HTAI
```

Enter your move as **row and column, each from 0 to 2**, separated by a space. For example, `1 1` is the centre cell.

## What I learned

- Core Java: classes and objects, constructors, arrays, loops and conditional statements
- OOP concepts: abstract classes, inheritance, polymorphism, static members
- Breaking a problem down into small methods (display, validate, place, check win)

## Ideas for improvement

- Make the computer unbeatable using the Minimax algorithm (backtracking)
- Handle non-numeric input without crashing
- Let players enter cells as 1–3 instead of 0–2

## Demo Video
https://github.com/user-attachments/assets/4c7c968c-3708-496a-b265-7ef7a04c3300



The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
