import java.util.Scanner;
import java.lang.Integer;

class Main{
    
    public Main(){
    
        Scanner scanner = new Scanner(System.in);
        
        Board board = new Board();
        
        Player player = Player.X;
        
        while(!board.isWon()){
            board.printBoard();
            
            System.out.printf("Player %s => ", board.formatPlayer(player));
            String data = scanner.nextLine();
            
            if(data.length() == 0){
                continue;
            }
            
            String[] split = data.split(",");
            
            if(split.length != 2){
                continue;
            }
            
            int[] points = new int[2];

            for(int i=0 ; i<split.length ; i++){
                points[i] = Integer.parseInt(split[i]); // try to parse each of the split variable into 2 int points
            }
            
            if(board.isOccupied(points[0], points[1])){
                System.out.printf("Sorry, point [%d, %d] is occupied!%n", points[0], points[1]);
                continue;
            }
            
            board.setSquare(points[0], points[1], player);
            
            if(player == Player.X){
                player = Player.O;
            }else{
                player = Player.X;
            }
        }
        
        board.printBoard();

        System.out.printf("Winner Is: %s%n", board.formatPlayer(board.getWinner()));
        
    }

    public static void main(String[] args){
        new Main();
    }
}
