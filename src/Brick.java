import java.awt.*;

public class Brick {

    private int x,y;
    private int def = 4;
    public final static int width = BrickBreakingMain.WIDTH / 10;
    public final static int height = (BrickBreakingMain.HEIGHT) / 15;

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

        graphics.setFont(new Font("Courier New", Font.BOLD,15));
        graphics.drawString(String.format("%d",def), x + width/2 - 4, y + height /2 + 4);

    }

    public void drop(){ y += height; }

    public int getY(){ return y; }

    public Rectangle getRect(){
        return new Rectangle(x,y,width,height);
    }

    public void removeDef(){ def -= 1; }

    public int getDef() { return def;}


}
