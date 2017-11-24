import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {


    public void mouseClicked(MouseEvent e) {

    }


    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

//        Rectangle playButton = new Rectangle(350,150,100,50);
//        Rectangle quitButton = new Rectangle(350,250,100,50);

        if (GamePanel.state == GamePanel.STATE.STARTMENU){
            if(mx >= 350 && mx <= 450){
                if(my >= 150 && my <= 200){
                    GamePanel.state = GamePanel.STATE.PLAY;
                }else if(my >= 250 && my <= 300){
                    System.exit(1);
                }
            }
        }

        if (GamePanel.state == GamePanel.STATE.GAMEOVER){
            if(mx >= 350 && mx <= 450){
                if(my >= 250 && my <= 300){
                    System.exit(1);
                }else if(my >= 350 && my <= 400){
                    GamePanel.state = GamePanel.STATE.NEWGAME;
                }
            }
        }



    }


    public void mouseReleased(MouseEvent e) {

    }


    public void mouseEntered(MouseEvent e) {

    }


    public void mouseExited(MouseEvent e) {

    }
}
