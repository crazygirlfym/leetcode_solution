package leetcode_top100;

public class Solution_Count_Primes {
	public int countPrimes(int n) {
		// 最暴力的方法就是遍历所有值 判断是不是素数了 这样应该会超时的吧
		// 另一个方法就是记录下，一个数不是素数，那么他的各个倍数都不是素数
		boolean[] notprime = new boolean[n];
		int count = 0;
		for(int i=2;i<n;i++) {
			if (notprime[i] == false) {
				count ++;
				for(int j=2;i*j < n;i++) {
					notprime[i*j] = true;
				}
			}
		}
		return count;
        
    }
	public boolean isPrime(int n) {
		if(n == 2 ) return true;
		for(int i=2 ;i<=Math.sqrt(n);i++) {
			if (n % i == 0) {
				return false;
			}
		
		}
		return true;
	}
}
