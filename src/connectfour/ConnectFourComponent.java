package connectfour;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

import static java.util.Arrays.*;

public class ConnectFourComponent extends JComponent {
    int colomns = 6;
    int rows = 7;
    int winner = 0;
    int [][] board = new int[colomns][rows];
    int turn = 1;



    public void droppeice( int row){
        if (winner == 0) {
            boolean peiceplaced = false;
            int colomn = 5;
            while (peiceplaced == false && colomn >= 0) {
                if (board[colomn][row] == 0) {
                    board[colomn][row] = turn;
                    peiceplaced = true;
                } else {
                    colomn --;
                }
            }

            if (peiceplaced ) {
                checkwinner(colomn,row);
                if(winner == 0) {
                    if (turn == 1) {
                        turn = 2;
                    } else {
                        turn = 1;
                    }
                }
            }
        }


        repaint();

    }

    public void checkwinner(int colomn, int row){
        boolean iswinner = false;
        int peicesinarow = 1;


        //check down
        for (int i = colomn + 1; i < 6; i ++) {
            if (board[i][row] == turn) {
                peicesinarow ++;
            } else {
                break;
            }
        }
        if (peicesinarow >= 4){
            iswinner = true;
        }

        //check across
        if (iswinner == false){
            peicesinarow = 1;
            for(int i = row + 1; i < 7; i ++){
                if(board[colomn][i] == turn){
                    peicesinarow ++;
                }
                else{break;}

            }
            for (int i = row - 1; i >= 0; i --){
                if(board[colomn][i] == turn){
                    peicesinarow ++;
                }
                else{break;}
            }
            if (peicesinarow >= 4){
                iswinner = true;
            }
        }




        //check 1st diagonal
        if (iswinner == false) {
            peicesinarow = 1;
            int i = colomn + 1;
            int j = row + 1;
            while(i < 6 && j < 7){
                if(board[i][j] == turn){
                    peicesinarow ++;
                    i ++;
                    j ++;
                }
                else{break;}
            }
            i = colomn - 1;
            j = row - 1;
            while(i >= 0 && j >= 0){
                if (board[i][j] == turn){
                    peicesinarow ++;
                    i --;
                    j --;
                }
                else{break;}
            }
            if (peicesinarow >= 4){
                iswinner = true;
            }

        }


        //check 2nd diagonal
        if (iswinner == false) {
            peicesinarow = 1;
            int i = colomn +1;
            int j = row -1;
            while(i < 6 && j >= 0){
                if(board[i][j] == turn){
                    peicesinarow ++;
                    i ++;
                    j --;
                }
                else{break;}
            }
            i = colomn - 1;
            j = row + 1;
            while(i >= 0 && j < 7){
                if (board[i][j] == turn){
                    peicesinarow ++;
                    i --;
                    j ++;
                }
                else{break;}
            }
            if (peicesinarow >= 4){
                iswinner = true;
            }

        }

        if (iswinner == true){
            winner = turn;
        }
        repaint();
    }



    public void newGame(){
        for (int i = 0; i < 6; i ++) {
            for (int j = 0; j < 7; j ++) {
                board[i][j] = 0;
            }
        }
        winner = 0;
        turn = 1;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics graphics){



        int rowplacement = 20;
        int colomnplacement = 20;
        int circlesize = 130;
        int spacebetween = 5;


        int height = colomnplacement + spacebetween * 5 + circlesize * 6;
        int width = rowplacement +spacebetween * 6 +circlesize * 7;


        graphics.setColor(Color.blue);
        graphics.fillRect(10,10, width,height);




        //board [5][2]= 1;
       // board [4][2]=2;
        for (int i = 0; i < 6; i ++){
            for (int j= 0; j < 7; j ++){
                if (board[i][j] == 0){
                    graphics.setColor(Color.white);
                }
                else if (board[i][j] == 1){
                    graphics.setColor(Color.red);
                }
                else if (board[i][j] == 2){
                    graphics.setColor(Color.yellow);
                }
                graphics.fillOval(colomnplacement,rowplacement,circlesize,circlesize);
                colomnplacement = colomnplacement + circlesize + spacebetween;

            }
            colomnplacement = 20;
            rowplacement = rowplacement + circlesize + spacebetween;
        }



        graphics.setColor(Color.BLACK);
        if (winner == 0) {
            if (turn == 1) {
                graphics.drawString("Red's Turn", width / 2 + 10, height + 30);
            }
            if (turn == 2) {
                graphics.drawString("Yellow's Turn", width / 2 + 10, height + 30);
            }
        }
        else{
            if (winner == 1){
                graphics.drawString("Red Won", width / 2 + 10, height + 30);
            }
            if (winner == 2) {
                graphics.drawString("Yellow Won", width / 2 + 10, height + 30);
            }
        }





    }


}
