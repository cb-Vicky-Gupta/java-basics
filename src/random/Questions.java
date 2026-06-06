package random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Questions {
    static void main() {
        int [] arr = {1,2,3,1,2,3};
        int [] nums = {99,99};
//        System.out.println(maxProduct(arr));

        System.out.println(containsNearbyDuplicate(nums, 2));
    }
    public static int xorOperation(int n, int start) {
        int result = 0;
        int i = 0;
        while(n>0){
            result ^=start + 2 * i;
//            System.out.println(result);
            n--;
            i++;
        }
        return result;
    }
    public static int subtractProductAndSum(int n){
        int sum = 0;
        int product = 1;
        while(n>0){
            int rem = n%10;
            sum+=rem;
            product*=rem;
            n/=10;
        }
        return product-sum;
    }
    public static boolean checkIfExist(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<arr.length; i++){
            map.put(arr[i], i);
        }
        for(int i = 0; i<arr.length; i++){
            if(map.containsKey(2*arr[i]) && i != map.get(2*arr[i])){
                return true;
            }
        }
        return false;
    }
    public static int maxProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max1Index = -1;
        int max2 = Integer.MIN_VALUE;
        int end = nums.length -1;
        for(int i = 0; i<nums.length; i++, end--){
            if(max1 < nums[i]){
                max1 = nums[i];
                max1Index = i;
            }
        }
        for (int i = 0; i < nums.length ; i++) {
            if(max2 < nums[i] && (i != max1Index)){
                max2 = nums[i];
            }
        }
//        System.out.println(max1);
//        System.out.println(max2);
//        System.out.println(max1Index);
        return (max1-1)*(max2-1);
    }
    public static int countBit(int n) {
        int count = 0;
        while (n>0){
            if((n & 1) ==1){
                count++;
            }
            n>>=1;
        }
        return count;
    }
    public static int [] countBits (int n){
//        ArrayList<Integer> list = new ArrayList<>();
//        for(int i = 1; i<=n; i++){
//            list.add(countBit(i));
//        }
        int [] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = countBit(i);
    }
        return  result;
//        return list.stream().mapToInt(Integer::intValue).toArray();
    }
        public static int missingNumber(int[] nums) {
            int result = 0;
            for(int i = 0; i<nums.length; i++){
                result^=nums[i];
            }
            for(int i = 0; i<=nums.length; i++){
                result^=i;
            }
            return result;
        }
    public static int hammingDistance(int x, int y) {
        int count = 0;
        int i = 0;
        while(i<64){
            if((x&1) != (y&1) &&  !(x == 0 && y == 0)){
                count++;
            }
            x>>=1;
            y>>=1;
            i++;
        }
        return count;
    }
    // Happy number from leetcode::

    public static boolean isHappy(int n){
        if(n<0){
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        while((n != 1) && !set.contains(n)){
            set.add(n);
            n = happy(n);
        }

        return n==1;
    }
    public static int happy(int n){
        int sum = 0;
        while (n>0){
            int rem = n%10;
            sum+=rem*rem;
            n/=10;
        }
        return sum;
    }
    public static int findMaxConsecutiveOnes(int [] nums){
        int count = 0;
        int reset = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1){
                reset++;
                if(count<reset){
                    count++;
                }
            }else {
                reset = 0;
            }
        }
        return count;
    }

    public static boolean containsNearbyDuplicateBruteForce(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            // Look ahead up to k elements, but don't go past the end of the array
            for (int j = i + 1; j <= i + k && j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> window = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                window.remove(nums[i - k - 1]);
            }
            if (!window.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
