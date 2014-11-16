/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.contacteditor;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eric Eugene Carter
 */
public class Moves {

    private final int EVENDOWNLEFT = 4; //even row down to left
    private final int EVENDOWNRIGHT = 5; //even row down to right
    private final int EVENUPRIGHT = -3; //even row up right
    private final int EVENUPLEFT = -4; //even row up left

    private final int ODDDOWNLEFT = 3; //odd row down to left
    private final int ODDDOWNRIGHT = 4; //odd row down to right
    private final int ODDUPLEFT = -5; //odd row up to left
    private final int ODDUPRIGHT = -4; //odd row up to right

    public List<Node> allPossibleMoves; //stores all king and non-king moves
    public char[] currentPosition; //current board position
    public Boolean blacksMove = true; // true if it is black's turn
    public List<Node> allPossibleJumps;

    public Moves() {

    }

    public void setCurrentPosition(char[] current) {
        currentPosition = new char[32];
        this.currentPosition = current;
    }

    private void findJumps() {
        allPossibleJumps = new ArrayList<Node>();
        char piece, kingPiece, enemy, enemyKing;
        if (blacksMove) {
            piece = 'b';
            kingPiece = 'B';
            enemy = 'w';
            enemyKing = 'W';
        } else {
            piece = 'w';
            kingPiece = 'W';
            enemy = 'b';
            enemyKing = 'B';
        }
        char[] temp;//temp array used to fix reference problems
        // all jumps from position 0
        if (blacksMove) {
            if (currentPosition[0] == piece) {
                if ((currentPosition[5] == enemy || currentPosition[5] == enemyKing) && currentPosition[9] == '-') {
                    temp = currentPosition.clone();
                    temp[0] = '-';
                    temp[5] = '-';
                    temp[9] = piece;
                    findRemainingBlackJumps(temp, 9, 0);
                }
            }
            //all moves from 1
            if (currentPosition[1] == piece) {
                if ((currentPosition[5] == enemy || currentPosition[5] == enemyKing) && currentPosition[8] == '-') {
                    temp = currentPosition.clone();
                    temp[1] = '-';
                    temp[5] = '-';
                    temp[8] = piece;
                    findRemainingBlackJumps(temp, 8, 1);
                }
                if ((currentPosition[6] == enemy || currentPosition[6] == enemyKing) && currentPosition[10] == '-') {
                    temp = currentPosition.clone();
                    temp[1] = '-';
                    temp[6] = '-';
                    temp[10] = piece;
                    findRemainingBlackJumps(temp, 10, 1);
                }
            }
            //all moves from 2
            if (currentPosition[2] == piece) {
                if ((currentPosition[6] == enemy || currentPosition[6] == enemyKing) && currentPosition[9] == '-') {
                    temp = currentPosition.clone();
                    temp[2] = '-';
                    temp[6] = '-';
                    temp[9] = piece;
                    findRemainingBlackJumps(temp, 9, 2);
                }
                if ((currentPosition[7] == enemy || currentPosition[7] == enemyKing) && currentPosition[11] == '-') {
                    temp = currentPosition.clone();
                    temp[2] = '-';
                    temp[7] = '-';
                    temp[11] = piece;
                    findRemainingBlackJumps(temp, 11, 2);
                }
            }
            //all moves from 3
            if (currentPosition[3] == piece) {
                if ((currentPosition[7] == enemy || currentPosition[7] == enemyKing) && currentPosition[10] == '-') {
                    temp = currentPosition.clone();
                    temp[3] = '-';
                    temp[7] = '-';
                    temp[10] = piece;
                    findRemainingBlackJumps(temp, 10, 3);
                }
            }
            //all moves from 4
            if (currentPosition[4] == piece) {
                if ((currentPosition[8] == enemy || currentPosition[8] == enemyKing) && currentPosition[13] == '-') {
                    temp = currentPosition.clone();
                    temp[4] = '-';
                    temp[8] = '-';
                    temp[13] = piece;
                    findRemainingBlackJumps(temp, 13, 4);
                }
            }
            //all moves from 5
            if (currentPosition[5] == piece) {
                if ((currentPosition[8] == enemy || currentPosition[8] == enemyKing) && currentPosition[12] == '-') {
                    temp = currentPosition.clone();
                    temp[5] = '-';
                    temp[8] = '-';
                    temp[12] = piece;
                    findRemainingBlackJumps(temp, 12, 5);
                }
                if ((currentPosition[9] == enemy || currentPosition[9] == enemyKing) && currentPosition[14] == '-') {
                    temp = currentPosition.clone();
                    temp[5] = '-';
                    temp[9] = '-';
                    temp[14] = piece;
                    findRemainingBlackJumps(temp, 14, 5);
                }
            }
            //all moves from 6
            if (currentPosition[6] == piece) {
                if ((currentPosition[9] == enemy || currentPosition[9] == enemyKing) && currentPosition[13] == '-') {
                    temp = currentPosition.clone();
                    temp[6] = '-';
                    temp[9] = '-';
                    temp[13] = piece;
                    findRemainingBlackJumps(temp, 13, 6);
                }
                if ((currentPosition[10] == enemy || currentPosition[10] == enemyKing) && currentPosition[15] == '-') {
                    temp = currentPosition.clone();
                    temp[6] = '-';
                    temp[10] = '-';
                    temp[15] = piece;
                    findRemainingBlackJumps(temp, 15, 6);
                }
            }
            //all moves from 7
            if (currentPosition[7] == piece) {
                if ((currentPosition[10] == enemy || currentPosition[10] == enemyKing) && currentPosition[14] == '-') {
                    temp = currentPosition.clone();
                    temp[7] = '-';
                    temp[10] = '-';
                    temp[14] = piece;
                    findRemainingBlackJumps(temp, 14, 7);
                }
            }
            //all moves from 8
            if (currentPosition[8] == piece) {
                if ((currentPosition[13] == enemy || currentPosition[13] == enemyKing) && currentPosition[17] == '-') {
                    temp = currentPosition.clone();
                    temp[8] = '-';
                    temp[13] = '-';
                    temp[17] = piece;
                    findRemainingBlackJumps(temp, 17, 8);
                }
            }
            //all moves from 9
            if (currentPosition[9] == piece) {
                if ((currentPosition[13] == enemy || currentPosition[13] == enemyKing) && currentPosition[16] == '-') {
                    temp = currentPosition.clone();
                    temp[9] = '-';
                    temp[13] = '-';
                    temp[16] = piece;
                    findRemainingBlackJumps(temp, 16, 9);
                }
                if ((currentPosition[14] == enemy || currentPosition[14] == enemyKing) && currentPosition[18] == '-') {
                    temp = currentPosition.clone();
                    temp[9] = '-';
                    temp[14] = '-';
                    temp[18] = piece;
                    findRemainingBlackJumps(temp, 18, 9);
                }
            }
            //all moves from 10
            if (currentPosition[10] == piece) {
                if ((currentPosition[14] == enemy || currentPosition[14] == enemyKing) && currentPosition[17] == '-') {
                    temp = currentPosition.clone();
                    temp[10] = '-';
                    temp[14] = '-';
                    temp[17] = piece;
                    findRemainingBlackJumps(temp, 17, 10);
                }
                if ((currentPosition[15] == enemy || currentPosition[15] == enemyKing) && currentPosition[19] == '-') {
                    temp = currentPosition.clone();
                    temp[10] = '-';
                    temp[15] = '-';
                    temp[19] = piece;
                    findRemainingBlackJumps(temp, 19, 10);
                }
            }
            //all moves from 11
            if (currentPosition[11] == piece) {
                if ((currentPosition[15] == enemy || currentPosition[15] == enemyKing) && currentPosition[18] == '-') {
                    temp = currentPosition.clone();
                    temp[11] = '-';
                    temp[15] = '-';
                    temp[18] = piece;
                    findRemainingBlackJumps(temp, 18, 11);
                }
            }
            //all moves from 12
            if (currentPosition[12] == piece) {
                if ((currentPosition[16] == enemy || currentPosition[16] == enemyKing) && currentPosition[21] == '-') {
                    temp = currentPosition.clone();
                    temp[12] = '-';
                    temp[16] = '-';
                    temp[21] = piece;
                    findRemainingBlackJumps(temp, 21, 12);
                }
            }
            //all moves from 13
            if (currentPosition[13] == piece) {
                if ((currentPosition[16] == enemy || currentPosition[16] == enemyKing) && currentPosition[20] == '-') {
                    temp = currentPosition.clone();
                    temp[13] = '-';
                    temp[16] = '-';
                    temp[20] = piece;
                    findRemainingBlackJumps(temp, 20, 13);
                }
                if ((currentPosition[17] == enemy || currentPosition[17] == enemyKing) && currentPosition[22] == '-') {
                    temp = currentPosition.clone();
                    temp[13] = '-';
                    temp[17] = '-';
                    temp[22] = piece;
                    findRemainingBlackJumps(temp, 22, 13);
                }
            }
            //all moves from 14
            if (currentPosition[14] == piece) {
                if ((currentPosition[17] == enemy || currentPosition[17] == enemyKing) && currentPosition[21] == '-') {
                    temp = currentPosition.clone();
                    temp[14] = '-';
                    temp[17] = '-';
                    temp[21] = piece;
                    findRemainingBlackJumps(temp, 21, 14);
                }
                if ((currentPosition[18] == enemy || currentPosition[18] == enemyKing) && currentPosition[23] == '-') {
                    temp = currentPosition.clone();
                    temp[14] = '-';
                    temp[18] = '-';
                    temp[23] = piece;
                    findRemainingBlackJumps(temp, 23, 14);
                }
            }
            //all moves from 15
            if (currentPosition[15] == piece) {
                if ((currentPosition[18] == enemy || currentPosition[18] == enemyKing) && currentPosition[22] == '-') {
                    temp = currentPosition.clone();
                    temp[15] = '-';
                    temp[18] = '-';
                    temp[22] = piece;
                    findRemainingBlackJumps(temp, 22, 15);
                }
            }
            //all moves from 16
            if (currentPosition[16] == piece) {
                if ((currentPosition[21] == enemy || currentPosition[21] == enemyKing) && currentPosition[25] == '-') {
                    temp = currentPosition.clone();
                    temp[16] = '-';
                    temp[21] = '-';
                    temp[25] = piece;
                    findRemainingBlackJumps(temp, 25, 16);
                }

            }
            //all moves from 17
            if (currentPosition[17] == piece) {
                if ((currentPosition[21] == enemy || currentPosition[21] == enemyKing) && currentPosition[24] == '-') {
                    temp = currentPosition.clone();
                    temp[17] = '-';
                    temp[21] = '-';
                    temp[24] = piece;
                    findRemainingBlackJumps(temp, 24, 17);
                }
                if ((currentPosition[22] == enemy || currentPosition[22] == enemyKing) && currentPosition[26] == '-') {
                    temp = currentPosition.clone();
                    temp[17] = '-';
                    temp[22] = '-';
                    temp[26] = piece;
                    findRemainingBlackJumps(temp, 26, 17);
                }
            }
            //all moves from 18
            if (currentPosition[18] == piece) {
                if ((currentPosition[22] == enemy || currentPosition[22] == enemyKing) && currentPosition[25] == '-') {
                    temp = currentPosition.clone();
                    temp[18] = '-';
                    temp[22] = '-';
                    temp[25] = piece;
                    findRemainingBlackJumps(temp, 25, 18);
                }
                if ((currentPosition[23] == enemy || currentPosition[23] == enemyKing) && currentPosition[27] == '-') {
                    temp = currentPosition.clone();
                    temp[18] = '-';
                    temp[23] = '-';
                    temp[27] = piece;
                    findRemainingBlackJumps(temp, 27, 18);
                }
            }
            //all moves from 19
            if (currentPosition[19] == piece) {
                if ((currentPosition[23] == enemy || currentPosition[23] == enemyKing) && currentPosition[26] == '-') {
                    temp = currentPosition.clone();
                    temp[19] = '-';
                    temp[23] = '-';
                    temp[26] = piece;
                    findRemainingBlackJumps(temp, 26, 19);
                }
            }
            //all moves from 20
            if (currentPosition[20] == piece) {
                if ((currentPosition[24] == enemy || currentPosition[24] == enemyKing) && currentPosition[29] == '-') {
                    temp = currentPosition.clone();
                    temp[20] = '-';
                    temp[24] = '-';
                    temp[29] = kingPiece;
                    findRemainingBlackJumps(temp, 29, 20);
                }
            }
            //all moves from 21
            if (currentPosition[21] == piece) {
                if ((currentPosition[24] == enemy || currentPosition[24] == enemyKing) && currentPosition[28] == '-') {
                    temp = currentPosition.clone();
                    temp[21] = '-';
                    temp[24] = '-';
                    temp[28] = kingPiece;
                    findRemainingBlackJumps(temp, 28, 21);
                }
                if ((currentPosition[25] == enemy || currentPosition[25] == enemyKing) && currentPosition[30] == '-') {
                    temp = currentPosition.clone();
                    temp[21] = '-';
                    temp[25] = '-';
                    temp[30] = kingPiece;
                    findRemainingBlackJumps(temp, 30, 21);
                }
            }
            //all moves from 22
            if (currentPosition[22] == piece) {
                if ((currentPosition[25] == enemy || currentPosition[25] == enemyKing) && currentPosition[29] == '-') {
                    temp = currentPosition.clone();
                    temp[22] = '-';
                    temp[25] = '-';
                    temp[29] = kingPiece;
                    findRemainingBlackJumps(temp, 29, 22);
                }
                if ((currentPosition[26] == enemy || currentPosition[26] == enemyKing) && currentPosition[31] == '-') {
                    temp = currentPosition.clone();
                    temp[22] = '-';
                    temp[26] = '-';
                    temp[31] = kingPiece;
                    findRemainingBlackJumps(temp, 31, 22);
                }
            }
            //all moves from 23
            if (currentPosition[23] == piece) {
                if ((currentPosition[26] == enemy || currentPosition[26] == enemyKing) && currentPosition[30] == '-') {
                    temp = currentPosition.clone();
                    temp[23] = '-';
                    temp[26] = '-';
                    temp[30] = kingPiece;
                    findRemainingBlackJumps(temp, 30, 23);
                }
            }
        } //start of white moves
        else {
            if (currentPosition[31] == piece) {
                if ((currentPosition[26] == enemy || currentPosition[26] == enemyKing) && currentPosition[22] == '-') {
                    temp = currentPosition.clone();
                    temp[31] = '-';
                    temp[26] = '-';
                    temp[22] = piece;
                    findRemainingWhiteJumps(temp, 22, 31);
                }
            }
            //all moves from 30
            if (currentPosition[30] == piece) {
                if ((currentPosition[26] == enemy || currentPosition[26] == enemyKing) && currentPosition[23] == '-') {
                    temp = currentPosition.clone();
                    temp[30] = '-';
                    temp[26] = '-';
                    temp[23] = piece;
                    findRemainingWhiteJumps(temp, 23, 30);
                }
                if ((currentPosition[25] == enemy || currentPosition[25] == enemyKing) && currentPosition[21] == '-') {
                    temp = currentPosition.clone();
                    temp[30] = '-';
                    temp[25] = '-';
                    temp[21] = piece;
                    findRemainingWhiteJumps(temp, 21, 30);
                }
            }
            //all moves from 29
            if (currentPosition[29] == piece) {
                if ((currentPosition[25] == enemy || currentPosition[25] == enemyKing) && currentPosition[22] == '-') {
                    temp = currentPosition.clone();
                    temp[29] = '-';
                    temp[25] = '-';
                    temp[22] = piece;
                    findRemainingWhiteJumps(temp, 22, 29);
                }
                if ((currentPosition[24] == enemy || currentPosition[24] == enemyKing) && currentPosition[20] == '-') {
                    temp = currentPosition.clone();
                    temp[29] = '-';
                    temp[24] = '-';
                    temp[20] = piece;
                    findRemainingWhiteJumps(temp, 20, 29);
                }
            }
            //all moves from 28
            if (currentPosition[28] == piece) {
                if ((currentPosition[24] == enemy || currentPosition[24] == enemyKing) && currentPosition[21] == '-') {
                    temp = currentPosition.clone();
                    temp[28] = '-';
                    temp[24] = '-';
                    temp[21] = piece;
                    findRemainingWhiteJumps(temp, 21, 28);
                }
            }
            //all moves from 27
            if (currentPosition[27] == piece) {
                if ((currentPosition[23] == enemy || currentPosition[23] == enemyKing) && currentPosition[18] == '-') {
                    temp = currentPosition.clone();
                    temp[27] = '-';
                    temp[23] = '-';
                    temp[18] = piece;
                    findRemainingWhiteJumps(temp, 18, 27);
                }
            }
            //all moves from 26
            if (currentPosition[26] == piece) {
                if ((currentPosition[23] == enemy || currentPosition[23] == enemyKing) && currentPosition[19] == '-') {
                    temp = currentPosition.clone();
                    temp[26] = '-';
                    temp[23] = '-';
                    temp[19] = piece;
                    findRemainingWhiteJumps(temp, 19, 26);
                }
                if ((currentPosition[22] == enemy || currentPosition[22] == enemyKing) && currentPosition[17] == '-') {
                    temp = currentPosition.clone();
                    temp[26] = '-';
                    temp[22] = '-';
                    temp[17] = piece;
                    findRemainingWhiteJumps(temp, 17, 26);
                }
            }
            //all moves from 25
            if (currentPosition[25] == piece) {
                if ((currentPosition[22] == enemy || currentPosition[22] == enemyKing) && currentPosition[18] == '-') {
                    temp = currentPosition.clone();
                    temp[25] = '-';
                    temp[22] = '-';
                    temp[18] = piece;
                    findRemainingWhiteJumps(temp, 18, 25);
                }
                if ((currentPosition[21] == enemy || currentPosition[21] == enemyKing) && currentPosition[16] == '-') {
                    temp = currentPosition.clone();
                    temp[25] = '-';
                    temp[21] = '-';
                    temp[16] = piece;
                    findRemainingWhiteJumps(temp, 16, 25);
                }
            }
            //all moves from 24
            if (currentPosition[24] == piece) {
                if ((currentPosition[21] == enemy || currentPosition[21] == enemyKing) && currentPosition[17] == '-') {
                    temp = currentPosition.clone();
                    temp[24] = '-';
                    temp[21] = '-';
                    temp[17] = piece;
                    findRemainingWhiteJumps(temp, 17, 24);
                }
            }
            //all moves from 23
            if (currentPosition[23] == piece) {
                if ((currentPosition[18] == enemy || currentPosition[18] == enemyKing) && currentPosition[14] == '-') {
                    temp = currentPosition.clone();
                    temp[23] = '-';
                    temp[18] = '-';
                    temp[14] = piece;
                    findRemainingWhiteJumps(temp, 14, 23);
                }
            }
            //all moves from 22
            if (currentPosition[22] == piece) {
                if ((currentPosition[18] == enemy || currentPosition[18] == enemyKing) && currentPosition[15] == '-') {
                    temp = currentPosition.clone();
                    temp[22] = '-';
                    temp[18] = '-';
                    temp[15] = piece;
                    findRemainingWhiteJumps(temp, 15, 22);
                }
                if ((currentPosition[17] == enemy || currentPosition[17] == enemyKing) && currentPosition[13] == '-') {
                    temp = currentPosition.clone();
                    temp[22] = '-';
                    temp[17] = '-';
                    temp[13] = piece;
                    findRemainingWhiteJumps(temp, 13, 22);
                }
            }
            //all moves from 21
            if (currentPosition[21] == piece) {
                if ((currentPosition[17] == enemy || currentPosition[17] == enemyKing) && currentPosition[14] == '-') {
                    temp = currentPosition.clone();
                    temp[21] = '-';
                    temp[17] = '-';
                    temp[14] = piece;
                    findRemainingWhiteJumps(temp, 14, 21);
                }
                if ((currentPosition[16] == enemy || currentPosition[16] == enemyKing) && currentPosition[12] == '-') {
                    temp = currentPosition.clone();
                    temp[21] = '-';
                    temp[16] = '-';
                    temp[12] = piece;
                    findRemainingWhiteJumps(temp, 12, 21);
                }
            }
            //all moves from 20
            if (currentPosition[20] == piece) {
                if ((currentPosition[16] == enemy || currentPosition[16] == enemyKing) && currentPosition[13] == '-') {
                    temp = currentPosition.clone();
                    temp[20] = '-';
                    temp[16] = '-';
                    temp[13] = piece;
                    findRemainingWhiteJumps(temp, 13, 20);
                }
            }
            //all moves from 19
            if (currentPosition[19] == piece) {
                if ((currentPosition[15] == enemy || currentPosition[15] == enemyKing) && currentPosition[10] == '-') {
                    temp = currentPosition.clone();
                    temp[19] = '-';
                    temp[15] = '-';
                    temp[10] = piece;
                    findRemainingWhiteJumps(temp, 10, 19);
                }
            }
            //all moves from 18
            if (currentPosition[18] == piece) {
                if ((currentPosition[15] == enemy || currentPosition[15] == enemyKing) && currentPosition[11] == '-') {
                    temp = currentPosition.clone();
                    temp[18] = '-';
                    temp[15] = '-';
                    temp[11] = piece;
                    findRemainingWhiteJumps(temp, 11, 18);
                }
                if ((currentPosition[14] == enemy || currentPosition[14] == enemyKing) && currentPosition[9] == '-') {
                    temp = currentPosition.clone();
                    temp[18] = '-';
                    temp[14] = '-';
                    temp[9] = piece;
                    findRemainingWhiteJumps(temp, 9, 18);
                }
            }
            //all moves from 17
            if (currentPosition[17] == piece) {
                if ((currentPosition[14] == enemy || currentPosition[14] == enemyKing) && currentPosition[10] == '-') {
                    temp = currentPosition.clone();
                    temp[17] = '-';
                    temp[14] = '-';
                    temp[10] = piece;
                    findRemainingWhiteJumps(temp, 10, 17);
                }
                if ((currentPosition[13] == enemy || currentPosition[13] == enemyKing) && currentPosition[8] == '-') {
                    temp = currentPosition.clone();
                    temp[17] = '-';
                    temp[13] = '-';
                    temp[8] = piece;
                    findRemainingWhiteJumps(temp, 8, 17);
                }
            }
            //all moves from 16
            if (currentPosition[16] == piece) {
                if ((currentPosition[13] == enemy || currentPosition[13] == enemyKing) && currentPosition[9] == '-') {
                    temp = currentPosition.clone();
                    temp[16] = '-';
                    temp[13] = '-';
                    temp[9] = piece;
                    findRemainingWhiteJumps(temp, 9, 16);
                }
            }
            //all moves from 15
            if (currentPosition[15] == piece) {
                if ((currentPosition[10] == enemy || currentPosition[10] == enemyKing) && currentPosition[6] == '-') {
                    temp = currentPosition.clone();
                    temp[15] = '-';
                    temp[10] = '-';
                    temp[6] = piece;
                    findRemainingWhiteJumps(temp, 6, 15);
                }
            }
            //all moves from 14
            if (currentPosition[14] == piece) {
                if ((currentPosition[10] == enemy || currentPosition[10] == enemyKing) && currentPosition[7] == '-') {
                    temp = currentPosition.clone();
                    temp[14] = '-';
                    temp[10] = '-';
                    temp[7] = piece;
                    findRemainingWhiteJumps(temp, 7, 14);
                }
                if ((currentPosition[9] == enemy || currentPosition[9] == enemyKing) && currentPosition[5] == '-') {
                    temp = currentPosition.clone();
                    temp[14] = '-';
                    temp[9] = '-';
                    temp[5] = piece;
                    findRemainingWhiteJumps(temp, 5, 14);
                }
            }
            //all moves from 13
            if (currentPosition[13] == piece) {
                if ((currentPosition[9] == enemy || currentPosition[9] == enemyKing) && currentPosition[6] == '-') {
                    temp = currentPosition.clone();
                    temp[13] = '-';
                    temp[9] = '-';
                    temp[6] = piece;
                    findRemainingWhiteJumps(temp, 6, 13);
                }
                if ((currentPosition[8] == enemy || currentPosition[8] == enemyKing) && currentPosition[4] == '-') {
                    temp = currentPosition.clone();
                    temp[13] = '-';
                    temp[8] = '-';
                    temp[4] = piece;
                    findRemainingWhiteJumps(temp, 4, 13);
                }
            }
            //all moves from 12
            if (currentPosition[12] == piece) {
                if ((currentPosition[8] == enemy || currentPosition[8] == enemyKing) && currentPosition[5] == '-') {
                    temp = currentPosition.clone();
                    temp[12] = '-';
                    temp[8] = '-';
                    temp[5] = piece;
                    findRemainingWhiteJumps(temp, 5, 12);
                }
            }
            //all moves from 11
            if (currentPosition[11] == piece) {
                if ((currentPosition[7] == enemy || currentPosition[7] == enemyKing) && currentPosition[2] == '-') {
                    temp = currentPosition.clone();
                    temp[11] = '-';
                    temp[7] = '-';
                    temp[2] = kingPiece;
                    findRemainingWhiteJumps(temp, 2, 11);
                }
            }
            //all moves from 10
            if (currentPosition[10] == piece) {
                if ((currentPosition[7] == enemy || currentPosition[7] == enemyKing) && currentPosition[3] == '-') {
                    temp = currentPosition.clone();
                    temp[10] = '-';
                    temp[7] = '-';
                    temp[3] = kingPiece;
                    findRemainingWhiteJumps(temp, 3, 10);
                }
                if ((currentPosition[6] == enemy || currentPosition[6] == enemyKing) && currentPosition[1] == '-') {
                    temp = currentPosition.clone();
                    temp[10] = '-';
                    temp[6] = '-';
                    temp[1] = kingPiece;
                    findRemainingWhiteJumps(temp, 1, 10);
                }
            }
            //all moves from 9
            if (currentPosition[9] == piece) {
                if ((currentPosition[6] == enemy || currentPosition[6] == enemyKing) && currentPosition[2] == '-') {
                    temp = currentPosition.clone();
                    temp[9] = '-';
                    temp[6] = '-';
                    temp[2] = kingPiece;
                    findRemainingWhiteJumps(temp, 2, 9);
                }
                if ((currentPosition[5] == enemy || currentPosition[5] == enemyKing) && currentPosition[0] == '-') {
                    temp = currentPosition.clone();
                    temp[9] = '-';
                    temp[5] = '-';
                    temp[0] = kingPiece;
                    findRemainingWhiteJumps(temp, 0, 9);
                }
            }
            //all moves from 8
            if (currentPosition[8] == piece) {
                if ((currentPosition[5] == enemy || currentPosition[5] == enemyKing) && currentPosition[1] == '-') {
                    temp = currentPosition.clone();
                    temp[8] = '-';
                    temp[5] = '-';
                    temp[1] = kingPiece;
                    findRemainingWhiteJumps(temp, 1, 8);
                }
            }
        }
        if (currentPosition[0] == kingPiece) {
            //the king can make at least one jump
            if ((currentPosition[5] == enemy || currentPosition[5] == enemyKing) && currentPosition[9] == '-') {
                temp = currentPosition.clone();
                temp[0] = '-';
                temp[5] = '-';
                temp[9] = kingPiece;
                findRemainingKingJumps(temp, 9, 0);
            }
        }
        if (currentPosition[1] == kingPiece) {
            //the king can make at least one jump
            if ((currentPosition[5] == enemy || currentPosition[5] == enemyKing) && currentPosition[8] == '-') {
                temp = currentPosition.clone();
                temp[1] = '-';
                temp[5] = '-';
                temp[8] = kingPiece;
                findRemainingKingJumps(temp, 8, 1);
            }
            if ((currentPosition[6] == enemy || currentPosition[6] == enemyKing) && currentPosition[10] == '-') {
                temp = currentPosition.clone();
                temp[1] = '-';
                temp[6] = '-';
                temp[10] = kingPiece;
                findRemainingKingJumps(temp, 10, 1);
            }
        }
        if (currentPosition[2] == kingPiece) {
            //the king can make at least one jump
            if ((currentPosition[6] == enemy || currentPosition[6] == enemyKing) && currentPosition[9] == '-') {
                temp = currentPosition.clone();
                temp[2] = '-';
                temp[6] = '-';
                temp[9] = kingPiece;
                findRemainingKingJumps(temp, 9, 2);
            }
            if ((currentPosition[7] == enemy || currentPosition[7] == enemyKing) && currentPosition[11] == '-') {
                temp = currentPosition.clone();
                temp[2] = '-';
                temp[7] = '-';
                temp[11] = kingPiece;
                findRemainingKingJumps(temp, 11, 2);
            }
        }
        if (currentPosition[3] == kingPiece) {
            //the king can make at least one jump
            if ((currentPosition[7] == enemy || currentPosition[7] == enemyKing) && currentPosition[10] == '-') {
                temp = currentPosition.clone();
                temp[3] = '-';
                temp[7] = '-';
                temp[10] = kingPiece;
                findRemainingKingJumps(temp, 10, 3);
            }
        }
        if (currentPosition[4] == kingPiece) {
            //the king can make at least one jump
            if ((currentPosition[8] == enemy || currentPosition[8] == enemyKing) && currentPosition[13] == '-') {
                temp = currentPosition.clone();
                temp[4] = '-';
                temp[8] = '-';
                temp[13] = kingPiece;
                findRemainingKingJumps(temp, 13, 4);
            }
        }
        if (currentPosition[5] == kingPiece) {
            //the king can make at least one jump
            if ((currentPosition[8] == enemy || currentPosition[8] == enemyKing) && currentPosition[12] == '-') {
                temp = currentPosition.clone();
                temp[5] = '-';
                temp[8] = '-';
                temp[12] = kingPiece;
                findRemainingKingJumps(temp, 12, 5);
            }
            if ((currentPosition[9] == enemy || currentPosition[9] == enemyKing) && currentPosition[14] == '-') {
                temp = currentPosition.clone();
                temp[5] = '-';
                temp[9] = '-';
                temp[14] = kingPiece;
                findRemainingKingJumps(temp, 14, 5);
            }
        }
        if (currentPosition[6] == kingPiece) {
            //the king can make at least one jump
            if ((currentPosition[9] == enemy || currentPosition[9] == enemyKing) && currentPosition[13] == '-') {
                temp = currentPosition.clone();
                temp[6] = '-';
                temp[9] = '-';
                temp[13] = kingPiece;
                findRemainingKingJumps(temp, 13, 6);
            }
            if ((currentPosition[10] == enemy || currentPosition[10] == enemyKing) && currentPosition[15] == '-') {
                temp = currentPosition.clone();
                temp[6] = '-';
                temp[10] = '-';
                temp[15] = kingPiece;
                findRemainingKingJumps(temp, 15, 6);
            }
        }
        if (currentPosition[7] == kingPiece) {
            //the king can make at least one jump
            if ((currentPosition[10] == enemy || currentPosition[10] == enemyKing) && currentPosition[14] == '-') {
                temp = currentPosition.clone();
                temp[7] = '-';
                temp[10] = '-';
                temp[14] = kingPiece;
                findRemainingKingJumps(temp, 14, 7);
            }
        }
        if (currentPosition[8] == kingPiece) {
            //the king can make at least one jump
            if ((currentPosition[5] == enemy || currentPosition[5] == enemyKing) && currentPosition[1] == '-') {
                temp = currentPosition.clone();
                temp[8] = '-';
                temp[5] = '-';
                temp[1] = kingPiece;
                findRemainingKingJumps(temp, 1, 8);
            }
            if ((currentPosition[13] == enemy || currentPosition[13] == enemyKing) && currentPosition[17] == '-') {
                temp = currentPosition.clone();
                temp[8] = '-';
                temp[13] = '-';
                temp[17] = kingPiece;
                findRemainingKingJumps(temp, 17, 8);
            }
        }
        if (currentPosition[9] == kingPiece) {
            //the king can make at least one jump
            if ((currentPosition[5] == enemy || currentPosition[5] == enemyKing) && currentPosition[0] == '-') {
                temp = currentPosition.clone();
                temp[9] = '-';
                temp[5] = '-';
                temp[0] = kingPiece;
                findRemainingKingJumps(temp, 0, 9);
            }
            if ((currentPosition[6] == enemy || currentPosition[6] == enemyKing) && currentPosition[2] == '-') {
                temp = currentPosition.clone();
                temp[9] = '-';
                temp[6] = '-';
                temp[2] = kingPiece;
                findRemainingKingJumps(temp, 2, 9);
            }
            if ((currentPosition[14] == enemy || currentPosition[14] == enemyKing) && currentPosition[18] == '-') {
                temp = currentPosition.clone();
                temp[9] = '-';
                temp[14] = '-';
                temp[18] = kingPiece;
                findRemainingKingJumps(temp, 18, 9);
            }
            if ((currentPosition[13] == enemy || currentPosition[13] == enemyKing) && currentPosition[16] == '-') {
                temp = currentPosition.clone();
                temp[9] = '-';
                temp[13] = '-';
                temp[16] = kingPiece;
                findRemainingKingJumps(temp, 16, 9);
            }
        }
        if (currentPosition[10] == kingPiece) {
            //the king can make at least one jump
            if ((currentPosition[6] == enemy || currentPosition[6] == enemyKing) && currentPosition[1] == '-') {
                temp = currentPosition.clone();
                temp[10] = '-';
                temp[6] = '-';
                temp[1] = kingPiece;
                findRemainingKingJumps(temp, 1, 10);
            }
            if ((currentPosition[7] == enemy || currentPosition[7] == enemyKing) && currentPosition[3] == '-') {
                temp = currentPosition.clone();
                temp[10] = '-';
                temp[7] = '-';
                temp[3] = kingPiece;
                findRemainingKingJumps(temp, 3, 10);
            }
            if ((currentPosition[15] == enemy || currentPosition[15] == enemyKing) && currentPosition[19] == '-') {
                temp = currentPosition.clone();
                temp[10] = '-';
                temp[15] = '-';
                temp[19] = kingPiece;
                findRemainingKingJumps(temp, 19, 10);
            }
            if ((currentPosition[14] == enemy || currentPosition[14] == enemyKing) && currentPosition[17] == '-') {
                temp = currentPosition.clone();
                temp[10] = '-';
                temp[14] = '-';
                temp[17] = kingPiece;
                findRemainingKingJumps(temp, 17, 10);
            }
        }
        if (currentPosition[11] == kingPiece) {
            //the king can make at least one jump
            if ((currentPosition[7] == enemy || currentPosition[7] == enemyKing) && currentPosition[2] == '-') {
                temp = currentPosition.clone();
                temp[11] = '-';
                temp[7] = '-';
                temp[2] = kingPiece;
                findRemainingKingJumps(temp, 2, 11);
            }
            if ((currentPosition[15] == enemy || currentPosition[15] == enemyKing) && currentPosition[18] == '-') {
                temp = currentPosition.clone();
                temp[11] = '-';
                temp[15] = '-';
                temp[18] = kingPiece;
                findRemainingKingJumps(temp, 18, 11);
            }

        }
        if (currentPosition[12] == kingPiece) {
            //the king can make at least one jump
            if ((currentPosition[8] == enemy || currentPosition[8] == enemyKing) && currentPosition[5] == '-') {
                temp = currentPosition.clone();
                temp[12] = '-';
                temp[8] = '-';
                temp[5] = kingPiece;
                findRemainingKingJumps(temp, 5, 12);
            }
            if ((currentPosition[16] == enemy || currentPosition[16] == enemyKing) && currentPosition[21] == '-') {
                temp = currentPosition.clone();
                temp[12] = '-';
                temp[16] = '-';
                temp[21] = kingPiece;
                findRemainingKingJumps(temp, 21, 12);
            }
        }
        if (currentPosition[13] == kingPiece) {
            //the king can make at least one jump
            if ((currentPosition[8] == enemy || currentPosition[8] == enemyKing) && currentPosition[4] == '-') {
                temp = currentPosition.clone();
                temp[13] = '-';
                temp[8] = '-';
                temp[4] = kingPiece;
                findRemainingKingJumps(temp, 4, 13);
            }
            if ((currentPosition[9] == enemy || currentPosition[9] == enemyKing) && currentPosition[6] == '-') {
                temp = currentPosition.clone();
                temp[13] = '-';
                temp[9] = '-';
                temp[6] = kingPiece;
                findRemainingKingJumps(temp, 6, 13);
            }
            if ((currentPosition[17] == enemy || currentPosition[17] == enemyKing) && currentPosition[22] == '-') {
                temp = currentPosition.clone();
                temp[13] = '-';
                temp[17] = '-';
                temp[22] = kingPiece;
                findRemainingKingJumps(temp, 22, 13);
            }
            if ((currentPosition[16] == enemy || currentPosition[16] == enemyKing) && currentPosition[20] == '-') {
                temp = currentPosition.clone();
                temp[13] = '-';
                temp[16] = '-';
                temp[20] = kingPiece;
                findRemainingKingJumps(temp, 20, 13);
            }
        }
        if (currentPosition[14] == kingPiece) {
            //the king can make at least one jump
            if ((currentPosition[9] == enemy || currentPosition[9] == enemyKing) && currentPosition[5] == '-') {
                temp = currentPosition.clone();
                temp[14] = '-';
                temp[9] = '-';
                temp[5] = kingPiece;
                findRemainingKingJumps(temp, 5, 14);
            }
            if ((currentPosition[10] == enemy || currentPosition[10] == enemyKing) && currentPosition[7] == '-') {
                temp = currentPosition.clone();
                temp[14] = '-';
                temp[10] = '-';
                temp[7] = kingPiece;
                findRemainingKingJumps(temp, 7, 14);
            }
            if ((currentPosition[18] == enemy || currentPosition[18] == enemyKing) && currentPosition[23] == '-') {
                temp = currentPosition.clone();
                temp[14] = '-';
                temp[18] = '-';
                temp[23] = kingPiece;
                findRemainingKingJumps(temp, 23, 14);
            }
            if ((currentPosition[17] == enemy || currentPosition[17] == enemyKing) && currentPosition[21] == '-') {
                temp = currentPosition.clone();
                temp[14] = '-';
                temp[17] = '-';
                temp[21] = kingPiece;
                findRemainingKingJumps(temp, 21, 14);
            }
        }
        if (currentPosition[15] == kingPiece) {
            //the king can make at least one jump
            if ((currentPosition[10] == enemy || currentPosition[10] == enemyKing) && currentPosition[6] == '-') {
                temp = currentPosition.clone();
                temp[15] = '-';
                temp[10] = '-';
                temp[6] = kingPiece;
                findRemainingKingJumps(temp, 6, 15);
            }
            if ((currentPosition[18] == enemy || currentPosition[18] == enemyKing) && currentPosition[22] == '-') {
                temp = currentPosition.clone();
                temp[15] = '-';
                temp[18] = '-';
                temp[22] = kingPiece;
                findRemainingKingJumps(temp, 22, 15);
            }
        }
        if (currentPosition[16] == kingPiece) {
            //the king can make at least one jump
            if ((currentPosition[13] == enemy || currentPosition[13] == enemyKing) && currentPosition[9] == '-') {
                temp = currentPosition.clone();
                temp[16] = '-';
                temp[13] = '-';
                temp[9] = kingPiece;
                findRemainingKingJumps(temp, 9, 16);
            }
            if ((currentPosition[21] == enemy || currentPosition[21] == enemyKing) && currentPosition[25] == '-') {
                temp = currentPosition.clone();
                temp[16] = '-';
                temp[21] = '-';
                temp[25] = kingPiece;
                findRemainingKingJumps(temp, 25, 16);
            }
        }
        if (currentPosition[17] == kingPiece) {
            //the king can make at least one jump
            if ((currentPosition[13] == enemy || currentPosition[13] == enemyKing) && currentPosition[8] == '-') {
                temp = currentPosition.clone();
                temp[17] = '-';
                temp[13] = '-';
                temp[8] = kingPiece;
                findRemainingKingJumps(temp, 8, 17);
            }
            if ((currentPosition[14] == enemy || currentPosition[14] == enemyKing) && currentPosition[10] == '-') {
                temp = currentPosition.clone();
                temp[17] = '-';
                temp[14] = '-';
                temp[10] = kingPiece;
                findRemainingKingJumps(temp, 10, 17);
            }
            if ((currentPosition[22] == enemy || currentPosition[22] == enemyKing) && currentPosition[26] == '-') {
                temp = currentPosition.clone();
                temp[17] = '-';
                temp[22] = '-';
                temp[26] = kingPiece;
                findRemainingKingJumps(temp, 26, 17);
            }
            if ((currentPosition[21] == enemy || currentPosition[21] == enemyKing) && currentPosition[24] == '-') {
                temp = currentPosition.clone();
                temp[17] = '-';
                temp[21] = '-';
                temp[24] = kingPiece;
                findRemainingKingJumps(temp, 24, 17);
            }
        }
        if (currentPosition[18] == kingPiece) {
            //the king can make at least one jump
            if ((currentPosition[14] == enemy || currentPosition[14] == enemyKing) && currentPosition[9] == '-') {
                temp = currentPosition.clone();
                temp[18] = '-';
                temp[14] = '-';
                temp[9] = kingPiece;
                findRemainingKingJumps(temp, 9, 18);
            }
            if ((currentPosition[15] == enemy || currentPosition[15] == enemyKing) && currentPosition[11] == '-') {
                temp = currentPosition.clone();
                temp[18] = '-';
                temp[15] = '-';
                temp[11] = kingPiece;
                findRemainingKingJumps(temp, 11, 18);
            }
            if ((currentPosition[23] == enemy || currentPosition[23] == enemyKing) && currentPosition[27] == '-') {
                temp = currentPosition.clone();
                temp[18] = '-';
                temp[23] = '-';
                temp[27] = kingPiece;
                findRemainingKingJumps(temp, 27, 18);
            }
            if ((currentPosition[22] == enemy || currentPosition[22] == enemyKing) && currentPosition[25] == '-') {
                temp = currentPosition.clone();
                temp[18] = '-';
                temp[22] = '-';
                temp[25] = kingPiece;
                findRemainingKingJumps(temp, 25, 18);
            }
        }
        if (currentPosition[19] == kingPiece) {
            //the king can make at least one jump
            if ((currentPosition[15] == enemy || currentPosition[15] == enemyKing) && currentPosition[10] == '-') {
                temp = currentPosition.clone();
                temp[19] = '-';
                temp[15] = '-';
                temp[10] = kingPiece;
                findRemainingKingJumps(temp, 10, 19);
            }
            if ((currentPosition[23] == enemy || currentPosition[23] == enemyKing) && currentPosition[26] == '-') {
                temp = currentPosition.clone();
                temp[19] = '-';
                temp[23] = '-';
                temp[26] = kingPiece;
                findRemainingKingJumps(temp, 26, 19);
            }
        } else if (currentPosition[20] == kingPiece) {
            //the king can make at least one jump
            if ((currentPosition[16] == enemy || currentPosition[16] == enemyKing) && currentPosition[13] == '-') {
                temp = currentPosition.clone();
                temp[20] = '-';
                temp[16] = '-';
                temp[13] = kingPiece;
                findRemainingKingJumps(temp, 13, 20);
            }
            if ((currentPosition[24] == enemy || currentPosition[24] == enemyKing) && currentPosition[29] == '-') {
                temp = currentPosition.clone();
                temp[20] = '-';
                temp[24] = '-';
                temp[29] = kingPiece;
                findRemainingKingJumps(temp, 29, 20);
            }
        }
        if (currentPosition[21] == kingPiece) {
            //the king can make at least one jump
            if ((currentPosition[16] == enemy || currentPosition[16] == enemyKing) && currentPosition[12] == '-') {
                temp = currentPosition.clone();
                temp[21] = '-';
                temp[16] = '-';
                temp[12] = kingPiece;
                findRemainingKingJumps(temp, 12, 21);
            }
            if ((currentPosition[17] == enemy || currentPosition[17] == enemyKing) && currentPosition[14] == '-') {
                temp = currentPosition.clone();
                temp[21] = '-';
                temp[17] = '-';
                temp[14] = kingPiece;
                findRemainingKingJumps(temp, 14, 21);
            }
            if ((currentPosition[25] == enemy || currentPosition[25] == enemyKing) && currentPosition[30] == '-') {
                temp = currentPosition.clone();
                temp[21] = '-';
                temp[25] = '-';
                temp[30] = kingPiece;
                findRemainingKingJumps(temp, 30, 21);
            }
            if ((currentPosition[24] == enemy || currentPosition[24] == enemyKing) && currentPosition[28] == '-') {
                temp = currentPosition.clone();
                temp[21] = '-';
                temp[24] = '-';
                temp[28] = kingPiece;
                findRemainingKingJumps(temp, 28, 21);
            }
        }
        if (currentPosition[22] == kingPiece) {
            //the king can make at least one jump
            if ((currentPosition[17] == enemy || currentPosition[17] == enemyKing) && currentPosition[13] == '-') {
                temp = currentPosition.clone();
                temp[22] = '-';
                temp[17] = '-';
                temp[13] = kingPiece;
                findRemainingKingJumps(temp, 13, 22);
            }
            if ((currentPosition[18] == enemy || currentPosition[18] == enemyKing) && currentPosition[15] == '-') {
                temp = currentPosition.clone();
                temp[22] = '-';
                temp[18] = '-';
                temp[15] = kingPiece;
                findRemainingKingJumps(temp, 15, 22);
            }
            if ((currentPosition[26] == enemy || currentPosition[26] == enemyKing) && currentPosition[31] == '-') {
                temp = currentPosition.clone();
                temp[22] = '-';
                temp[26] = '-';
                temp[31] = kingPiece;
                findRemainingKingJumps(temp, 31, 22);
            }
            if ((currentPosition[25] == enemy || currentPosition[25] == enemyKing) && currentPosition[29] == '-') {
                temp = currentPosition.clone();
                temp[22] = '-';
                temp[25] = '-';
                temp[29] = kingPiece;
                findRemainingKingJumps(temp, 29, 22);
            }
        }
        if (currentPosition[23] == kingPiece) {
            //the king can make at least one jump
            if ((currentPosition[18] == enemy || currentPosition[18] == enemyKing) && currentPosition[14] == '-') {
                temp = currentPosition.clone();
                temp[23] = '-';
                temp[18] = '-';
                temp[14] = kingPiece;
                findRemainingKingJumps(temp, 14, 23);
            }
            if ((currentPosition[26] == enemy || currentPosition[26] == enemyKing) && currentPosition[30] == '-') {
                temp = currentPosition.clone();
                temp[23] = '-';
                temp[26] = '-';
                temp[30] = kingPiece;
                findRemainingKingJumps(temp, 30, 23);
            }
        }
        //all moves from 24
        if (currentPosition[24] == kingPiece) {
            if ((currentPosition[21] == enemy || currentPosition[21] == enemyKing) && currentPosition[17] == '-') {
                temp = currentPosition.clone();
                temp[24] = '-';
                temp[21] = '-';
                temp[17] = kingPiece;
                findRemainingKingJumps(temp, 17, 24);
            }
        }
        //all moves from 25
        if (currentPosition[25] == kingPiece) {
            if ((currentPosition[21] == enemy || currentPosition[21] == enemyKing) && currentPosition[16] == '-') {
                temp = currentPosition.clone();
                temp[25] = '-';
                temp[21] = '-';
                temp[16] = kingPiece;
                findRemainingKingJumps(temp, 16, 25);
            }
            if ((currentPosition[22] == enemy || currentPosition[22] == enemyKing) && currentPosition[18] == '-') {
                temp = currentPosition.clone();
                temp[25] = '-';
                temp[22] = '-';
                temp[18] = kingPiece;
                findRemainingKingJumps(temp, 18, 25);
            }
        }
        //all moves from 26
        if (currentPosition[26] == kingPiece) {
            if ((currentPosition[22] == enemy || currentPosition[22] == enemyKing) && currentPosition[17] == '-') {
                temp = currentPosition.clone();
                temp[26] = '-';
                temp[22] = '-';
                temp[17] = kingPiece;
                findRemainingKingJumps(temp, 17, 26);
            }
            if ((currentPosition[23] == enemy || currentPosition[23] == enemyKing) && currentPosition[19] == '-') {
                temp = currentPosition.clone();
                temp[26] = '-';
                temp[23] = '-';
                temp[19] = kingPiece;
                findRemainingKingJumps(temp, 19, 26);
            }
        }
        //all moves from 27
        if (currentPosition[27] == kingPiece) {
            if ((currentPosition[23] == enemy || currentPosition[23] == enemyKing) && currentPosition[18] == '-') {
                temp = currentPosition.clone();
                temp[27] = '-';
                temp[23] = '-';
                temp[18] = kingPiece;
                findRemainingKingJumps(temp, 18, 27);
            }
        }
        //all moves from 28
        if (currentPosition[28] == kingPiece) {
            if ((currentPosition[24] == enemy || currentPosition[24] == enemyKing) && currentPosition[21] == '-') {
                temp = currentPosition.clone();
                temp[28] = '-';
                temp[24] = '-';
                temp[21] = kingPiece;
                findRemainingKingJumps(temp, 21, 28);
            }
        }
        //all moves from 29
        if (currentPosition[29] == kingPiece) {
            if ((currentPosition[24] == enemy || currentPosition[24] == enemyKing) && currentPosition[20] == '-') {
                temp = currentPosition.clone();
                temp[29] = '-';
                temp[24] = '-';
                temp[20] = kingPiece;
                findRemainingKingJumps(temp, 20, 29);
            }
            if ((currentPosition[25] == enemy || currentPosition[25] == enemyKing) && currentPosition[22] == '-') {
                temp = currentPosition.clone();
                temp[29] = '-';
                temp[25] = '-';
                temp[22] = kingPiece;
                findRemainingKingJumps(temp, 22, 29);
            }
        }
        //all moves from 30
        if (currentPosition[30] == kingPiece) {
            if ((currentPosition[25] == enemy || currentPosition[25] == enemyKing) && currentPosition[21] == '-') {
                temp = currentPosition.clone();
                temp[30] = '-';
                temp[25] = '-';
                temp[21] = kingPiece;
                findRemainingKingJumps(temp, 21, 30);
            }
            if ((currentPosition[26] == enemy || currentPosition[26] == enemyKing) && currentPosition[23] == '-') {
                temp = currentPosition.clone();
                temp[30] = '-';
                temp[26] = '-';
                temp[23] = kingPiece;
                findRemainingKingJumps(temp, 23, 30);
            }
        }
        //all moves from 31
        if (currentPosition[31] == kingPiece) {
            if ((currentPosition[26] == enemy || currentPosition[26] == enemyKing) && currentPosition[22] == '-') {
                temp = currentPosition.clone();
                temp[31] = '-';
                temp[26] = '-';
                temp[22] = kingPiece;
                findRemainingKingJumps(temp, 22, 31);
            }
        }
    }

