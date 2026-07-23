package random;

public class Binary {

    private static int pick;

    private static int guess(int num) {
        return Integer.compare(pick, num);
    }

    public static int guessNumber(int n) {
        int low = 1, high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int result = guess(mid);
            if (result == 0) {
                return mid;
            } else if (result < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
    public static int findPositiveMax(int [] nums) {
        if(nums[0] >0 && nums[nums.length-1] >0) return 0;
        if(nums[0] <0 && nums[nums.length-1] <0) return nums.length;
        if(nums.length == 1 && nums[0] >0){
            return 0;
        }
        if(nums.length == 1 && nums[0] <0){
            return 1;
        }
        int low = 0, high = nums.length-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if(mid==0){
            }
            if (nums[mid]>=0 && nums[mid+1] <0) {

                return nums.length-(mid+1);
            } else if (nums[mid] >0) {
                low = mid + 1;
            } else {

                high= mid - 1;
            }
        }
        return 0;
    }
    public static int countNegatives(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
//            System.out.println(findPositiveMax(grid[i]));
            count +=findPositiveMax(grid[i]);
        }
        return count;
    }

    public static void main(String[] args) {
//        int [][] mat = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
//        [[3,-1,-3,-3,-3],[2,-2,-3,-3,-3],[1,-2,-3,-3,-3],[0,-3,-3,-3,-3]]
        int [][] mat = {{3,-1,-3,-3,-3},{2,-2,-3,-3,-3}, {1,-2,-3,-3,-3}, {0,-3,-3,-3,-3}};
//        System.out.println(countNegatives(mat));
        System.out.println(findPositiveMax(mat[3]));
    }
}
