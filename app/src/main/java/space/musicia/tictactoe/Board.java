package space.musicia.tictactoe;

/**
 * Created by shubham on 4/6/17.
 */

public class Board {
    int board[][] = new int[3][3];
    int moves;

   void init(){
       for(int i=0;i<3;i++){
           for(int j=0;j<3;j++){
               board[i][j]=-1;
           }
       }
       moves=8;
   }
    boolean canplay(){
        return moves>0;
    }
    boolean setText(int x,int y,int player){
        board[x][y]=player;
        boolean check = this.check(player);
        moves--;
        if(check){
            this.endGame(player);

            return check;
        }else{
            return false;
        }
    }

    void endGame(int player){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j]=player;
            }
        }
    }
    boolean check(int player){
        for(int i=0;i<3;i++){
            int cnt=0;
            for(int j=0;j<3;j++){
                if(board[i][j]==player){
                    cnt++;
                }
            }
            if(cnt==3){
                return true;
            }
        }
        for(int i=0;i<3;i++){
            int cnt=0;
            for(int j=0;j<3;j++){
                if(board[j][i]==player){
                    cnt++;
                }
            }
            if(cnt==3){
                return true;
            }
        }
        int cnt=0;
        for(int i=0;i<3;i++){
            if(board[i][i]==player){
                cnt++;
            }
        }
        if(cnt==3){return true;}
        cnt=0;
        for(int i=0;i<3;i++){
            if(board[i][2-i]==player){
                cnt++;
            }
        }
        if(cnt==3){
            return true;
        }
        return false;
    }

}
