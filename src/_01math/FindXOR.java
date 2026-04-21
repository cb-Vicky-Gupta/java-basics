package _01math;

public class FindXOR {
    // find XOR of numbers from0 to a
    // a | XOR
    // 0 | 0^0 = 0
    // 1 | 0^1 = 1
    // 2 | 0^1^2 = 3
    // 3 | 0^1^2^3 = 0
    // 4 | 0^1^2^3^4 = 4
    // 5 | 0^1^2^3^4^5 = 1
    // 6 | 0^1^2^3^4^5^6 = 7
    // 7 | 0^1^2^3^4^5^6^7 = 0
    // 8 | 0^1^2^3^4^5^6^7^8 = 8
    // 9 | 0^1^2^3^4^5^6^7^8^9 = 1
    // 10 | 0^1^2^3^4^5^6^7^8^9^10 =

    // **** Pattern ****
    // a%4 = 0   | a
    // a%4 = 1   | 1
    // a%4 = 2   | a+1
    // a%4 = 3   | 0
    static int xorFrom0ToA(int a){
        if(a % 4 == 0) return a;
        if(a % 4 == 1) return 1;
        if(a % 4 == 2) return a + 1;
        return 0; // when a % 4 == 3
    }

    public static void main(String[] args) {
        System.out.println(xorFrom0ToA(10)); // Output: 11
    }
}
