package _01math;

public class FindNoOfSetBits {
    static void main() {
        System.out.println(countSetBitsMethodTwo(7));
    }
    static int methodOneSetBit(int num){
        int count = 0;
        while(num>0){
            if((num & 1) != 0){
                count++;
            }
            num>>=1;
        }
        return count;
    }
    // method 2
//    Idea Behind n & -n
//    n & -n isolates the rightmost set bit (1) in a number.
//    Extract the rightmost set bit
//    Subtract it from n
//    Repeat until n == 0
//    n = 12  → 1100
//            -n      → 0100 (two's complement)
//    n & -n  → 0100
    static int countSetBitsMethodTwo(int num){
        int count = 0;

        while(num > 0){
            int rightMostSetBit = num & -num;
            num = num - rightMostSetBit;
            count++;
        }

        return count;
    }
}
