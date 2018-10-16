package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.domain.Apple;
import wormgame.domain.Worm;
import wormgame.gui.Updatable;
import java.util.Random;

public class WormGame extends Timer implements ActionListener {

    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;
    private Worm worm;
    private Apple apple;

    public WormGame(int width, int height) {
        super(1000, null);

        this.width = width;
        this.height = height;
        continues = true;
        worm = new Worm(width / 2, height / 2, Direction.DOWN);
        apple = generateApple();
        while (worm.runsInto(apple)) {
            apple = generateApple();
        }

        addActionListener(this);
        setInitialDelay(2000);
    }

    public Worm getWorm() {
        return worm;
    }

    public void setWorm(Worm worm) {
        this.worm = worm;
    }

    public Apple getApple() {
        return apple;
    }

    public void setApple(Apple apple) {
        this.apple = apple;
    }

    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    private Apple generateApple() {
        return new Apple(new Random().nextInt(width), new Random().nextInt(height));
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!continues) {
            return;
        }

        worm.move();
        if (worm.runsInto(apple)) {
            worm.grow();
            apple = generateApple();
        }
        if (worm.runsIntoItself()) {
            continues = false;
        }
        else if (worm.wormHead().getX() == this.width || worm.wormHead().getX() < 0) {
            continues = false;
        } else if (worm.wormHead().getY() == this.height || worm.wormHead().getY() < 0) {
            continues = false;
        }

        updatable.update();

        setDelay(1000 / worm.getLength());

    }

}
