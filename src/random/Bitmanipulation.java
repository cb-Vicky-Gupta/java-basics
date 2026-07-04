package random;

public class Bitmanipulation {
    static void main() {
        System.out.println(complement(11));
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
}
