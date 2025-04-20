import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInputs implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        int mouseCode = e.getButton();
        System.out.println(mouseCode);
        if(mouseCode == 1){
            //left click
        }
        if(mouseCode == 3){
            //right click
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
