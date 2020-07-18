package com.example.gamedoz.model;

public class TicTacToe {
    private Players[][] gameChart;
    private Players x= Players.X;
    private Players o= Players.O;
    private Players start;
    public TicTacToe(){
        gameChart =new Players[3][3];
        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j <3 ; j++) {
                gameChart[i][j]= Players.E;
            }
        }
    }

    public Players[][] getGameChart(){
        return gameChart;
    }

    public void setGameChart(int a,int b) {
        Players aa =this.switchTurn();
        this.gameChart[a][b] =this.switchTurn() ;
    }


    public Players switchTurn(){
        if (start==null){
            start=x;
            return start;
        } else if (start== Players.X){
            start=o;
            return o;
        }
        else if (start==Players.O){
            start=x;
            return x;
        }

        else return x;
    }

    public Conditions isFinished(){

        for (int i = 0; i <3 ; i++) {
            if (gameChart[i][0]!=Players.E && gameChart[i][0]== gameChart[i][1] && gameChart[i][1] == gameChart[i][2] ){
                if (gameChart[i][0]==x) return Conditions.X_WINS;
                if (gameChart[i][0]==o) return Conditions.O_WINS;
            }
            if (gameChart[i][0]!=Players.E && gameChart[0][i]== gameChart[1][i] && gameChart[1][i] == gameChart[2][i] ){
                if (gameChart[i][0]==x) return Conditions.X_WINS;
                if (gameChart[i][0]==o) return Conditions.O_WINS;
            }

        }

        for (int i = 0; i <3 ; i++) {
            if ( gameChart[i][0]==Players.E || gameChart[i][1]==Players.E ||  gameChart[i][2]==Players.E ){
                return Conditions.NOT_FINISHED;
            }
            if (gameChart[0][i]==Players.E || gameChart[1][i]==Players.E ||  gameChart[2][i]==Players.E ){
                return Conditions.NOT_FINISHED;
            }
        }
        return Conditions.DRAW;
    }
}