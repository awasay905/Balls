package SimpleBall;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DrawingPanel extends JPanel {
    private final Ball[] ball;
    private final int borderLength=8;

    public DrawingPanel() {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(500, 500));
        ball = new Ball[10];
        fillBalls();

        setFocusable(true);

        new Timer(25, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Toolkit.getDefaultToolkit().sync();
                moveTheBall();
                repaint();
            }
        }).start();
    }

    public void fillBalls() {

        for (int i = 0; i < ball.length; i++) {

            int size = (int) (Math.random() * 15) + 30;
            int x = (int) (Math.random() * 445) + 15 + size/2;
            int y = (int) (Math.random() * 445) + 15+ size/2;
            int sx = (int) (Math.random() * 5)+10;
            int sy = (int) (Math.random() * 5)+10;

            ball[i] = new Ball(size, x, y);
            ball[i].setSpeedx(sx);
            ball[i].setSpeedy(sy);
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBorder(g);
        for (Ball value : ball) {
            value.draw(g);
        }
        }

    public void drawBorder(Graphics g) {
        int i = 0;
        int m = 0;
        for (Ball b: ball){
            g.drawString("Momentum of ball " + i +" :" +(b.getSize()*b.getVelocity()), 20,20+(i*20));
            m+=b.getSize()*b.getVelocity();
            i++;
        }

        g.drawString("Total Momentum :"+m,  20,(i*20)+20);

        Graphics2D g2 = (Graphics2D) g;
        Stroke old = g2.getStroke();
        g2.setStroke(new BasicStroke(2*borderLength));
        g2.drawRect(0, 0, 500, 500);
        g2.setStroke(old);

    }

    public void moveTheBall() {
        for (Ball ball : ball) {
            ball.move();
            if (ball.getX() + ball.getSize()/2 >= this.getWidth() - borderLength) {
                if (ball.getSpeedx() > 0)ball.setSpeedx(-ball.getSpeedx());
            }
            if (ball.getY() + ball.getSize()/2 >= this.getHeight() - borderLength) {
                if (ball.getSpeedy() > 0)ball.setSpeedy(-ball.getSpeedy());
            }
            if (ball.getX() - ball.getSize()/2 <= borderLength) {
                if (ball.getSpeedx() < 0) ball.setSpeedx(-ball.getSpeedx());
            }
            if (ball.getY()- ball.getSize()/2 <= borderLength) {
                if (ball.getSpeedy() <0 ) ball.setSpeedy(-ball.getSpeedy());
            }
            ball.collide(this.ball);
        }
    }

}