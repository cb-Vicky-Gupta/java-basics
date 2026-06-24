package random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ArrayNew {
    static void main() {
        int[] arr = {1, 2, 3, 4};
        int k = -2;
        int[] arrN = decrypt(arr, k);
        for (int i = 0; i < arrN.length; i++) {
//            System.out.print(arrN[i] + " ");
        }
        System.out.println(rotateString("abcde", "bcdea"));

    }

    public static int maxVowels(String s, int k) {
        List<Character> list = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (list.contains(s.charAt(i))) {
                count++;
            }
        }
        int max = count;
        for (int i = k; i < s.length(); i++) {

            if (list.contains(s.charAt(i))) {
                max++;
            }
            if (list.contains(s.charAt(i - k))) {
                max--;
            }
            count = Math.max(max, count);
        }
        return count;
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int reset = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 1) {
                reset++;
                if (count < reset) {
                    count++;
                }
            } else {
                reset = 0;
            }
        }
        return count;
    }

    public static int[] decrypt(int[] code, int k) {
        int[] arr = new int[code.length];
        for (int i = 0; i < code.length; i++) {
            arr[i] = makeArraysum(code, k, i);
        }
        return arr;
    }

    public static int makeArraysum(int[] arr, int k, int i) {
        int sum = 0;
        int n = arr.length;
        if (k == 0) {
            return sum;
        }
        if (k > 0) {
            for (int j = 1; j <= k; j++) {
                sum += arr[(i + j) % n];
            }
        } else {
            int absK = Math.abs(k);
            for (int j = 1; j <= absK; j++) {
                sum += arr[(i - j + n) % n];
            }
        }
        return sum;
    }

    public static int countGoodSubstrings(String s) {
        if (s.length() < 3) return 0;

        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        if (map.size() == 3) count++;
        for (int i = 3; i < s.length(); i++) {
            char inChar = s.charAt(i);
            map.put(inChar, map.getOrDefault(inChar, 0) + 1);
            char outChar = s.charAt(i - 3);
            if (map.get(outChar) == 1) {
                map.remove(outChar);
            } else {
                map.put(outChar, map.get(outChar) - 1);
            }
            if (map.size() == 3) {
                count++;
            }
        }

        return count;
    }

    public static int maxProduct(int[] nums) {
        if (nums.length <= 2) return -1;
        if (nums.length == 3) return nums[0] * nums[1] * nums[2];
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (max1 < nums[i]) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            } else if (max2 < nums[i]) {
                max3 = max2;
                max2 = nums[i];
            } else if (max3 < nums[i]) {
                max3 = nums[i];
            }

            if (min1 > nums[i]) {
                min2 = min1;
                min1 = nums[i];
            } else if (min2 > nums[i]) {
                min2 = nums[i];
            }
        }
        System.out.print(max1 + " " + max2 + " " + max3 + " " + min1 + " " + min2 + " ");
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int currentSum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            while (currentSum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                currentSum -= nums[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static int[] seperateZero(int[] nums) {

        int slow = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[slow] = nums[i];
                slow++;
            }
         }
        for (int i = slow; i < nums.length; i++) {
            nums[slow] = 0;
        }
        return nums;
    }
    public static String reverseSubString(String word, char ch){
        String result = "";

        int index = -1;
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == ch){
                index = i;
                break;
            }
        }
        result = word.substring(0, index+1);
        String reversedMiddle = String.valueOf(new StringBuilder(result).reverse());
        result = reversedMiddle+ word.substring(index+1, word.length());
        return index == -1 ? word : result;
    }
    public static boolean rotateString(String s, String goal){
        for (int i = 0; i < s.length(); i++) {
            if(s.equals(goal)){
                return true;
            }else{
                char ch = s.charAt(s.length()-1);
                StringBuilder sb = new StringBuilder(s);
                sb.deleteCharAt(s.length()-1);
                s = ch + sb.toString();
                if(s.equals(goal)){
                    return true;
                }
            }
        }

        return false;
    }

}
