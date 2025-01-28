import java.util.Scanner;

public class BisectionMethod {
    static double function(double x){
        return (Math.pow(x, 3) - x - 2);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the value of initial guess: ");
        double a = in.nextDouble();
        double b = in.nextDouble();
        double tolerance = 0.0001;
        double c = 0;
        // Algorithm to be executed
        while(Math.abs((a - b) / b) > tolerance){
            c = (a + b) / 2;
            if(function(a) * function(c) > 0){
                a = c;
            }
            else{
                b = c;
            }
        }
        System.out.println("Root of this equation is " + c);
    }
}
