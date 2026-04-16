package _01math;

public class OddEve {
    // every number is stored in computer in the form of binary
    // if we and with 1 and get 1 then the number will be odd if we get 0 then number will be even
    // because 1111 like this number last digit will be 1*2^0 and it will be 1 if last digit will be 1
    // so last digit must be 0 in binary for odd then only it will be factor of 2
    static void main() {
        int num = 56;
        System.out.println(isEven(num));
    }
    public static boolean isEven(int num){
        return (num & 1) != 1;
    }

}
