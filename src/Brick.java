import java.awt.*;
import java.util.Random;


public class Brick {

    private int x,y;
    public final static int width = BrickBreakingMain.WIDTH / 10;
    public final static int height = (BrickBreakingMain.HEIGHT) / 15;
    private boolean canRemove = true;
    private Random rand = new Random();
    private int def = rand.nextInt(4) + 1;

    public Brick(int x,int y){
        this.x = x;
        this.y = y;
    }

    public void drawBrick(Graphics2D graphics){

        if(def == 4){
            graphics.setColor(new Color(51, 51, 102));
        } else if(def == 3){
            graphics.setColor(new Color(70, 85, 150));
        }else if(def == 2){
            graphics.setColor(new Color(90, 125, 190));
        }else if(def == 1){
            graphics.setColor(new Color(113, 150, 223));
        }
        graphics.fillRect(x, y, width, height);

        graphics.setStroke(new BasicStroke(5));
        graphics.setColor(new Color(0,0,0));
        graphics.drawRect(x, y, width, height);

    }

    public void drop(){ y += 10; }

    public int getY(){ return y; }

    public Rectangle getTopRect(){
        return new Rectangle(x,y,width,1);
    }

    public Rectangle getBottomRect(){
        return new Rectangle(x,y+height,width,1);
    }

    public Rectangle getLeftRect(){
        return new Rectangle(x,y,1,height);
    }

    public Rectangle getRightRect(){ return new Rectangle(x+height,y,1,height); }

    public Rectangle getRect(){
        return new Rectangle(x,y,width,height);
    }

    public void removeDef(){
        if(canRemove) def -= 1;
    }

    public void setCanRemove(boolean canRemove) {
        this.canRemove = canRemove;
    }

    public int getDef() { return def;}


}
