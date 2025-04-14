public class SimpsonsThreeEighthRule {

    // Define the function f(x) to integrate
    public static double f(double x) {
        return x * x;  // Example: f(x) = x^2
    }

    // Simpson's 3/8 Rule Implementation
    public static double simpsonsThreeEighth(double a, double b, int n) {
        if (n % 3 != 0) {
            System.out.println("Error: n must be a multiple of 3 for Simpson's 3/8 Rule.");
            return -1;
        }

        double h = (b - a) / n;
        double sum = f(a) + f(b);

        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            if (i % 3 == 0) {
                sum += 2 * f(x);  // Every 3rd term
            } else {
                sum += 3 * f(x);  // All other terms
            }
        }

        return (3 * h / 8) * sum;
    }

    public static void main(String[] args) {
        double a = 0;     // Lower limit
        double b = 6;     // Upper limit
        int n = 6;        // Number of subintervals (must be multiple of 3)

        double result = simpsonsThreeEighth(a, b, n);
        if (result != -1) {
            System.out.printf("Approximate integral from %.2f to %.2f is: %.6f%n", a, b, result);
        }
    }
}
