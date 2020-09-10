class Board{
    public static final int length = 3;
    public static final int width = 3;

    private final Player[][] board = new Player[length][width];

    public Board(){
        for(int x = 0; x< length; x++){
            for(int y = 0; y< width; y++){
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
        for(int x = 0; x< length; x++){
            for(int y = 0; y< width; y++){
                System.out.printf("|%s", formatPlayer(getSquare(x, y)));
            }
            System.out.println("|");
        }
    }
    
    public Player getSquare(int x, int y){
        if(x < width && y < length && y >= 0 && x >= 0){
            return board[x][y];
        }
        return null;
    }
    
    public void setSquare(int x, int y, Player player){
        if(x < width && y < length && y >= 0 && x >= 0){
            board[x][y] = player;
        }
    }
    
    public boolean isOccupied(int x, int y){
        return getSquare(x, y) != Player.NONE;
    }
    
    public Player getWinner(){
        for(int x = 0; x< length; x++){
            if(getSquare(x, 0) == getSquare(x, 1) && getSquare(x, 1) == getSquare(x, 2)){
                return getSquare(x, 0);
            }
        }
        
        for(int y = 0; y< width; y++){
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
