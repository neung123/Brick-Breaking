import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class GamePanel extends JPanel {

    private boolean running;
    private BufferedImage image;
    private Graphics2D graphics;

    Ball ball;

    public GamePanel(){
        init();
    }


    public void init(){
        ball = new Ball();
        running = true;

        image = new BufferedImage(BrickBreakingMain.WIDTH,BrickBreakingMain.HEIGHT,BufferedImage.TYPE_INT_RGB);
        graphics = (Graphics2D) image.getGraphics();

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

    }



    public void playGame() {
    //game loop

        while (running){

            update();

            draw();

            repaint();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

    public void update(){
        ball.update();
    }

    public  void draw(){
        //drae bg
        graphics.setColor(Color.DARK_GRAY);
        graphics.fillRect(0,0,BrickBreakingMain.WIDTH,BrickBreakingMain.HEIGHT);

        ball.draw(graphics);
    }

    public  void paintComponent(Graphics graphics){

        Graphics2D graphics2 = (Graphics2D) graphics; //update graphics to graphics2

        graphics2.drawImage(image,0,0,BrickBreakingMain.WIDTH,BrickBreakingMain.HEIGHT,null);
        graphics2.dispose();
    }

}

