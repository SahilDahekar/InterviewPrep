package Arrays3;

public class Power {
    public static double myPow(double x, int n){
        return binaryExp(x, (long) n);
    }

    public static double binaryExp(double x , long n) {
        if(n == 0){
            return 1;
        }

        if(n < 0){
            return binaryExp(x, -n);
        } else if (n % 2 == 1){
            return x * binaryExp(x * x , (n - 1)/2 );
        } else {
            return binaryExp(x * x, n/2);
        }
    }
    public static void main(String[] args) {
        double x = 2.00000; 
        int n = 10;

        System.out.println(myPow(x, n));
    }
}
