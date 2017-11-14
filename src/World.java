import java.awt.*;
import java.util.ArrayList;

/**
 * default of the bricks are 5 rows and 10 columns
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

}
