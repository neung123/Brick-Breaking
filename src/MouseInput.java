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

        if(mx >= 350 && mx <= 450){
            if(my >= 150 && my <= 200){
                GamePanel.state = GamePanel.STATE.PLAY;
            }
        }
        if(mx >= 350 && mx <= 450){
            if(my >= 250 && my <= 300){
                System.exit(1);
            }
        }
        if(mx >= 350 && mx <= 450){
            if(my >= 350 && my <= 400){
                GamePanel.state = GamePanel.STATE.START;
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
