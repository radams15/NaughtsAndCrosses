import javax.swing.*;
import java.awt.*;

public class Gui {
    private final JFrame frame;
    private final JButton[][] buttons = new JButton[3][3];
    private Board board;
    private JLabel info;
    private boolean isWon = false;

    private Player player;

    public Gui(Board board){

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
        }catch(Exception e){
            e.printStackTrace();
        }

        frame = new JFrame();
        frame.setSize(400, 500);
        BorderLayout layout = new BorderLayout();
        frame.setLayout(layout);

        this.board = board;

        player = Player.X;

        build();
    }

    private void switchPlayer(){
        if(player == Player.X){
            player = Player.O;
        }else{
            player = Player.X;
        }
    }

    private void updateDisplay(){
        if(!isWon) {
            for (int x = 0; x < Board.length; x++) {
                for (int y = 0; y < Board.width; y++) {
                    buttons[x][y].setText(board.formatPlayer(board.getSquare(x, y))); // set the button text to the new value
                    info.setText(String.format("Player: %s", board.formatPlayer(player))); // set the title text to the current player
                }
            }
        }
        if(board.isWon()){
            info.setText(String.format("Winner Is %s", board.formatPlayer(board.getWinner())));
            isWon = true;
        }
    }

    public void build(){
        info = new JLabel();
        frame.add(info, BorderLayout.PAGE_START);

        GridLayout grid = new GridLayout(3, 3);
        JPanel buttonLayout = new JPanel();
        buttonLayout.setLayout(grid);
        for(int x=0 ; x<Board.length ; x++){
            for(int y=0 ; y<Board.width ; y++){
                buttons[x][y] = new JButton(board.formatPlayer(board.getSquare(x, y)));

                int x1 = x; // temp variables to pass to inner class
                int y1 = y;

                buttons[x][y].addActionListener(e -> {
                    if(! board.isOccupied(x1, y1)){ // if square not occupied
                        board.setSquare(x1, y1, player); // change the square value
                        switchPlayer();
                        updateDisplay(); // update the buttons and the info label
                    }
                });

                buttonLayout.add(buttons[x][y]);
            }
        }

        frame.add(buttonLayout, BorderLayout.CENTER);

        updateDisplay();

        frame.setVisible(true);
    }
}
