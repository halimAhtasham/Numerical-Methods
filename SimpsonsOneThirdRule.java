public class SimpsonsOneThirdRule {

    // Define the function f(x) you want to integrate
    public static double f(double x) {
        return x * x;  // Example: f(x) = x^2
    }

    // Simpson's 1/3 Rule implementation
    public static double simpsonsOneThird(double a, double b, int n) {
        if (n % 2 != 0) {
            System.out.println("Error: n must be even for Simpson's 1/3 Rule.");
            return -1;
        }

        double h = (b - a) / n;
        double sum = f(a) + f(b);

        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            if (i % 2 == 0) {
                sum += 2 * f(x);  // Even index
            } else {
                sum += 4 * f(x);  // Odd index
            }
        }

        return (h / 3) * sum;
    }

    public static void main(String[] args) {
        double a = 0;     // Lower limit
        double b = 4;     // Upper limit
        int n = 10;       // Must be even

        double result = simpsonsOneThird(a, b, n);
        if (result != -1) {
            System.out.printf("Approximate integral from %.2f to %.2f is: %.6f%n", a, b, result);
        }
    }
}
