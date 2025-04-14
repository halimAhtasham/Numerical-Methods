public class TrapezoidalRule {

    // Define the function f(x) you want to integrate
    public static double f(double x) {
        return x * x;  // Example: f(x) = x^2
    }

    // Method to compute integral using Trapezoidal Rule
    public static double trapezoidal(double a, double b, int n) {
        double h = (b - a) / n;  // Width of each interval
        double sum = f(a) + f(b);  // First and last terms

        for (int i = 1; i < n; i++) {
            double xi = a + i * h;
            sum += 2 * f(xi);
        }

        return (h / 2) * sum;
    }

    public static void main(String[] args) {
        double a = 0;     // Lower limit
        double b = 4;     // Upper limit
        int n = 10;       // Number of subintervals

        double result = trapezoidal(a, b, n);
        System.out.printf("Approximate integral from %.2f to %.2f is: %.6f%n", a, b, result);
    }
}
