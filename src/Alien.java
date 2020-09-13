import java.awt.Color;

public class Alien extends GameObject {

	public Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 1;
	}
	
	void update() {
		y+=speed;
	}
	
	void draw() {
		g.setColor(Color.YELLOW);
        g.fillRect(x, y, width, height);
	}
	
}
