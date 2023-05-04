package SimpleBall;

import javax.swing.*;

public class Frame{
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new Panel());
        frame.setResizable(false);
        frame.setVisible(true);
    }
}

class Panel extends JPanel{

    public Panel(){
    }
}
