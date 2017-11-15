import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.security.Key;


public class GamePanel extends JPanel implements ActionListener, KeyListener{

    private boolean running;
    private BufferedImage image;
    private Graphics2D graphics;
    double x ,dx = 0;
    public int score = 0;
    Timer timer = new Timer(5 , this);
    Ball ball;
    Paddle paddle;
    World world;

    public GamePanel(){
        timer.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        ball = new Ball();
        paddle = new Paddle();
        x = BrickBreakingMain.WIDTH / 2 - paddle.width / 2;
        world = new World();
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

    public void checkCollisions(){
        Rectangle ballRect = ball.getRect();
        Rectangle paddleRect = paddle.getRect();

        if(ballRect.intersects(paddleRect)){

            if(ball.getDY() > 0) {

                ball.setDY(-ball.getDY());

                for (Brick b : world.bricks) b.drop();

                for (int i = 0; i < world.column; i++) {
                    world.addBrick(new Brick(i * Brick.width, 0));
                }
            }

        }
        for(int i = 0; i < world.bricks.size(); i++) {
            if (ballRect.intersects(world.bricks.get(i).getRect())) {
                world.bricks.get(i).removeDef();


                if(world.bricks.get(i).getDef() == 0){
                    world.bricks.remove(world.bricks.get(i));
                    score ++;
                    System.out.println(score);
                }else  ball.setDY(-ball.getDY());
            }
        }
    }

    public void update(){
        checkCollisions();
        ball.update();
    }

    public  void draw(){

        //draw background
        graphics.setColor(Color.DARK_GRAY);
        graphics.fillRect(0,0,BrickBreakingMain.WIDTH,BrickBreakingMain.HEIGHT);

        ball.drawBall(graphics);
        paddle.drawPaddle(graphics,(int)x);
        world.drawWorld(graphics);

        if(ball.gameOverBall()){
            drawGM();
            running = false;
        }
        if(checkGameOverBrick() == true){
            drawGM();
            running = false;
        }

    }
    public boolean checkGameOverBrick(){
        for(int i = 0; i < world.bricks.size(); i++) {
            if (world.bricks.get(i).getY() > BrickBreakingMain.HEIGHT - Brick.height) {
                return true;
            }
        }
        return false;
    }

    public void drawGM(){
        graphics.setColor(Color.RED);
        graphics.setFont(new Font("Courier New", Font.BOLD,50));
        graphics.drawString("Game Over", 265, 250);
    }

    public  void paintComponent(Graphics graphics){

        Graphics2D graphics2 = (Graphics2D) graphics; //update graphics to graphics2

        graphics2.drawImage(image,0,0,BrickBreakingMain.WIDTH,BrickBreakingMain.HEIGHT,null);
        graphics2.dispose();
    }

    public void actionPerformed(ActionEvent e) {
        x = Math.abs(Math.min(x + dx,BrickBreakingMain.WIDTH - paddle.width));
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_LEFT ){
            left();
        }
        if(key == KeyEvent.VK_RIGHT ){
            right();
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_LEFT ){
            leftStop();
        }
        if(key == KeyEvent.VK_RIGHT ){
            rightStop();
        }
    }
    public void leftStop(){dx = 0;}
    public void rightStop(){dx = 0;}
    public void left(){ dx = -5; }
    public void right(){ dx = 5; }
}

