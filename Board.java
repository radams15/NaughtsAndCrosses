class Board{
    private Player[][] board = new Player[3][3];

    public Board(){
        for(int x=0 ; x<3 ; x++){
            for(int y=0 ; y<3 ; y++){
                board[x][y] = Player.NONE;
            }
        }
    }
    
    public String formatPlayer(Player player){
        if(player == Player.NONE){
            return "NONE";
        }else if(player == Player.O){
            return "O";
        }else if(player == Player.X){
            return "X";
        }
        
        return "FAIL";
    }
    
    public void printBoard(){
        for(int x=0 ; x<3 ; x++){
            for(int y=0 ; y<3 ; y++){
                System.out.printf("|%s", board[x][y]);
            }
            System.out.println("|");
        }
    }
    
    public Player getSquare(int x, int y){
        if(x < 3 && y < 3 && y >= 0 && x >= 0){
            return board[x][y];
        }
        return null;
    }
    
    public void setSquare(int x, int y, Player player){
        if(x < 3 && y < 3 && y >= 0 && x >= 0){
            board[x][y] = player;
        }
    }
    
    public boolean isOccupied(int x, int y){
        if(getSquare(x, y) == Player.NONE){
            return false;
        }
        return true;
    }
    
    public Player getWinner(){
        for(int x=0 ; x<3 ; x++){
            if(getSquare(x, 0) == getSquare(x, 1) && getSquare(x, 1) == getSquare(x, 2)){
                return getSquare(x, 0);
            }
        }
        
        for(int y=0 ; y<3 ; y++){
            if(getSquare(1, y) == getSquare(1, y) && getSquare(1, y) == getSquare(2, y)){
                return getSquare(0, y);
            }
        }
        
        if(getSquare(0,0) == getSquare(1,1) && getSquare(1,1) == getSquare(2, 2)){
            return getSquare(0, 0);
        }
        
        if(getSquare(0,2) == getSquare(1,1) && getSquare(1,1) == getSquare(2, 0)){
            return getSquare(0, 2);
        }
        
        return Player.NONE;
    }
    
    public boolean isWon(){
        if(getWinner() != Player.NONE){
            return true;
        }
        return false;
    }
}
