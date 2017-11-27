import javax.swing.*;
/*
This main class the used to create the whole visual content of this program. Mainly the frame
and how it uses all the methods from the GamePanel class.

@author Thanapoom Rattanathumawat
@author Pornpavee Seri-umnuoy
 */

public class BrickBreakingMain {

    public static final int WIDTH = 800;
    public static  final int HEIGHT = 600;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Brick Breaking"); //Create the frame.
        GamePanel game = new GamePanel();

        frame.add(new JLabel(new ImageIcon("C:/Users/Poom/Desktop/Brick.jpg")));
        frame.pack();
        frame.setSize(WIDTH,HEIGHT);
        frame.setLocationRelativeTo(null); //set location to the middle
        frame.setResizable(false); //can't extend the frame
        frame.add(game);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //The EXIT_ON_CLOSE operation exits the program when user closes the frame.
        frame.setVisible(true); //Show it.

        game.playGame();
    }

}
