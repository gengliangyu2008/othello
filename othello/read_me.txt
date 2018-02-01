How to start this project:

1. install java8
2. compile all codes under src folder.
3. run command "java com.othello.main.Main"
4. for user input, all spaces will be ignored.
5. type "quit" to exit.


Project description:

1. class and file introduction:

1.1 othello.properties, include all the print out label and according value.

1.2 Constants, provide constants and label constants which refer to label in othello.properties.

1.3 MessageUtil, provide message access and formatting in othello.properties.  

1.4 GameService, class used to start the game, it include references to all other services
Main logic is in the start method, after it is called, then game started. 

1.5 BoardService, class provide board related functions, like initialization, print final result etc.

1.6 InputService, class used to convert and validate user input.

1.7 MovementService, class used to check available movements

1.8 FlipService,  class used to flip nodes.

1.9 classes in entity package, three entity classes.

1.10 Main, project entrance.

2. test folder, all test cases.

3. In GameService, there is a method "autoPlay" which can auto play the game till end.
The input parameter is a sleep time after each move. That method can be called by test case: TestGameService 

