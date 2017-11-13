import javax.swing.*;
import java.awt.*;

public class Paddle extends JPanel{
    // Fields
    private double x;
    private int width, height;

    public final int  positiony = BrickBreakingMain.HEIGHT - 100;

    // Constructor
    public Paddle(){
        width = 150;
        height = 20;
        x = BrickBreakingMain.WIDTH / 2 - width / 2;
    }

    // drawPaddle
    public void drawPaddle(Graphics2D graphics, int x){
        graphics.setColor(Color.WHITE);
        graphics.fillRect((int) x, positiony, width, height);
    }




}
