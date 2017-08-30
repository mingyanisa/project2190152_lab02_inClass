package com.lab02.inClass;

import java.applet.Applet;
import java.awt.*;

public class StarWars extends Applet {
    Title thread1;
    Ship thread2;

    public void init() {
        thread1 = new Title(this);
        thread2 = new Ship(this);

        thread1.start();
        thread2.start();

    }

    public void paint(Graphics g) {
        thread1.paint(g);
        thread2.paint(g);
    }
}

class Title extends Thread {
    StarWars a;
    String text1 = "Long time ago,";
    String text2 = "in the galaxy far far away";

    int x, y;
    int z = 40;

    Title(StarWars a) {
        this.a = a;
        this.x = a.getWidth();
        this.y = a.getHeight() - 20;
    }

    public void run() {
        while (y > 0) {
            y -= 10;
            --z;
            if (z < 0) {
                z = 0;
            }
            a.repaint();
            try {
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public void paint(Graphics g) {

        g.setFont(new Font("Cordia New", Font.PLAIN, z));
        g.drawString(text1, (x - g.getFontMetrics().stringWidth(text1)) / 2, y - 50);
        g.drawString(text2, (x - g.getFontMetrics().stringWidth(text2)) / 2, y);
    }

}

class Ship extends Thread {
    StarWars b;
    int x, y;

    Ship(StarWars b) {
        this.b = b;
        this.x = b.getWidth();
        this.y = b.getHeight();
    }


    void paint(Graphics g) {
        System.out.println("in paint");
        g.setColor(Color.BLACK);
        Bullet bullet = new Bullet();

        g.fillPolygon(bullet.shape);

    }


}

class Bullet {
    Polygon shape;

    Bullet() {
        shape = new Polygon(new int[]{50, 100, 200}, new int[]{200, 0, 100}, 3);
    }
}

class BigShip {
    int[] x;
    int[] y;

    public BigShip(int[] x, int[] y) {
        x = new int[]{50, 100, 200};
        y = new int[]{200, 0, 100};
    }
}

class LittleShip {
    int[] x;
    int[] y;

    public LittleShip(int[] x, int[] y) {
        x = new int[]{10, 20, 40};
        y = new int[]{40, 0, 20};
    }
}