    private void findNonJumps() {
        char[] temp;

        if (blacksMove) {
            //single moves from position 0
            if (currentPosition[0] == 'b') {
                if (currentPosition[4] == '-') {
                    temp = currentPosition.clone();
                    temp[0] = '-';
                    temp[4] = 'b';
                    allPossibleMoves.add(new Node(temp, 0, 4));
                }
                if (currentPosition[5] == '-') {
                    temp = currentPosition.clone();
                    temp[0] = '-';
                    temp[5] = 'b';
                    allPossibleMoves.add(new Node(temp, 0, 5));
                }
            } else if (currentPosition[0] == 'B') {
                if (currentPosition[4] == '-') {
                    temp = currentPosition.clone();
                    temp[0] = '-';
                    temp[4] = 'B';
                    allPossibleMoves.add(new Node(temp, 0, 4));
                }
                if (currentPosition[5] == '-') {
                    temp = currentPosition.clone();
                    temp[0] = '-';
                    temp[5] = 'B';
                    allPossibleMoves.add(new Node(temp, 0, 5));
                }
            }
            //single moves from position 1
            if (currentPosition[1] == 'b') {
                if (currentPosition[5] == '-') {
                    temp = currentPosition.clone();
                    temp[1] = '-';
                    temp[5] = 'b';
                    allPossibleMoves.add(new Node(temp, 1, 5));
                }
                if (currentPosition[6] == '-') {
                    temp = currentPosition.clone();
                    temp[1] = '-';
                    temp[6] = 'b';
                    allPossibleMoves.add(new Node(temp, 1, 6));
                }
            } else if (currentPosition[1] == 'B') {
                if (currentPosition[5] == '-') {
                    temp = currentPosition.clone();
                    temp[1] = '-';
                    temp[5] = 'B';
                    allPossibleMoves.add(new Node(temp, 1, 5));
                }
                if (currentPosition[6] == '-') {
                    temp = currentPosition.clone();
                    temp[1] = '-';
                    temp[6] = 'B';
                    allPossibleMoves.add(new Node(temp, 1, 6));
                }
            }
            //single moves from position 2
            if (currentPosition[2] == 'b') {
                if (currentPosition[6] == '-') {
                    temp = currentPosition.clone();
                    temp[2] = '-';
                    temp[6] = 'b';
                    allPossibleMoves.add(new Node(temp, 2, 6));
                }
                if (currentPosition[7] == '-') {
                    temp = currentPosition.clone();
                    temp[2] = '-';
                    temp[7] = 'b';
                    allPossibleMoves.add(new Node(temp, 2, 7));
                }
            } else if (currentPosition[2] == 'B') {
                if (currentPosition[6] == '-') {
                    temp = currentPosition.clone();
                    temp[2] = '-';
                    temp[6] = 'B';
                    allPossibleMoves.add(new Node(temp, 2, 6));
                }
                if (currentPosition[7] == '-') {
                    temp = currentPosition.clone();
                    temp[2] = '-';
                    temp[7] = 'B';
                    allPossibleMoves.add(new Node(temp, 2, 7));
                }
            }

            //single moves from position 3
            if (currentPosition[3] == 'b') {
                if (currentPosition[7] == '-') {
                    temp = currentPosition.clone();
                    temp[3] = '-';
                    temp[7] = 'b';
                    allPossibleMoves.add(new Node(temp, 3, 7));
                }
            } else if (currentPosition[3] == 'B') {
                if (currentPosition[7] == '-') {
                    temp = currentPosition.clone();
                    temp[3] = '-';
                    temp[7] = 'B';
                    allPossibleMoves.add(new Node(temp, 3, 7));
                }
            }

            //single moves from position 4
            if (currentPosition[4] == 'b') {
                if (currentPosition[8] == '-') {
                    temp = currentPosition.clone();
                    temp[4] = '-';
                    temp[8] = 'b';
                    allPossibleMoves.add(new Node(temp, 4, 8));
                }
            } else if (currentPosition[4] == 'B') {
                if (currentPosition[0] == '-') {
                    temp = currentPosition.clone();
                    temp[4] = '-';
                    temp[0] = 'B';
                    allPossibleMoves.add(new Node(temp, 4, 0));
                }
                if (currentPosition[8] == '-') {
                    temp = currentPosition.clone();
                    temp[4] = '-';
                    temp[8] = 'B';
                    allPossibleMoves.add(new Node(temp, 4, 8));
                }
            }
            //single moves from position 5
            if (currentPosition[5] == 'b') {
                if (currentPosition[8] == '-') {
                    temp = currentPosition.clone();
                    temp[5] = '-';
                    temp[8] = 'b';
                    allPossibleMoves.add(new Node(temp, 5, 8));
                }
                if (currentPosition[9] == '-') {
                    temp = currentPosition.clone();
                    temp[5] = '-';
                    temp[9] = 'b';
                    allPossibleMoves.add(new Node(temp, 5, 9));
                }
            } else if (currentPosition[5] == 'B') {
                if (currentPosition[0] == '-') {
                    temp = currentPosition.clone();
                    temp[5] = '-';
                    temp[0] = 'B';
                    allPossibleMoves.add(new Node(temp, 5, 0));
                }
                if (currentPosition[1] == '-') {
                    temp = currentPosition.clone();
                    temp[5] = '-';
                    temp[1] = 'B';
                    allPossibleMoves.add(new Node(temp, 5, 1));
                }
                if (currentPosition[8] == '-') {
                    temp = currentPosition.clone();
                    temp[5] = '-';
                    temp[8] = 'B';
                    allPossibleMoves.add(new Node(temp, 5, 8));
                }
                if (currentPosition[9] == '-') {
                    temp = currentPosition.clone();
                    temp[5] = '-';
                    temp[9] = 'B';
                    allPossibleMoves.add(new Node(temp, 5, 9));
                }
            }

            //single moves from position 6
            if (currentPosition[6] == 'b') {
                if (currentPosition[9] == '-') {
                    temp = currentPosition.clone();
                    temp[6] = '-';
                    temp[9] = 'b';
                    allPossibleMoves.add(new Node(temp, 6, 9));
                }
                if (currentPosition[10] == '-') {
                    temp = currentPosition.clone();
                    temp[6] = '-';
                    temp[10] = 'b';
                    allPossibleMoves.add(new Node(temp, 6, 10));
                }
            } else if (currentPosition[6] == 'B') {
                if (currentPosition[1] == '-') {
                    temp = currentPosition.clone();
                    temp[6] = '-';
                    temp[1] = 'B';
                    allPossibleMoves.add(new Node(temp, 6, 1));
                }
                if (currentPosition[2] == '-') {
                    temp = currentPosition.clone();
                    temp[6] = '-';
                    temp[2] = 'B';
                    allPossibleMoves.add(new Node(temp, 6, 2));
                }
                if (currentPosition[10] == '-') {
                    temp = currentPosition.clone();
                    temp[6] = '-';
                    temp[10] = 'B';
                    allPossibleMoves.add(new Node(temp, 6, 10));
                }
                if (currentPosition[9] == '-') {
                    temp = currentPosition.clone();
                    temp[6] = '-';
                    temp[9] = 'B';
                    allPossibleMoves.add(new Node(temp, 6, 9));
                }
            }
            //single moves from position 7
            if (currentPosition[7] == 'b') {
                if (currentPosition[10] == '-') {
                    temp = currentPosition.clone();
                    temp[7] = '-';
                    temp[10] = 'b';
                    allPossibleMoves.add(new Node(temp, 7, 10));
                }
                if (currentPosition[11] == '-') {
                    temp = currentPosition.clone();
                    temp[7] = '-';
                    temp[11] = 'b';
                    allPossibleMoves.add(new Node(temp, 7, 11));
                }
            } else if (currentPosition[7] == 'B') {
                if (currentPosition[2] == '-') {
                    temp = currentPosition.clone();
                    temp[7] = '-';
                    temp[2] = 'B';
                    allPossibleMoves.add(new Node(temp, 7, 2));
                }
                if (currentPosition[3] == '-') {
                    temp = currentPosition.clone();
                    temp[7] = '-';
                    temp[3] = 'B';
                    allPossibleMoves.add(new Node(temp, 7, 3));
                }
                if (currentPosition[10] == '-') {
                    temp = currentPosition.clone();
                    temp[7] = '-';
                    temp[10] = 'B';
                    allPossibleMoves.add(new Node(temp, 7, 10));
                }
                if (currentPosition[11] == '-') {
                    temp = currentPosition.clone();
                    temp[7] = '-';
                    temp[11] = 'B';
                    allPossibleMoves.add(new Node(temp, 7, 11));
                }
            }
            //single moves from position 8
            if (currentPosition[8] == 'b') {
                if (currentPosition[12] == '-') {
                    temp = currentPosition.clone();
                    temp[8] = '-';
                    temp[12] = 'b';
                    allPossibleMoves.add(new Node(temp, 8, 12));
                }
                if (currentPosition[13] == '-') {
                    temp = currentPosition.clone();
                    temp[8] = '-';
                    temp[13] = 'b';
                    allPossibleMoves.add(new Node(temp, 8, 13));
                }
            } else if (currentPosition[8] == 'B') {
                if (currentPosition[4] == '-') {
                    temp = currentPosition.clone();
                    temp[8] = '-';
                    temp[4] = 'B';
                    allPossibleMoves.add(new Node(temp, 8, 4));
                }
                if (currentPosition[5] == '-') {
                    temp = currentPosition.clone();
                    temp[8] = '-';
                    temp[5] = 'B';
                    allPossibleMoves.add(new Node(temp, 8, 5));
                }
                if (currentPosition[13] == '-') {
                    temp = currentPosition.clone();
                    temp[8] = '-';
                    temp[13] = 'B';
                    allPossibleMoves.add(new Node(temp, 8, 13));
                }
                if (currentPosition[12] == '-') {
                    temp = currentPosition.clone();
                    temp[8] = '-';
                    temp[12] = 'B';
                    allPossibleMoves.add(new Node(temp, 8, 12));
                }
            }

            //single moves from position 9
            if (currentPosition[9] == 'b') {
                if (currentPosition[13] == '-') {
                    temp = currentPosition.clone();
                    temp[9] = '-';
                    temp[13] = 'b';
                    allPossibleMoves.add(new Node(temp, 9, 13));
                }
                if (currentPosition[14] == '-') {
                    temp = currentPosition.clone();
                    temp[9] = '-';
                    temp[14] = 'b';
                    allPossibleMoves.add(new Node(temp, 9, 14));
                }
            } else if (currentPosition[9] == 'B') {
                if (currentPosition[5] == '-') {
                    temp = currentPosition.clone();
                    temp[9] = '-';
                    temp[5] = 'B';
                    allPossibleMoves.add(new Node(temp, 9, 5));
                }
                if (currentPosition[6] == '-') {
                    temp = currentPosition.clone();
                    temp[9] = '-';
                    temp[6] = 'B';
                    allPossibleMoves.add(new Node(temp, 9, 6));
                }
                if (currentPosition[14] == '-') {
                    temp = currentPosition.clone();
                    temp[9] = '-';
                    temp[14] = 'B';
                    allPossibleMoves.add(new Node(temp, 9, 14));
                }
                if (currentPosition[13] == '-') {
                    temp = currentPosition.clone();
                    temp[9] = '-';
                    temp[13] = 'B';
                    allPossibleMoves.add(new Node(temp, 9, 13));
                }
            }
            //single moves from position 10
            if (currentPosition[10] == 'b') {
                if (currentPosition[14] == '-') {
                    temp = currentPosition.clone();
                    temp[10] = '-';
                    temp[14] = 'b';
                    allPossibleMoves.add(new Node(temp, 10, 14));
                }
                if (currentPosition[15] == '-') {
                    temp = currentPosition.clone();
                    temp[10] = '-';
                    temp[15] = 'b';
                    allPossibleMoves.add(new Node(temp, 10, 15));
                }
            } else if (currentPosition[10] == 'B') {
                if (currentPosition[6] == '-') {
                    temp = currentPosition.clone();
                    temp[10] = '-';
                    temp[6] = 'B';
                    allPossibleMoves.add(new Node(temp, 10, 6));
                }
                if (currentPosition[7] == '-') {
                    temp = currentPosition.clone();
                    temp[10] = '-';
                    temp[7] = 'B';
                    allPossibleMoves.add(new Node(temp, 10, 7));
                }
                if (currentPosition[15] == '-') {
                    temp = currentPosition.clone();
                    temp[10] = '-';
                    temp[15] = 'B';
                    allPossibleMoves.add(new Node(temp, 10, 15));
                }
                if (currentPosition[14] == '-') {
                    temp = currentPosition.clone();
                    temp[10] = '-';
                    temp[14] = 'B';
                    allPossibleMoves.add(new Node(temp, 10, 14));
                }
            }
            //single moves from position 11
            if (currentPosition[11] == 'b') {
                if (currentPosition[15] == '-') {
                    temp = currentPosition.clone();
                    temp[11] = '-';
                    temp[15] = 'b';
                    allPossibleMoves.add(new Node(temp, 11, 15));
                }
            } else if (currentPosition[11] == 'B') {
                if (currentPosition[7] == '-') {
                    temp = currentPosition.clone();
                    temp[11] = '-';
                    temp[7] = 'B';
                    allPossibleMoves.add(new Node(temp, 11, 7));
                }
                if (currentPosition[15] == '-') {
                    temp = currentPosition.clone();
                    temp[11] = '-';
                    temp[15] = 'B';
                    allPossibleMoves.add(new Node(temp, 11, 15));
                }
            }

            //single moves from position 12
            if (currentPosition[12] == 'b') {
                if (currentPosition[16] == '-') {
                    temp = currentPosition.clone();
                    temp[12] = '-';
                    temp[16] = 'b';
                    allPossibleMoves.add(new Node(temp, 12, 16));
                }
            } else if (currentPosition[12] == 'B') {
                if (currentPosition[8] == '-') {
                    temp = currentPosition.clone();
                    temp[12] = '-';
                    temp[8] = 'B';
                    allPossibleMoves.add(new Node(temp, 12, 8));
                }
                if (currentPosition[16] == '-') {
                    temp = currentPosition.clone();
                    temp[12] = '-';
                    temp[16] = 'B';
                    allPossibleMoves.add(new Node(temp, 12, 16));
                }
            }

            //single moves from position 13
            if (currentPosition[13] == 'b') {
                if (currentPosition[16] == '-') {
                    temp = currentPosition.clone();
                    temp[13] = '-';
                    temp[16] = 'b';
                    allPossibleMoves.add(new Node(temp, 13, 16));
                }
                if (currentPosition[17] == '-') {
                    temp = currentPosition.clone();
                    temp[13] = '-';
                    temp[17] = 'b';
                    allPossibleMoves.add(new Node(temp, 13, 17));
                }
            } else if (currentPosition[13] == 'B') {
                if (currentPosition[8] == '-') {
                    temp = currentPosition.clone();
                    temp[13] = '-';
                    temp[8] = 'B';
                    allPossibleMoves.add(new Node(temp, 13, 8));
                }
                if (currentPosition[9] == '-') {
                    temp = currentPosition.clone();
                    temp[13] = '-';
                    temp[9] = 'B';
                    allPossibleMoves.add(new Node(temp, 13, 9));
                }
                if (currentPosition[17] == '-') {
                    temp = currentPosition.clone();
                    temp[13] = '-';
                    temp[17] = 'B';
                    allPossibleMoves.add(new Node(temp, 13, 17));
                }
                if (currentPosition[16] == '-') {
                    temp = currentPosition.clone();
                    temp[13] = '-';
                    temp[16] = 'B';
                    allPossibleMoves.add(new Node(temp, 13, 16));
                }
            }
            //single moves from position 14
            if (currentPosition[14] == 'b') {
                if (currentPosition[17] == '-') {
                    temp = currentPosition.clone();
                    temp[14] = '-';
                    temp[17] = 'b';
                    allPossibleMoves.add(new Node(temp, 14, 17));
                }
                if (currentPosition[18] == '-') {
                    temp = currentPosition.clone();
                    temp[14] = '-';
                    temp[18] = 'b';
                    allPossibleMoves.add(new Node(temp, 14, 18));
                }
            } else if (currentPosition[14] == 'B') {
                if (currentPosition[9] == '-') {
                    temp = currentPosition.clone();
                    temp[14] = '-';
                    temp[9] = 'B';
                    allPossibleMoves.add(new Node(temp, 14, 9));
                }
                if (currentPosition[10] == '-') {
                    temp = currentPosition.clone();
                    temp[14] = '-';
                    temp[10] = 'B';
                    allPossibleMoves.add(new Node(temp, 14, 10));
                }
                if (currentPosition[18] == '-') {
                    temp = currentPosition.clone();
                    temp[14] = '-';
                    temp[18] = 'B';
                    allPossibleMoves.add(new Node(temp, 14, 18));
                }
                if (currentPosition[17] == '-') {
                    temp = currentPosition.clone();
                    temp[14] = '-';
                    temp[17] = 'B';
                    allPossibleMoves.add(new Node(temp, 14, 17));
                }
            }
            //single moves from position 15
            if (currentPosition[15] == 'b') {
                if (currentPosition[18] == '-') {
                    temp = currentPosition.clone();
                    temp[15] = '-';
                    temp[18] = 'b';
                    allPossibleMoves.add(new Node(temp, 15, 18));
                }
                if (currentPosition[19] == '-') {
                    temp = currentPosition.clone();
                    temp[15] = '-';
                    temp[19] = 'b';
                    allPossibleMoves.add(new Node(temp, 15, 19));
                }
            } else if (currentPosition[15] == 'B') {
                if (currentPosition[10] == '-') {
                    temp = currentPosition.clone();
                    temp[15] = '-';
                    temp[10] = 'B';
                    allPossibleMoves.add(new Node(temp, 15, 10));
                }
                if (currentPosition[11] == '-') {
                    temp = currentPosition.clone();
                    temp[15] = '-';
                    temp[11] = 'B';
                    allPossibleMoves.add(new Node(temp, 15, 11));
                }
                if (currentPosition[19] == '-') {
                    temp = currentPosition.clone();
                    temp[15] = '-';
                    temp[19] = 'B';
                    allPossibleMoves.add(new Node(temp, 15, 19));
                }
                if (currentPosition[18] == '-') {
                    temp = currentPosition.clone();
                    temp[15] = '-';
                    temp[18] = 'B';
                    allPossibleMoves.add(new Node(temp, 15, 18));
                }
            }
            //single moves from position 16
            if (currentPosition[16] == 'b') {
                if (currentPosition[20] == '-') {
                    temp = currentPosition.clone();
                    temp[16] = '-';
                    temp[20] = 'b';
                    allPossibleMoves.add(new Node(temp, 16, 20));
                }
                if (currentPosition[21] == '-') {
                    temp = currentPosition.clone();
                    temp[16] = '-';
                    temp[21] = 'b';
                    allPossibleMoves.add(new Node(temp, 16, 21));
                }
            } else if (currentPosition[16] == 'B') {
                if (currentPosition[12] == '-') {
                    temp = currentPosition.clone();
                    temp[16] = '-';
                    temp[12] = 'B';
                    allPossibleMoves.add(new Node(temp, 16, 12));
                }
                if (currentPosition[13] == '-') {
                    temp = currentPosition.clone();
                    temp[16] = '-';
                    temp[13] = 'B';
                    allPossibleMoves.add(new Node(temp, 16, 13));
                }
                if (currentPosition[21] == '-') {
                    temp = currentPosition.clone();
                    temp[16] = '-';
                    temp[21] = 'B';
                    allPossibleMoves.add(new Node(temp, 16, 21));
                }
                if (currentPosition[20] == '-') {
                    temp = currentPosition.clone();
                    temp[16] = '-';
                    temp[20] = 'B';
                    allPossibleMoves.add(new Node(temp, 16, 20));
                }
            }
            //single moves from position 17
            if (currentPosition[17] == 'b') {
                if (currentPosition[21] == '-') {
                    temp = currentPosition.clone();
                    temp[17] = '-';
                    temp[21] = 'b';
                    allPossibleMoves.add(new Node(temp, 17, 21));
                }
                if (currentPosition[22] == '-') {
                    temp = currentPosition.clone();
                    temp[17] = '-';
                    temp[22] = 'b';
                    allPossibleMoves.add(new Node(temp, 17, 22));
                }
            } else if (currentPosition[17] == 'B') {
                if (currentPosition[13] == '-') {
                    temp = currentPosition.clone();
                    temp[17] = '-';
                    temp[13] = 'B';
                    allPossibleMoves.add(new Node(temp, 17, 13));
                }
                if (currentPosition[14] == '-') {
                    temp = currentPosition.clone();
                    temp[17] = '-';
                    temp[14] = 'B';
                    allPossibleMoves.add(new Node(temp, 17, 14));
                }
                if (currentPosition[22] == '-') {
                    temp = currentPosition.clone();
                    temp[17] = '-';
                    temp[22] = 'B';
                    allPossibleMoves.add(new Node(temp, 17, 22));
                }
                if (currentPosition[21] == '-') {
                    temp = currentPosition.clone();
                    temp[17] = '-';
                    temp[21] = 'B';
                    allPossibleMoves.add(new Node(temp, 17, 21));
                }
            }
            //single moves from position 18
            if (currentPosition[18] == 'b') {
                if (currentPosition[22] == '-') {
                    temp = currentPosition.clone();
                    temp[18] = '-';
                    temp[22] = 'b';
                    allPossibleMoves.add(new Node(temp, 18, 22));
                }
                if (currentPosition[23] == '-') {
                    temp = currentPosition.clone();
                    temp[18] = '-';
                    temp[23] = 'b';
                    allPossibleMoves.add(new Node(temp, 18, 23));
                }
            } else if (currentPosition[18] == 'B') {
                if (currentPosition[14] == '-') {
                    temp = currentPosition.clone();
                    temp[18] = '-';
                    temp[14] = 'B';
                    allPossibleMoves.add(new Node(temp, 18, 14));
                }
                if (currentPosition[15] == '-') {
                    temp = currentPosition.clone();
                    temp[18] = '-';
                    temp[15] = 'B';
                    allPossibleMoves.add(new Node(temp, 18, 15));
                }
                if (currentPosition[23] == '-') {
                    temp = currentPosition.clone();
                    temp[18] = '-';
                    temp[23] = 'B';
                    allPossibleMoves.add(new Node(temp, 18, 23));
                }
                if (currentPosition[22] == '-') {
                    temp = currentPosition.clone();
                    temp[18] = '-';
                    temp[22] = 'B';
                    allPossibleMoves.add(new Node(temp, 18, 22));
                }
            }
            //single moves from position 19
            if (currentPosition[19] == 'b') {
                if (currentPosition[23] == '-') {
                    temp = currentPosition.clone();
                    temp[19] = '-';
                    temp[23] = 'b';
                    allPossibleMoves.add(new Node(temp, 19, 23));
                }
            } else if (currentPosition[19] == 'B') {
                if (currentPosition[15] == '-') {
                    temp = currentPosition.clone();
                    temp[19] = '-';
                    temp[15] = 'B';
                    allPossibleMoves.add(new Node(temp, 19, 15));
                }
                if (currentPosition[23] == '-') {
                    temp = currentPosition.clone();
                    temp[19] = '-';
                    temp[23] = 'B';
                    allPossibleMoves.add(new Node(temp, 19, 23));
                }
            }
            //single moves from position 20
            if (currentPosition[20] == 'b') {
                if (currentPosition[24] == '-') {
                    temp = currentPosition.clone();
                    temp[20] = '-';
                    temp[24] = 'b';
                    allPossibleMoves.add(new Node(temp, 20, 24));
                }
            } else if (currentPosition[20] == 'B') {
                if (currentPosition[16] == '-') {
                    temp = currentPosition.clone();
                    temp[20] = '-';
                    temp[16] = 'B';
                    allPossibleMoves.add(new Node(temp, 20, 16));
                }
                if (currentPosition[24] == '-') {
                    temp = currentPosition.clone();
                    temp[20] = '-';
                    temp[24] = 'B';
                    allPossibleMoves.add(new Node(temp, 20, 24));
                }
            }
            //single moves from position 21
            if (currentPosition[21] == 'b') {
                if (currentPosition[24] == '-') {
                    temp = currentPosition.clone();
                    temp[21] = '-';
                    temp[24] = 'b';
                    allPossibleMoves.add(new Node(temp, 21, 24));
                }
                if (currentPosition[25] == '-') {
                    temp = currentPosition.clone();
                    temp[21] = '-';
                    temp[25] = 'b';
                    allPossibleMoves.add(new Node(temp, 21, 25));
                }
            } else if (currentPosition[21] == 'B') {
                if (currentPosition[16] == '-') {
                    temp = currentPosition.clone();
                    temp[21] = '-';
                    temp[16] = 'B';
                    allPossibleMoves.add(new Node(temp, 21, 16));
                }
                if (currentPosition[17] == '-') {
                    temp = currentPosition.clone();
                    temp[21] = '-';
                    temp[17] = 'B';
                    allPossibleMoves.add(new Node(temp, 21, 17));
                }
                if (currentPosition[25] == '-') {
                    temp = currentPosition.clone();
                    temp[21] = '-';
                    temp[25] = 'B';
                    allPossibleMoves.add(new Node(temp, 21, 25));
                }
                if (currentPosition[24] == '-') {
                    temp = currentPosition.clone();
                    temp[21] = '-';
                    temp[24] = 'B';
                    allPossibleMoves.add(new Node(temp, 21, 24));
                }
            }
            //single moves from position 22
            if (currentPosition[22] == 'b') {
                if (currentPosition[25] == '-') {
                    temp = currentPosition.clone();
                    temp[22] = '-';
                    temp[25] = 'b';
                    allPossibleMoves.add(new Node(temp, 22, 25));
                }
                if (currentPosition[26] == '-') {
                    temp = currentPosition.clone();
                    temp[22] = '-';
                    temp[26] = 'b';
                    allPossibleMoves.add(new Node(temp, 22, 26));
                }
            } else if (currentPosition[22] == 'B') {
                if (currentPosition[17] == '-') {
                    temp = currentPosition.clone();
                    temp[22] = '-';
                    temp[17] = 'B';
                    allPossibleMoves.add(new Node(temp, 22, 17));
                }
                if (currentPosition[18] == '-') {
                    temp = currentPosition.clone();
                    temp[22] = '-';
                    temp[18] = 'B';
                    allPossibleMoves.add(new Node(temp, 22, 18));
                }
                if (currentPosition[26] == '-') {
                    temp = currentPosition.clone();
                    temp[22] = '-';
                    temp[26] = 'B';
                    allPossibleMoves.add(new Node(temp, 22, 26));
                }
                if (currentPosition[25] == '-') {
                    temp = currentPosition.clone();
                    temp[22] = '-';
                    temp[25] = 'B';
                    allPossibleMoves.add(new Node(temp, 22, 25));
                }
            }
            //single moves from position 23
            if (currentPosition[23] == 'b') {
                if (currentPosition[26] == '-') {
                    temp = currentPosition.clone();
                    temp[23] = '-';
                    temp[26] = 'b';
                    allPossibleMoves.add(new Node(temp, 23, 26));
                }
                if (currentPosition[27] == '-') {
                    temp = currentPosition.clone();
                    temp[23] = '-';
                    temp[27] = 'b';
                    allPossibleMoves.add(new Node(temp, 23, 27));
                }
            } else if (currentPosition[23] == 'B') {
                if (currentPosition[18] == '-') {
                    temp = currentPosition.clone();
                    temp[23] = '-';
                    temp[18] = 'B';
                    allPossibleMoves.add(new Node(temp, 23, 18));
                }
                if (currentPosition[19] == '-') {
                    temp = currentPosition.clone();
                    temp[23] = '-';
                    temp[19] = 'B';
                    allPossibleMoves.add(new Node(temp, 23, 19));
                }
                if (currentPosition[27] == '-') {
                    temp = currentPosition.clone();
                    temp[23] = '-';
                    temp[27] = 'B';
                    allPossibleMoves.add(new Node(temp, 23, 27));
                }
                if (currentPosition[26] == '-') {
                    temp = currentPosition.clone();
                    temp[23] = '-';
                    temp[26] = 'B';
                    allPossibleMoves.add(new Node(temp, 23, 26));
                }
            }
            //single moves from position 24
            if (currentPosition[24] == 'b') {
                if (currentPosition[28] == '-') {
                    temp = currentPosition.clone();
                    temp[24] = '-';
                    temp[28] = 'B';
                    allPossibleMoves.add(new Node(temp, 24, 28));
                }
                if (currentPosition[29] == '-') {
                    temp = currentPosition.clone();
                    temp[24] = '-';
                    temp[29] = 'B';
                    allPossibleMoves.add(new Node(temp, 24, 29));
                }
            } else if (currentPosition[24] == 'B') {
                if (currentPosition[20] == '-') {
                    temp = currentPosition.clone();
                    temp[24] = '-';
                    temp[20] = 'B';
                    allPossibleMoves.add(new Node(temp, 24, 20));
                }
                if (currentPosition[21] == '-') {
                    temp = currentPosition.clone();
                    temp[24] = '-';
                    temp[21] = 'B';
                    allPossibleMoves.add(new Node(temp, 24, 21));
                }
                if (currentPosition[29] == '-') {
                    temp = currentPosition.clone();
                    temp[24] = '-';
                    temp[29] = 'B';
                    allPossibleMoves.add(new Node(temp, 24, 29));
                }
                if (currentPosition[28] == '-') {
                    temp = currentPosition.clone();
                    temp[24] = '-';
                    temp[28] = 'B';
                    allPossibleMoves.add(new Node(temp, 24, 28));
                }
            }
            //single moves from position 25
            if (currentPosition[25] == 'b') {
                if (currentPosition[29] == '-') {
                    temp = currentPosition.clone();
                    temp[25] = '-';
                    temp[29] = 'B';
                    allPossibleMoves.add(new Node(temp, 25, 29));
                }
                if (currentPosition[30] == '-') {
                    temp = currentPosition.clone();
                    temp[25] = '-';
                    temp[30] = 'B';
                    allPossibleMoves.add(new Node(temp, 25, 30));
                }
            } else if (currentPosition[25] == 'B') {
                if (currentPosition[21] == '-') {
                    temp = currentPosition.clone();
                    temp[25] = '-';
                    temp[21] = 'B';
                    allPossibleMoves.add(new Node(temp, 25, 21));
                }
                if (currentPosition[22] == '-') {
                    temp = currentPosition.clone();
                    temp[25] = '-';
                    temp[22] = 'B';
                    allPossibleMoves.add(new Node(temp, 25, 22));
                }
                if (currentPosition[30] == '-') {
                    temp = currentPosition.clone();
                    temp[25] = '-';
                    temp[30] = 'B';
                    allPossibleMoves.add(new Node(temp, 25, 30));
                }
                if (currentPosition[29] == '-') {
                    temp = currentPosition.clone();
                    temp[25] = '-';
                    temp[29] = 'B';
                    allPossibleMoves.add(new Node(temp, 25, 29));
                }
            }
            //single moves from position 26
            if (currentPosition[26] == 'b') {
                if (currentPosition[30] == '-') {
                    temp = currentPosition.clone();
                    temp[26] = '-';
                    temp[30] = 'B';
                    allPossibleMoves.add(new Node(temp, 26, 30));
                }
                if (currentPosition[31] == '-') {
                    temp = currentPosition.clone();
                    temp[26] = '-';
                    temp[31] = 'B';
                    allPossibleMoves.add(new Node(temp, 26, 31));
                }
            } else if (currentPosition[26] == 'B') {
                if (currentPosition[22] == '-') {
                    temp = currentPosition.clone();
                    temp[26] = '-';
                    temp[22] = 'B';
                    allPossibleMoves.add(new Node(temp, 26, 22));
                }
                if (currentPosition[23] == '-') {
                    temp = currentPosition.clone();
                    temp[26] = '-';
                    temp[23] = 'B';
                    allPossibleMoves.add(new Node(temp, 26, 23));
                }
                if (currentPosition[31] == '-') {
                    temp = currentPosition.clone();
                    temp[26] = '-';
                    temp[31] = 'B';
                    allPossibleMoves.add(new Node(temp, 26, 31));
                }
                if (currentPosition[30] == '-') {
                    temp = currentPosition.clone();
                    temp[26] = '-';
                    temp[30] = 'B';
                    allPossibleMoves.add(new Node(temp, 26, 30));
                }
            }
            //single moves from position 27
            if (currentPosition[27] == 'b') {
                if (currentPosition[31] == '-') {
                    temp = currentPosition.clone();
                    temp[27] = '-';
                    temp[31] = 'B';
                    allPossibleMoves.add(new Node(temp, 27, 31));
                }
            } else if (currentPosition[27] == 'B') {
                if (currentPosition[23] == '-') {
                    temp = currentPosition.clone();
                    temp[27] = '-';
                    temp[23] = 'B';
                    allPossibleMoves.add(new Node(temp, 27, 23));
                }
                if (currentPosition[31] == '-') {
                    temp = currentPosition.clone();
                    temp[27] = '-';
                    temp[31] = 'B';
                    allPossibleMoves.add(new Node(temp, 27, 31));
                }
            }
            if (currentPosition[28] == 'B') {
                if (currentPosition[24] == '-') {
                    temp = currentPosition.clone();
                    temp[28] = '-';
                    temp[24] = 'B';
                    allPossibleMoves.add(new Node(temp, 28, 24));
                }
            }
            if (currentPosition[29] == 'B') {
                if (currentPosition[24] == '-') {
                    temp = currentPosition.clone();
                    temp[29] = '-';
                    temp[24] = 'B';
                    allPossibleMoves.add(new Node(temp, 29, 24));
                }
                if (currentPosition[25] == '-') {
                    temp = currentPosition.clone();
                    temp[29] = '-';
                    temp[25] = 'B';
                    allPossibleMoves.add(new Node(temp, 29, 25));
                }
            }
            if (currentPosition[30] == 'B') {
                if (currentPosition[25] == '-') {
                    temp = currentPosition.clone();
                    temp[30] = '-';
                    temp[25] = 'B';
                    allPossibleMoves.add(new Node(temp, 30, 25));
                }
                if (currentPosition[26] == '-') {
                    temp = currentPosition.clone();
                    temp[30] = '-';
                    temp[26] = 'B';
                    allPossibleMoves.add(new Node(temp, 30, 26));
                }
            }
            if (currentPosition[31] == 'B') {
                if (currentPosition[26] == '-') {
                    temp = currentPosition.clone();
                    temp[31] = '-';
                    temp[26] = 'B';
                    allPossibleMoves.add(new Node(temp, 31, 26));
                }
                if (currentPosition[27] == '-') {
                    temp = currentPosition.clone();
                    temp[31] = '-';
                    temp[27] = 'B';
                    allPossibleMoves.add(new Node(temp, 31, 27));
                }
            }
        } else { //these are white's moves
            //moves from 31
            if (currentPosition[31] == 'w') {
                if (currentPosition[27] == '-') {
                    temp = currentPosition.clone();
                    temp[31] = '-';
                    temp[27] = 'w';
                    allPossibleMoves.add(new Node(temp, 31, 27));
                }
                if (currentPosition[26] == '-') {
                    temp = currentPosition.clone();
                    temp[31] = '-';
                    temp[26] = 'w';
                    allPossibleMoves.add(new Node(temp, 31, 26));
                }
            } else if (currentPosition[31] == 'W') {
                if (currentPosition[27] == '-') {
                    temp = currentPosition.clone();
                    temp[31] = '-';
                    temp[27] = 'W';
                    allPossibleMoves.add(new Node(temp, 31, 27));
                }
                if (currentPosition[26] == '-') {
                    temp = currentPosition.clone();
                    temp[31] = '-';
                    temp[26] = 'W';
                    allPossibleMoves.add(new Node(temp, 31, 26));
                }
            }
            //single moves from position 30
            if (currentPosition[30] == 'w') {
                if (currentPosition[26] == '-') {
                    temp = currentPosition.clone();
                    temp[30] = '-';
                    temp[26] = 'w';
                    allPossibleMoves.add(new Node(temp, 30, 26));
                }
                if (currentPosition[25] == '-') {
                    temp = currentPosition.clone();
                    temp[30] = '-';
                    temp[25] = 'w';
                    allPossibleMoves.add(new Node(temp, 30, 25));
                }
            } else if (currentPosition[30] == 'W') {
                if (currentPosition[26] == '-') {
                    temp = currentPosition.clone();
                    temp[30] = '-';
                    temp[26] = 'W';
                    allPossibleMoves.add(new Node(temp, 30, 26));
                }
                if (currentPosition[25] == '-') {
                    temp = currentPosition.clone();
                    temp[30] = '-';
                    temp[25] = 'W';
                    allPossibleMoves.add(new Node(temp, 30, 25));
                }
            }
            //single moves from position 29
            if (currentPosition[29] == 'w') {
                if (currentPosition[25] == '-') {
                    temp = currentPosition.clone();
                    temp[29] = '-';
                    temp[25] = 'w';
                    allPossibleMoves.add(new Node(temp, 29, 25));
                }
                if (currentPosition[24] == '-') {
                    temp = currentPosition.clone();
                    temp[29] = '-';
                    temp[24] = 'w';
                    allPossibleMoves.add(new Node(temp, 29, 24));
                }
            } else if (currentPosition[29] == 'W') {
                if (currentPosition[25] == '-') {
                    temp = currentPosition.clone();
                    temp[29] = '-';
                    temp[25] = 'W';
                    allPossibleMoves.add(new Node(temp, 29, 25));
                }
                if (currentPosition[24] == '-') {
                    temp = currentPosition.clone();
                    temp[29] = '-';
                    temp[24] = 'W';
                    allPossibleMoves.add(new Node(temp, 29, 24));
                }
            }

            //single moves from position 28
            if (currentPosition[28] == 'w') {
                if (currentPosition[24] == '-') {
                    temp = currentPosition.clone();
                    temp[28] = '-';
                    temp[24] = 'w';
                    allPossibleMoves.add(new Node(temp, 28, 24));
                }
            } else if (currentPosition[28] == 'W') {
                if (currentPosition[24] == '-') {
                    temp = currentPosition.clone();
                    temp[28] = '-';
                    temp[24] = 'W';
                    allPossibleMoves.add(new Node(temp, 28, 24));
                }
            }

            //single moves from position 27
            if (currentPosition[27] == 'w') {
                if (currentPosition[23] == '-') {
                    temp = currentPosition.clone();
                    temp[27] = '-';
                    temp[23] = 'w';
                    allPossibleMoves.add(new Node(temp, 27, 23));
                }
            } else if (currentPosition[27] == 'W') {
                if (currentPosition[31] == '-') {
                    temp = currentPosition.clone();
                    temp[27] = '-';
                    temp[31] = 'W';
                    allPossibleMoves.add(new Node(temp, 27, 31));
                }
                if (currentPosition[23] == '-') {
                    temp = currentPosition.clone();
                    temp[27] = '-';
                    temp[23] = 'W';
                    allPossibleMoves.add(new Node(temp, 27, 23));
                }
            }
            //single moves from position 26
            if (currentPosition[26] == 'w') {
                if (currentPosition[23] == '-') {
                    temp = currentPosition.clone();
                    temp[26] = '-';
                    temp[23] = 'w';
                    allPossibleMoves.add(new Node(temp, 26, 23));
                }
                if (currentPosition[22] == '-') {
                    temp = currentPosition.clone();
                    temp[26] = '-';
                    temp[22] = 'w';
                    allPossibleMoves.add(new Node(temp, 26, 22));
                }
            } else if (currentPosition[26] == 'W') {
                if (currentPosition[31] == '-') {
                    temp = currentPosition.clone();
                    temp[26] = '-';
                    temp[31] = 'W';
                    allPossibleMoves.add(new Node(temp, 26, 31));
                }
                if (currentPosition[30] == '-') {
                    temp = currentPosition.clone();
                    temp[26] = '-';
                    temp[30] = 'W';
                    allPossibleMoves.add(new Node(temp, 26, 30));
                }
                if (currentPosition[23] == '-') {
                    temp = currentPosition.clone();
                    temp[26] = '-';
                    temp[23] = 'W';
                    allPossibleMoves.add(new Node(temp, 26, 23));
                }
                if (currentPosition[22] == '-') {
                    temp = currentPosition.clone();
                    temp[26] = '-';
                    temp[22] = 'W';
                    allPossibleMoves.add(new Node(temp, 26, 22));
                }
            }

            //single moves from position 25
            if (currentPosition[25] == 'w') {
                if (currentPosition[22] == '-') {
                    temp = currentPosition.clone();
                    temp[25] = '-';
                    temp[22] = 'w';
                    allPossibleMoves.add(new Node(temp, 25, 22));
                }
                if (currentPosition[21] == '-') {
                    temp = currentPosition.clone();
                    temp[25] = '-';
                    temp[21] = 'w';
                    allPossibleMoves.add(new Node(temp, 25, 21));
                }
            } else if (currentPosition[25] == 'W') {
                if (currentPosition[30] == '-') {
                    temp = currentPosition.clone();
                    temp[25] = '-';
                    temp[30] = 'W';
                    allPossibleMoves.add(new Node(temp, 25, 30));
                }
                if (currentPosition[29] == '-') {
                    temp = currentPosition.clone();
                    temp[25] = '-';
                    temp[29] = 'W';
                    allPossibleMoves.add(new Node(temp, 25, 29));
                }
                if (currentPosition[21] == '-') {
                    temp = currentPosition.clone();
                    temp[25] = '-';
                    temp[21] = 'W';
                    allPossibleMoves.add(new Node(temp, 25, 21));
                }
                if (currentPosition[22] == '-') {
                    temp = currentPosition.clone();
                    temp[25] = '-';
                    temp[22] = 'W';
                    allPossibleMoves.add(new Node(temp, 25, 22));
                }
            }
            //single moves from position 24
            if (currentPosition[24] == 'w') {
                if (currentPosition[21] == '-') {
                    temp = currentPosition.clone();
                    temp[24] = '-';
                    temp[21] = 'w';
                    allPossibleMoves.add(new Node(temp, 24, 21));
                }
                if (currentPosition[20] == '-') {
                    temp = currentPosition.clone();
                    temp[24] = '-';
                    temp[20] = 'w';
                    allPossibleMoves.add(new Node(temp, 24, 20));
                }
            } else if (currentPosition[24] == 'W') {
                if (currentPosition[29] == '-') {
                    temp = currentPosition.clone();
                    temp[24] = '-';
                    temp[29] = 'W';
                    allPossibleMoves.add(new Node(temp, 24, 29));
                }
                if (currentPosition[28] == '-') {
                    temp = currentPosition.clone();
                    temp[24] = '-';
                    temp[28] = 'W';
                    allPossibleMoves.add(new Node(temp, 24, 28));
                }
                if (currentPosition[21] == '-') {
                    temp = currentPosition.clone();
                    temp[24] = '-';
                    temp[21] = 'W';
                    allPossibleMoves.add(new Node(temp, 24, 21));
                }
                if (currentPosition[20] == '-') {
                    temp = currentPosition.clone();
                    temp[24] = '-';
                    temp[20] = 'W';
                    allPossibleMoves.add(new Node(temp, 24, 20));
                }
            }
            //single moves from position 23
            if (currentPosition[23] == 'w') {
                if (currentPosition[19] == '-') {
                    temp = currentPosition.clone();
                    temp[23] = '-';
                    temp[19] = 'w';
                    allPossibleMoves.add(new Node(temp, 23, 19));
                }
                if (currentPosition[18] == '-') {
                    temp = currentPosition.clone();
                    temp[23] = '-';
                    temp[18] = 'w';
                    allPossibleMoves.add(new Node(temp, 23, 18));
                }
            } else if (currentPosition[23] == 'W') {
                if (currentPosition[27] == '-') {
                    temp = currentPosition.clone();
                    temp[23] = '-';
                    temp[27] = 'W';
                    allPossibleMoves.add(new Node(temp, 23, 27));
                }
                if (currentPosition[26] == '-') {
                    temp = currentPosition.clone();
                    temp[23] = '-';
                    temp[26] = 'W';
                    allPossibleMoves.add(new Node(temp, 23, 26));
                }
                if (currentPosition[18] == '-') {
                    temp = currentPosition.clone();
                    temp[23] = '-';
                    temp[18] = 'W';
                    allPossibleMoves.add(new Node(temp, 23, 18));
                }
                if (currentPosition[19] == '-') {
                    temp = currentPosition.clone();
                    temp[23] = '-';
                    temp[19] = 'W';
                    allPossibleMoves.add(new Node(temp, 23, 19));
                }
            }

            //single moves from position 22
            if (currentPosition[22] == 'w') {
                if (currentPosition[18] == '-') {
                    temp = currentPosition.clone();
                    temp[22] = '-';
                    temp[18] = 'w';
                    allPossibleMoves.add(new Node(temp, 22, 18));
                }
                if (currentPosition[17] == '-') {
                    temp = currentPosition.clone();
                    temp[22] = '-';
                    temp[17] = 'w';
                    allPossibleMoves.add(new Node(temp, 22, 17));
                }
            } else if (currentPosition[22] == 'W') {
                if (currentPosition[26] == '-') {
                    temp = currentPosition.clone();
                    temp[22] = '-';
                    temp[26] = 'W';
                    allPossibleMoves.add(new Node(temp, 22, 26));
                }
                if (currentPosition[25] == '-') {
                    temp = currentPosition.clone();
                    temp[22] = '-';
                    temp[25] = 'W';
                    allPossibleMoves.add(new Node(temp, 22, 25));
                }
                if (currentPosition[17] == '-') {
                    temp = currentPosition.clone();
                    temp[22] = '-';
                    temp[17] = 'W';
                    allPossibleMoves.add(new Node(temp, 22, 17));
                }
                if (currentPosition[18] == '-') {
                    temp = currentPosition.clone();
                    temp[22] = '-';
                    temp[18] = 'W';
                    allPossibleMoves.add(new Node(temp, 22, 18));
                }
            }
            //single moves from position 21
            if (currentPosition[21] == 'w') {
                if (currentPosition[17] == '-') {
                    temp = currentPosition.clone();
                    temp[21] = '-';
                    temp[17] = 'w';
                    allPossibleMoves.add(new Node(temp, 21, 17));
                }
                if (currentPosition[16] == '-') {
                    temp = currentPosition.clone();
                    temp[21] = '-';
                    temp[16] = 'w';
                    allPossibleMoves.add(new Node(temp, 21, 16));
                }
            } else if (currentPosition[21] == 'W') {
                if (currentPosition[25] == '-') {
                    temp = currentPosition.clone();
                    temp[21] = '-';
                    temp[25] = 'W';
                    allPossibleMoves.add(new Node(temp, 21, 25));
                }
                if (currentPosition[24] == '-') {
                    temp = currentPosition.clone();
                    temp[21] = '-';
                    temp[24] = 'W';
                    allPossibleMoves.add(new Node(temp, 21, 24));
                }
                if (currentPosition[16] == '-') {
                    temp = currentPosition.clone();
                    temp[21] = '-';
                    temp[16] = 'W';
                    allPossibleMoves.add(new Node(temp, 21, 16));
                }
                if (currentPosition[17] == '-') {
                    temp = currentPosition.clone();
                    temp[21] = '-';
                    temp[17] = 'W';
                    allPossibleMoves.add(new Node(temp, 21, 17));
                }
            }
            //single moves from position 20
            if (currentPosition[20] == 'w') {
                if (currentPosition[16] == '-') {
                    temp = currentPosition.clone();
                    temp[20] = '-';
                    temp[16] = 'w';
                    allPossibleMoves.add(new Node(temp, 20, 16));
                }
            } else if (currentPosition[20] == 'W') {
                if (currentPosition[24] == '-') {
                    temp = currentPosition.clone();
                    temp[20] = '-';
                    temp[24] = 'W';
                    allPossibleMoves.add(new Node(temp, 20, 24));
                }
                if (currentPosition[16] == '-') {
                    temp = currentPosition.clone();
                    temp[20] = '-';
                    temp[16] = 'W';
                    allPossibleMoves.add(new Node(temp, 20, 16));
                }
            }

            //single moves from position 19
            if (currentPosition[19] == 'w') {
                if (currentPosition[15] == '-') {
                    temp = currentPosition.clone();
                    temp[19] = '-';
                    temp[15] = 'w';
                    allPossibleMoves.add(new Node(temp, 19, 15));
                }
            } else if (currentPosition[19] == 'W') {
                if (currentPosition[23] == '-') {
                    temp = currentPosition.clone();
                    temp[19] = '-';
                    temp[23] = 'W';
                    allPossibleMoves.add(new Node(temp, 19, 23));
                }
                if (currentPosition[15] == '-') {
                    temp = currentPosition.clone();
                    temp[19] = '-';
                    temp[15] = 'W';
                    allPossibleMoves.add(new Node(temp, 19, 15));
                }
            }

            //single moves from position 18
            if (currentPosition[18] == 'w') {
                if (currentPosition[14] == '-') {
                    temp = currentPosition.clone();
                    temp[18] = '-';
                    temp[14] = 'w';
                    allPossibleMoves.add(new Node(temp, 18, 14));
                }
                if (currentPosition[15] == '-') {
                    temp = currentPosition.clone();
                    temp[18] = '-';
                    temp[15] = 'w';
                    allPossibleMoves.add(new Node(temp, 18, 15));
                }
            } else if (currentPosition[18] == 'W') {
                if (currentPosition[23] == '-') {
                    temp = currentPosition.clone();
                    temp[18] = '-';
                    temp[23] = 'W';
                    allPossibleMoves.add(new Node(temp, 18, 23));
                }
                if (currentPosition[22] == '-') {
                    temp = currentPosition.clone();
                    temp[18] = '-';
                    temp[22] = 'W';
                    allPossibleMoves.add(new Node(temp, 18, 22));
                }
                if (currentPosition[14] == '-') {
                    temp = currentPosition.clone();
                    temp[18] = '-';
                    temp[14] = 'W';
                    allPossibleMoves.add(new Node(temp, 18, 14));
                }
                if (currentPosition[15] == '-') {
                    temp = currentPosition.clone();
                    temp[18] = '-';
                    temp[15] = 'W';
                    allPossibleMoves.add(new Node(temp, 18, 15));
                }
            }
            //single moves from position 17
            if (currentPosition[17] == 'w') {
                if (currentPosition[14] == '-') {
                    temp = currentPosition.clone();
                    temp[17] = '-';
                    temp[14] = 'w';
                    allPossibleMoves.add(new Node(temp, 17, 14));
                }
                if (currentPosition[13] == '-') {
                    temp = currentPosition.clone();
                    temp[17] = '-';
                    temp[13] = 'w';
                    allPossibleMoves.add(new Node(temp, 17, 13));
                }
            } else if (currentPosition[17] == 'W') {
                if (currentPosition[22] == '-') {
                    temp = currentPosition.clone();
                    temp[17] = '-';
                    temp[22] = 'W';
                    allPossibleMoves.add(new Node(temp, 17, 22));
                }
                if (currentPosition[21] == '-') {
                    temp = currentPosition.clone();
                    temp[17] = '-';
                    temp[21] = 'W';
                    allPossibleMoves.add(new Node(temp, 17, 21));
                }
                if (currentPosition[17] == '-') {
                    temp = currentPosition.clone();
                    temp[17] = '-';
                    temp[14] = 'W';
                    allPossibleMoves.add(new Node(temp, 17, 14));
                }
                if (currentPosition[13] == '-') {
                    temp = currentPosition.clone();
                    temp[17] = '-';
                    temp[13] = 'W';
                    allPossibleMoves.add(new Node(temp, 17, 13));
                }
            }
            //single moves from position 16
            if (currentPosition[16] == 'w') {
                if (currentPosition[13] == '-') {
                    temp = currentPosition.clone();
                    temp[16] = '-';
                    temp[13] = 'w';
                    allPossibleMoves.add(new Node(temp, 16, 13));
                }
                if (currentPosition[12] == '-') {
                    temp = currentPosition.clone();
                    temp[16] = '-';
                    temp[12] = 'w';
                    allPossibleMoves.add(new Node(temp, 16, 12));
                }
            } else if (currentPosition[16] == 'W') {
                if (currentPosition[21] == '-') {
                    temp = currentPosition.clone();
                    temp[16] = '-';
                    temp[21] = 'W';
                    allPossibleMoves.add(new Node(temp, 16, 21));
                }
                if (currentPosition[20] == '-') {
                    temp = currentPosition.clone();
                    temp[16] = '-';
                    temp[20] = 'W';
                    allPossibleMoves.add(new Node(temp, 16, 20));
                }
                if (currentPosition[13] == '-') {
                    temp = currentPosition.clone();
                    temp[16] = '-';
                    temp[13] = 'W';
                    allPossibleMoves.add(new Node(temp, 16, 13));
                }
                if (currentPosition[12] == '-') {
                    temp = currentPosition.clone();
                    temp[16] = '-';
                    temp[12] = 'W';
                    allPossibleMoves.add(new Node(temp, 16, 12));
                }
            }
            //single moves from position 15
            if (currentPosition[15] == 'w') {
                if (currentPosition[11] == '-') {
                    temp = currentPosition.clone();
                    temp[15] = '-';
                    temp[11] = 'w';
                    allPossibleMoves.add(new Node(temp, 15, 11));
                }
                if (currentPosition[10] == '-') {
                    temp = currentPosition.clone();
                    temp[15] = '-';
                    temp[10] = 'w';
                    allPossibleMoves.add(new Node(temp, 15, 10));
                }
            } else if (currentPosition[15] == 'W') {
                if (currentPosition[19] == '-') {
                    temp = currentPosition.clone();
                    temp[15] = '-';
                    temp[19] = 'W';
                    allPossibleMoves.add(new Node(temp, 15, 19));
                }
                if (currentPosition[18] == '-') {
                    temp = currentPosition.clone();
                    temp[15] = '-';
                    temp[18] = 'W';
                    allPossibleMoves.add(new Node(temp, 15, 18));
                }
                if (currentPosition[10] == '-') {
                    temp = currentPosition.clone();
                    temp[15] = '-';
                    temp[10] = 'W';
                    allPossibleMoves.add(new Node(temp, 15, 10));
                }
                if (currentPosition[11] == '-') {
                    temp = currentPosition.clone();
                    temp[15] = '-';
                    temp[11] = 'W';
                    allPossibleMoves.add(new Node(temp, 15, 11));
                }
            }
            //single moves from position 14
            if (currentPosition[14] == 'w') {
                if (currentPosition[10] == '-') {
                    temp = currentPosition.clone();
                    temp[14] = '-';
                    temp[10] = 'w';
                    allPossibleMoves.add(new Node(temp, 14, 10));
                }
                if (currentPosition[9] == '-') {
                    temp = currentPosition.clone();
                    temp[14] = '-';
                    temp[9] = 'w';
                    allPossibleMoves.add(new Node(temp, 14, 9));
                }
            } else if (currentPosition[14] == 'W') {
                if (currentPosition[18] == '-') {
                    temp = currentPosition.clone();
                    temp[14] = '-';
                    temp[18] = 'W';
                    allPossibleMoves.add(new Node(temp, 14, 18));
                }
                if (currentPosition[17] == '-') {
                    temp = currentPosition.clone();
                    temp[14] = '-';
                    temp[17] = 'W';
                    allPossibleMoves.add(new Node(temp, 14, 17));
                }
                if (currentPosition[9] == '-') {
                    temp = currentPosition.clone();
                    temp[14] = '-';
                    temp[9] = 'W';
                    allPossibleMoves.add(new Node(temp, 14, 9));
                }
                if (currentPosition[10] == '-') {
                    temp = currentPosition.clone();
                    temp[14] = '-';
                    temp[10] = 'W';
                    allPossibleMoves.add(new Node(temp, 14, 10));
                }
            }
            //single moves from position 13
            if (currentPosition[13] == 'w') {
                if (currentPosition[9] == '-') {
                    temp = currentPosition.clone();
                    temp[13] = '-';
                    temp[9] = 'w';
                    allPossibleMoves.add(new Node(temp, 13, 9));
                }
                if (currentPosition[8] == '-') {
                    temp = currentPosition.clone();
                    temp[13] = '-';
                    temp[8] = 'w';
                    allPossibleMoves.add(new Node(temp, 13, 8));
                }
            } else if (currentPosition[13] == 'W') {
                if (currentPosition[17] == '-') {
                    temp = currentPosition.clone();
                    temp[13] = '-';
                    temp[17] = 'W';
                    allPossibleMoves.add(new Node(temp, 13, 17));
                }
                if (currentPosition[16] == '-') {
                    temp = currentPosition.clone();
                    temp[13] = '-';
                    temp[16] = 'W';
                    allPossibleMoves.add(new Node(temp, 13, 16));
                }
                if (currentPosition[8] == '-') {
                    temp = currentPosition.clone();
                    temp[13] = '-';
                    temp[8] = 'W';
                    allPossibleMoves.add(new Node(temp, 13, 8));
                }
                if (currentPosition[9] == '-') {
                    temp = currentPosition.clone();
                    temp[13] = '-';
                    temp[9] = 'W';
                    allPossibleMoves.add(new Node(temp, 13, 9));
                }
            }
            //single moves from position 12
            if (currentPosition[12] == 'w') {
                if (currentPosition[8] == '-') {
                    temp = currentPosition.clone();
                    temp[12] = '-';
                    temp[8] = 'w';
                    allPossibleMoves.add(new Node(temp, 12, 8));
                }
            } else if (currentPosition[12] == 'W') {
                if (currentPosition[16] == '-') {
                    temp = currentPosition.clone();
                    temp[12] = '-';
                    temp[16] = 'W';
                    allPossibleMoves.add(new Node(temp, 12, 16));
                }
                if (currentPosition[8] == '-') {
                    temp = currentPosition.clone();
                    temp[12] = '-';
                    temp[8] = 'W';
                    allPossibleMoves.add(new Node(temp, 12, 8));
                }
            }
            //single moves from position 11
            if (currentPosition[11] == 'w') {
                if (currentPosition[7] == '-') {
                    temp = currentPosition.clone();
                    temp[11] = '-';
                    temp[7] = 'w';
                    allPossibleMoves.add(new Node(temp, 11, 7));
                }
            } else if (currentPosition[11] == 'W') {
                if (currentPosition[15] == '-') {
                    temp = currentPosition.clone();
                    temp[11] = '-';
                    temp[15] = 'W';
                    allPossibleMoves.add(new Node(temp, 11, 15));
                }
                if (currentPosition[7] == '-') {
                    temp = currentPosition.clone();
                    temp[11] = '-';
                    temp[7] = 'W';
                    allPossibleMoves.add(new Node(temp, 11, 7));
                }
            }
            //single moves from position 10
            if (currentPosition[10] == 'w') {
                if (currentPosition[7] == '-') {
                    temp = currentPosition.clone();
                    temp[10] = '-';
                    temp[7] = 'w';
                    allPossibleMoves.add(new Node(temp, 10, 7));
                }
                if (currentPosition[6] == '-') {
                    temp = currentPosition.clone();
                    temp[10] = '-';
                    temp[6] = 'w';
                    allPossibleMoves.add(new Node(temp, 10, 6));
                }
            } else if (currentPosition[10] == 'W') {
                if (currentPosition[15] == '-') {
                    temp = currentPosition.clone();
                    temp[10] = '-';
                    temp[15] = 'W';
                    allPossibleMoves.add(new Node(temp, 10, 15));
                }
                if (currentPosition[14] == '-') {
                    temp = currentPosition.clone();
                    temp[10] = '-';
                    temp[14] = 'W';
                    allPossibleMoves.add(new Node(temp, 10, 14));
                }
                if (currentPosition[6] == '-') {
                    temp = currentPosition.clone();
                    temp[10] = '-';
                    temp[6] = 'W';
                    allPossibleMoves.add(new Node(temp, 10, 6));
                }
                if (currentPosition[7] == '-') {
                    temp = currentPosition.clone();
                    temp[10] = '-';
                    temp[7] = 'W';
                    allPossibleMoves.add(new Node(temp, 10, 7));
                }
            }
            //single moves from position 9
            if (currentPosition[9] == 'w') {
                if (currentPosition[6] == '-') {
                    temp = currentPosition.clone();
                    temp[9] = '-';
                    temp[6] = 'w';
                    allPossibleMoves.add(new Node(temp, 9, 6));
                }
                if (currentPosition[5] == '-') {
                    temp = currentPosition.clone();
                    temp[9] = '-';
                    temp[5] = 'w';
                    allPossibleMoves.add(new Node(temp, 9, 5));
                }
            } else if (currentPosition[9] == 'W') {
                if (currentPosition[14] == '-') {
                    temp = currentPosition.clone();
                    temp[9] = '-';
                    temp[14] = 'W';
                    allPossibleMoves.add(new Node(temp, 9, 14));
                }
                if (currentPosition[13] == '-') {
                    temp = currentPosition.clone();
                    temp[9] = '-';
                    temp[13] = 'W';
                    allPossibleMoves.add(new Node(temp, 9, 13));
                }
                if (currentPosition[5] == '-') {
                    temp = currentPosition.clone();
                    temp[9] = '-';
                    temp[5] = 'W';
                    allPossibleMoves.add(new Node(temp, 9, 5));
                }
                if (currentPosition[6] == '-') {
                    temp = currentPosition.clone();
                    temp[9] = '-';
                    temp[6] = 'W';
                    allPossibleMoves.add(new Node(temp, 9, 6));
                }
            }
            //single moves from position 8
            if (currentPosition[8] == 'w') {
                if (currentPosition[5] == '-') {
                    temp = currentPosition.clone();
                    temp[8] = '-';
                    temp[5] = 'w';
                    allPossibleMoves.add(new Node(temp, 8, 5));
                }
                if (currentPosition[4] == '-') {
                    temp = currentPosition.clone();
                    temp[8] = '-';
                    temp[4] = 'w';
                    allPossibleMoves.add(new Node(temp, 8, 4));
                }
            } else if (currentPosition[8] == 'W') {
                if (currentPosition[13] == '-') {
                    temp = currentPosition.clone();
                    temp[8] = '-';
                    temp[13] = 'W';
                    allPossibleMoves.add(new Node(temp, 8, 13));
                }
                if (currentPosition[12] == '-') {
                    temp = currentPosition.clone();
                    temp[8] = '-';
                    temp[12] = 'W';
                    allPossibleMoves.add(new Node(temp, 8, 12));
                }
                if (currentPosition[5] == '-') {
                    temp = currentPosition.clone();
                    temp[8] = '-';
                    temp[5] = 'W';
                    allPossibleMoves.add(new Node(temp, 8, 5));
                }
                if (currentPosition[4] == '-') {
                    temp = currentPosition.clone();
                    temp[8] = '-';
                    temp[4] = 'W';
                    allPossibleMoves.add(new Node(temp, 8, 4));
                }
            }
            //single moves from position 7
            if (currentPosition[7] == 'w') {
                if (currentPosition[3] == '-') {
                    temp = currentPosition.clone();
                    temp[7] = '-';
                    temp[3] = 'W';
                    allPossibleMoves.add(new Node(temp, 7, 3));
                }
                if (currentPosition[2] == '-') {
                    temp = currentPosition.clone();
                    temp[7] = '-';
                    temp[2] = 'W';
                    allPossibleMoves.add(new Node(temp, 7, 2));
                }
            } else if (currentPosition[7] == 'W') {
                if (currentPosition[11] == '-') {
                    temp = currentPosition.clone();
                    temp[7] = '-';
                    temp[11] = 'W';
                    allPossibleMoves.add(new Node(temp, 7, 11));
                }
                if (currentPosition[10] == '-') {
                    temp = currentPosition.clone();
                    temp[7] = '-';
                    temp[10] = 'W';
                    allPossibleMoves.add(new Node(temp, 7, 10));
                }
                if (currentPosition[2] == '-') {
                    temp = currentPosition.clone();
                    temp[7] = '-';
                    temp[2] = 'W';
                    allPossibleMoves.add(new Node(temp, 7, 2));
                }
                if (currentPosition[3] == '-') {
                    temp = currentPosition.clone();
                    temp[7] = '-';
                    temp[3] = 'W';
                    allPossibleMoves.add(new Node(temp, 7, 3));
                }
            }
            //single moves from position 6
            if (currentPosition[6] == 'w') {
                if (currentPosition[2] == '-') {
                    temp = currentPosition.clone();
                    temp[6] = '-';
                    temp[2] = 'W';
                    allPossibleMoves.add(new Node(temp, 6, 2));
                }
                if (currentPosition[1] == '-') {
                    temp = currentPosition.clone();
                    temp[6] = '-';
                    temp[1] = 'W';
                    allPossibleMoves.add(new Node(temp, 6, 1));
                }
            } else if (currentPosition[6] == 'W') {
                if (currentPosition[10] == '-') {
                    temp = currentPosition.clone();
                    temp[6] = '-';
                    temp[10] = 'W';
                    allPossibleMoves.add(new Node(temp, 6, 10));
                }
                if (currentPosition[9] == '-') {
                    temp = currentPosition.clone();
                    temp[6] = '-';
                    temp[9] = 'W';
                    allPossibleMoves.add(new Node(temp, 6, 9));
                }
                if (currentPosition[1] == '-') {
                    temp = currentPosition.clone();
                    temp[6] = '-';
                    temp[1] = 'W';
                    allPossibleMoves.add(new Node(temp, 6, 1));
                }
                if (currentPosition[2] == '-') {
                    temp = currentPosition.clone();
                    temp[6] = '-';
                    temp[2] = 'W';
                    allPossibleMoves.add(new Node(temp, 6, 2));
                }
            }
            //single moves from position 5
            if (currentPosition[5] == 'w') {
                if (currentPosition[1] == '-') {
                    temp = currentPosition.clone();
                    temp[5] = '-';
                    temp[1] = 'W';
                    allPossibleMoves.add(new Node(temp, 5, 1));
                }
                if (currentPosition[0] == '-') {
                    temp = currentPosition.clone();
                    temp[5] = '-';
                    temp[0] = 'W';
                    allPossibleMoves.add(new Node(temp, 5, 0));
                }
            } else if (currentPosition[5] == 'W') {
                if (currentPosition[9] == '-') {
                    temp = currentPosition.clone();
                    temp[5] = '-';
                    temp[9] = 'W';
                    allPossibleMoves.add(new Node(temp, 5, 9));
                }
                if (currentPosition[8] == '-') {
                    temp = currentPosition.clone();
                    temp[5] = '-';
                    temp[8] = 'W';
                    allPossibleMoves.add(new Node(temp, 5, 8));
                }
                if (currentPosition[0] == '-') {
                    temp = currentPosition.clone();
                    temp[5] = '-';
                    temp[0] = 'W';
                    allPossibleMoves.add(new Node(temp, 5, 0));
                }
                if (currentPosition[1] == '-') {
                    temp = currentPosition.clone();
                    temp[5] = '-';
                    temp[1] = 'W';
                    allPossibleMoves.add(new Node(temp, 5, 1));
                }
            }
            //single moves from position 4
            if (currentPosition[4] == 'w') {
                if (currentPosition[0] == '-') {
                    temp = currentPosition.clone();
                    temp[4] = '-';
                    temp[0] = 'W';
                    allPossibleMoves.add(new Node(temp, 4, 0));
                }
            } else if (currentPosition[4] == 'W') {
                if (currentPosition[8] == '-') {
                    temp = currentPosition.clone();
                    temp[4] = '-';
                    temp[8] = 'W';
                    allPossibleMoves.add(new Node(temp, 4, 8));
                }
                if (currentPosition[0] == '-') {
                    temp = currentPosition.clone();
                    temp[4] = '-';
                    temp[0] = 'W';
                    allPossibleMoves.add(new Node(temp, 4, 0));
                }
            }
            if (currentPosition[3] == 'W') {
                if (currentPosition[7] == '-') {
                    temp = currentPosition.clone();
                    temp[3] = '-';
                    temp[7] = 'W';
                    allPossibleMoves.add(new Node(temp, 3, 7));
                }
            }
            if (currentPosition[2] == 'W') {
                if (currentPosition[7] == '-') {
                    temp = currentPosition.clone();
                    temp[2] = '-';
                    temp[7] = 'W';
                    allPossibleMoves.add(new Node(temp, 2, 7));
                }
                if (currentPosition[6] == '-') {
                    temp = currentPosition.clone();
                    temp[2] = '-';
                    temp[6] = 'W';
                    allPossibleMoves.add(new Node(temp, 2, 6));
                }
            }
            if (currentPosition[1] == 'W') {
                if (currentPosition[6] == '-') {
                    temp = currentPosition.clone();
                    temp[1] = '-';
                    temp[6] = 'W';
                    allPossibleMoves.add(new Node(temp, 1, 6));
                }
                if (currentPosition[5] == '-') {
                    temp = currentPosition.clone();
                    temp[1] = '-';
                    temp[5] = 'W';
                    allPossibleMoves.add(new Node(temp, 1, 5));
                }
            }
            if (currentPosition[0] == 'W') {
                if (currentPosition[5] == '-') {
                    temp = currentPosition.clone();
                    temp[0] = '-';
                    temp[5] = 'W';
                    allPossibleMoves.add(new Node(temp, 0, 5));
                }
                if (currentPosition[4] == '-') {
                    temp = currentPosition.clone();
                    temp[0] = '-';
                    temp[4] = 'W';
                    allPossibleMoves.add(new Node(temp, 0, 4));
                }
            }
        }
    }

