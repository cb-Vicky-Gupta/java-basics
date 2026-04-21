package _01math;

public class CalculatePower {
    // 3^6 = 3*3*3*3*3*3
    // brute force fun loop for 6 times if n then n times
    static void main() {
        System.out.println(power(2,3));
    }
    static int  calPower(int base, int pow){
        int power = 1;
        for (int i = 0; i < pow; i++) {
            power *= base;
        }
        return  power;
        // Time Complexity = O(n)
    }

    // binary expontential
    // a^2 = a*a
    // a^4 = a^2 * a^2
    // a^8 = a^4 * a^4  --> for calculation of a^8 needs only 3 steps
    // If b is even → a^b = (a^(b/2))^2 — split in half, square it
    // If b is odd → a^b = a * a^(b-1) — peel one out, then split

//usiing while loop
    static public int power(int a, int b) {
        int result = 1;

        while (b > 0) {
            if (b % 2 == 1) {       // if current bit is 1
                result *= a;        // multiply this power into result
            }
            a *= a;                 // square a for next bit
            b /= 2;                 // shift to next bit
        }

        return result;
        // Time complexity O(log(b))
    }

    // recursion
//    static public int power(int a, int b) {
//        if (b == 0) return 1;        // anything^0 = 1
//
//        if (b % 2 == 0) {
//            int half = power(a, b/2);
//            return half * half;      // don't write power(a, b/2) * power(a, b/2)
//        } else {
//            return a * power(a, b-1);
//        }
//    }
}
