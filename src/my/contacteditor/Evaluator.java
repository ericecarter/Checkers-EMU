/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.contacteditor;

import java.util.List;

/**
 *
 * @author Eric Eugene Carter
 */
public class Evaluator {

    private int startPosition; //where the checker started at
    private int endPosition;// this is where the checker lands at

    private final Moves evalMoveFinder; //the evaluator's move Finder
    private Boolean evalBlacksTurn; // the evaluator's turn tracker

    private static final int maxDepth = 6; //controls how deep the min-max algorithm goes

    public Evaluator() {
        evalMoveFinder = new Moves();
    }

    public char[] makeMinMaxMove(char[] currentBoard, Boolean blacksMove) {
        Node move; // this node is the decided move
        //set the evaluator's boolean
        //this is set so the eval method will keep one color as 'color'
        // and one color as 'enemy' throughout the minmax algorithm
        evalBlacksTurn = blacksMove;
        move = minimax(currentBoard, blacksMove); //apply the minimax algorithm to the current board
        if (move != null) {
            startPosition = move.getStart();//set start position so contactEditor can update history
            endPosition = move.getFinish();//set finish position so contactEditor can update history
            return move.getNp(); //return the char array to contactEditor
        }
        return null; //no moves available return null to contactEditor
    }

    private Node minimax(char[] currentBoard, Boolean blacksMove) {
        List<Node> successors;
        Node move, bestMove = null;
        int value, maxValue = Integer.MIN_VALUE;

        //give the evaluator's move finder the current board
        evalMoveFinder.setCurrentPosition(currentBoard);
        //update moveFinder to find right color's moves
        evalMoveFinder.blacksMove = blacksMove;
        //find all possible moves from the current position
        evalMoveFinder.findAllMoves();
        //assign those moves to successor to be be evaluated
        successors = evalMoveFinder.allPossibleMoves;

        while (!successors.isEmpty()) {
            move = successors.remove(0);//calculate the minmax value for one possible move
            value = minMove(move, 1, maxValue, Integer.MAX_VALUE, blacksMove);
            //we want to play the move with the MOST MIN-MAX VALUE!!
            if (value > maxValue) {
                maxValue = value;
                bestMove = move;
            }
        }
        return bestMove;
    }

    private int maxMove(Node move, int depth, int alpha, int beta, Boolean blacksMove) {
        Boolean maxMoveBlacksTurn; //this keeps track of whose moves we want to generate
        maxMoveBlacksTurn = !blacksMove; // change turn from one color to the other
        List successors; //this holds subsequent possible moves
        Node thisMove; //the next move that could be made
        int value;
        //update move Finders boolean
        evalMoveFinder.blacksMove = maxMoveBlacksTurn;
        //update move finders current position
        evalMoveFinder.setCurrentPosition(move.getNp());
        // find all the possible moves
        evalMoveFinder.findAllMoves();
        //assign those moves to be evaluated
        successors = evalMoveFinder.allPossibleMoves;
        //do a test to see if anymore move are possible or if we have
        //gone "deep" enough
        if (cutOffTest(successors, depth)) {
            int temp;
            temp = setBoardValue(move.getNp(), maxMoveBlacksTurn) - 3 * evalMoveFinder.allPossibleJumps.size();
            return temp;
        }
        while (!successors.isEmpty()) {
            //remove first node and evaluate it
            thisMove = (Node) successors.remove(0);
            //find the max value of this move
            value = minMove(thisMove, depth + 1, alpha, beta, maxMoveBlacksTurn);
            //keep track of the MOST MAX VALUE!!
            if (value > alpha) {
                alpha = value;
            }
            if (alpha > beta) {
                return beta;
            }
        }
        return alpha;
    }

