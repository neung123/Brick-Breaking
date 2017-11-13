import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.security.Key;


public class GamePanel extends JPanel implements ActionListener, KeyListener{

    private boolean running;
    private BufferedImage image;
    private Graphics2D graphics;
    Timer timer = new Timer(5 , this);
    double x = 0,dx = 0;
    Ball ball;
    Paddle paddle;

    public GamePanel(){
        timer.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        ball = new Ball();
        paddle = new Paddle();
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

        ball.drawBall(graphics);
        paddle.drawPaddle(graphics,(int)x);
    }

    public  void paintComponent(Graphics graphics){

        Graphics2D graphics2 = (Graphics2D) graphics; //update graphics to graphics2

        graphics2.drawImage(image,0,0,BrickBreakingMain.WIDTH,BrickBreakingMain.HEIGHT,null);
        graphics2.dispose();
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
        x += dx;
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_LEFT){
            left();
        }
        if(key == KeyEvent.VK_RIGHT){
            right();
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_LEFT){
            leftStop();
        }
        if(key == KeyEvent.VK_RIGHT){
            rightStop();
        }
    }
    public void leftStop(){dx = 0;}
    public void rightStop(){dx = 0;}
    public void left(){dx = -5;}
    public void right(){dx = 5;}
}

