package leetcode;

public class Solution_547_2 {
	
	public int dfs(int[][]M, int[] visited, int ind) {
		if (visited[ind] == 1) {
			return 0;
		}
		
		visited[ind] = 1;
		int cnum = 1;
		for(int j=0;j<M.length;j++) {
			if(ind !=j &&M[ind][j] ==1) {
				cnum += dfs(M, visited, j);
			}
		}
		return cnum;
	}
	
	public int findCircleNum(int[][] M) {
        int size = M.length;
        if (size == 0) return 0;
        int[] visited = new int[size];
        for (int i=0;i<size;i++) {
        		visited[i] = 0;
        }
        int cnum = 0;
        for(int i=0; i< size;i++) {
        		if (dfs(M,visited,i) > 0) cnum += 1;
        		
        }
        return cnum;
        
    }
}
