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
	for(int j = 0; j < projectiles.size(); j++) {
		Projectile projectile = projectiles.get(j);
		projectile.update();
	}
	rocket.update();
	
	checkCollision();
	purgeObjects();
}

void draw(Graphics g) {
	rocket.draw(g);
	for(int i = 0; i < aliens.size(); i++) {
		Alien alien = aliens.get(i);
		alien.draw(g);
	}
	for(int j = 0; j < projectiles.size(); j++) {
		Projectile projectile = projectiles.get(j);
		projectile.draw(g);
	}
}

void purgeObjects() {
	for(int k = projectiles.size()-1; k >= 0; k--) {
		if (projectiles.get(k).isActive == false) {
			projectiles.remove(k);
		}
	}
	
	for(int l = aliens.size()-1; l >= 0; l--) {
		if (aliens.get(l).isActive == false) {
			aliens.remove(l);
		}
	}
}

void checkCollision(){
	for(int i = 0; i < aliens.size(); i++) {
		Alien alien1 = aliens.get(i);
		for(int j = 0; j < projectiles.size(); j++) {
			Projectile projectiles1 = projectiles.get(j);
			if (alien1.collisionBox.intersects(projectiles1.collisionBox)){
				projectiles1.isActive = false;
				alien1.isActive = false;
			}
		}
				if (alien1.collisionBox.intersects(rocket.collisionBox)){
			alien1.isActive = false;
			rocket.isActive = false;
		}
	}
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
	addAlien();
	
}

}
