import java.awt.*;
import java.util.ArrayList;

/*
This World class is reponsible of implementing the actual rows
and column of the Brick class.

@author Thanapoom Rattanathumawat
@author Pornpavee Seri-umnuoy
 */

public class World {

    public int row = 5,column = 10;
    public ArrayList<Brick> bricks = new ArrayList<>();

    public World(){
        initBrick();
    }

    public void drawWorld(Graphics2D graphics) {

        for (Brick b:bricks){
            b.drawBrick(graphics);
        }

    }

    public void initBrick() {

        for (int j = 0; j < row; j++) {
            for (int i = 0; i < column; i++) {
                bricks.add(new Brick(i*Brick.width, j*Brick.height));
            }
        }
    }

    public void addBrick(Brick brick) {
        bricks.add(brick);
    }

    public int getMinimumHeight(){
        int minH = BrickBreakingMain.HEIGHT;

        for(int i = 0; i < bricks.size(); i++) {
            minH = Math.min(minH, bricks.get(i).getY());
        }

        return minH;
    }

    public boolean checkGameOverBrick(){
        for(int i = 0; i < bricks.size(); i++) {
            if (bricks.get(i).getY() > BrickBreakingMain.HEIGHT - Brick.height * 2) {
                return true;
            }
        }
        return false;
    }


}
