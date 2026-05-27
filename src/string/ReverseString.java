package string;

import java.util.Arrays;

public class ReverseString {
    static void main() {
//        System.out.println(reverseString("Hello);
//        System.out.println(checkPalindrome("VIV"));
//        System.out.println(countVowel("Vicky Kumar Gupta"));
//        System.out.println(removeSpace("Vicky Kumar Gupta"));
//        System.out.println(nonRepeat("vviicckky"));
//        System.out.println(checkAna("listen", "silent"));
//        System.out.println(countOccouranceChar("Vicky Kumar Gupta", 'u'));
//        System.out.println(reverseWord("I am a bad Boy"));
//        System.out.println(containsNonAlphanumeric("A man, a plan, a canal: Panama"));
        System.out.println(palindromeCheck(-121));
    }


// easy problems
//Reverse a String
    public static String reverseString(String s){
        String reverse = new StringBuilder(s).reverse().toString();
        return reverse;
    }
    //Check if a String is Palindrome
    public static Boolean checkPalindrome(String str){
        String reversed = new StringBuilder(str).reverse().toString();

        return str.equals(reversed);
    }
    //Count vowels in a String
    public static int countVowel (String str){
        int count = 0;
        String s = str.toLowerCase();
        for(char c : s.toCharArray()){
            if("aeiou".indexOf(c) != -1){
                count++;
            }
        }
        return count;
    }
    //Remove all spaces from a String
    public static String removeSpace(String s){
        // method 1
        String result = s.replace(" ", "");
        // method 2
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c != ' '){
                sb.append(c);
            }
        }
        return sb.toString();
    }
    //Find the first non-repeating character
    public static char nonRepeat(String s){
        int [] freq = new int[26];
        for(char c : s.toCharArray()){
           freq[c-'a'] ++;
        }
        for (char c : s.toCharArray()){
            if(freq[c-'a']==1){
                return c;
            }
        }
        return '-';
    }
    //Check if two Strings are Anagrams
    public static Boolean checkAna(String s1, String s2){
        if(s1.length() != s2.length()) return  false;
        char [] a = s1.toCharArray();
        char [] b = s2.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);


        return Arrays.equals(a, b);
    }
    //Count occurrences of a character
    public static int countOccouranceChar(String s, char target){
        int count = 0;

        for(char c : s.toCharArray()){
            if(c == target){
                count++;
            }
        }
        return count;
    }
    //Reverse each word in a sentence
    public static String reverseWord(String s){
        String [] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(new StringBuilder(word).reverse());
            result.append(" ");
        }
        return result.toString();
    }
    //medium problems
//    Longest Palindromic Substring

    // palindrome
    public static boolean containsNonAlphanumeric(String str) {
        StringBuilder sb = new StringBuilder();
        str = str.toLowerCase();
        for (char c : str.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }
        String original = sb.toString();
        String reversed = sb.reverse().toString();

        return original.equals(reversed);
    }
    // valid palindrome number
    public static boolean palindromeCheck(int num){

//        num = Math.abs(num);
        int original = num;
        int reverse = 0;
        while(num>0){
            int rem = num%10;
            reverse =reverse*10 + rem;
            num/=10;
        }
        return original == reverse;
    }

}

//public class LongestPalindrome {
//    public static String longestPalindrome(String s) {
//        if (s.length() < 2) return s;
//
//        int start = 0, maxLen = 1;
//
//        for (int i = 0; i < s.length(); i++) {
//            // odd length palindrome
//            int len1 = expand(s, i, i);
//            // even length palindrome
//            int len2 = expand(s, i, i + 1);
//
//            int len = Math.max(len1, len2);
//
//            if (len > maxLen) {
//                maxLen = len;
//                start = i - (len - 1) / 2;
//            }
//        }
//
//        return s.substring(start, start + maxLen);
//    }
//
//    private static int expand(String s, int left, int right) {
//        while (left >= 0 && right < s.length()
//                && s.charAt(left) == s.charAt(right)) {
//            left--;
//            right++;
//        }
//        return right - left - 1;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(longestPalindrome("babad")); // "bab"
//        System.out.println(longestPalindrome("cbbd"));  // "bb"
//    }
//}