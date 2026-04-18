package _01math;

public class MagicNumber {
    // find nth magic number
    static void main() {
        System.out.println(findMagic(5));
    }
    static  public int findMagic(int num){
        int sum=0;
        int base = 5;

        while(num>0){
            int last = num & 1;
            num = num>>1;
            sum+= last*base;
            base*=5;
        }
        return  sum;
    }
}
