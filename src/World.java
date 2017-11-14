import java.awt.*;
import java.util.ArrayList;

/**
 * default of the bricks are 4 rows and 6 columns
 */
public class World {

    public int row = 4,column = 6;
    private ArrayList<Brick> bricks = new ArrayList<>();

    public World(){
        initBrick();
    }

    public void drawWorld(Graphics2D graphics) {

        for (Brick b:bricks){
            b.drawBrick(graphics);
        }

    }

    private void initBrick() {

        for (int j = 0; j < row; j++) {
            for (int i = 0; i < column; i++) {
                bricks.add(new Brick(i*Brick.width, j*Brick.height));
            }
        }
    }

    private void addBrick(Brick brick) {
        bricks.add(brick);
    }
}
