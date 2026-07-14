package random;

import java.util.ArrayList;
import java.util.List;

public class MathQuestions {
    static void main() {
//        List<Integer> ans = primesUpTo(20);
//        for (int i = 0; i <= ans.size(); i++) {
//            System.out.print(ans.get(i)+ " ");
//        }
//        int [][] mat = {{1,2,3},{5,17,7},{9,10,11}};
        System.out.println(numPrimeArrangements(100));
    }

    public static List<Integer> primesUpTo(int n) {
        boolean[] composite = new boolean[n + 1];
        int count = 0;
        List<Integer> primes = new ArrayList<>();

        for (int p = 2; p <= n; p++) {
            if (!composite[p]) {
                primes.add(p);
                count++;
                for (long multiple = (long) p * p; multiple <= n; multiple += p) {
                    composite[(int) multiple] = true;
                }
            }
        }
        System.out.println(count);
        return primes;
    }

    static Boolean isPrime(int num) {
        if (num < 2) return false;

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static int diagonalPrime(int[][] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if ((i == j && isPrime(nums[i][j]))) {
                    max = Math.max(max, nums[i][j]);
                } else if ((isPrime(nums[i][nums.length - i - 1]))) {
                    max = Math.max(max, nums[i][nums.length - i - 1]);
                }
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }

    public static int numPrimeArrangements(int n) {
        boolean[] composite = new boolean[n + 1];
        int count = 0;
        int MOD = 1_000_000_007;
        long result = 1;
        for (int p = 2; p <= n; p++) {
            if (!composite[p]) {
                count++;
                for (long multiple = (long) p * p; multiple <= n; multiple += p) {
                    composite[(int) multiple] = true;
                }
            }
        }

        for (int i = 1; i <= count; i++) {
            result = (result * i) % MOD;
        }
        for (int i = 1; i <= n - count; i++) {
            result = (result * i) % MOD;
        }

        return (int) result;

    }
    public static int numPrimeArrangements2(int n) {
            int MOD = 1_000_000_007;

            // 1. Count primes up to n
            int primeCount = 0;
            for (int i = 1; i <= n; i++) {
                if (isPrime(i)) {
                    primeCount++;
                }
            }

            int nonPrimeCount = n - primeCount;

            // 2. Calculate (primeCount! * nonPrimeCount!) % MOD
            long result = 1;

            // Multiply factorials iteratively while applying modulo
            for (int i = 1; i <= primeCount; i++) {
                result = (result * i) % MOD;
            }
            for (int i = 1; i <= nonPrimeCount; i++) {
                result = (result * i) % MOD;
            }

            return (int) result;
        }



}