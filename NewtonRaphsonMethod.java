public class NewtonRaphsonMethod {

    // Define the function f(x)
    public static double f(double x) {
        return x * x * x - x - 2;  // Example: f(x) = x^3 - x - 2
    }

    // Define the derivative f'(x)
    public static double df(double x) {
        return 3 * x * x - 1;  // Derivative: f'(x) = 3x^2 - 1
    }

    // Newton-Raphson implementation
    public static void newtonRaphson(double x0, double tolerance, int maxIterations) {
        int iteration = 0;
        double x1;

        System.out.println("Iter\t\tx\t\tf(x)");

        while (iteration < maxIterations) {
            double fx = f(x0);
            double dfx = df(x0);

            if (dfx == 0) {
                System.out.println("Zero derivative. No solution found.");
                return;
            }

            x1 = x0 - fx / dfx;

            System.out.printf("%d\t\t%.6f\t%.6f%n", iteration + 1, x0, fx);

            if (Math.abs(x1 - x0) < tolerance) {
                System.out.printf("Root found after %d iterations: %.6f%n", iteration + 1, x1);
                return;
            }

            x0 = x1;
            iteration++;
        }

        System.out.println("Exceeded maximum iterations. Approximate root: " + x0);
    }

    public static void main(String[] args) {
        double initialGuess = 1.5;     // Starting value for x
        double tolerance = 1e-6;       // Accuracy tolerance
        int maxIterations = 100;       // Maximum steps

        newtonRaphson(initialGuess, tolerance, maxIterations);
    }
}
