package random;

import java.util.HashMap;

public class Bitmanipulation {
    static void main() {
//        System.out.println(reverseBits(43261596));
        int [] arr = {6,2,7,3};
        int first = 4;
        int[] ans = decode(arr, first);
        for (int i = 0; i <ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
    public static int complement(int n){
        int num = 0, power = 1;
        while(n>0){
            int bit = n & 1;
            System.out.println("Bit is : " + bit);
            if(bit ==1){
                bit = 0;
            }else bit =1;
            System.out.println(num + " " + bit + " "  + power );
            num = num + bit * power;
            power*=2;
            n=n>>1;
        }
        return num;
    }
    public static boolean hasAlternatingBits(int n) {
        int first = -1, count = 0;
        while(n>0){
            int bit = n & 1;
            System.out.println(bit + " " + count);

            if(count != 0 && first == bit){
                return false;
            }
            first = bit;
            count++;
            n = n>>1;
        }
        return true;
    }
    public static int rangeBitwise(int left, int right) {
        int shiftCount = 0;
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shiftCount++;
        }
        return left << shiftCount;
    }
    public static  String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        char[] hexChars = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        StringBuilder result = new StringBuilder();
    //    while (num>0){
    //        int rem = num%16;
    //        result.insert(0, hexChars[rem]);
    //        num/=16;
    //    }
        for (int i = 0; i < 8 && num != 0; i++) {
            int rem = num & 15;
            result.insert(0, hexChars[rem]);
            num >>= 4;
        }
        return result.toString();
    }
    public static int reverseBits(int n){
        int result = 0;
        long coeff = (long) Math.pow(2,31);
        for (int i = 31; i > 0; i--) {
            int rem = n&1;
            result+= rem * coeff;

            n>>=1;
            coeff/=2;
        }
        return result;
    }
    public static int[] decode(int[] encoded, int first) {
        int [] result = new int[encoded.length+1];
        result[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            int number = result[i]^encoded[i];
            result[i+1] = number;
        }
        return result;
    }
}
