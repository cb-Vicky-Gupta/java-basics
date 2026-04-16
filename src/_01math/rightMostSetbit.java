package _01math;

public class rightMostSetbit {
    // 10110100 ==> ans will br 4
    //formula num & -num
    // 10=> 1010
    static void main() {
        System.out.println(rightMostSetBit(10));
    }
    static public int rightMostSetBit(int num){
        return num & (-num);
    }
}
