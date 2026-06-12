package random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ArrayNew {
    static void main() {
        int[] arr = {2,4,9,3};
        int k =-2;
        int [] arrN = decrypt(arr, k);
        for (int i = 0; i < arrN.length; i++) {
//            System.out.print(arrN[i] + " ");
        }
        System.out.println(countGoodSubstrings("owuxoelszb"));

    }
    public static int maxVowels(String s, int k) {
        List<Character> list = new ArrayList<>(Arrays.asList('a','e','i','o','u'));
        int count = 0;
        for (int i = 0; i <k; i++) {
            if(list.contains(s.charAt(i))){
                count++;
            }
        }
        int max = count;
        for (int i = k; i < s.length(); i++) {

            if(list.contains(s.charAt(i))){
                max++;
            }
            if(list.contains(s.charAt(i-k))){
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

            if(nums[i] == 1){
                reset++;
                if(count<reset){
                    count++;
                }
            }else{
                reset = 0;
            }
        }
        return count;
    }
    public static int[] decrypt(int[] code, int k) {
        int [] arr = new int[code.length];
        for (int i = 0; i < code.length; i++) {
            arr[i] = makeArraysum(code, k , i);
        }
        return arr;
    }
    public static int makeArraysum(int [] arr, int k, int i){
        int sum = 0;
        int n = arr.length;
        if(k == 0){
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
}
