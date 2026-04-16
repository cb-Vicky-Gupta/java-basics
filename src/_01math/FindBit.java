package _01math;

public class FindBit {
    static void main() {
        System.out.println(ithBit(10, 3));
        // 10 - 1010
    }
    public static int ithBit(int num, int n){
        // 11101 if this is the number and we need to find 3rd bit ans will be 1
        // so for it we need to remove last 2 bit and then we can get the 3rd
        // if we and with remaining number then we get last bit like this
        // after removing last 2 bit number will be 111
        // then 111 & 001 now we can get the last bit that is 1
        // for removing last n-1 bit we need to apply right shift operator n-1 times
        for (int i = 0; i < n-1; i++) {
            num = num>>1;
        }
        return  num&1;
    }
}