    public void findAllMoves() {
        allPossibleMoves = new ArrayList<Node>();
        findJumps(); //find jumps for kings and non kings
        if (allPossibleMoves.isEmpty()) { //no jumps possible
            findNonJumps(); // find single moves          
        }
    }

    private void findRemainingKingJumps(char[] boardPosition, int currentSquare, int startSquare) {
        char kingPiece;
        char enemyPiece;
        char enemyKingPiece;
        boolean noNewMoveFound = true; //this is set to false if a new move is found
        //this prevents the recursive method from
        //recording invalid moves
        if (blacksMove) {
            kingPiece = 'B';
            enemyPiece = 'w';
            enemyKingPiece = 'W';
        } else {
            kingPiece = 'W';
            enemyPiece = 'b';
            enemyKingPiece = 'B';
        }

        if (currentSquare == 1 || currentSquare == 2) { //this is an even row
            // if there is a enemy down to the left and an empty square to land
            char[] tempBoard;
            if ((boardPosition[currentSquare + EVENDOWNLEFT] == enemyPiece || boardPosition[currentSquare + EVENDOWNLEFT] == enemyKingPiece)
                    && boardPosition[currentSquare + EVENDOWNLEFT + ODDDOWNLEFT] == '-') {
                tempBoard = boardPosition.clone();//clone made to fix reference problems
                tempBoard[currentSquare] = '-'; //move checker to open spot
                tempBoard[currentSquare + EVENDOWNLEFT] = '-'; // remove enemy checker
                tempBoard[currentSquare + EVENDOWNLEFT + ODDDOWNLEFT] = kingPiece; //place checker
                int tempCurrent = currentSquare + EVENDOWNLEFT + ODDDOWNLEFT;//next look at moves from here
                findRemainingKingJumps(tempBoard, tempCurrent, startSquare);
                noNewMoveFound = false;
            }
            if ((boardPosition[currentSquare + EVENDOWNRIGHT] == enemyPiece || boardPosition[currentSquare + EVENDOWNRIGHT] == enemyKingPiece)
                    && boardPosition[currentSquare + EVENDOWNRIGHT + ODDDOWNRIGHT] == '-') {
                tempBoard = boardPosition.clone();//clone made to fix reference problems
                tempBoard[currentSquare] = '-'; //move checker to open spot
                tempBoard[currentSquare + EVENDOWNRIGHT] = '-'; // remove enemy checker
                tempBoard[currentSquare + EVENDOWNRIGHT + ODDDOWNRIGHT] = kingPiece; //place checker
                int tempCurrent = currentSquare + EVENDOWNRIGHT + ODDDOWNRIGHT;//next look at moves from here
                findRemainingKingJumps(tempBoard, tempCurrent, startSquare);
                noNewMoveFound = false;
            }
        }
        if (currentSquare == 5 || currentSquare == 6) {
            char[] tempBoard;
            if ((boardPosition[currentSquare + ODDDOWNRIGHT] == enemyPiece || boardPosition[currentSquare + ODDDOWNRIGHT] == enemyKingPiece)
                    && boardPosition[currentSquare + ODDDOWNRIGHT + EVENDOWNRIGHT] == '-') {
                tempBoard = boardPosition.clone();//clone made to fix reference problems
                tempBoard[currentSquare] = '-'; //move checker to open spot
                tempBoard[currentSquare + ODDDOWNRIGHT] = '-'; // remove enemy checker
                tempBoard[currentSquare + ODDDOWNRIGHT + EVENDOWNRIGHT] = kingPiece; //place checker
                int tempCurrent = currentSquare + ODDDOWNRIGHT + EVENDOWNRIGHT;//next look at moves from here
                findRemainingKingJumps(tempBoard, tempCurrent, startSquare);
                noNewMoveFound = false;
            }
            if ((boardPosition[currentSquare + ODDDOWNLEFT] == enemyPiece || boardPosition[currentSquare + ODDDOWNLEFT] == enemyKingPiece)
                    && boardPosition[currentSquare + ODDDOWNLEFT + EVENDOWNLEFT] == '-') {
                tempBoard = boardPosition.clone();//clone made to fix reference problems
                tempBoard[currentSquare] = '-'; //move checker to open spot
                tempBoard[currentSquare + ODDDOWNLEFT] = '-'; // remove enemy checker
                tempBoard[currentSquare + ODDDOWNLEFT + EVENDOWNLEFT] = kingPiece; //place checker
                int tempCurrent = currentSquare + ODDDOWNLEFT + EVENDOWNLEFT;//next look at moves from here
                findRemainingKingJumps(tempBoard, tempCurrent, startSquare);
                noNewMoveFound = false;
            }
        }
        if (currentSquare == 8 || currentSquare == 16) {
            char[] tempBoard;
            if ((boardPosition[currentSquare + EVENDOWNRIGHT] == enemyPiece || boardPosition[currentSquare + EVENDOWNRIGHT] == enemyKingPiece)
                    && boardPosition[currentSquare + EVENDOWNRIGHT + ODDDOWNRIGHT] == '-') {
                tempBoard = boardPosition.clone();//clone made to fix reference problems
                tempBoard[currentSquare] = '-'; //move checker to open spot
                tempBoard[currentSquare + EVENDOWNRIGHT] = '-'; // remove enemy checker
                tempBoard[currentSquare + EVENDOWNRIGHT + ODDDOWNRIGHT] = kingPiece; //place checker
                int tempCurrent = currentSquare + EVENDOWNRIGHT + ODDDOWNRIGHT;//next look at moves from here
                findRemainingKingJumps(tempBoard, tempCurrent, startSquare);
                noNewMoveFound = false;
            }
            if ((boardPosition[currentSquare + EVENUPRIGHT] == enemyPiece || boardPosition[currentSquare + EVENUPRIGHT] == enemyKingPiece)
                    && boardPosition[currentSquare + EVENUPRIGHT + ODDUPRIGHT] == '-') {
                boardPosition[currentSquare] = '-'; //move checker to open spot
                boardPosition[currentSquare + EVENUPRIGHT] = '-'; // remove enemy checker
                boardPosition[currentSquare + EVENUPRIGHT + ODDUPRIGHT] = kingPiece; //place checker
                int tempCurrent = currentSquare + EVENUPRIGHT + ODDUPRIGHT;//next look at moves from here
                findRemainingKingJumps(boardPosition, tempCurrent, startSquare);
                noNewMoveFound = false;
            }
        }
        if (currentSquare == 12 || currentSquare == 20) {
            char[] tempBoard;
            if ((boardPosition[currentSquare + ODDDOWNRIGHT] == enemyPiece || boardPosition[currentSquare + ODDDOWNRIGHT] == enemyKingPiece)
                    && boardPosition[currentSquare + ODDDOWNRIGHT + EVENDOWNRIGHT] == '-') {
                tempBoard = boardPosition.clone();//clone made to fix reference problems
                tempBoard[currentSquare] = '-'; //move checker to open spot
                tempBoard[currentSquare + ODDDOWNRIGHT] = '-'; // remove enemy checker
                tempBoard[currentSquare + ODDDOWNRIGHT + EVENDOWNRIGHT] = kingPiece; //place checker
                int tempCurrent = currentSquare + ODDDOWNRIGHT + EVENDOWNRIGHT;//next look at moves from here
                findRemainingKingJumps(tempBoard, tempCurrent, startSquare);
                noNewMoveFound = false;
            }
            if ((boardPosition[currentSquare + ODDUPRIGHT] == enemyPiece || boardPosition[currentSquare + ODDUPRIGHT] == enemyKingPiece)
                    && boardPosition[currentSquare + ODDUPRIGHT + EVENUPRIGHT] == '-') {
                boardPosition[currentSquare] = '-'; //move checker to open spot
                boardPosition[currentSquare + ODDUPRIGHT] = '-'; // remove enemy checker
                boardPosition[currentSquare + ODDUPRIGHT + EVENUPRIGHT] = kingPiece; //place checker
                int tempCurrent = currentSquare + ODDUPRIGHT + EVENUPRIGHT;//next look at moves from here
                findRemainingKingJumps(boardPosition, tempCurrent, startSquare);
                noNewMoveFound = false;
            }
        }
        if (currentSquare == 11 || currentSquare == 19) {
            char[] tempBoard;
            if ((boardPosition[currentSquare + EVENDOWNLEFT] == enemyPiece || boardPosition[currentSquare + EVENDOWNLEFT] == enemyKingPiece)
                    && boardPosition[currentSquare + EVENDOWNLEFT + ODDDOWNLEFT] == '-') {
                tempBoard = boardPosition.clone();//clone made to fix reference problems
                tempBoard[currentSquare] = '-'; //move checker to open spot
                tempBoard[currentSquare + EVENDOWNLEFT] = '-'; // remove enemy checker
                tempBoard[currentSquare + EVENDOWNLEFT + ODDDOWNLEFT] = kingPiece; //place checker
                int tempCurrent = currentSquare + EVENDOWNLEFT + ODDDOWNLEFT;//next look at moves from here
                findRemainingKingJumps(tempBoard, tempCurrent, startSquare);
                noNewMoveFound = false;
            }
            if ((boardPosition[currentSquare + EVENUPLEFT] == enemyPiece || boardPosition[currentSquare + EVENUPLEFT] == enemyKingPiece)
                    && boardPosition[currentSquare + EVENUPLEFT + ODDUPLEFT] == '-') {
                boardPosition[currentSquare] = '-'; //move checker to open spot
                boardPosition[currentSquare + EVENUPLEFT] = '-'; // remove enemy checker
                boardPosition[currentSquare + EVENUPLEFT + ODDUPLEFT] = kingPiece; //place checker
                int tempCurrent = currentSquare + EVENUPLEFT + ODDUPLEFT;//next look at moves from here
                findRemainingKingJumps(boardPosition, tempCurrent, startSquare);
                noNewMoveFound = false;
            }
        }
        if (currentSquare == 15 || currentSquare == 23) {
            char[] tempBoard;
            if ((boardPosition[currentSquare + ODDDOWNLEFT] == enemyPiece || boardPosition[currentSquare + ODDDOWNLEFT] == enemyKingPiece)
                    && boardPosition[currentSquare + ODDDOWNLEFT + EVENDOWNLEFT] == '-') {
                tempBoard = boardPosition.clone();//clone made to fix reference problems
                tempBoard[currentSquare] = '-'; //move checker to open spot
                tempBoard[currentSquare + ODDDOWNLEFT] = '-'; // remove enemy checker
                tempBoard[currentSquare + ODDDOWNLEFT + EVENDOWNLEFT] = kingPiece; //place checker
                int tempCurrent = currentSquare + ODDDOWNLEFT + EVENDOWNLEFT;//next look at moves from here
                findRemainingKingJumps(tempBoard, tempCurrent, startSquare);
                noNewMoveFound = false;
            }
            if ((boardPosition[currentSquare + ODDUPLEFT] == enemyPiece || boardPosition[currentSquare + ODDUPLEFT] == enemyKingPiece)
                    && boardPosition[currentSquare + ODDUPLEFT + EVENUPLEFT] == '-') {
                tempBoard = boardPosition.clone();//clone made to fix reference problems
                tempBoard[currentSquare] = '-'; //move checker to open spot
                tempBoard[currentSquare + ODDUPLEFT] = '-'; // remove enemy checker
                tempBoard[currentSquare + ODDUPLEFT + EVENUPLEFT] = kingPiece; //place checker
                int tempCurrent = currentSquare + ODDUPLEFT + EVENUPLEFT;//next look at moves from here
                findRemainingKingJumps(tempBoard, tempCurrent, startSquare);
                noNewMoveFound = false;
            }
        }
        if (currentSquare == 25 || currentSquare == 26) {
            char[] tempBoard;
            if ((boardPosition[currentSquare + EVENUPRIGHT] == enemyPiece || boardPosition[currentSquare + EVENUPRIGHT] == enemyKingPiece)
                    && boardPosition[currentSquare + EVENUPRIGHT + ODDUPRIGHT] == '-') {
                tempBoard = boardPosition.clone();//clone made to fix reference problems
                tempBoard[currentSquare] = '-'; //move checker to open spot
                tempBoard[currentSquare + EVENUPRIGHT] = '-'; // remove enemy checker
                tempBoard[currentSquare + EVENUPRIGHT + ODDUPRIGHT] = kingPiece; //place checker
                int tempCurrent = currentSquare + EVENUPRIGHT + ODDUPRIGHT;//next look at moves from here
                findRemainingKingJumps(tempBoard, tempCurrent, startSquare);
                noNewMoveFound = false;
            }
            if ((boardPosition[currentSquare + EVENUPLEFT] == enemyPiece || boardPosition[currentSquare + EVENUPLEFT] == enemyKingPiece)
                    && boardPosition[currentSquare + EVENUPLEFT + ODDUPLEFT] == '-') {
                tempBoard = boardPosition.clone();//clone made to fix reference problems
                tempBoard[currentSquare] = '-'; //move checker to open spot
                tempBoard[currentSquare + EVENUPLEFT] = '-'; // remove enemy checker
                tempBoard[currentSquare + EVENUPLEFT + ODDUPLEFT] = kingPiece; //place checker
                int tempCurrent = currentSquare + EVENUPLEFT + ODDUPLEFT;//next look at moves from here
                findRemainingKingJumps(tempBoard, tempCurrent, startSquare);
                noNewMoveFound = false;
            }
        }
        if (currentSquare == 29 || currentSquare == 30) {
            char[] tempBoard;
            if ((boardPosition[currentSquare + ODDUPRIGHT] == enemyPiece || boardPosition[currentSquare + ODDUPRIGHT] == enemyKingPiece)
                    && boardPosition[currentSquare + ODDUPRIGHT + EVENUPRIGHT] == '-') {
                tempBoard = boardPosition.clone();//clone made to fix reference problems
                tempBoard[currentSquare] = '-'; //move checker to open spot
                tempBoard[currentSquare + ODDUPRIGHT] = '-'; // remove enemy checker
                tempBoard[currentSquare + ODDUPRIGHT + EVENUPRIGHT] = kingPiece; //place checker
                int tempCurrent = currentSquare + ODDUPRIGHT + EVENUPRIGHT;//next look at moves from here
                findRemainingKingJumps(tempBoard, tempCurrent, startSquare);
                noNewMoveFound = false;
            }
            if ((boardPosition[currentSquare + ODDUPLEFT] == enemyPiece || boardPosition[currentSquare + ODDUPLEFT] == enemyKingPiece)
                    && boardPosition[currentSquare + ODDUPLEFT + EVENUPLEFT] == '-') {
                tempBoard = boardPosition.clone();//clone made to fix reference problems
                tempBoard[currentSquare] = '-'; //move checker to open spot
                tempBoard[currentSquare + ODDUPLEFT] = '-'; // remove enemy checker
                tempBoard[currentSquare + ODDUPLEFT + EVENUPLEFT] = kingPiece; //place checker
                int tempCurrent = currentSquare + ODDUPLEFT + EVENUPLEFT;//next look at moves from here
                findRemainingKingJumps(tempBoard, tempCurrent, startSquare);
                noNewMoveFound = false;
            }

        } // remaining even squares
        if (currentSquare == 9 || currentSquare == 10 || currentSquare == 17 || currentSquare == 18) {
            char[] tempBoard;
            if ((boardPosition[currentSquare + EVENDOWNLEFT] == enemyPiece || boardPosition[currentSquare + EVENDOWNLEFT] == enemyKingPiece)
                    && boardPosition[currentSquare + EVENDOWNLEFT + ODDDOWNLEFT] == '-') {
                tempBoard = boardPosition.clone();//clone made to fix reference problems
                tempBoard[currentSquare] = '-'; //move checker to open spot
                tempBoard[currentSquare + EVENDOWNLEFT] = '-'; // remove enemy checker
                tempBoard[currentSquare + EVENDOWNLEFT + ODDDOWNLEFT] = kingPiece; //place checker
                int tempCurrent = currentSquare + EVENDOWNLEFT + ODDDOWNLEFT;//next look at moves from here
                findRemainingKingJumps(tempBoard, tempCurrent, startSquare);
                noNewMoveFound = false;
            }
            if ((boardPosition[currentSquare + EVENDOWNRIGHT] == enemyPiece || boardPosition[currentSquare + EVENDOWNRIGHT] == enemyKingPiece)
                    && boardPosition[currentSquare + EVENDOWNRIGHT + ODDDOWNRIGHT] == '-') {
                tempBoard = boardPosition.clone();
                tempBoard[currentSquare] = '-'; //move checker to open spot
                tempBoard[currentSquare + EVENDOWNRIGHT] = '-'; // remove enemy checker
                tempBoard[currentSquare + EVENDOWNRIGHT + ODDDOWNRIGHT] = kingPiece; //place checker
                int tempCurrent = currentSquare + EVENDOWNRIGHT + ODDDOWNRIGHT;//next look at moves from here
                findRemainingKingJumps(tempBoard, tempCurrent, startSquare);
                noNewMoveFound = false;
            }
            if ((boardPosition[currentSquare + EVENUPRIGHT] == enemyPiece || boardPosition[currentSquare + EVENUPRIGHT] == enemyKingPiece)
                    && boardPosition[currentSquare + EVENUPRIGHT + ODDUPRIGHT] == '-') {
                tempBoard = boardPosition.clone();
                tempBoard[currentSquare] = '-'; //move checker to open spot
                tempBoard[currentSquare + EVENUPRIGHT] = '-'; // remove enemy checker
                tempBoard[currentSquare + EVENUPRIGHT + ODDUPRIGHT] = kingPiece; //place checker
                int tempCurrent = currentSquare + EVENUPRIGHT + ODDUPRIGHT;//next look at moves from here
                findRemainingKingJumps(tempBoard, tempCurrent, startSquare);
                noNewMoveFound = false;
            }
            if ((boardPosition[currentSquare + EVENUPLEFT] == enemyPiece || boardPosition[currentSquare + EVENUPLEFT] == enemyKingPiece)
                    && boardPosition[currentSquare + EVENUPLEFT + ODDUPLEFT] == '-') {
                tempBoard = boardPosition.clone();
                tempBoard[currentSquare] = '-'; //move checker to open spot
                tempBoard[currentSquare + EVENUPLEFT] = '-'; // remove enemy checker
                tempBoard[currentSquare + EVENUPLEFT + ODDUPLEFT] = kingPiece; //place checker
                int tempCurrent = currentSquare + EVENUPLEFT + ODDUPLEFT;//next look at moves from here
                findRemainingKingJumps(tempBoard, tempCurrent, startSquare);
                noNewMoveFound = false;
            }
        }   // remaining odd squares
        if (currentSquare == 13 || currentSquare == 14 || currentSquare == 21 || currentSquare == 22) {
            char[] tempBoard;
            if ((boardPosition[currentSquare + ODDDOWNRIGHT] == enemyPiece || boardPosition[currentSquare + ODDDOWNRIGHT] == enemyKingPiece)
                    && boardPosition[currentSquare + ODDDOWNRIGHT + EVENDOWNRIGHT] == '-') {
                tempBoard = boardPosition.clone();
                tempBoard[currentSquare] = '-'; //move checker to open spot
                tempBoard[currentSquare + ODDDOWNRIGHT] = '-'; // remove enemy checker
                tempBoard[currentSquare + ODDDOWNRIGHT + EVENDOWNRIGHT] = kingPiece; //place checker
                int tempCurrent = currentSquare + ODDDOWNRIGHT + EVENDOWNRIGHT;//next look at moves from here
                findRemainingKingJumps(tempBoard, tempCurrent, startSquare);
                noNewMoveFound = false;
            }
            if ((boardPosition[currentSquare + ODDDOWNLEFT] == enemyPiece || boardPosition[currentSquare + ODDDOWNLEFT] == enemyKingPiece)
                    && boardPosition[currentSquare + ODDDOWNLEFT + EVENDOWNLEFT] == '-') {
                tempBoard = boardPosition.clone();
                tempBoard[currentSquare] = '-'; //move checker to open spot
                tempBoard[currentSquare + ODDDOWNLEFT] = '-'; // remove enemy checker
                tempBoard[currentSquare + ODDDOWNLEFT + EVENDOWNLEFT] = kingPiece; //place checker
                int tempCurrent = currentSquare + ODDDOWNLEFT + EVENDOWNLEFT;//next look at moves from here
                findRemainingKingJumps(tempBoard, tempCurrent, startSquare);
                noNewMoveFound = false;
            }
            if ((boardPosition[currentSquare + ODDUPLEFT] == enemyPiece || boardPosition[currentSquare + ODDUPLEFT] == enemyKingPiece)
                    && boardPosition[currentSquare + ODDUPLEFT + EVENUPLEFT] == '-') {
                tempBoard = boardPosition.clone();
                tempBoard[currentSquare] = '-'; //move checker to open spot
                tempBoard[currentSquare + ODDUPLEFT] = '-'; // remove enemy checker
                tempBoard[currentSquare + ODDUPLEFT + EVENUPLEFT] = kingPiece; //place checker
                int tempCurrent = currentSquare + ODDUPLEFT + EVENUPLEFT;//next look at moves from here
                findRemainingKingJumps(tempBoard, tempCurrent, startSquare);
                noNewMoveFound = false;
            }
            if ((boardPosition[currentSquare + ODDUPRIGHT] == enemyPiece || boardPosition[currentSquare + ODDUPRIGHT] == enemyKingPiece)
                    && boardPosition[currentSquare + ODDUPRIGHT + EVENUPRIGHT] == '-') {
                tempBoard = boardPosition.clone();
                tempBoard[currentSquare] = '-'; //move checker to open spot
                tempBoard[currentSquare + ODDUPRIGHT] = '-'; // remove enemy checker
                tempBoard[currentSquare + ODDUPRIGHT + EVENUPRIGHT] = kingPiece; //place checker
                int tempCurrent = currentSquare + ODDUPRIGHT + EVENUPRIGHT;//next look at moves from here
                findRemainingKingJumps(tempBoard, tempCurrent, startSquare);
                noNewMoveFound = false;
            }
        }
        if (noNewMoveFound) {
            allPossibleMoves.add(new Node(boardPosition, startSquare, currentSquare));//add new node
            allPossibleJumps.add(new Node(boardPosition, startSquare, currentSquare));//add new node
        }
    }

