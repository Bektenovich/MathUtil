public class MathUtil{
    // Static Methods
    /**
     * Checks whether a given number n is prime.
     * @param n the number to check
     * @return true if n is prime, otherwise false
     */
    public static boolean isPrime(int n){
        if(n<=1) return false;
        for(int i=2; i<=Math.sqrt(n); i++){
            if (n%i==0) return false;
        }
        return true;
    }
    /**
     * Calculates the greatest common divisor (GCD) of two integers using the Euclidean algorithm.
     * @param a first integer
     * @param b second integer
     * @return the GCD of a and b
     */
    public static int gcd(int a, int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    /**
     * Computes the least common multiple (LCM) of two numbers.
     * @param a first integer
     * @param b second integer
     * @return the LCM of a and b
     */
    public static int lcm(int a, int b){
        return (a*b) /gcd(a,b);
    }
    /**
     * Returns the nth Fibonacci number.
     * @param n the position in the Fibonacci sequence
     * @return the nth Fibonacci number
     */
    public static int fibonacci(int n){
        if(n<=0) return 0;
        if(n==1) return 1;
        int a = 0, b = 1;
        for(int i=2; i<=n; i++){
            int temp=a+b;
            a=b;
            b=temp;
        }
        return b;
    }
    /**
     * Calculates the factorial of a number n.
     * @param n the number to calculate the factorial for
     * @return the factorial of n
     */
    public static long factorial(int n){
        if(n<0) throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        long result=1;
        for(int i=2;i<=n; i++) {
            result*=i;
        }
        return result;
    }
    // Non-static Methods
    /**
     * Determines if the given number n is a perfect number.
     * @param n the number to check
     * @return true if n is perfect, otherwise false
     */
    public boolean isPerfectNumber(int n) {
        if (n <= 1) return false;
        int sum = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum == n;
    }

    /**
     * Computes the sum of the digits of the given number n.
     * @param n the number to compute the sum of digits
     * @return the sum of the digits of n
     */
    public int sumOfDigits(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    /**
     * Reverses the digits of a number n.
     * @param n the number to reverse
     * @return the number formed by reversing the digits of n
     */
    public int reverseNumber(int n) {
        int reversed = 0;
        while (n != 0) {
            reversed = reversed * 10 + n % 10;
            n /= 10;
        }
        return reversed;
    }

    /**
     * Checks if a number is an Armstrong number.
     * @param n the number to check
     * @return true if n is an Armstrong number, otherwise false
     */
    public boolean isArmstrongNumber(int n) {
        int original = n, sum = 0, digits = String.valueOf(n).length();
        while (n != 0) {
            int digit = n % 10;
            sum += Math.pow(digit, digits);
            n /= 10;
        }
        return sum == original;
    }

    /**
     * Finds the smallest prime number greater than n.
     * @param n the number to find the next prime for
     * @return the next prime number after n
     */
    public int nextPrime(int n) {
        int next = n + 1;
        while (!isPrime(next)) {
            next++;
        }
        return next;
    }

    // Main Method to Test the Methods
    public static void main(String[] args) {
        // Test static methods
        System.out.println("Static Method Tests:");
        System.out.println("isPrime(5): " + MathUtil.isPrime(5)); // true
        System.out.println("gcd(48, 18): " + MathUtil.gcd(48, 18)); // 6
        System.out.println("lcm(4, 6): " + MathUtil.lcm(4, 6)); // 12
        System.out.println("fibonacci(5): " + MathUtil.fibonacci(5)); // 5
        System.out.println("factorial(5): " + MathUtil.factorial(5)); // 120

        // Create an object for non-static methods
        MathUtil mathUtil = new MathUtil();

        // Test non-static methods
        System.out.println("\nNon-Static Method Tests:");
        System.out.println("isPerfectNumber(6): " + mathUtil.isPerfectNumber(6)); // true
        System.out.println("sumOfDigits(123): " + mathUtil.sumOfDigits(123)); // 6
        System.out.println("reverseNumber(12345): " + mathUtil.reverseNumber(12345)); // 54321
        System.out.println("isArmstrongNumber(153): " + mathUtil.isArmstrongNumber(153)); // true
        System.out.println("nextPrime(10): " + mathUtil.nextPrime(10)); // 11
    }
}
