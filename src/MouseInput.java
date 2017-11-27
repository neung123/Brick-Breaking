import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/*
This MouseInput class was made to interact with the position of the blocks
made on the starter screen and the ending screen.

@author Thanapoom Rattanathumawat
@author Pornpavee Seri-umnuoy
 */

public class MouseInput implements MouseListener {


    public void mouseClicked(MouseEvent e) {

    }


    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

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
                if(my >= 400 && my <= 450){
                    GamePanel.state = GamePanel.STATE.NEWGAME;
                }else if(my >= 470 && my <= 520){
                    System.exit(1);
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
