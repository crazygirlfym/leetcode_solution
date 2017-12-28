package leetcode_top100;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
	// 要实现两个操作， 一个是添加一个元素到结构中
	// 第二个是找到中位数
	
	/** initialize your data structure here. */
	
	// 最小堆， 堆顶取到的是最小的元素， 保存的是大的那部分数据
	private PriorityQueue<Integer> small;
	
	// 最大堆，堆顶取到的是最大的元素， 保存的是小的那部分数据
	private PriorityQueue<Integer> large;
	
	
    public MedianFinder() {
//    			small = new PriorityQueue<>(Collections.reverseOrder());
    			large = new PriorityQueue<>();
    			small = new PriorityQueue<>(Collections.reverseOrder());
        
    }
    
    public void addNum(int num) {
    			if( small.size() == 0 && large.size() == 0) small.add(num);  
    			
    			else if(small.size() > large.size()) {
    				
    				if(num > small.peek()) {  
    					
    					large.add(small.poll());
    					small.add(num);
    					
    				}else { large.add(num);}
    			} else if(small.size() < large.size()) {
    				if (large.peek() > num) {
    					small.add(large.poll());
    					large.add(num);
    					
    				}else {small.add(num);} 
    			} else {
    				if(num < large.peek()) large.add(num);
    				else small.add(num);
    			}
    		
        
    }
    
    public double findMedian() {
    		
    		if(small.size() == 0 && large.size() == 0) return 0.0;
    		if(small.size() > large.size()) return (double)small.peek();
    		if(small.size() < large.size()) return (double)large.peek();
    		return ((double) (small.peek() + large.peek())/ 2.0);
    		
    	
    }
   
    public static void main(String[] args) {
    		MedianFinder m = new MedianFinder();	
    		m.addNum(1);
    		m.addNum(2);
    		System.out.println(m.findMedian());
    		m.addNum(3);
    		System.out.println(m.findMedian());
    		
	}
    
    
   
}
