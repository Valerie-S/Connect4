package fourInARow;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.ArrayList;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Connect4 extends Connect4_Controller{

	static int width = 1500, height = 1200, scale = 150, x = 8, y = 6;
	int grid[][] = new int[x][y];
	int droploc = 1;
	int drop[] = new int[x];
	MinMax mm = new MinMax();

	public void paintComponent(Graphics g){

		//change color by the turns of players
		if(playerTurn % 2 == 1){
			playerColor = new Color(102, 178, 255);
		}
		if(playerTurn % 2 == 0){
			playerColor = new Color(255, 178, 102);
		}
		//draw the grid 
		for(int i = 0; i < x; i ++){
			for(int j = 0; j < y; j ++){
				if(cc[child].grid[i][j] == 3){
					g.setColor(Color.white);
					g.fillOval((i + 1) * scale , (j + 1) * scale , 120, 120);

				}
				if(cc[child].grid[i][j] == 1){
					g.setColor(new Color(102, 178, 255));
					g.fillOval((i + 1) * scale , (j + 1) * scale , 120, 120);
				}
				if(cc[child].grid[i][j] == 0){
					g.setColor(new Color(255, 178, 102));
					g.fillOval((i + 1) * scale , (j + 1) * scale , 120, 120);
				}
			}
		}
		//call the AI method
		//int score = mm.scoreCal(grid, playerTurn, droploc);


		//draw the win message 
		g.setFont(new Font("Arial",40, 60));
		g.setColor(Color.cyan);
		if(checkWin(grid) == true && playerTurn % 2 == 1){
			g.drawString("Orange wins", 550, 60);
			restart();
		}
		if(checkWin(grid) == true && playerTurn % 2 == 0){
			g.drawString("Blue wins", 600, 60);
			restart();

		}


		//show the location to drop the circle
		g.setColor(playerColor);
		g.fillOval(droploc * (scale) + 30, 80, 60, 60);



		restart();


	}

	public void blankCell(){
		//make the default value of the blank cell 3
		for(int i = 0; i < x; i ++){
			for(int j = 0; j < y; j ++){
				grid[i][j] = 3;
			}
		}
	}
	public void restart(){
		if(win == true){
			cc[child].win = false;
			cc[child].playerTurn = 1;
			cc[child].droploc = 1;
			//make the default value of the blank cell 3
			blankCell();
		}
	}
	public boolean checkWin(int [][] array){
		//vertical check
		for(int r = 0; r < x; r ++){
			for(int c = 0; c < y - 3; c ++){
				if(array[r][c] == array[r][c + 1] && array[r][c + 2] == array[r][c] && array[r][c + 3] == array[r][c] && array[r][c] != 3){
					cc[child].win = true;
				}
			}
		}
		//horizontal check
		for(int r = 0; r < x - 3; r ++){
			for(int c = 0; c < y; c ++){
				if(array[r][c] == array[r + 1][c] && array[r + 2][c] == array[r][c] && array[r + 3][c] == array[r][c] && array[r][c] != 3){
					cc[child].win = true;
				}
			}
		}
		//ascending diagonal check
		for(int r = 3; r < x; r ++){
			for(int c = 0; c < y - 3; c ++){
				if (array[r][c] == array[r-1][c+1] && array[r-2][c+2] == array[r][c] && array[r-3][c+3] == array[r][c] && array[r][c] != 3){
					cc[child].win = true;
				}
			}
		}
		//descending diagonal check
		for(int r = 3; r < x; r ++){
			for(int c = 3; c < y; c ++){
				if (array[r][c] == array[r-1][c-1] && array[r-2][c-2] == array[r][c] && array[r-3][c-3] == array[r][c] && array[r][c] != 3){
					cc[child].win = true;
				}
			}
		}
		return cc[child].win;
	}

	public void dropCell(int droploc){
		for(int j = 0; j < y; j ++){
			if(cc[child].grid[droploc - 1][y - j - 1] == 3){
				//the value of player is 1
				if(playerTurn % 2 == 1){
					cc[child].grid[droploc - 1][y - j - 1] = (cc[child].playerTurn % 2);
				}

				//the AI controller is called in paint

				break;
			}
		}
		cc[child].playerTurn ++;
	}

	public void auto(){
		for(int j = 0; j < y; j ++){
			if(cc[child].playerTurn % 2 == 0){
				if(cc[child].grid[droploc - 1][y - j - 1] == 3){
					droploc = 3;
					cc[child].grid[droploc - 1][y - j - 1] = 0;
					cc[child].playerTurn ++;
				}
				break;
			}
		}

	}
}
