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
        System.out.println(size + "|" + x + "|"+ y);
        this.size = size;
        this.x = x;
        this.y = y;
        speedx = 0;
        speedy = 0;
        color = new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256) );
    }

    public void move(){
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

    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval(x-size/2,y-size/2,size,size);
    }

    public void collide(Ball[] balls){
        for (Ball b: balls){
            if (b.equals(this)) continue;
            if (b.x < this.x && (b.y  > this.y - this.size/2 - b.size/2) && (b.y < this.y + this.size/2 + b.size/2)){
                if (b.x + b.size/2 >= this.x - this.size/2) {
                    int tempx = b.speedx;
                    b.speedx = this.speedx;
                    this.speedx = tempx;
                    //let v2 be b and v1 be this
                  //  b.speedx =( 2*this.size*this.speedx/(b.size + this.size)) - b.speedx*((this.size- b.size)/(this.size+b.size));
                  //  this.speedx = ((this.size- b.size)*this.speedx)/(this.size+b.size) + ( 2*b.size*tempx/(b.size + this.size));
                }
            }
            if (b.y < this.y && (b.x  > this.x - this.size/2 - b.size/2) && (b.x < this.x + this.size/2 + b.size/2)){
                if (b.y + b.size/2 >= this.y - this.size/2 ) {
                    int tempy = b.speedy;
                    b.speedy= this.speedy;
                    this.speedy = tempy;
                   // b.speedy =( 2*this.size*this.speedy/(b.size + this.size)) - ((this.size- b.size)*b.speedy)/(this.size+b.size);
                   // this.speedy = this.speedy*((this.size- b.size)/(this.size+b.size)) + ( 2*b.size*tempy/(b.size + this.size));

                }
            }
        }
    }
}
