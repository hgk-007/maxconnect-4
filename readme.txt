Name:Himanshu Girish Kotbagi
UTA ID:1001581530

(i) The programming language used is java.
(ii)Code structure:
The input is given through the command prompt which takes in the name of the mode(interactive or one-move), the input file, the output file and depth. In case of interactive mode human-next or compuer-next is specified to decide who plays first.

The input data can be changed in the input file.

The algorithm uses minimax with alpha beta pruning and considers the data as a tree.

For one-move mode, the input file initializes the current game state and prints the current state with the game scores. This is performed by getGameBoard and printGameBoard function for both one-move and interactive mode. Maxconnect is the main function. The program accepts the depth from the command prompt and the findBestPlay function which takes the depth as input performs depth limited minimax and decides which branch to take first.

For interactive mode ,the input file initializes the current game state and if the input file does not exist or has invalid inputs then an empty game board is created. Here the findBestPlay function takes in the depth as well as the mode(human-next or computer-next) from the command prompt as inputs. If human-next is given then the program prompts the user to play first and stores the output in human.txt file. The computer would play next once the user is done.

If computer-next is given then the computter would play first and the outputs would be stored in computer.txt file. Both the computer and the user continue playing till the board is full where the piececount is 42.

The evaluation function Calculate_Min_Utility and Calculate_Max_Utility is used to calculate the utility values.The findBestPlay funcion uses these two utility values to perform the minmax algorithm.

(iii) Instructions to run the code:

To compile the code: javac Maxconnect4.java
One-move mode:java Maxconnect4 one-move input1.txt output.txt 2
Interactive mode: java Maxconnect4 interactive input1.txt human-next 2(for user to play first)
                  java Maxconnect4 interactive input1.txt computer-next 2(for computer to play first)

(iv) Code referrence:
Github 


