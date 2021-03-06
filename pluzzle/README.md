# Pluzzle - Java Implementation

## Objective

The game of eight is a simple game that consists of a 3X3 grid, containing 9 squares. Being 8 numbered pieces and an empty space. What allows the movement of the pieces one by one, in the four directions, allowing the numerical ordering of them. At the beginning of the game the board is occupied by disordered pieces.

The moves are carried out by moving the numbered piece to the empty square, until the board with the ordered numbers is arranged. The Figure below shows the final state.


## Settings

* JDK 11
* Project Maven

## Class
 * Main: Main class, game executor;
 * Engine: Class that controls game events and ui.

## Methods

* initData() : start data for ui;
* addButtons(): add the buttons in the ui.
* setCoordinates(): calculate the coordinates of the buttons
* getCoordinateY(int i, int y): calculates Y coordinates based on list position;
* getCoordinateX(int i, int x): calculates X coordinates based on list position;
* getRandomValue(Random rand): makes the value available randomly for the game;
* actionPerformed(ActionEvent e): controls click events on buttons;
* checkZero(e): controls the click and event on the first button;
* checkOne(e): controls the click and event on the second button;
* checkTwo(e): controls the click and event on the third button;
* checkThree(e): controls the click and event on the fourth button;
* checkFour(e): controls the click and event on the fifth button;
* checkFive(e): controls the click and event on the sixth button;
* checkSix(e): controls the click and event on the seventh button;
* checkSeven(e): controls the click and event on the eighth button;
* checkEight(e):  controls the click and event on the ninth button;
* assertResults(): returns if the screen has the buttons ordered according to the initial list.

