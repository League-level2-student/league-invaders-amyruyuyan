import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{ 
	Font titleFont; 
	Font smallerFont;
	Timer frameDraw;
    final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;
    Rocketship rocket;
    ObjectManager manager;
    
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
    	g.setColor(Color.BLACK);
    	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
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
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
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
		    if (currentState == END) {
		        currentState = MENU;
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
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
	

