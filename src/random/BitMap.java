package random;

public class BitMap {
    static void main() {
        System.out.println(square(4));
    }
    public static boolean isPower(int n, int base) {
        if (n <= 0 || base <= 1) return false;

        while (n % base == 0) {
            n /= base;
        }

        return n == 1;
    }
    public static boolean perfectSquare(int n){
        int s = 0, e = n;
        while(s<=e){
            int m = s+(e-s)/2;
            long sq = (long) m * m;
            if(sq == n) return true;
            else if( sq < n) s = m+1;
            else e = m-1;
        }
        return false;
    }
    public static int square(int n){
        int s = 0, e = n;
        int root = 0;
        while(s<=e){
            int m = s+(e-s)/2;
            long sq = (long) m * m;
            long sq2 = (long) (m+1)*(m+1);
            if(sq < n && sq2 > n) {
                root = m;
                break;
            }
            if(sq == n){
                root = m;
                break;
            }
            else if( sq < n) s = m+1;
            else e = m-1;
        }
        return root;
    }
}
