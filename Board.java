class Board{
    public static final int length = 3;
    public static final int width = 3;

    public static final int xVal = 1;
    public static final int oVal = -1;
    public static final int noVal = 0;

    public static final int xWin = 3;
    public static final int oWin = -3;

    private final Player[][] board = new Player[length][width];
    private final int[][] boardValues = new int[length][width];

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

    public int getPlayerValue(Player player){
        if(player == Player.NONE){
            return noVal;
        }else if(player == Player.X){
            return xVal;
        }else if(player == Player.O){
            return oVal;
        }

        return -1;
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

    public int getSquareValue(int x, int y){
        if(x < width && y < length && y >= 0 && x >= 0){
            return boardValues[x][y];
        }
        return -100;
    }
    
    public void setSquare(int x, int y, Player player){
        if(x < width && y < length && y >= 0 && x >= 0){
            board[x][y] = player;
            boardValues[x][y] = getPlayerValue(player);
        }
    }
    
    public boolean isOccupied(int x, int y){
        return getSquare(x, y) != Player.NONE;
    }
    
    public Player getWinner(){
        for(int x = 0; x< length; x++){
            if(getSquareValue(x, 0) + getSquareValue(x, 1) + getSquareValue(x, 2) == xWin
                    || getSquareValue(x, 0) + getSquareValue(x, 1) + getSquareValue(x, 2) == oWin){
                return getSquare(x, 0);
            }
        }
        
        for(int y = 0; y< width; y++){
            if(getSquareValue(0, y) + getSquareValue(1, y) + getSquareValue(2, y) == xWin
                || getSquareValue(0, y) + getSquareValue(1, y) + getSquareValue(2, y) == oWin){
                return getSquare(0, y);
            }
        }
        
        if(getSquareValue(0,0) + getSquareValue(1,1) + getSquareValue(2, 2) == xWin
            || getSquareValue(0,0) + getSquareValue(1,1) + getSquareValue(2, 2) == oWin){
            return getSquare(0, 0);
        }
        
        if(getSquareValue(0,2) + getSquareValue(1,1) + getSquareValue(2, 0) == xWin
            || getSquareValue(0,2) + getSquareValue(1,1) + getSquareValue(2, 0) == oWin){
            return getSquare(0, 2);
        }
        
        return Player.NONE;
    }
    
    public boolean isWon(){
        return getWinner() != Player.NONE;
    }
}
