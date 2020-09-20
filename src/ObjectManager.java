import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	
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

void addProjectile(Projectile projectile) {
	projectiles.add(projectile);
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
}

void purgeObjects() {
	
}

}
