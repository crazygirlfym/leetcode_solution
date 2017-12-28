package leetcode_top100;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_Course_Schedule {
	// 如果存在环则该任务不能被完成
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if(numCourses <=0 ) return false;
		Queue<Integer> queue = new LinkedList<>();
		int[] inDegree = new int[numCourses];
		
		for (int i = 0; i < prerequisites.length; i++) {
			inDegree[prerequisites[i][1]]++;
		}
		for(int i=0;i< inDegree.length;i++) {
			if(inDegree[i] == 0)
				queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			for(int i=0;i<prerequisites.length;i++) {
				if(x == prerequisites[i][0]) {
					inDegree[prerequisites[i][1]] --;
					if(inDegree[prerequisites[i][1]] == 0)
						queue.offer(prerequisites[i][1]);
				}
			}
		}
		
		for(int i=0;i<inDegree.length;i++) {
			if(inDegree[i] !=0) 
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Solution_Course_Schedule s = new Solution_Course_Schedule();
		int [][]prerequisites= new int[][] {{1,0},{0,2},{2,1}};
		System.out.println(s.canFinish(3, prerequisites));
	}
}
