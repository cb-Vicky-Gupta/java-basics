package _01math;

public class NumberOfDigits {
    static void main() {
        System.out.println(withBaseNOptimize(10,2));
    }
    // brute force
    static public int withBaseN(int num, int base) {
        if (num == 0) return 1;

        int count = 0;
        while (num != 0) {
            num /= base;
            count++;
        }
        return count;
    }
    static public int withBaseNOptimize(int num, int base) {
       // formula int(log(base^num) +1 ===> int(log(num)/log(base)) + 1
        int result = (int)(Math.log(num)/Math.log(base))+1;
        return result;
    }
}
// 10 1010