    private void findRemainingBlackJumps(char[] boardPosition, int currentSquare, int startSquare) {
        char piece; // a checker
        char kingPiece; // a king checker
        char enemyPiece;
        char enemyKingPiece;
        boolean noNewMoveFound = true;

        piece = 'b'; // black piece
        kingPiece = 'B';
        enemyPiece = 'w';
        enemyKingPiece = 'W';

        if (currentSquare == 8 || currentSquare == 16) {
            if ((boardPosition[currentSquare + EVENDOWNRIGHT] == enemyPiece || boardPosition[currentSquare + EVENDOWNRIGHT] == enemyKingPiece)
                    && boardPosition[currentSquare + EVENDOWNRIGHT + ODDDOWNRIGHT] == '-') {
                boardPosition[currentSquare] = '-'; //move checker to open spot
                boardPosition[currentSquare + EVENDOWNRIGHT] = '-'; // remove enemy checker
                boardPosition[currentSquare + EVENDOWNRIGHT + ODDDOWNRIGHT] = piece; //place checker
                int tempCurrent = currentSquare + EVENDOWNRIGHT + ODDDOWNRIGHT;//next look at moves from here
                findRemainingBlackJumps(boardPosition, tempCurrent, startSquare);
                noNewMoveFound = false;
            }

        }
        if (currentSquare == 12 || currentSquare == 20) {
            if ((boardPosition[currentSquare + ODDDOWNRIGHT] == enemyPiece || boardPosition[currentSquare + ODDDOWNRIGHT] == enemyKingPiece)
                    && boardPosition[currentSquare + ODDDOWNRIGHT + EVENDOWNRIGHT] == '-') {
                boardPosition[currentSquare] = '-'; //move checker to open spot
                boardPosition[currentSquare + ODDDOWNRIGHT] = '-'; // remove enemy checker
                if ((currentSquare + ODDDOWNRIGHT + EVENDOWNRIGHT) == 29) {
                    boardPosition[currentSquare + ODDDOWNRIGHT + EVENDOWNRIGHT] = kingPiece;//place king because of promotion 
                } else {
                    boardPosition[currentSquare + ODDDOWNRIGHT + EVENDOWNRIGHT] = piece; //place checker
                }
                int tempCurrent = currentSquare + ODDDOWNRIGHT + EVENDOWNRIGHT;//next look at moves from here
                findRemainingBlackJumps(boardPosition, tempCurrent, startSquare);
                noNewMoveFound = false;
            }
        }
        if (currentSquare == 11 || currentSquare == 19) {
            if ((boardPosition[currentSquare + EVENDOWNLEFT] == enemyPiece || boardPosition[currentSquare + EVENDOWNLEFT] == enemyKingPiece)
                    && boardPosition[currentSquare + EVENDOWNLEFT + ODDDOWNLEFT] == '-') {
                boardPosition[currentSquare] = '-'; //move checker to open spot
                boardPosition[currentSquare + EVENDOWNLEFT] = '-'; // remove enemy checker
                boardPosition[currentSquare + EVENDOWNLEFT + ODDDOWNLEFT] = piece; //place checker
                int tempCurrent = currentSquare + EVENDOWNLEFT + ODDDOWNLEFT;//next look at moves from here
                findRemainingBlackJumps(boardPosition, tempCurrent, startSquare);
                noNewMoveFound = false;
            }
        }
        if (currentSquare == 15 || currentSquare == 23) {
            if ((boardPosition[currentSquare + ODDDOWNLEFT] == enemyPiece || boardPosition[currentSquare + ODDDOWNLEFT] == enemyKingPiece)
                    && boardPosition[currentSquare + ODDDOWNLEFT + EVENDOWNLEFT] == '-') {
                boardPosition[currentSquare] = '-'; //move checker to open spot
                boardPosition[currentSquare + ODDDOWNLEFT] = '-'; // remove enemy checker
                if ((currentSquare + ODDDOWNLEFT + EVENDOWNLEFT) == 30) {
                    boardPosition[currentSquare + ODDDOWNLEFT + EVENDOWNLEFT] = kingPiece;//place king because of promotion 
                } else {
                    boardPosition[currentSquare + ODDDOWNLEFT + EVENDOWNLEFT] = piece; //place checker
                }
                int tempCurrent = currentSquare + ODDDOWNLEFT + EVENDOWNLEFT;//next look at moves from here
                findRemainingBlackJumps(boardPosition, tempCurrent, startSquare);
                noNewMoveFound = false;
            }
        }
        if (currentSquare == 9 || currentSquare == 10 || currentSquare == 17 || currentSquare == 18) {
            char[] tempBoard;
            if ((boardPosition[currentSquare + EVENDOWNLEFT] == enemyPiece || boardPosition[currentSquare + EVENDOWNLEFT] == enemyKingPiece)
                    && boardPosition[currentSquare + EVENDOWNLEFT + ODDDOWNLEFT] == '-') {
                tempBoard = boardPosition.clone();
                tempBoard[currentSquare] = '-'; //move checker to open spot
                tempBoard[currentSquare + EVENDOWNLEFT] = '-'; // remove enemy checker
                tempBoard[currentSquare + EVENDOWNLEFT + ODDDOWNLEFT] = piece; //place checker
                int tempCurrent = currentSquare + EVENDOWNLEFT + ODDDOWNLEFT;//next look at moves from here
                findRemainingBlackJumps(tempBoard, tempCurrent, startSquare);
                noNewMoveFound = false;
            }
            if ((boardPosition[currentSquare + EVENDOWNRIGHT] == enemyPiece || boardPosition[currentSquare + EVENDOWNRIGHT] == enemyKingPiece)
                    && boardPosition[currentSquare + EVENDOWNRIGHT + ODDDOWNRIGHT] == '-') {
                tempBoard = boardPosition.clone();
                tempBoard[currentSquare] = '-'; //move checker to open spot
                tempBoard[currentSquare + EVENDOWNRIGHT] = '-'; // remove enemy checker
                tempBoard[currentSquare + EVENDOWNRIGHT + ODDDOWNRIGHT] = piece; //place checker
                int tempCurrent = currentSquare + EVENDOWNRIGHT + ODDDOWNRIGHT;//next look at moves from here
                findRemainingBlackJumps(tempBoard, tempCurrent, startSquare);
                noNewMoveFound = false;
            }
        }
        if (currentSquare == 13 || currentSquare == 14 || currentSquare == 21 || currentSquare == 22) {
            //remaining odd squares
            char[] tempBoard;
            if ((boardPosition[currentSquare + ODDDOWNRIGHT] == enemyPiece || boardPosition[currentSquare + ODDDOWNRIGHT] == enemyKingPiece)
                    && boardPosition[currentSquare + ODDDOWNRIGHT + EVENDOWNRIGHT] == '-') {
                tempBoard = boardPosition.clone();
                tempBoard[currentSquare] = '-'; //move checker to open spot
                tempBoard[currentSquare + ODDDOWNRIGHT] = '-'; // remove enemy checker
                if ((currentSquare + ODDDOWNRIGHT + EVENDOWNRIGHT) == 30 || (currentSquare + ODDDOWNRIGHT + EVENDOWNRIGHT) == 31) {
                    tempBoard[currentSquare + ODDDOWNRIGHT + EVENDOWNRIGHT] = kingPiece; //place king because of promotion 
                } else {
                    tempBoard[currentSquare + ODDDOWNRIGHT + EVENDOWNRIGHT] = piece; //place checker
                }
                int tempCurrent = currentSquare + ODDDOWNRIGHT + EVENDOWNRIGHT;//next look at moves from here
                findRemainingBlackJumps(tempBoard, tempCurrent, startSquare);
                noNewMoveFound = false;
            }
            if ((boardPosition[currentSquare + ODDDOWNLEFT] == enemyPiece || boardPosition[currentSquare + ODDDOWNLEFT] == enemyKingPiece)
                    && boardPosition[currentSquare + ODDDOWNLEFT + EVENDOWNLEFT] == '-') {
                tempBoard = boardPosition.clone();
                tempBoard[currentSquare] = '-'; //move checker to open spot
                tempBoard[currentSquare + ODDDOWNLEFT] = '-'; // remove enemy checker
                if ((currentSquare + ODDDOWNLEFT + EVENDOWNLEFT == 28) || (currentSquare + ODDDOWNLEFT + EVENDOWNLEFT == 29)) {
                    tempBoard[currentSquare + ODDDOWNLEFT + EVENDOWNLEFT] = kingPiece; //place king because of promotion 
                } else {
                    tempBoard[currentSquare + ODDDOWNLEFT + EVENDOWNLEFT] = piece; //place checker
                }
                int tempCurrent = currentSquare + ODDDOWNLEFT + EVENDOWNLEFT;//next look at moves from here
                findRemainingBlackJumps(tempBoard, tempCurrent, startSquare);
                noNewMoveFound = false;
            }
        }
        if (noNewMoveFound) {
            allPossibleMoves.add(new Node(boardPosition, startSquare, currentSquare));
            allPossibleJumps.add(new Node(boardPosition, startSquare, currentSquare));//add new node
        }

    }

