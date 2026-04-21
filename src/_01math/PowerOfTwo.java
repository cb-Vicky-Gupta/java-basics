package _01math;

public class PowerOfTwo {
    // 8 = 2^3 == 100
    // right shift the number till the number is 0 and count 1
    // if count is == 1 then it is power of two else not
    static void main() {
        System.out.println(isPowerofTwoM2(8));
        System.out.println(isPowerofTwo(8));
    }
    static boolean isPowerofTwo(int num){
        int count = 0;
        while(num>0){
            int rightBit = num & 1;
            if(rightBit == 1){
                count++;
            }
            num>>=1;
        }
        return  count == 1 ? true : false;
    }

    // method 2
    static boolean isPowerofTwoM2(int num){
        return  (num & (num-1)) == 0 ? true : false;
    }
}
