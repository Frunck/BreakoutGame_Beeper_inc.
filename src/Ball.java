import acm.graphics.*;
import acm.util.*;
import java.awt.*;

public class Ball extends GCompound {

	public Ball(double radius) {
		r = radius;
		GOval ball = new GOval(-r, -r, r * 2, r * 2);
		ball.setFilled(true);
		ball.setColor(new Color(200, 200, 200));

		GOval light = new GOval(-r + 3, -r + 3, r * 2 - 6, r - 2);

		light.setFilled(true);
		light.setColor(new Color(255, 255, 255, 150));
		add(ball);
		add(light);

		direction = rgen.nextDouble(220, 320);
		direction = 290;
	}

	public void move() {
		this.movePolar(velocity, direction);
	}

	public void moveBack() {
		this.movePolar(velocity, (direction + 180) % 360);
	}

	public void restart() {
		this.setVisible(false);
		pause(100);
		this.setVisible(true);
		pause(100);
		this.setVisible(false);
		pause(100);
		this.setLocation(Breakout.WIDTH / 2, Breakout.HEIGHT / 2);
		this.setVisible(true);
		direction = rgen.nextDouble(220, 320);
	}

	public double getRadius() {
		return r;
	}

	public void changeDirection(int xory) {
		if (xory == 1)
			direction -= (direction - 270) * 2;
		if (xory == 2)
			direction -= (direction - 180) * 2;
	}

	public double getDirection() {
		return direction;
	}

	public static void setVelocity(double v) {
		velocity = v;
	}

	public void setDirection(double d) {
		direction = d;
	}

	private double r;
	private double direction;

	private static final double STARTING_VELOCITY = 5.0;
	private static double velocity = STARTING_VELOCITY;

	private RandomGenerator rgen = RandomGenerator.getInstance();
}