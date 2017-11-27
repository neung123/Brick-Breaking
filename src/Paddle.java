import javax.swing.*;
import java.awt.*;
/*
This Paddle class is responsible of creating the Paddle, which interacts mostly with
the class Ball.

@author Thanapoom Rattanathumawat
@author Pornpavee Seri-umnuoy
 */

public class
Paddle extends JPanel{


    public double x;
    public int width, height;

    public final int positionY = BrickBreakingMain.HEIGHT - 100;

    public Paddle(){
        width = 150;
        height = 15;
    }

    public void drawPaddle(Graphics2D graphics, int x){
        graphics.setColor(Color.WHITE);
        graphics.fillRect(x, positionY, width, height);
        this.x = x;
    }
    public Rectangle getRect(){
        return new Rectangle((int)x, positionY,width,1);
    }



}
