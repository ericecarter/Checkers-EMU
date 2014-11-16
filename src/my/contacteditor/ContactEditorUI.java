/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.contacteditor;

import javax.swing.*;

/**
 *
 * @author KN
 */
public class ContactEditorUI extends javax.swing.JFrame {

    //Holds the data for the checkerboard
    private CheckerPiece[][] checkersBoard;

    //track the checker pieces
    JLabel[] tracker;

    //this finds all possible moves based on the current board
    Moves moveFinder;

    //this picks a random move
    Evaluator evaluator;

    //this one dimensional array holds the current position of the board
    char[] currentPosition = new char[32];

    //Keep track of cells clicked by the user on the checkerboard
    private CheckerPiece firstClickedCell = null;
    private CheckerPiece secondClickedCell = null;

    //two clicks per action
    private int clicks = 1;
    //Keep track of who's turn it is
    //Black goes first
    private boolean computersTurn = false;

    /**
     * Creates new form ContactEditorUI
     */
    public ContactEditorUI() {
        this.moveFinder = new Moves();
        this.evaluator = new Evaluator();
        initComponents();
        setSize(768, 550);
        setBoard();
        drawBoard();
    }

    //Initializes the checkerboard with all the pieces and cell index #s
    private void setBoard() {

        //Create the CheckerBoard 8x8 cells
        checkersBoard = new CheckerPiece[8][8];

        //even rows start with red or white, odd rows start with black
        //this tells us which cells aren't being used therefore they have no index #
        //as well as players cannot move on them
        boolean evenRow = true;

        int i = 1;//Each row has 8 columns/cells, some are usable and others are not, 1~8
        int index = 1;//1~32, index #s for cells are used in the evaluator
        //Go through 8 rows
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                //From cells 1~8 in even rows, the even cells are used
                if (evenRow == true) {   //cells where checkers may move
                    if ((i % 2) == 0) {
                        //rows 3 and 4 start off empty and other side is white pieces
                        if (y == 0 || y == 1 || y == 2) {
                            checkersBoard[y][x] = new CheckerPiece('b', index);
                        } else if (y == 5 || y == 6 || y == 7) {
                            checkersBoard[y][x] = new CheckerPiece('w', index);
                        } else {
                            checkersBoard[y][x] = new CheckerPiece('-', index);
                        }
                        index++;//increment the index where pieces can move
                    } //cells where checkers cannot move
                    else {
                        checkersBoard[y][x] = new CheckerPiece('.', 0);
                    }
                } //From cells 1~8 in odd rows, the odd cells are used
                else {   //cells where checkers may move
                    if ((i % 2) != 0) {
                        //rows 3 and 4 start off empty and other side is black pieces
                        if (y == 0 || y == 1 || y == 2) {
                            checkersBoard[y][x] = new CheckerPiece('b', index);
                        } else if (y == 5 || y == 6 || y == 7) {
                            checkersBoard[y][x] = new CheckerPiece('w', index);
                        } else {
                            checkersBoard[y][x] = new CheckerPiece('-', index);
                        }
                        index++;//increment the index where pieces can move
                    } //cells where checkers cannot move
                    else {
                        checkersBoard[y][x] = new CheckerPiece('.', 0);
                    }

                }

                i++;//moving on to next cell/column in the current row
            }
            //Each row switch between even and odd index placement
            if (evenRow == true) {
                evenRow = false;
            } else {
                evenRow = true;
            }