    private void findRemainingWhiteJumps(char[] boardPosition, int currentSquare, int startSquare) {
        char piece;
        char kingPiece;
        char enemyPiece;
        char enemyKingPiece;
        boolean noNewMoveFound = true;

        piece = 'w';
        kingPiece = 'W';
        enemyPiece = 'b';
        enemyKingPiece = 'B';

        if (currentSquare == 8 || currentSquare == 16) {
            if ((boardPosition[currentSquare + EVENUPRIGHT] == enemyPiece || boardPosition[currentSquare + EVENUPRIGHT] == enemyKingPiece)
                    && boardPosition[currentSquare + EVENUPRIGHT + ODDUPRIGHT] == '-') {
                boardPosition[currentSquare] = '-'; //move checker to open spot
                boardPosition[currentSquare + EVENUPRIGHT] = '-'; // remove enemy checker
                if ((currentSquare + EVENUPRIGHT + ODDUPRIGHT) == 1) {
                    boardPosition[currentSquare + EVENUPRIGHT + ODDUPRIGHT] = kingPiece; //place checker
                } else {
                    boardPosition[currentSquare + EVENUPRIGHT + ODDUPRIGHT] = piece; //place checker
                }
                int tempCurrent = currentSquare + EVENUPRIGHT + ODDUPRIGHT;//next look at moves from here
                findRemainingWhiteJumps(boardPosition, tempCurrent, startSquare);
                noNewMoveFound = false;
            }
        }
        if (currentSquare == 12 || currentSquare == 20) {
            if ((boardPosition[currentSquare + ODDUPRIGHT] == enemyPiece || boardPosition[currentSquare + ODDUPRIGHT] == enemyKingPiece)
                    && boardPosition[currentSquare + ODDUPRIGHT + EVENUPRIGHT] == '-') {
                boardPosition[currentSquare] = '-'; //move checker to open spot
                boardPosition[currentSquare + ODDUPRIGHT] = '-'; // remove enemy checker
                boardPosition[currentSquare + ODDUPRIGHT + EVENUPRIGHT] = piece; //place checker
                int tempCurrent = currentSquare + ODDUPRIGHT + EVENUPRIGHT;//next look at moves from here
                findRemainingWhiteJumps(boardPosition, tempCurrent, startSquare);
                noNewMoveFound = false;
            }
        }
        if (currentSquare == 11 || currentSquare == 19) {
            char[] tempBoard;
            if ((boardPosition[currentSquare + EVENUPLEFT] == enemyPiece || boardPosition[currentSquare + EVENUPLEFT] == enemyKingPiece)
                    && boardPosition[currentSquare + EVENUPLEFT + ODDUPLEFT] == '-') {
                tempBoard = boardPosition.clone();
                tempBoard[currentSquare] = '-'; //move checker to open spot
                tempBoard[currentSquare + EVENUPLEFT] = '-'; // remove enemy checker
                if ((currentSquare + EVENUPLEFT + ODDUPLEFT) == 2) {
                    tempBoard[currentSquare + EVENUPLEFT + ODDUPLEFT] = kingPiece; //place checker 
                }
                tempBoard[currentSquare + EVENUPLEFT + ODDUPLEFT] = piece; //place checker
                int tempCurrent = currentSquare + EVENUPLEFT + ODDUPLEFT;//next look at moves from here
                findRemainingWhiteJumps(tempBoard, tempCurrent, startSquare);
                noNewMoveFound = false;
            }
        }
        if (currentSquare == 15 || currentSquare == 23) {
            char[] tempBoard;
            if ((boardPosition[currentSquare + ODDUPLEFT] == enemyPiece || boardPosition[currentSquare + ODDUPLEFT] == enemyKingPiece)
                    && boardPosition[currentSquare + ODDUPLEFT + EVENUPLEFT] == '-') {
                tempBoard = boardPosition.clone();
                tempBoard[currentSquare] = '-'; //move checker to open spot
                tempBoard[currentSquare + ODDUPLEFT] = '-'; // remove enemy checker
                tempBoard[currentSquare + ODDUPLEFT + EVENUPLEFT] = piece; //place checker
                int tempCurrent = currentSquare + ODDUPLEFT + EVENUPLEFT;//next look at moves from here
                findRemainingWhiteJumps(tempBoard, tempCurrent, startSquare);
                noNewMoveFound = false;
            }
        }
        if (currentSquare == 9 || currentSquare == 10 || currentSquare == 17 || currentSquare == 18) {
            char[] tempBoard;
            if ((boardPosition[currentSquare + EVENUPLEFT] == enemyPiece || boardPosition[currentSquare + EVENUPLEFT] == enemyKingPiece)
                    && boardPosition[currentSquare + EVENUPLEFT + ODDUPLEFT] == '-') {
                tempBoard = boardPosition.clone();
                tempBoard[currentSquare] = '-'; //move checker to open spot
                tempBoard[currentSquare + EVENUPLEFT] = '-'; // remove enemy checker
                if ((currentSquare + EVENUPLEFT + ODDUPLEFT) == 1 || (currentSquare + EVENUPLEFT + ODDUPLEFT) == 0) {
                    tempBoard[currentSquare + EVENUPLEFT + ODDUPLEFT] = kingPiece; //place checker
                } else {
                    tempBoard[currentSquare + EVENUPLEFT + ODDUPLEFT] = piece; //place checker 
                }
                int tempCurrent = currentSquare + EVENUPLEFT + ODDUPLEFT;//next look at moves from here
                findRemainingWhiteJumps(tempBoard, tempCurrent, startSquare);
                noNewMoveFound = false;
            }
            if ((boardPosition[currentSquare + EVENUPRIGHT] == enemyPiece || boardPosition[currentSquare + EVENUPRIGHT] == enemyKingPiece)
                    && boardPosition[currentSquare + EVENUPRIGHT + ODDUPRIGHT] == '-') {
                tempBoard = boardPosition.clone();
                tempBoard[currentSquare] = '-'; //move checker to open spot
                tempBoard[currentSquare + EVENUPRIGHT] = '-'; // remove enemy checker
                if ((currentSquare + EVENUPRIGHT + ODDUPRIGHT) == 2 || (currentSquare + EVENUPRIGHT + ODDUPRIGHT) == 3) {
                    tempBoard[currentSquare + EVENUPRIGHT + ODDUPRIGHT] = kingPiece; //place checker
                } else {
                    tempBoard[currentSquare + EVENUPRIGHT + ODDUPRIGHT] = piece; //place checker
                }
                int tempCurrent = currentSquare + EVENUPRIGHT + ODDUPRIGHT;//next look at moves from here
                findRemainingWhiteJumps(tempBoard, tempCurrent, startSquare);
                noNewMoveFound = false;
            }
        }
        if (currentSquare == 13 || currentSquare == 14 || currentSquare == 21 || currentSquare == 22) {
            //remaining odd squares
            char[] tempBoard;
            if ((boardPosition[currentSquare + ODDUPRIGHT] == enemyPiece || boardPosition[currentSquare + ODDUPRIGHT] == enemyKingPiece)
                    && boardPosition[currentSquare + ODDUPRIGHT + EVENUPRIGHT] == '-') {
                tempBoard = boardPosition.clone();
                tempBoard[currentSquare] = '-'; //move checker to open spot
                tempBoard[currentSquare + ODDUPRIGHT] = '-'; // remove enemy checker
                tempBoard[currentSquare + ODDUPRIGHT + EVENUPRIGHT] = piece; //place checker
                int tempCurrent = currentSquare + ODDUPRIGHT + EVENUPRIGHT;//next look at moves from here
                findRemainingWhiteJumps(tempBoard, tempCurrent, startSquare);
                noNewMoveFound = false;
            }
            if ((boardPosition[currentSquare + ODDUPLEFT] == enemyPiece || boardPosition[currentSquare + ODDUPLEFT] == enemyKingPiece)
                    && boardPosition[currentSquare + ODDUPLEFT + EVENUPLEFT] == '-') {
                tempBoard = boardPosition.clone();
                tempBoard[currentSquare] = '-'; //move checker to open spot
                tempBoard[currentSquare + ODDUPLEFT] = '-'; // remove enemy checker
                tempBoard[currentSquare + ODDUPLEFT + EVENUPLEFT] = piece; //place checker
                int tempCurrent = currentSquare + ODDUPLEFT + EVENUPLEFT;//next look at moves from here
                findRemainingWhiteJumps(tempBoard, tempCurrent, startSquare);
                noNewMoveFound = false;
            }
        }
        if (noNewMoveFound) {
            allPossibleMoves.add(new Node(boardPosition, startSquare, currentSquare));
            allPossibleJumps.add(new Node(boardPosition, startSquare, currentSquare));//add new node
        }
    }
}
