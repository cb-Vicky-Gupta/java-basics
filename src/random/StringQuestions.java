package random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class StringQuestions {
    static String allowed = "cad";
    static String [] words = {"cc","acd","b","ba","bac","bad","ac","d"};
    static void main() {
        System.out.println(countConsistentStrings(allowed, words));
    }
    public static Boolean checkPalindrome(String s){
        int left = 0, right = s.length()-1;
        while (left<right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static Boolean checkPalindromeAlphaNumeric(String s){
        int left = 0, right = s.length()-1;
        while(left<right){
            while (left<right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while (left<right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static Boolean isValidPalindrome(String s){
        int left = 0, right = s.length()-1;
        while(left <right){
            if(s.charAt(left) != s.charAt(right)){
                return isRange(s, left+1, right) || isRange(s, left, right-1);
            }
            left++;
            right--;
        }
        return true;
    }
    public static Boolean isRange(String s, int left, int right){
        while (left < right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    public static String longestPalindrome(String s){
        if(s.length()<2) return s;
        int start = 0, maxLen = 1;
        for (int i = 0; i < s.length(); i++) {
            int oddLen = range(s, i, i);
            int evenLen = range(s, i, i+1);
            int len = Math.max(oddLen, evenLen);
            if(len>maxLen){
                maxLen = len;
                start = i-(len-1)/2;
            }
        }
        return s.substring(start,start+maxLen);
    }
    public static int range(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
    public static int longestPalindromeCanMade(String s){
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        AtomicInteger length = new AtomicInteger(0);
        AtomicBoolean hasOdd = new AtomicBoolean(false);
        final int[] oddLen = {0};
        map.forEach((key, value) -> {
            if (value % 2 == 0) {
                length.addAndGet(value);
            } else {
                length.addAndGet(value - 1);
                hasOdd.set(true);
            }
        });
        return length.get() + (hasOdd.get() ? 1 : 0);
    }
    public static char findTheDifference(String s, String t) {
       int [] alphaArray  = new int[26];
       int ans = -1;
        for (int i = 0; i < s.length(); i++) {
            int getIndex = s.charAt(i)-'a';
            alphaArray[getIndex] = alphaArray[getIndex]+1;
        }
        for (int i = 0; i < t.length(); i++) {
            int getIndex = t.charAt(i)-'a';
            alphaArray[getIndex] = alphaArray[getIndex]-1;
            if(alphaArray[getIndex] == -1){
                ans = getIndex;
            }
        }
       return  (char) ('a' + ans);

    }
    public static int countConsistentStrings(String allowed, String[] words) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i<allowed.length(); i++) {
            list.add(allowed.charAt(i));
        }
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if(checkString(words[i], list)){
                count++;
            }
        }
        return count;
    }
    public static Boolean checkString(String word, List list){
        for (int i = 0; i < word.length(); i++) {
            if(!list.contains(word.charAt(i))){
                return false;
            }
        }
        return true;
    }

}