            i = 1;
        }

    }

    //Draws or Places the checker pieces on the board based on the data in the checkersboard 2d array
    private void drawBoard() {
        //Used to reference labels that represent pieces visually with Imageicons
        int whiteCount = 12;
        int blackCount = 0;
        tracker = new JLabel[24];

        //make the text areas uneditable
        Sentence.setEditable(false);
        jTextArea2.setEditable(false);

        //black pieces 0 to 11
        tracker[0] = BP1;
        tracker[1] = BP2;
        tracker[2] = BP3;
        tracker[3] = BP4;
        tracker[4] = BP5;
        tracker[5] = BP6;
        tracker[6] = BP7;
        tracker[7] = BP8;
        tracker[8] = BP9;
        tracker[9] = BP10;
        tracker[10] = BP11;
        tracker[11] = BP12;

        //Cut off from black pieces to white pieces
        //white pieces 12 to 23
        tracker[12] = WP1;
        tracker[13] = WP2;
        tracker[14] = WP3;
        tracker[15] = WP4;
        tracker[16] = WP5;
        tracker[17] = WP6;
        tracker[18] = WP7;
        tracker[19] = WP8;
        tracker[20] = WP9;
        tracker[21] = WP10;
        tracker[22] = WP11;
        tracker[23] = WP12;

        //Check to see if any pieces just became kings resently
        setUpKings();

        //Place checkers board
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if (checkersBoard[y][x].getColor() == 'b') {
                    tracker[blackCount].setLocation(x * 64, y * 64);

                    //Is the piece selected?
                    if (checkersBoard[y][x].getSelect() == true) {
                        tracker[blackCount].setIcon(new javax.swing.ImageIcon(getClass().getResource("/GFX/BPHL.png")));
                    } else {
                        tracker[blackCount].setIcon(new javax.swing.ImageIcon(getClass().getResource("/GFX/BP.png")));
                    }

                    blackCount++;
                }
                if (checkersBoard[y][x].getColor() == 'B') {
                    tracker[blackCount].setLocation(x * 64, y * 64);

                    //Is the king selected or not?
                    if (checkersBoard[y][x].getSelect() == true) {
                        tracker[blackCount].setIcon(new javax.swing.ImageIcon(getClass().getResource("/GFX/BPKHL.png")));
                    } else {
                        tracker[blackCount].setIcon(new javax.swing.ImageIcon(getClass().getResource("/GFX/BPK.png")));
                    }

                    blackCount++;
                }
                if (checkersBoard[y][x].getColor() == 'w') {
                    tracker[whiteCount].setLocation(x * 64, y * 64);

                    //Is the piece selected?
                    if (checkersBoard[y][x].getSelect() == true) {
                        tracker[whiteCount].setIcon(new javax.swing.ImageIcon(getClass().getResource("/GFX/WPHL.png")));
                    } else {
                        tracker[whiteCount].setIcon(new javax.swing.ImageIcon(getClass().getResource("/GFX/WP.png")));
                    }

                    whiteCount++;
                }
                if (checkersBoard[y][x].getColor() == 'W') {
                    tracker[whiteCount].setLocation(x * 64, y * 64);

                    //Is the king selected or not?
                    if (checkersBoard[y][x].getSelect() == true) {
                        tracker[whiteCount].setIcon(new javax.swing.ImageIcon(getClass().getResource("/GFX/WPKHL.png")));
                    } else {
                        tracker[whiteCount].setIcon(new javax.swing.ImageIcon(getClass().getResource("/GFX/WPK.png")));
                    }

                    whiteCount++;
                }
            }
        }

        //any jumped pieces/left over are put on the side of the checkersboard
        for (int i = whiteCount; i < 24; i++) {
            tracker[i].setLocation(522, 320);
        }

        for (int i = blackCount; i < 12; i++) {
            tracker[i].setLocation(522, 256);
        }
    }

    //makes sure if a piece should be a king it is in the 2d array and visually
    private void setUpKings() {
        for (int i = 0; i < 8; i++) {
            for (int o = 0; o < 8; o++) {
                //make white pieces kings if they should be
                if (checkersBoard[i][o].getPosition() == 1 && checkersBoard[i][o].getColor() == 'w') {
                    checkersBoard[i][o].setColor('W');
                }
                if (checkersBoard[i][o].getPosition() == 2 && checkersBoard[i][o].getColor() == 'w') {
                    checkersBoard[i][o].setColor('W');
                }
                if (checkersBoard[i][o].getPosition() == 3 && checkersBoard[i][o].getColor() == 'w') {
                    checkersBoard[i][o].setColor('W');
                }
                if (checkersBoard[i][o].getPosition() == 4 && checkersBoard[i][o].getColor() == 'w') {
                    checkersBoard[i][o].setColor('W');
                }

                //make black pieces kings if they should be
                if (checkersBoard[i][o].getPosition() == 29 && checkersBoard[i][o].getColor() == 'b') {
                    checkersBoard[i][o].setColor('B');
                }
                if (checkersBoard[i][o].getPosition() == 30 && checkersBoard[i][o].getColor() == 'b') {
                    checkersBoard[i][o].setColor('B');
                }
                if (checkersBoard[i][o].getPosition() == 31 && checkersBoard[i][o].getColor() == 'b') {
                    checkersBoard[i][o].setColor('B');
                }
                if (checkersBoard[i][o].getPosition() == 32 && checkersBoard[i][o].getColor() == 'b') {
                    checkersBoard[i][o].setColor('B');
                }
            }
        }
    }

    // this method converts the two dimension checkerboard array to
    // a one dimensional array
    private void ConvertToOneDimension() {
        int index = 0;
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if (y % 2 == 0 && x % 2 == 1) {
                    currentPosition[index] = checkersBoard[y][x].getColor();
                    index++;
                }
                if (y % 2 == 1 && x % 2 == 0) {
                    currentPosition[index] = checkersBoard[y][x].getColor();
                    index++;
                }
            }
        }
    }

    // this method converts the one dimensional array to a two dimensional
    // array
    private void convertToTwoDimension() {
        int index = 0;
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if (y % 2 == 0 && x % 2 == 1) {
                    checkersBoard[y][x].setColor(currentPosition[index]);
                    index++;
                }
                if (y % 2 == 1 && x % 2 == 0) {
                    checkersBoard[y][x].setColor(currentPosition[index]);
                    index++;
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	
    	jLayeredPane1 = new javax.swing.JLayeredPane();
        WP1 = new javax.swing.JLabel();
        WP2 = new javax.swing.JLabel();
        WP3 = new javax.swing.JLabel();
        WP4 = new javax.swing.JLabel();
        WP5 = new javax.swing.JLabel();
        WP6 = new javax.swing.JLabel();
        WP7 = new javax.swing.JLabel();
        WP8 = new javax.swing.JLabel();
        WP9 = new javax.swing.JLabel();
        WP10 = new javax.swing.JLabel();
        WP11 = new javax.swing.JLabel();
        WP12 = new javax.swing.JLabel();
        BP1 = new javax.swing.JLabel();
        BP2 = new javax.swing.JLabel();
        BP3 = new javax.swing.JLabel();
        BP4 = new javax.swing.JLabel();
        BP5 = new javax.swing.JLabel();
        BP6 = new javax.swing.JLabel();
        BP7 = new javax.swing.JLabel();
        BP8 = new javax.swing.JLabel();
        BP9 = new javax.swing.JLabel();
        BP10 = new javax.swing.JLabel();
        BP11 = new javax.swing.JLabel();
        BP12 = new javax.swing.JLabel();
        checkerBoard = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        BlackBox = new javax.swing.JCheckBox();
        WhiteBox = new javax.swing.JCheckBox();
        Sentence = new javax.swing.JTextField();
        ResetButton = new javax.swing.JButton();
        
    	setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        WP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GFX/WP.png"))); // NOI18N
        WP1.setText("jLabel1");
        jLayeredPane1.add(WP1);
        WP1.setBounds(60, 380, 64, 64);
        WP1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	boardClicked(evt);
            }
        });

        WP2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GFX/WP.png"))); // NOI18N
        WP2.setText("jLabel1");
        jLayeredPane1.add(WP2);
        WP2.setBounds(450, 390, 64, 64);
        WP2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	boardClicked(evt);
            }
        });

        WP3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GFX/WP.png"))); // NOI18N
        WP3.setText("jLabel1");
        jLayeredPane1.add(WP3);
        WP3.setBounds(390, 450, 64, 64);
        WP3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	boardClicked(evt);
            }
        });

        WP4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GFX/WP.png"))); // NOI18N
        WP4.setText("jLabel1");
        jLayeredPane1.add(WP4);
        WP4.setBounds(260, 450, 64, 64);
        WP4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	boardClicked(evt);
            }
        });

        WP5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GFX/WP.png"))); // NOI18N
        WP5.setText("jLabel1");
        jLayeredPane1.add(WP5);
        WP5.setBounds(130, 450, 64, 64);
        WP5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	boardClicked(evt);
            }
        });

        WP6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GFX/WP.png"))); // NOI18N
        WP6.setText("jLabel1");
        jLayeredPane1.add(WP6);
        WP6.setBounds(320, 390, 64, 64);
        WP6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	boardClicked(evt);
            }
        });

        WP7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GFX/WP.png"))); // NOI18N
        WP7.setText("jLabel1");
        jLayeredPane1.add(WP7);
        WP7.setBounds(190, 380, 64, 64);
        WP7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	boardClicked(evt);
            }
        });

        WP8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GFX/WP.png"))); // NOI18N
        WP8.setText("jLabel1");
        jLayeredPane1.add(WP8);
        WP8.setBounds(390, 260, 64, 64);
        WP8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	boardClicked(evt);
            }
        });

        WP9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GFX/WP.png"))); // NOI18N
        WP9.setText("jLabel1");
        jLayeredPane1.add(WP9);
        WP9.setBounds(190, 260, 64, 64);
        WP9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	boardClicked(evt);
            }
        });

        WP10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GFX/WP.png"))); // NOI18N
        WP10.setText("jLabel1");
        jLayeredPane1.add(WP10);
        WP10.setBounds(130, 320, 64, 64);
        WP10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	boardClicked(evt);
            }
        });

        WP11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GFX/WP.png"))); // NOI18N
        WP11.setText("jLabel1");
        jLayeredPane1.add(WP11);
        WP11.setBounds(0, 320, 64, 64);
        WP11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	boardClicked(evt);
            }
        });

        WP12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GFX/WP.png"))); // NOI18N
        WP12.setText("jLabel1");
        jLayeredPane1.add(WP12);
        WP12.setBounds(0, 450, 64, 64);
        WP12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	boardClicked(evt);
            }
        });

        BP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GFX/BP.png"))); // NOI18N
        BP1.setText("jLabel1");
        jLayeredPane1.add(BP1);
        BP1.setBounds(130, 190, 64, 64);
        BP1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	boardClicked(evt);
            }
        });

        BP2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GFX/BP.png"))); // NOI18N
        BP2.setText("jLabel1");
        jLayeredPane1.add(BP2);
        BP2.setBounds(190, 0, 64, 64);
        BP2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	boardClicked(evt);
            }
        });

        BP3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GFX/BP.png"))); // NOI18N
        BP3.setText("jLabel1");
        jLayeredPane1.add(BP3);
        BP3.setBounds(0, 60, 64, 64);
        BP3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	boardClicked(evt);
            }
        });

        BP4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GFX/BP.png"))); // NOI18N
        BP4.setText("jLabel1");
        jLayeredPane1.add(BP4);
        BP4.setBounds(320, 0, 64, 64);
        BP4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	boardClicked(evt);
            }
        });

        BP5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GFX/BP.png"))); // NOI18N
        BP5.setText("jLabel1");
        jLayeredPane1.add(BP5);
        BP5.setBounds(450, 0, 64, 64);
        BP5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	boardClicked(evt);
            }
        });

        BP6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GFX/BP.png"))); // NOI18N
        BP6.setText("jLabel1");
        jLayeredPane1.add(BP6);
        BP6.setBounds(260, 190, 64, 64);
        BP6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	boardClicked(evt);
            }
        });

        BP7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GFX/BP.png"))); // NOI18N
        BP7.setText("jLabel1");
        jLayeredPane1.add(BP7);
        BP7.setBounds(380, 70, 64, 64);
        BP7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	boardClicked(evt);
            }
        });

        BP8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GFX/BP.png"))); // NOI18N
        BP8.setText("jLabel1");
        jLayeredPane1.add(BP8);
        BP8.setBounds(60, 130, 64, 64);
        BP8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	boardClicked(evt);
            }
        });

        BP9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GFX/BP.png"))); // NOI18N
        BP9.setText("jLabel1");
        jLayeredPane1.add(BP9);
        BP9.setBounds(190, 130, 64, 64);
        BP9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	boardClicked(evt);
            }
        });

        BP10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GFX/BP.png"))); // NOI18N
        BP10.setText("jLabel1");
        jLayeredPane1.add(BP10);
        BP10.setBounds(320, 130, 64, 64);
        BP10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	boardClicked(evt);
            }
        });

        BP11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GFX/BP.png"))); // NOI18N
        BP11.setText("jLabel1");
        jLayeredPane1.add(BP11);
        BP11.setBounds(450, 130, 64, 64);
        BP11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	boardClicked(evt);
            }
        });

        BP12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GFX/BP.png"))); // NOI18N
        BP12.setText("jLabel1");
        BP12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	boardClicked(evt);
            }
        });
        jLayeredPane1.add(BP12);
        BP12.setBounds(60, 0, 64, 64);

        checkerBoard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GFX/CheckerBoard.png"))); // NOI18N
        checkerBoard.setText("jLabel2");
        checkerBoard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	boardClicked(evt);
            }
        });
        jLayeredPane1.add(checkerBoard);
        checkerBoard.setBounds(0, 0, 512, 512);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jLayeredPane1.add(jScrollPane2);
        jScrollPane2.setBounds(520, 10, 220, 200);

        BlackBox.setText("Black");
        jLayeredPane1.add(BlackBox);
        BlackBox.setBounds(520, 260, 60, 23);
        BlackBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BlackBoxActionPerformed(evt);
            }
        });
        
        WhiteBox.setText("White");
        jLayeredPane1.add(WhiteBox);
        WhiteBox.setBounds(590, 260, 60, 23);
        WhiteBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WhiteBoxActionPerformed(evt);
            }
        });
        
        Sentence.setText(" Pick your piece color");
        jLayeredPane1.add(Sentence);
        Sentence.setBounds(520, 220, 130, 30);

        ResetButton.setText("Reset Buton");
        jLayeredPane1.add(ResetButton);
        ResetButton.setBounds(520, 470, 100, 30);
        ResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetButtonActionPerformed(evt);
            }
        });
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Gets the cell that was clicked at the x & y position and keeps track of the two cells being clicked for a complete move/action
    private void boardClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BP12MouseClicked

        //get x and y coordinates from mouse click
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        //figure out which row and column were clicked to find the cell they selected
        int row = y / 64;
        int column = x / 64;

        //first or second click?
        if (clicks == 1 && row < 8 && column < 8) { //check if less than 8 to prevent 
            // array index out of bounds
            firstClickedCell = checkersBoard[row][column];

            //first click must be where an actual checker piece exist
            if (firstClickedCell.getColor() == 'w' || firstClickedCell.getColor() == 'W'
                    || firstClickedCell.getColor() == 'b' || firstClickedCell.getColor() == 'B') {
                clicks++;

                //piece has been selected so show that graphically
                firstClickedCell.setSelect(true);
                drawBoard();
            }
        } else {
            if (row < 8 && column < 8)//prevents array exception
            {
                secondClickedCell = checkersBoard[row][column];
            }

            //Cannot have the first cell and second cell the same
            if (firstClickedCell != secondClickedCell && secondClickedCell.getColor() != '.') {

                for (int i = 0; i < moveFinder.allPossibleMoves.size(); i++) {
                    if ((firstClickedCell.getPosition() - 1) == moveFinder.allPossibleMoves.get(i).start
                            && (secondClickedCell.getPosition() - 1) == moveFinder.allPossibleMoves.get(i).finish) {
                        currentPosition = moveFinder.allPossibleMoves.get(i).getNp();
                        convertToTwoDimension();
                        drawBoard();
                        jTextArea2.append(firstClickedCell.getPosition() + "-" + secondClickedCell.getPosition() + "\n");

                        computersTurn = true;
                        if (moveFinder.blacksMove == true) {
                            moveFinder.blacksMove = false;
                        } else {
                            moveFinder.blacksMove = true;
                        }
                        ConvertToOneDimension();
                        moveFinder.setCurrentPosition(currentPosition);
                        break;
                    }
                }

                drawBoard();

                if (computersTurn) {
                    currentPosition = evaluator.makeMinMaxMove(currentPosition, moveFinder.blacksMove);
                    if (currentPosition != null) {
                        convertToTwoDimension(); // convert back to 2-d
                        //update history
                        jTextArea2.append((evaluator.getStartPosition() + 1) + "-" + (evaluator.getEndPosition() + 1) + "\n");
                        drawBoard(); //draw the new board
                        computersTurn = false;
                        if (moveFinder.blacksMove == true) {
                            moveFinder.blacksMove = false;
                        } else {
                            moveFinder.blacksMove = true;
                        }
                        ConvertToOneDimension();
                        moveFinder.setCurrentPosition(currentPosition);
                        moveFinder.findAllMoves();
                    }
                }
            } //if same cell is the first and second click deselect it and reset clicks to 1

            firstClickedCell.setSelect(false);

            //deselect all pieces
            for (int i = 0; i < 8; i++) {
                for (int o = 0; o < 8; o++) {
                    checkersBoard[i][o].setSelect(false);
                }
            }

            drawBoard();
            clicks = 1;
        }

    }//GEN-LAST:event_BP12MouseClicked
    //Reset the checkers game
    private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetButtonActionPerformed
        setBoard();
        drawBoard();
        ConvertToOneDimension();
        moveFinder.blacksMove = true;
        clicks = 1;
        jTextArea2.setText("");
        BlackBox.setVisible(true);
        WhiteBox.setVisible(true);
        Sentence.setVisible(true);
    }//GEN-LAST:event_ResetButtonActionPerformed
    //Player has choosen to be white
    private void WhiteBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WhiteBoxActionPerformed
        computersTurn = true;
        BlackBox.setVisible(false);
        BlackBox.setSelected(false);
        WhiteBox.setSelected(false);
        WhiteBox.setVisible(false);
        Sentence.setVisible(false);

        //Computer's Turn
        ConvertToOneDimension(); //convert the 2-d array to one d
        //the computer picks a move
        currentPosition = evaluator.makeMinMaxMove(currentPosition, moveFinder.blacksMove);
        convertToTwoDimension(); // convert back to 2-d
        // update history
        jTextArea2.append((evaluator.getStartPosition() + 1) + "-" + (evaluator.getEndPosition() + 1) + "\n");
        drawBoard(); //draw the new board
        moveFinder.blacksMove = false;//players turn now
        ConvertToOneDimension(); //convert the 2-d array to one d
        moveFinder.setCurrentPosition(currentPosition); //send the current position to movefinder
        moveFinder.findAllMoves(); //find all moves

    }//GEN-LAST:event_WhiteBoxActionPerformed
    //Player has choosen to be black
    private void BlackBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BlackBoxActionPerformed
        computersTurn = false;
        BlackBox.setVisible(false);
        WhiteBox.setVisible(false);
        BlackBox.setSelected(false);
        WhiteBox.setSelected(false);
        Sentence.setVisible(false);
        ConvertToOneDimension();
        moveFinder.setCurrentPosition(currentPosition);
        moveFinder.findAllMoves();
    }//GEN-LAST:event_BlackBoxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ContactEditorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ContactEditorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ContactEditorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ContactEditorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ContactEditorUI().setVisible(true);
            }
        });

    }
//

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BP1;
    private javax.swing.JLabel BP10;
    private javax.swing.JLabel BP11;
    private javax.swing.JLabel BP12;
    private javax.swing.JLabel BP2;
    private javax.swing.JLabel BP3;
    private javax.swing.JLabel BP4;
    private javax.swing.JLabel BP5;
    private javax.swing.JLabel BP6;
    private javax.swing.JLabel BP7;
    private javax.swing.JLabel BP8;
    private javax.swing.JLabel BP9;
    private javax.swing.JCheckBox BlackBox;
    private javax.swing.JButton ResetButton;
    private javax.swing.JTextField Sentence;
    private javax.swing.JLabel WP1;
    private javax.swing.JLabel WP10;
    private javax.swing.JLabel WP11;
    private javax.swing.JLabel WP12;
    private javax.swing.JLabel WP2;
    private javax.swing.JLabel WP3;
    private javax.swing.JLabel WP4;
    private javax.swing.JLabel WP5;
    private javax.swing.JLabel WP6;
    private javax.swing.JLabel WP7;
    private javax.swing.JLabel WP8;
    private javax.swing.JLabel WP9;
    private javax.swing.JCheckBox WhiteBox;
    private javax.swing.JLabel checkerBoard;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
