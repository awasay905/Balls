package SimpleBall;

import java.awt.event.*;

import javax.swing.*;

class DrawingFrame extends JFrame implements ActionListener{

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Ball");
        frame.setDefaultCloseOperation(3);

        DrawingPanel panel = new DrawingPanel();
        frame.add(panel);

        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}

