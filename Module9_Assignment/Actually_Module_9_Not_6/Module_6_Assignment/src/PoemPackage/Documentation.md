!!! PoemParse Documentation !!!

Author:
Daniel Reecy

Assignments:
Module 2 - Poem Sorter
Module 6 - JavaFX GUI for Module 2 program
Module 7 - Software Testing Using JavaFX
Module 9 - SDLC 2 - javadoc implementation

Program: Word Occurrences, PoemParse
Current Version: 4

Objectives module 6;
Using the module 2 Poem Parser;
! implement a graphical user interface using JavaFX
- interface can be simplistic
- interface requires some level of user interaction
- live free with no other instruction

*** 
The files required to run the program are; 
    PoemParseFX.java,
    PoemParse_Sorter.java,
    ParseController.java,
    PoemParseGUI.fxml
    *file path for poem txt*

PoemParseFX.java is the launch file that needs to 
be run for the application to execute. 
--It contains the main class-- 
***

Version history:
1 - Module 2 Assignment
    Basic source code. Reads in a file and outputs 
    the strings and their frequencies of occurence.

2 - Module 6 Assignment
    Implemented JavaFX GUI. Input reads from a specified file path
    inputted by the user at the GUI. 
    Outputs words and their frequencies of occurrence to the GUI.

3 - Module 7 Assignment
    Implementing software testing capabilities using JUnit.
    Testing individual components in the Sorter class to ensure 
    their reliability.

4 - Module 9 Assigment
    Adding javadoc commenting and formatting. 
    * Module 6 and 7 were completed using different copies of the 
      program. Attempts at merging the two have failed as javafx
      hates it for some reason. This assignment is completed with 
      the module 6 assignment file. 

Use cases:
    Version 2 Use Case;
    * Application Run
        User inputs file path of a .txt file containing
        a poem, or series of strings into the TextField
        at center screen, above "Submit" button.
        User clicks "Submit" button
    * Exectution Output
        The individual strings and their frequency of
        occurence are printed to the TextArea, line by line,
        in order of greatest frequency to least.
        !format: "string = frequency"
    * User Closes Program Window

Challenges - post completion - v3:
! Javafx decides that it does not want to work
  whenever it sees fit for no reason. It is
  fickle and I hate it so much.


