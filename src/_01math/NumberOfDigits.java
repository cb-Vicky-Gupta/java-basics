package _01math;

public class NumberOfDigits {
    static void main() {
        System.out.println(withBaseN(10,2));
    }
    static public int withBaseN(int num, int base) {
        if (num == 0) return 1;

        int count = 0;
        while (num != 0) {
            num /= base;
            count++;
        }
        return count;
    }
}
// 10 1010
