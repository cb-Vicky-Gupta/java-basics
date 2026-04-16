package arrays;

public class LinearSearch {
    static void main() {
        int[] arr = {1,4,4,5,2,98};
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==98){
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}
