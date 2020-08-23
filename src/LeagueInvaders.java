import javax.swing.JFrame;

public class LeagueInvaders {
	
GamePanel GP;	
int uwu;
JFrame frame;
public static final int WIDTH = 500;
public static final int HEIGHT = 800;
	
public static void main(String[] args) {
	LeagueInvaders LeagueInvaders = new LeagueInvaders();
	//GamePanelObject 
	LeagueInvaders.setup();
}

void setup(){
	frame.add(GP);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	frame.setVisible(true);
	frame.setSize(WIDTH, HEIGHT);
	frame.addKeyListener(GP);
}

public LeagueInvaders(){
	frame = new JFrame();
	GP = new GamePanel();
}

}
	

