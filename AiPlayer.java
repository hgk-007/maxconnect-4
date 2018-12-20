import java.util.*;

/**
 * This is the AiPlayer class. It simulates a minimax player for the max connect four game. */
 

public class AiPlayer {

    public int depthLevel;
    public GameBoard aiGameBoard;

    /**
     * The constructor essentially does nothing except instantiate an AiPlayer object.
     * 
     * @param currentGame
     * 
     */
    public AiPlayer(int depth, GameBoard currentGame) {
        this.depthLevel = depth;
        this.aiGameBoard = currentGame;
    }

    /**
     * This method makes the decision to make a move for the computer using 
       min and max value from the below two functions.
     
    
     */
    public int find_best_move(GameBoard currentGame) throws CloneNotSupportedException {
        int playChoice = Maxconnect4.INVALID;
        if (currentGame.getCurrentTurn() == Maxconnect4.ONE) {
            int v = Integer.MAX_VALUE;
            for (int i = 0; i < GameBoard.NO_OF_COLS; i++) {
                if (currentGame.isValidPlay(i)) {
                    GameBoard nextMoveBoard = new GameBoard(currentGame.getGameBoard());
                    nextMoveBoard.playPiece(i);
                    int value = calculate_maximum_utility(nextMoveBoard, depthLevel, Integer.MIN_VALUE, Integer.MAX_VALUE);
                    if (v > value) {
                        playChoice = i;
                        v = value;
                    }
                }
            }
        } else {
            int v = Integer.MIN_VALUE;
            for (int i = 0; i < GameBoard.NO_OF_COLS; i++) {
                if (currentGame.isValidPlay(i)) {
                    GameBoard nextMoveBoard = new GameBoard(currentGame.getGameBoard());
                    nextMoveBoard.playPiece(i);
                    int value = calculate_minimum_utility(nextMoveBoard, depthLevel, Integer.MIN_VALUE, Integer.MAX_VALUE);
                    if (v < value) {
                        playChoice = i;
                        v = value;
                    }
                }
            }
        }
        return playChoice;
    }

    /**
     * This method calculates the min value.
      
      gameBoard- The GameBoard object that is currently being used to play the game.
      depthLevel- depth to which computer will search for making best feasible move next
      alpha_value- maximum utility value for MAX player
      beta_value- maximum utility value for MIN player 
     
     */

    private int calculate_minimum_utility(GameBoard gameBoard, int depthLevel, int alpha_value, int beta_value)
        throws CloneNotSupportedException {
        
        if (!gameBoard.isBoardFull() && depthLevel > 0) {
            int v = Integer.MAX_VALUE;
            for (int i = 0; i < GameBoard.NO_OF_COLS; i++) {
                if (gameBoard.isValidPlay(i)) {
                    GameBoard board4NextMove = new GameBoard(gameBoard.getGameBoard());
                    board4NextMove.playPiece(i);
                    int value = calculate_maximum_utility(board4NextMove, depthLevel - 1, alpha_value, beta_value);
                    if (v > value) {
                        v = value;
                    }
                    if (v <= alpha_value) {
                        return v;
                    }
                    if (beta_value > v) {
                        beta_value = v;
                    }
                }
            }
            return v;
        } else {
            // this is a terminal state
            return gameBoard.getScore(Maxconnect4.TWO) - gameBoard.getScore(Maxconnect4.ONE);
        }
    }

    /**
     * This method calculates the max value.
     * 
     * @param gameBoard The GameBoard object that is currently being used to play the game.
     * @param depthLevel depth to which computer will search for making best possible next move
     * @param alpha_value maximum utility value for MAX player
     * @param beta_value maximum utility value for MIN player 
     * @return an integer indicating which column the AiPlayer would like to play in.
     * @throws CloneNotSupportedException
     */

    private int calculate_maximum_utility(GameBoard gameBoard, int depthLevel, int alpha_value, int beta_value)
        throws CloneNotSupportedException {
        
        if (!gameBoard.isBoardFull() && depthLevel > 0) {
            int v = Integer.MIN_VALUE;
            for (int i = 0; i < GameBoard.NO_OF_COLS; i++) {
                if (gameBoard.isValidPlay(i)) {
                    GameBoard board4NextMove = new GameBoard(gameBoard.getGameBoard());
                    board4NextMove.playPiece(i);
                    int value = calculate_minimum_utility(board4NextMove, depthLevel - 1, alpha_value, beta_value);
                    if (v < value) {
                        v = value;
                    }
                    if (v >= beta_value) {
                        return v;
                    }
                    if (alpha_value < v) {
                        alpha_value = v;
                    }
                }
            }
            return v;
        } else {
            // this is a terminal state
            return gameBoard.getScore(Maxconnect4.TWO) - gameBoard.getScore(Maxconnect4.ONE);
        }
    }

}