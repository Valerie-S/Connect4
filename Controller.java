package fourInARow;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Connect4_Controller extends JPanel implements KeyListener, ActionListener{

	
	public static JFrame jf;
	//grid variables
	static int width = 1500, height = 1200;
	int scale = 150, x = 8, y = 6;
	int grid[][] = new int[x][y];
	int drop[] = new int[x];
	//player variables
	int playerTurn = 1;
	int droploc = 1;
	public Color playerColor;
	public boolean win = false;
	//indicate which panel to choose
	public static int child;

	public static Connect4 game1 = new Connect4();
	public static Connect4 game2 = new Connect4();
	public static Connect4 game3 = new Connect4();
	public static Connect4[] cc= new Connect4[]{game1, game2, game3};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connect4_Controller ctl = new Connect4_Controller();

		jf = new JFrame();
		jf.add(ctl);
		jf.setTitle("Connect Four");
		jf.addKeyListener(ctl);
		jf.setSize(width,  height);
		jf.setVisible(true);
		jf.setBackground(Color.black);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setFocusable(true);
		cc[child].blankCell();
		jf.repaint();
	}

	public void paintComponent(Graphics g){
		cc[child].paintComponent(g);
	}
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(child);
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_SPACE){
			cc[child].dropCell(cc[child].droploc);
			cc[child].auto();
			displayBoard(cc[child].grid);
		}
		if(key == KeyEvent.VK_RIGHT){
			cc[child].droploc ++;
		}
		if(key == KeyEvent.VK_LEFT){
			cc[child].droploc --;
		}

		if(key == KeyEvent.VK_1){
			child = 0;
		}
		if(key == KeyEvent.VK_2){
			child = 1;
		}
		if(key == KeyEvent.VK_3){
			child = 2;
		}

		//remain the drop location on the screen
		if(cc[child].droploc >= x + 1){
			cc[child].droploc = 1;
		}
		if(cc[child].droploc <= 0){
			cc[child].droploc = x;
		}
		jf.repaint();
	}

	public void displayBoard(int[][] grid){
		for(int i = 0; i < y; i ++){
			for(int j = 0; j < x; j ++){
				System.out.print(grid[j][i]);
			}
			System.out.println();
		}
	}
	
	public void displayRank(int[][] rankBoard){
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
