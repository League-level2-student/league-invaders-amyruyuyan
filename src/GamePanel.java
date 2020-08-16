import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener{ 
	Font titleFont; 
	Font smallerFont;
	Timer frameDraw;
    final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;
    
    void updateMenuState() {  }
    void updateGameState() {  }
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
		    
		    System.out.println("action");
		    
		}
		
	}
}
	

