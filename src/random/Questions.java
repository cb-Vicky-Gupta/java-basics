package random;

import java.util.HashMap;

public class Questions {
    static void main() {
        int [] arr = {10,2,5,3};
        System.out.println(checkIfExist(arr));
    }
    public static int xorOperation(int n, int start) {
        int result = 0;
        int i = 0;
        while(n>0){
            result ^=start + 2 * i;
//            System.out.println(result);
            n--;
            i++;
        }
        return result;
    }
    public static int subtractProductAndSum(int n){
        int sum = 0;
        int product = 1;
        while(n>0){
            int rem = n%10;
            sum+=rem;
            product*=rem;
            n/=10;
        }
        return product-sum;
    }
    public static boolean checkIfExist(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<arr.length; i++){
            map.put(arr[i], i);
        }
        for(int i = 0; i<arr.length; i++){
            if(map.containsKey(2*arr[i]) && i != map.get(2*arr[i])){
                return true;
            }
        }
        return false;
    }
}
