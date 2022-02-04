import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class GUI extends JFrame {

    static String[][] buttonText = {
            {"√x", "x^2", "c", "⌫"},
            {"(", ")", "%", "/"},
            {"7", "8", "9", "*"},
            {"4", "5", "6", "-"},
            {"1", "2", "3", "+"},
            {"±", "0", ".", "="},
    };



    static JButton button[][] = new JButton[buttonText.length][buttonText[0].length];
    static JTextField field = new JTextField();
    static JLabel label = new JLabel();


    GUI(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(550,550);


        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 50);

        label.setFont(font.deriveFont(Font.PLAIN));
        field.setFont(font.deriveFont(Font.PLAIN));
        field.addKeyListener(new KeyListener());

        JPanel panel = new JPanel(new GridLayout(2,1));
        panel.add(label);
        panel.add(field);


        JPanel buttonPanel = new JPanel(new GridLayout(buttonText.length, buttonText[0].length));

        for (int i = 0; i < buttonText.length; i++) {
            for (int j = 0; j < buttonText[i].length; j++) {
                button[i][j] = new JButton(String.valueOf(buttonText[i][j]));
                button[i][j].addActionListener(new Poslusalec());
                button[i][j].addKeyListener(new KeyListener());
                button[i][j].setFont(font);
                buttonPanel.add(button[i][j]);
            }
        }

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(panel, BorderLayout.PAGE_START);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        this.getContentPane().add(mainPanel);
        this.setLocationRelativeTo(null);
        this.add(mainPanel);
        this.setVisible(true);
    }


    public static void main(String[] args) {
        new GUI();
    }
}
