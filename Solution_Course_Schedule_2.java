package leetcode_top100;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_Course_Schedule_2 {
	
	
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		
		int[] result = new int[numCourses];
		if (numCourses <=0) return result;
		int count = 0;
		Queue<Integer> queue = new LinkedList<>();
		int[] inDegree = new int[numCourses];
		
		for (int i = 0; i < prerequisites.length; i++) {
			inDegree[prerequisites[i][0]]++;
		}
		for(int i=0;i< inDegree.length;i++) {
			if(inDegree[i] == 0)
				queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			result[count] = x;
			count ++;
			for(int i=0;i<prerequisites.length;i++) {
				if(x == prerequisites[i][1]) {
					inDegree[prerequisites[i][0]] --;
					if(inDegree[prerequisites[i][0]] == 0)
						queue.offer(prerequisites[i][0]);
				}
			}
		}
		
		for(int i=0;i<inDegree.length;i++) {
			if(inDegree[i] !=0) 
				return null;
		}
		
		return result;
    }
	
	public static void main(String[] args) {
		Solution_Course_Schedule_2 s = new Solution_Course_Schedule_2();
		int [][] prerequisites= new int[][]{{1,0},{2,0},{3,1},{3,2}};
		int[] result=s.findOrder(4, prerequisites);
		for(int i=0;i<result.length;i++) {
			System.out.println(result[i]);
		}
	}
}
