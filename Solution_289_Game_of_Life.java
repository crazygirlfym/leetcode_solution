package leetcode_top100;

public class Solution_289_Game_of_Life {
	
	// 周围存活细胞小于2个， 则死亡
	// 周围存活细胞2个或3个， 则存活
	// 周围存活细胞3个以上，则死亡
	// 周围存活细胞3个的死细胞， 将成为一个活细胞
	
	// 本题的难点在于 所有点的状态需要一次性发生改变， 而且不用额外的空间
	
	
	//对二维数组中的每个元素轮训，找出每个元素周围八个格子活着格子的数目，并判断下一秒是活着还是死亡。
	//将每个格子下一秒的状态保存在当前格子的第二位中，当完成所有元素下一秒状态之后，同时更新所有元素状态。
	
	public void gameOfLife(int[][] board) {
		 if (board == null || board.length == 0) return;
	        int m = board.length, n = board[0].length;
	        for(int i=0;i<m;i++) {
	        		for(int j=0; j<n; j++) {
	        			int lives = liveNeighbors(board, m, n, i, j);
	        			if(board[i][j] ==0) {
	        				if(lives == 3) {
	        					board[i][j] = 2;
	        				}
	        			} else {
	        				if(lives == 2  || lives == 3) {
	        					board[i][j] = 3;
	        				}
	        			}
	        			
	        		}
	        }
	        
	        for(int i=0;i<m;i++) {
        			for(int j=0; j<n; j++) {
        			board[i][j] = board[i][j] >> 1;
        			}
        		}
        		
	        
	        
    }
	public int liveNeighbors(int [][] board, int m, int n, int i, int j) {
		int lives = 0;
		for (int x = Math.max(i - 1, 0);  x <= Math.min(i+1, m - 1); x++ ) {
            for (int y = Math.max(j - 1, 0);  y <= Math.min(j + 1, n - 1); y++) {
                lives += board[x][y] & 1;
            }
        }
		lives -= board[i][j] & 1;
        return lives;

	}
}
