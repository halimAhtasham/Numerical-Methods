public class FalsePositionMethod {

    // Define your function f(x) here
    public static double f(double x) {
        return x * x * x - x - 2;  // Example: f(x) = x^3 - x - 2
    }

    public static void falsePosition(double a, double b, double tolerance, int maxIterations) {
        if (f(a) * f(b) >= 0) {
            System.out.println("The function has the same sign at points a and b.");
            return;
        }

        double c = a;
        int iteration = 0;

        System.out.println("Iter\t\ta\t\tb\t\tc\t\tf(c)");

        while (iteration < maxIterations) {
            // Calculate c using the false position formula
            c = (a * f(b) - b * f(a)) / (f(b) - f(a));
            double fc = f(c);

            // Output current iteration values
            System.out.printf("%d\t\t%.6f\t%.6f\t%.6f\t%.6f%n", iteration + 1, a, b, c, fc);

            // Check if root is found
            if (Math.abs(fc) < tolerance) {
                break;
            }

            // Update interval
            if (f(a) * fc < 0) {
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
        double tolerance = 1e-6;        // Tolerance level
        int maxIterations = 100;        // Maximum number of iterations

        falsePosition(a, b, tolerance, maxIterations);
    }
}
