import java.awt.*;

/**
 * default of the bricks are 4 rows and 6 columns
 */
public class World {

    public int row = 4,column = 6;
    private int x,y;
    private Brick[][] bricks = new Brick[row][column];

    public World(){
        x = 0 ;
        y = 0;

        addBrick(x,y);
    }

    public void drawWorld(Graphics2D graphics) {

        for (int i = 0; i < bricks.length; i++) {
            for (int k = 0; k < bricks[0].length; k++) {
                bricks[i][k].drawBrick(graphics);
            }
        }

    }

    private void addBrick(int x, int y) {
        for (int i = 0; i < bricks.length; i++) {
            for (int k = 0; k < bricks[0].length; k++) {
                bricks[i][k] = new Brick(x, y);
                x += bricks[0][0].width;
            }
            x = 0;
            y += bricks[0][0].height;
        }

    }
}
