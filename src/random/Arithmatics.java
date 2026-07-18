package random;

public class Arithmatics {
    static void main() {
        System.out.println(getLucky("zbax", 2));
    }
    public static int pivotInteger(int n) {
        int total = 0;
        for(int i = 1; i<=n;i++){
            total+=i;
        }

        int lastSum = 0;
        for(int i=n; i>=1; i--){
            lastSum+=i;
            int result = total + i - lastSum;

            if(result == lastSum){
                return i;
            }
        }
        return -1;
    }
    public static  int totalMoney(int n) {
        int round = (n/7)+1;
        int lastRound = n%7;
        int balance = 0;
        for (int i = 0; i < round; i++) {
            int j = 1;
            int start = j+i;
            if(i+1 < round){
                while (j<=7){
                    balance+=start;
                    j++;
                    start++;
                }
            }else{
                while (j<=lastRound){
                    balance+=start;
                    j++;
                    start++;
                }
            }

        }
        return balance;
    }
    public static int getLucky(String s, int k) {
//        System.out.println('a'-'a'+1);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)-'a'+1 <= 10){
                sum+=s.charAt(i)-'a'+1;
            }else{
                sum+=digitSum(s.charAt(i)-'a'+1);
            }

        }
        while(k>1){
            sum =  digitSum(sum);
           k--;
        }
        return sum;
    }
    public static int digitSum(int num){
        int sum = 0;
        while(num>0){
            int rem = num%10;
            sum+=rem;
            num/=10;
        }
        return sum;
    }
}
