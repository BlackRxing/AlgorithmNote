package math_problem;

import java.util.Arrays;
//所有数标记为质数，然后标记2i（2i<=n）,标记3i为合数等等，到x时从x*x标记，因为之前的已经遍历过了
public class _204_count_primes {
    class Solution {
        public int countPrimes(int n) {
            int[] isPrime = new int[n];
            Arrays.fill(isPrime, 1);
            int ans = 0;
            for (int i = 2; i < n; ++i) {
                if (isPrime[i] == 1) {
                    ans += 1;
                    if ((long) i * i < n) {
                        for (int j = i * i; j < n; j += i) {
                            isPrime[j] = 0;
                        }
                    }
                }
            }
            return ans;
        }
    }
}
