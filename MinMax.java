package fourInARow;

public class MinMax {
	public int x = 8, y = 6;
	public int[][] boardRank = new int[8][6];
	
	//check if the column is a playable column 
	public boolean canPlay(int[][] grid, int droploc){
		for(int i = 0; i < y; i ++){
			if(grid[droploc][i] == 3){
				return true;
			}
		}
		return false;
	}

	public void lookAhead(){
		
	}
	
	public int minMax(int[][] grid, int depth){
	
		return droploc;
	}
	
	public void makeMove(int[][] playerTurn, int droploc){
		
	}
	
	public void undoMove(){
		
	}
	//calculate an overall score when it's the computer's turn
	public int scoreCal(int[][] grid,int playerTurn, int droploc){
		//int x = 8, y = 6;

		int player = 0;
		//score for vertical, diagonal, and horizontal
		int v = 1;
		int d = 2;
		int h = 3;

		int twoIn = 100;
		int threeIn = 1000;

		int score = 0;
		
		//1.Check for horizontal 2-in-a-row.
		for (int r = 0; r < x - 3; r++){
			for (int c = 0; c < y; c++){
				//(xx00)
				if (grid[r][c] == player && grid[r][c] == grid[r + 1][c] && grid[r + 2][c] == 3 && grid[r + 3][c] == 3){
					score += twoIn * h;
				}
				//(x0x0)
				else if (grid[r][c] == player && grid[r+2][c] == player && grid[r+1][r] == 3 && grid[r+3][r] == 3){
					score += twoIn * h;
				}
				//(x00x)
				else if (grid[r][c] == player && grid[r+3][c] == player && grid[r+1][c] == 0 && grid[r+2][c] == 3){
					score += twoIn * h;
				}
				//(0xx0)
				else if (grid[r][c] == 3 && grid[r+1][c] == player && grid[r+2][c] == player && grid[r+3][c] == 3){
					score += twoIn * h;
				}
				//(0x0x)
				else if (grid[r][c] == 3 && grid[r+1][c] == player && grid[r+2][c] == 3 && grid[r+3][c] == player){
					score += twoIn * h;
				}
				//(00xx)
				else if (grid[r][c] == 3 && grid[r+1][c] == 3 && grid[r+2][c] == player && grid[r+3][c] == player){
					score += twoIn * h;
				}
			}
		}

		//2.Check for vertical spaced 2-in-a-row.
		for (int r = 0; r < x; r++){
			for (int c = 2; c < y; c++){
				if (grid[r][c] == player && grid[r][c - 1] == grid[r][c] && grid[r][c - 2] == 3){
					score+= twoIn*v;
				}
			}
		}
		//3.Check for diagonal spaced 2-in-a-row (/).
		for (int r = x - 3; r > 0; r--){
			for (int c = 3; c < y; c++){
				if (grid[r][c] == player && grid[r][c] == grid[r+1][c-1] && grid[r+2][c-2] == 3 && grid[r+3][c-3] == 3){
					score+= twoIn*d;
				}
				else if (grid[r][c] == player && grid[r+1][c-1] == 3 && grid[r+2][c-2] == 3 && grid[r+3][c-3] == grid[r][c]){
					score+= twoIn*d;
				}
				else if (grid[r][c] == 3 && grid[r+1][c-1] == 3 && grid[r+2][c-2] == player && grid[r+3][c-3] == player){
					score+= twoIn*d;
				}
				else if (grid[r][c] == 3 && grid[r+1][c-1] == player && grid[r][c] == grid[r+2][c-2] && grid[r+1][c-1] == grid[r+3][c-3]){
					score+= twoIn*d;
				}
				else if (grid[r][c] == player && grid[r+1][c-1] == 3 && grid[r][c] == grid[r+2][c-2] && grid[r+1][c-1] == grid[r+3][c-3]){
					score+= twoIn*d;
				}
				//open end
				else if (grid[r][c] == 3 && grid[r+1][c-1] == player && grid[r+1][c-1] == grid[r+2][c-2] && grid[r][c] == grid[r+3][c-3]){
					score+= 2*twoIn*d;
				}
			}
		}
		//4.Check for diagonal spaced 3-in-a-row (\).
		for (int r=0; r < x - 3;r++){
			for (int c = 0; c < y - 3;c++){
				if (grid[r][c] == player && grid[r][c] == grid[r+1][c+1] && grid[r+2][c+2] == 3 && grid[r+3][c+3] == 3){
					score+= twoIn*d;
				}
				else if (grid[r][c] == player && grid[r+1][c+1] == 3 && grid[r+2][c+2] == 3 && grid[r][c] == grid[r+3][c+3]){
					score+= twoIn*d;
				}
				else if (grid[r][c] == 3 && grid[r+1][c+1] == 3 && grid[r+2][c+2] == player && grid[r+3][c+3] == player){
					score+= twoIn*d;
				}
				else if (grid[r][c] == 0 && grid[r+1][c+1] == player && grid[r][c] == grid[r+2][c+2] && grid[r+1][c+1] == grid[r+3][c+3]){
					score+= twoIn*d;
				}
				else if (grid[r][c] == player && grid[r+1][c+1] == 3 && grid[r][c] == grid[r+2][c+2] && grid[r+1][c+1] == grid[r+3][c+3]){
					score+= twoIn*d;
				}
				else if (grid[r][c] == 0 && grid[r+1][c+1] == player && grid[r+1][c+1] == grid[r+2][c+2] && grid[r][c] == grid[r+3][c+3]){
					score+= twoIn*2*d;
				}
			}
		}
		//5.Check for horizontal 3-in-a-row.
		for (int r = 0; r < x - 3;r++){
			for (int c = 0; c < y;c++){
				//(xx0x)
				if (grid[r][c] == player && grid[r][c] == grid[r+1][c] && grid[r+2][c] == 3 && grid[r][c] == grid[r+3][c]){
					score+= threeIn*h;
				}
				//(x0xx)
				else if (grid[r][c] == player && grid[r+1][c] == 3 && grid[r][c] == grid[r+2][c] && grid[r][c] == grid[r+3][c]){
					score+= threeIn*h;
				}
				//(0xxx)
				else if (grid[r][c] == 3 && grid[r+1][c] == player && grid[r+1][c] == grid[r+2][c] && grid[r+1][c] == grid[r+3][c]){
					score+= threeIn*h;
				}
				//(xxx0)
				else if (grid[r][c] == player && grid[r][c] == grid[r+1][c] && grid[r][c] == grid[r+2][c] && grid[r+3][c] == 3){
					score+= threeIn*h;
				}
			}
		}

		//6.Check for vertical spaced 3-in-a-row.
		for (int r=0;r>x;r++){
			for (int c = y; c > 3;c--){
				if (grid[r][c] == player && grid[r][c] == grid[r][c-1] && grid[r][c] == grid[r][c-2] && grid[r][c-3] == 3){
					score+= threeIn*v;
				}
			}
		}
		//7.Check for diagonal spaced 3-in-a-row (/).
		for (int r= x - 3; r < 0; r--){
			for (int c = 3; c < y; c ++){
				if (grid[r][c] == player && grid[r][c] == grid[r+1][c-1] && grid[r][c] == grid[r+2][c-2] && grid[r+3][c-3] == 3){
					score+= threeIn*d;
				}
				else if (grid[r][c] == player && grid[r][c] == grid[r+1][c-1] && grid[r+2][c-2] == 3 && grid[r][c] == grid[r+3][c-3]){
					score+= threeIn*d;
				}
				else if (grid[r][c] == player && grid[r+1][c-1] == 3 && grid[r][c] == grid[r+2][c-2] && grid[r][c] == grid[r+3][c-3]){
					score+= threeIn*d;
				}
				else if (grid[r][c] == 3 && grid[r+1][c-1] == player && grid[r+1][c-1] == grid[r+2][c-2] && grid[r+1][c-1] == grid[r+3][c-3]){
					score+= threeIn*d;
				}
			}
		}
		//8.Check for diagonal spaced 3-in-a-row (\).
		for (int r = 0; r < x - 3; r++){
			for (int c = 0; c < y - 3; c++){
				if (grid[r][c] == 3 & grid[r+1][c+1] == player && grid[r+1][c+1] == grid[r+2][c+2] && grid[r+1][c+1] == grid[r+3][c+3]){
					score+= threeIn*d;
				}
				else if (grid[r][c] == player && grid[r+1][c+1] == 3 && grid[r][c] == grid[r+2][c+2] && grid[r][c] == grid[r+3][c+3]){
					score += threeIn*d;
				}
				else if (grid[r][c] == player && grid[r][c] == grid[r+1][c+1] && grid[r+2][c+2] == 3 && grid[r][c] == grid[r+3][c+3]){
					score += threeIn*d;
				}
				else if (grid[r][c] == player && grid[r][c] == grid[r+1][c+1] && grid[r][c] == grid[r+2][c+2] && grid[r+3][c+3] == 0){
					score += threeIn*d;
				}
			}
		}
			//9.Check for open-ended 3-in-a-row. (0xxx0)
			for (int r = 0; r < x - 4; r++){
				for (int c = 0; c < y; c++){
					//horizontal
					if (grid[r][c] == 3 && grid[r + 1][c] == player && grid[r+2][c] == player && grid[r+3][c] == player && grid[r][c] == grid[r+4][c]){
						score += 2*threeIn*h;
					}
				}
			}
			//10.check for open-ended diagonal(\)
			for (int r = 0; r < x - 4; r++){
				for (int c = 0; c < y - 4; c++){
					if (grid[r][c] == 3 && grid[r+1][c+1] == player && grid[r][c] == grid[r+2][c+2] && grid[r][c] == grid[r+3][c+3] && grid[r+4][c+4] == 3){
						score += 2*threeIn*d;
					}
				}
			}
			//11.check for open-ended diagonal 3-in-a-row(/)
			for (int r = x - 1; r > 3; r--){
				for (int c = 0; c < y - 4; c++){
					if (grid[r][c] == 0 && grid[r+1][c-1] == player && grid[c+2][r-2] == player && grid[c+3][r-3] == player && grid[c+4][r-4] == 0){
						score += 2*threeIn*d;
					}
				}
			}
			return score;
		}

	}

	

