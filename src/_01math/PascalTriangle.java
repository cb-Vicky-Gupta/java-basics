package _01math;

public class PascalTriangle {
    static void main() {
        System.out.println(sumIthRow(3));
    }
    static public int sumIthRow (int i){
        // nC0 + nC1 + nC2 + ....nCn = 2^n
        // by observation elements of pascal triangle are binomial coefficients
        // sum nth row = 2^(n-1)


        // Math function Method 1
//        return (int) Math.pow(2, i-1);


//        Option 2: Bit shift (most efficient)
//        return 1 << i-1;  // 1 ko i positions left shift = 2^i

//        Option 3: Loop (brute force)
        int sum = 1;
        for (int j = 0; j < i-1; j++) {
            sum *= 2;    // 2 se i baar multiply karo
        }
        return sum;

    }


}
