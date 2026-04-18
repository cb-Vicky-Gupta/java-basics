package _01math;

// if all the number appears three times and single number appears only once find that

// if the number appears at three times their set bits also appears three times
// so modulo of 3 is equals to 0
public class FindNumber {
    static void main() {
        int[] arr= {1,1,1,2,3,3,5,3,5,5};
        System.out.println(findIthBit(arr));

    }
    static public int findIthBit(int[] nums){
        int result = 0;
        for (int i = 0; i < 32; i++) { // check each bit position
           int bitCount = 0;
            for (int num : nums) {
                if((num>>i & 1 ) == 1){  // is the i-th bit set?
                    bitCount++;
                }
            }
            if(bitCount%3 != 0){  // leftover bit → belongs to answer
                result = result | (1<<i); // set that bit in result
            }
        }
        return result;
    }
}

