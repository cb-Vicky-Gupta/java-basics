package _01math;

public class ResetBit {
    //formula num & ~(1 << i)
    //1 << i → creates a number with only the i-th bit set
    //~(1 << i) → flips it → all 1s except i-th bit is 0
    //num & that → keeps all bits same except i-th bit becomes 0
    static void main() {
        int num = 10; // 1010
        int i = 1;

        int result = resetBit(num, i);
        System.out.println(result); // Output: 8 (1000)
    }
    static public int resetBit(int num, int k){
        return num & ~(1 << k);
    }
}
