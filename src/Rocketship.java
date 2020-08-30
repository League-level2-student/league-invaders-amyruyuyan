import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {

	void draw(Graphics g) {
		 
		 g.setColor(Color.BLUE);
	     g.fillRect(x, y, width, height);	
	}
	
	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
		// TODO Auto-generated constructor stub
	}

	void up() {
		if (y>=20)	
		y-=speed;
	}
	
	void down() {
		if (y<=700)
		y+=speed;
	}
	
	void left() {
		if (x>=20)
		x-=speed;
	}
	
	void right() {
		if (x<=430)
		x+=speed;
	}
	
}
