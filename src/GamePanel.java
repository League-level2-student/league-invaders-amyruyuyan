import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{ 
	Font titleFont; 
	Font smallerFont;
	Timer frameDraw;
	Timer alienSpawn;
    final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;
    Rocketship rocket;
    ObjectManager manager;
    public static BufferedImage image;
    public static boolean needImage = true;
    public static boolean gotImage = false;	
    
    void updateMenuState() {  }
    void updateGameState() {  
    	manager.update();
    }
    void updateEndState()  {  }
    
    void drawMenuState(Graphics g) { 
    	g.setColor(Color.BLUE);
    	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
    	
    	g.setFont(titleFont);
    	g.setColor(Color.white);
    	g.drawString("LEAGUE INVADERS", 25, 125);
    	
    	g.setFont(smallerFont);
    	g.setColor(Color.white);
    	g.drawString("Press ENTER to start", 125, 400);
    	
    	g.setFont(smallerFont);
    	g.setColor(Color.white);
    	g.drawString("Press SPACE for instructions", 85, 600);
    }
    void drawGameState(Graphics g) { 
    	if (gotImage) {
    		g.drawImage(image, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
    	} else {
    		g.setColor(Color.BLACK);
        	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
    	}
    	manager.draw(g);
    }
    void drawEndState(Graphics g)  {   
    	g.setColor(Color.RED);
    	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
    }
   
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);}		
		else if(currentState == GAME) {
			drawGameState(g);
		}
		else if(currentState == END){
	    drawEndState(g);
	}

	}
	
	public GamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 48);
		smallerFont = new Font("Arial", Font.PLAIN, 24);
	    frameDraw = new Timer(1000/60,this);
	    frameDraw.start();
	    rocket = new Rocketship(250, 700, 50, 50);
	    manager = new ObjectManager(rocket);
	    if (needImage) {
	        loadImage ("space.png");
	    }

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		    manager.addProjectile(rocket.getProjectile());
		}else if(currentState == END){
		    updateEndState();
		    
		}
		//System.out.println("action");
		repaint();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
			startGame();
		    if (currentState == END) {
		        currentState = MENU;
		        alienSpawn.stop();
		    } else {
		        currentState++;
		    }
		}  
		
		if (e.getKeyCode()==KeyEvent.VK_UP) {
		    System.out.println("UP");
		    rocket.up();
		}
		
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
		    System.out.println("DOWN");
		    rocket.down();
		}

		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
		    System.out.println("LEFT");
		    rocket.left();
		}
		
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
		    System.out.println("RIGHT");
		    rocket.right();
		}
	}
	
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
	
	void startGame() {
		alienSpawn = new Timer(1000 , manager);
	    alienSpawn.start();
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
	

