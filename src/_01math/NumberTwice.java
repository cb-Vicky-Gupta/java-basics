package _01math;

public class NumberTwice {
    // XOR Rule
    // a^a = 0
    // a^0 = a
    // a^1 = ~a

    static void main() {
        System.out.println(numberTwice());
    }
    public static int numberTwice(){
        int[] arr = {2,3,2,4,5,4,5};
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans^=arr[i];
        }
        return ans;
    }
//    private static int bruteForce(){
//        int[] arr = {2,3,2,4,5,4,5};
//        int ans = 0;
//        // first sort the array and then check if adjacent number is not same then return
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i; j < arr.length; j++) {
//                if(arr[i] < arr[j]){
//
//                }
//            }
//
//        }
//        return  ans;
//    }
}
