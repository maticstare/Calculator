import java.awt.event.KeyEvent;

public class KeyListener implements java.awt.event.KeyListener {
    @Override
    public void keyTyped(KeyEvent evt) {
        char c = evt.getKeyChar();

        if(!(Character.isDigit(c) || c == '(' || c == ')' || c == '%' || c == '/' || c == '*' || c == '-' || c == '+' || c == '.')){
            evt.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            if(!GUI.field.getText().isEmpty()){
                GUI.label.setText(GUI.field.getText());
                Poslusalec.Splitter();
                Poslusalec.Evaluate();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }



}