    private int minMove(Node move, int depth, int alpha, int beta, Boolean blacksMove) {
        Boolean minMoveBlacksTurn; //this keeps track of whose moves we want to generate
        minMoveBlacksTurn = !blacksMove; // change turn from one color to the other
        List successors; //this holds subsequent possible moves
        Node thisMove; //the next move that could be made
        int value;
        //update move Finders boolean
        evalMoveFinder.blacksMove = minMoveBlacksTurn;
        //update move finders current position
        evalMoveFinder.setCurrentPosition(move.getNp());
        // find all the possible moves
        evalMoveFinder.findAllMoves();
        //assign those moves to be evaluated
        successors = evalMoveFinder.allPossibleMoves;
        //do a test to see if anymore move are possible or if we have
        //gone "deep" enough
        if (cutOffTest(successors, depth)) {
            int temp;
            temp = setBoardValue(move.getNp(), minMoveBlacksTurn) - 3 * evalMoveFinder.allPossibleJumps.size();
            return temp;
        }
        while (!successors.isEmpty()) {
            //remove first node and evaluate it
            thisMove = (Node) successors.remove(0);
            //find the max value of this move
            value = maxMove(thisMove, depth + 1, alpha, beta, minMoveBlacksTurn);
            //keep track of the MOST MIN VALUE!!
            if (value < beta) {
                beta = value;
            }
            if (beta < alpha) {
                return alpha;
            }
        }
        return beta;
    }

    public int setBoardValue(char[] boardState, Boolean isBlack) {

        int numBlackPieces = 0, numWhitePieces = 0, blackPiecesPos = 0, whitePiecesPos = 0, boardValue;

        //positions on board with values for pieces being at
        int[] posValue1 = {15, 18, 23};
        int[] posValue2 = {10, 11, 14, 19, 22, 26, 27};
        int[] posValue3 = {6, 7, 8, 9, 16, 17, 24, 25};
        int[] posValue4 = {1, 2, 3, 4, 5, 12, 13, 20, 21, 28, 29, 30, 31, 32};
        //plus 1 to match board logic,check every cell for values to add to the variables
        for (int i = 0; i < 32; i++) {
            if (boardState[i] == 'b' || boardState[i] == 'B') {

                //either is a b or B, b gets 1 and B gets 3
                if (boardState[i] == 'b') {
                    numBlackPieces += 1;
                } else {
                    numBlackPieces += 3;
                }

                //figure out which position value is associated with the piece
                for (int o = 0; o < posValue1.length; o++) {
                    if (i + 1 == posValue1[o]) {
                        blackPiecesPos += 1;
                    }
                }

                for (int o = 0; o < posValue2.length; o++) {
                    if (i + 1 == posValue2[o]) {
                        blackPiecesPos += 2;
                    }
                }

                for (int o = 0; o < posValue3.length; o++) {
                    if (i + 1 == posValue3[o]) {
                        blackPiecesPos += 3;
                    }
                }

                for (int o = 0; o < posValue4.length; o++) {
                    if (i + 1 == posValue4[o]) {
                        blackPiecesPos += 4;
                    }
                }

            }
        }

        for (int i = 0; i < 32; i++) {
            if (boardState[i] == 'w' || boardState[i] == 'W') {

                //either is a w or W, w gets 1 and W gets 3
                if (boardState[i] == 'w') {
                    numWhitePieces += 1;
                } else {
                    numWhitePieces += 3;
                }

                //figure out which position value is associated with the piece
                for (int o = 0; o < posValue1.length; o++) {
                    if (i + 1 == posValue1[o]) {
                        whitePiecesPos += 1;
                    }
                }

                for (int o = 0; o < posValue2.length; o++) {
                    if (i + 1 == posValue2[o]) {
                        whitePiecesPos += 2;
                    }
                }

                for (int o = 0; o < posValue3.length; o++) {
                    if (i + 1 == posValue3[o]) {
                        whitePiecesPos += 3;
                    }
                }

                for (int o = 0; o < posValue4.length; o++) {
                    if (i + 1 == posValue4[o]) {
                        whitePiecesPos += 4;
                    }
                }

            }
        }

        //need check for king black and white jumps, as they can move back and forth (could be white/black pieces comibined?)
        //Formula/Equation for board Value  based on whether the computer is black or white
        if (evalBlacksTurn) {
            //boardValue = 2*numBlackPieces + 3*blackPiecesPos - 2*numWhitePieces - 3*whitePiecesPos - 10*givenOppJumps;
            boardValue = 3 * numBlackPieces + blackPiecesPos - 4 * numWhitePieces - whitePiecesPos;// - 5 * givenOppJumps;
        } else {
            boardValue = 3 * numWhitePieces + whitePiecesPos - 4 * numBlackPieces - blackPiecesPos;// - 5 * givenOppJumps;
        }

        return boardValue;
    }

    private boolean cutOffTest(List<Node> board, int depth) {
        return depth > maxDepth || board.isEmpty();
    }

    public int getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }

    public int getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(int endPosition) {
        this.endPosition = endPosition;
    }
}
