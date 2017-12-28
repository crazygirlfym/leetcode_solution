package leetcode_top100;
// 利用归并排序找逆序对O(nlogn)
public class InversePairs {
	
	public int InversePairs(int [] array) {
		int len = array.length;
		if(len == 0 || len == 1) return 0;
		return getCount(array, 0, len-1);
        
    }
	public int getCount(int []array, int begin, int end) {
		if(begin >= end) return 0;
		int mid = begin +(end-begin) /2;
		//逆序对存在左右两边的逆序对，加上交叉的逆序对
		int lCount = getCount(array, begin, mid);
		int rCount = getCount(array, mid+1, end);
		int[] tmp = new int[end-begin +1];
		int tmpIdx = end-begin;
		int startIdx = mid;
		int endIdx = end;
		int crossCount = 0;
		
		//以下是正常递归的过程的merge过程
		while(startIdx >= begin && endIdx >= mid+1) {
			if(array[startIdx] > array[endIdx]) { //存在逆序数
				crossCount += (endIdx - mid);  // 读这个大数而言， 存在endIdx - mid逆序对，该大数就处理完了，可以放入到临时数组中
				if (crossCount > 1000000007)// 数值过大求余
                {
					crossCount %= 1000000007;
                }
				
				tmp[tmpIdx] = array[startIdx];
				tmpIdx --;
				startIdx --;
			}else {
				tmp[tmpIdx] = array[endIdx];
				tmpIdx --;
				endIdx --;
				
			}
			

		}
		
		while(startIdx >= begin) {
			tmp[tmpIdx] = array[startIdx];
			tmpIdx --;
			startIdx --;
		}
		while(endIdx >= mid+1) {
			tmp[tmpIdx] = array[endIdx];
			tmpIdx --;
			endIdx --;
		}
	
		// 将临时数组的值copy回源数组
		
		for(int i=0;i<=tmp.length-1;i++) {
			array[begin+i] = tmp[i];	
		}

		return (lCount + rCount + crossCount) % 1000000007;
	}
	
	
	
	public static void main(String[] args) {
		InversePairs s = new InversePairs();
		int [] array = new int[] {1,2,3,4,5,6,7,0};
		System.out.println(s.InversePairs(array));
	}
	
	
}
