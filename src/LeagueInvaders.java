import javax.swing.JFrame;

public class LeagueInvaders {
	
int uwu;
JFrame frame;
public static final int WIDTH = 500;
public static final int HEIGHT = 800;
	
public static void main(String[] args) {
	LeagueInvaders LeagueInvaders = new LeagueInvaders();
	LeagueInvaders.setup();
}

void setup(){
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	frame.setVisible(true);
	frame.setSize(WIDTH, HEIGHT);
}

public LeagueInvaders(){
	frame = new JFrame();
}
}
	

