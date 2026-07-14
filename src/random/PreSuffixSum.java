package random;

import java.util.*;

public class PreSuffixSum {
    static void main() {
        int [] arr = {7,7,7,7};
        String[] strArr = {"X++","++X","--X","X--"};
        int [] startTime = {4}, endTime = {4};
        int queryTime = 4;
        System.out.println(smallerNumbersThanCurrent(arr));
    }
    public static int[] runningSum(int [] nums){
        int [] arr = new int [nums.length];
        int sum = 0;
        for(int i = 0; i<nums.length; i++){
            sum+=nums[i];
            arr[i] = sum;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        return arr;
    }
    public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for(int i = 0; i<startTime.length; i++){
            if(startTime[i] <= queryTime && queryTime <= endTime[i]){
                count++;
            }
        }
        return count;
    }
    public static int minStartValue(int[] nums) {
        int min_num = 1;
        int sum = 0;
        for(int i = 0; i<nums.length; i++){
            sum+=nums[i];
            if(sum<=0){
                min_num = Math.max(Math.abs(sum)+1, min_num);
            }
        }
        return min_num;
    }
    public static int pivotIndex(int[] nums) {
        int [] prefix = new int [nums.length+1];
        int [] suffix = new int [nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i+1] = nums[i] + prefix[i];
        }
        for (int i = nums.length-1; i >=0; i--) {
            suffix[i] = suffix[i+1] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if(prefix[i] == suffix[i+1]){
                return i;
            }
        }
        return -1;
    }
    public static int[] leftRightDifference(int[] nums) {
        int total = 0;
        int [] result = new int [nums.length];
        for (int num : nums){
            total+=num;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            leftSum+=nums[i]; // left sum
            int rightSum = total -leftSum;
            int left = leftSum - nums[i];
            result[i] = Math.abs(left-rightSum);
        }
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        return result;
    }
    public static  int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for(String s : operations){
            if(Objects.equals(s, "++X") || Objects.equals(s, "X++")){
                x++;
            }else{
                x--;
            }
        }
        return x;
    }
    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        for (int i = 0; i < items.size(); i++) {
            List<String> list = items.get(i);
            for (int j = 0; j < list.size(); j++) {
                if(list.contains(ruleKey) && list.contains(ruleValue)){
                    return i;
                }
            }
        }
        return -1;
    }
    public static int sumOddLengthSubarrays(int[] arr) {
        int [] prefix = new int[arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            prefix[i+1] = prefix[i]+arr[i];
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if((j-i)%2 == 0){
                    sum+= prefix[j+1]-prefix[i];
                }
            }
        }
        return sum;
    }
    public static int findMiddleIndex(int[] nums) {
        int [] prefix = new int [nums.length+1];
        int [] suffix = new int [nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i+1] = nums[i] + prefix[i];
        }
        for (int i = nums.length-1; i >=0; i--) {
            suffix[i] = suffix[i+1] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if(prefix[i] == suffix[i+1]){
                return i;
            }
        }
        return -1;
    }
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        //brute force
        int [] result =new int [nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if(nums[i]>nums[j] && i !=j){
                    count++;
                }
            }
            result[i] = count;
        }
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        return result;
    }

    public static class Factors {
    }
}
