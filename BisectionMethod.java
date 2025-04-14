public class BisectionMethod {

    // Define the function f(x) here
    public static double f(double x) {
        return x * x * x - x - 2;  // Example: f(x) = x^3 - x - 2
    }

    public static void bisection(double a, double b, double tolerance, int maxIterations) {
        if (f(a) * f(b) >= 0) {
            System.out.println("The function has the same signs at a and b. Bisection method cannot proceed.");
            return;
        }

        double c = a;
        int iteration = 0;

        while ((b - a) >= tolerance && iteration < maxIterations) {
            // Find middle point
            c = (a + b) / 2;

            // Output the current step
            System.out.printf("Iteration %d: c = %.6f, f(c) = %.6f%n", iteration + 1, c, f(c));

            // Check if c is a root
            if (f(c) == 0.0) {
                break;
            }
            // Decide the side to repeat the steps
            else if (f(c) * f(a) < 0) {
                b = c;
            } else {
                a = c;
            }

            iteration++;
        }

        System.out.printf("Approximate root after %d iterations: %.6f%n", iteration, c);
    }

    public static void main(String[] args) {
        double a = 1, b = 2;            // Interval [a, b]
        double tolerance = 1e-6;        // Accuracy tolerance
        int maxIterations = 100;        // Safety stop
        bisection(a, b, tolerance, maxIterations);
    }
}
