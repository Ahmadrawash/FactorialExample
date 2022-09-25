public class Main {
    public static void main(String args[])
    {
        for(int i = 1 ; i <=5 ; i++)
        System.out.println("factorial of " + i + " is " + Factorial(i));
    }
    public static int Factorial (int n)
    {
        if (n < 2)
            return n;
        return n * Factorial(n-1);
    }
}


