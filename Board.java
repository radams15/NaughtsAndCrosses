class Board{
    private final int l = 3;
    private final int w = 3;

    private final Player[][] board = new Player[l][w];

    public Board(){
        for(int x=0 ; x<l ; x++){
            for(int y=0 ; y<w ; y++){
                board[x][y] = Player.NONE;
            }
        }
    }
    
    public String formatPlayer(Player player){
        if(player == Player.NONE){
            return "_";
        }else if(player == Player.O){
            return "O";
        }else if(player == Player.X){
            return "X";
        }
        
        return "FAIL";
    }
    
    public void printBoard(){
        for(int x=0 ; x<l ; x++){
            for(int y=0 ; y<w ; y++){
                System.out.printf("|%s", formatPlayer(getSquare(x, y)));
            }
            System.out.println("|");
        }
    }
    
    public Player getSquare(int x, int y){
        if(x < w && y < l && y >= 0 && x >= 0){
            return board[x][y];
        }
        return null;
    }
    
    public void setSquare(int x, int y, Player player){
        if(x < w && y < l && y >= 0 && x >= 0){
            board[x][y] = player;
        }
    }
    
    public boolean isOccupied(int x, int y){
        return getSquare(x, y) != Player.NONE;
    }
    
    public Player getWinner(){
        for(int x=0 ; x<l ; x++){
            if(getSquare(x, 0) == getSquare(x, 1) && getSquare(x, 1) == getSquare(x, 2)){
                return getSquare(x, 0);
            }
        }
        
        for(int y=0 ; y<w ; y++){
            if(getSquare(0, y) == getSquare(1, y) && getSquare(1, y) == getSquare(2, y)){
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
        return getWinner() != Player.NONE;
    }
}
