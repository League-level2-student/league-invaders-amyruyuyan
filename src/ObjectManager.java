import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	
Rocketship rocket;
ArrayList<Projectile> projectiles;
ArrayList<Alien> aliens;
Random random;

public ObjectManager(Rocketship rocket) {

	
	this.rocket = rocket;
	
	this.projectiles = new ArrayList<Projectile>();
	
	this.aliens = new ArrayList<Alien>();
	
	this.random = new Random();
}

void addProjectile(Projectile Projectile) {
	projectiles.add(Projectile);
}

void addAlien() {
	aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
}

void update() {
	for(int i = 0; i < aliens.size(); i++) {
		Alien alien = aliens.get(i);
		alien.update();
	}
}

void draw(Graphics g) {
	rocket.draw(g);
	for(int i = 0; i < aliens.size(); i++) {
		Alien alien = aliens.get(i);
		alien.draw(g);
	}
}

void purgeObjects() {	
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
	addAlien();
	
}

}
