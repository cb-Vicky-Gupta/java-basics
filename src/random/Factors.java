package random;

import java.util.*;

public class Factors {
    static void main() {
//        Map<Integer, Integer> ans = factorizeFast(60);
//        ans.forEach((key, value) -> System.out.println(key + " : " + value));
        int [] nums = {1,2,3,4,5};
        System.out.println(sumFourDivisors(nums));
    }
//    public static Map<Integer, Integer> primeFactorize(int n) {
//        Map<Integer, Integer> factors = new LinkedHashMap<>(); // prime -> how many times it divides
//        for (int p = 2; (long) p * p <= n; p++) {
//            while (n % p == 0) {                 // while p still divides n...
//                factors.merge(p, 1, Integer::sum); // ...count it...
////                factors.put(p, factors.getOrDefault(p, 0) + 1);
//                n /= p;                            // ...and remove it
//            }
//        }
//        if (n > 1) {
//            factors.merge(n, 1, Integer::sum);   // the one possible leftover prime > sqrt(original n)
//        }
//        return factors;
//    }
    public static Map<Integer, Integer> primeFactors(int n){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 2; (long) i*i <= n; i++){
            while (n % i ==0){
                map.merge(i,1, Integer::sum);
                n/=i;
            }
        }
        if(n>1){
            map.merge(n, 1, Integer::sum);
        }
        return map;
    }
    public static Map<Integer, Integer> factorizeFast(int n, int[] spf) {
        Map<Integer, Integer> factors = new LinkedHashMap<>();
        while (n > 1) {
            int p = spf[n];              // smallest prime factor in O(1) via the precomputed table
            while (n % p == 0) {
                factors.merge(p, 1, Integer::sum);
                n /= p;
            }
        }
        return factors;
    }
    public static int gcdRecursive(int a, int b) {
        return b == 0 ? a : gcdRecursive(b, a % b);
    }
    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for(int i = left; i<=right; i++){
            if(check(i)){
                list.add(i);
            }
        }
        return list;
    }
    public static Boolean check(int num){
        int copyNum = num;
        while(num>0){
            int rem = num%10;
            if(rem == 0) return false;
            if(copyNum%rem != 0){
                return false;
            }
            num/=10;
        }
        return true;
    }

        public static boolean isThree(int n) {
            int count = 0;
            for(int i = 1; (long) i*2 <= n; i++){
                if(n%i == 0){
                    count++;
                }
            }
            System.out.println(count);
            return count == 2 ? true : false;
        }
    public static int sumFourDivisors(int[] nums) {
        int sum = 0;
        for(int i = 0; i<nums.length; i++){
            sum+=sumDigit(nums[i]);
        }
        return sum;
    }
    public static int sumDigit(int num){
        int count = 0;
        int sum = 0;
        for(int i = 1; (long) i*2 <= num; i++){
            int rem = num%i;
            if(rem == 0){
                sum+=i;
                count++;
            }
        }
        if(count == 3) sum= sum+num;
        return count == 3 ? sum :  0;
    }




}
