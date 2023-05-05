package SimpleBall;

import java.awt.*;

public class Ball {
    private int size;
    private int x;
    private int y;
    private int speedx;
    private int speedy;
    private Color color;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Ball(int size, int x, int y) {
        this.size = size;
        this.x = x;
        this.y = y;
        speedx = 0;
        speedy = 0;
        color = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
    }

    public void move() {
        x += speedx;
        y += speedy;
    }

    public int getSpeedx() {
        return speedx;
    }

    public void setSpeedx(int speedx) {
        this.speedx = speedx;
    }

    public int getSpeedy() {
        return speedy;
    }

    public void setSpeedy(int speedy) {
        this.speedy = speedy;
    }


    public int getSize() {
        return size;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x - size / 2, y - size / 2, size, size);
    }

    public void collide(Ball[] balls) {
        for (Ball b : balls) {
            if (b.equals(this)) continue;
            double distance = Math.sqrt((b.x+b.speedx-this.speedx-this.x)*(b.x+b.speedx-this.speedx-this.x) + (b.y+b.speedy-this.speedy-this.y)*(b.y+b.speedy-this.speedy-this.y));
            if (distance < (b.size + this.size)/2.0) {
                System.out.println("COLLIDED");
                //m1v1+m2v2 = m1u1+m2u2. v is initial u is final
                double tbx = b.speedx*1.0;
                double tby = b.speedy*1.0;
                double ttx = speedx*1.0;
                double tty = speedy*1.0;

                double m1 = b.size*1.0;
                double m2 = size*1.0;

                //1 is b, 2 is this
                b.speedx = (int)(((m1- m2)/(m1+m2))*tbx + ((m2+m2)/(m1+m2))*ttx);
                b.speedy = (int)(((m1- m2)/(m1+m2))*tby + ((m2+m2)/(m1+m2))*tty);

                speedx =(int)(( (m1+m1)/(m1+m2))*tbx + ((m1- m2)/(m1+m2))*ttx);
                speedy =(int)(( (m1+m1)/(m1+m2))*tby + ((m1- m2)/(m1+m2))*tty);

//
//                int tempx = b.speedx;
//                b.speedx = this.speedx;
//                this.speedx = tempx;
//
//                int tempy = b.speedy;
//                b.speedy = this.speedy;
//                this.speedy = tempy;
            }

        }
    }

    public int getVelocity(){
        return (int)(Math.sqrt((speedx*speedx) + (speedy*speedy)));
    }
}
