import javax.swing.*;
import java.awt.*;

public class Paddle extends JPanel{

    // Fields
    public double x;
    public int width, height;

    public final int positionY = BrickBreakingMain.HEIGHT - 100;

    // Constructor
    public Paddle(){
        width = 150;
        height = 20;
    }

    // drawPaddle
    public void drawPaddle(Graphics2D graphics, int x){
        graphics.setColor(Color.WHITE);
        graphics.fillRect(x, positionY, width, height);
        this.x = x;
    }
    public Rectangle getRect(){
        return new Rectangle((int)x, positionY,width,height);
    }



}
