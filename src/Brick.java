import java.awt.*;

public class Brick {

    private int x,y;
    public final static int width = BrickBreakingMain.WIDTH / 6;
    public final static int height = (BrickBreakingMain.HEIGHT / 2 ) / 4;

    public Brick(int x,int y){
        this.x = x;
        this.y = y;
    }

    public void drawBrick(Graphics2D graphics){
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.fillRect(x, y, width, height);

        graphics.setStroke(new BasicStroke(5));
        graphics.setColor(Color.DARK_GRAY);
        graphics.drawRect(x, y, width, height);

    }

    public void drop(){ y -= height; }

    public Rectangle getRect(){
        return new Rectangle(x,y,width,height);
    }

}
