import javax.swing.*;

public class BrickBreakingMain {

    public static final int WIDTH = 800;
    public static  final int HEIGHT = 600;
    public static void main(String[] args) {

        JFrame frame = new JFrame("Brick Breaking"); //Create the frame.
        GamePanel game = new GamePanel();


        frame.setSize(WIDTH,HEIGHT);
        frame.setLocationRelativeTo(null); //set location to the middle
        frame.setResizable(false); //can't extend the frame
        frame.add(game);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //The EXIT_ON_CLOSE operation exits the program when user closes the frame.
        frame.setVisible(true); //Show it.

        game.playGame();
    }

}
