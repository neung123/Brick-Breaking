import java.awt.*;

public class Ball {

    private double x,y,dx,dy;
    private int ballSize = 30;

    public Ball(){
        x = 200;
        y = 200;
        dx = 3;
        dy = 3;
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
}
