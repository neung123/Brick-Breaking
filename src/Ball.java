import java.awt.*;
/*
This Ball class is responsible for creating the ball that is displayed on the frame.
Including methods that give interactions to the GamePanel class and more.

@author Thanapoom Rattanathumawat
@author Pornpavee Seri-umnuoy
 */

public class Ball {

    private double x,y,dx,dy;
    private int ballSize = 30;

    public Ball(){
        x = 400;
        y = 470;
        dx = 1;
        dy = 1;
    }

    public void update(){
        setPosition();
    }

    private void setPosition() {
        x += dx;
        y += dy;

        if(x<0){
            dx = -dx;
        }
        if(y<0){
            dy = -dy;
        }
        if(x > BrickBreakingMain.WIDTH - ballSize){
            dx = -dx;
        }
        if( y > BrickBreakingMain.HEIGHT - 2*ballSize){
            dy = -dy;
        }
    }

    public void drawBall(Graphics2D graphics){
        graphics.setColor(Color.ORANGE);
        graphics.fillOval((int)x,(int)y,ballSize,ballSize);
    }
    public Rectangle getRect(){
        return new Rectangle((int)x,(int)y,ballSize,ballSize);
    }

    public void setDY(double theDY){dy = theDY;}

    public double getDY(){return dy;}

    public double getDX() { return dx; }

    public void setDX(double dx) { this.dx = dx; }

    public boolean gameOverBall(){
        boolean gameover = false;

        if(y > BrickBreakingMain.HEIGHT - ballSize * 2){
            gameover = true;
        }

        return gameover;
    }
}
