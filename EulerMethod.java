public class EulerMethod {

    // Define the differential equation dy/dx = f(x, y)
    public static double f(double x, double y) {
        return x + y;  // Example: dy/dx = x + y
    }

    // Euler's Method implementation
    public static void euler(double x0, double y0, double h, int steps) {
        System.out.println("Step\t\tx\t\ty");

        for (int i = 0; i <= steps; i++) {
            System.out.printf("%d\t\t%.4f\t%.4f%n", i, x0, y0);

            y0 = y0 + h * f(x0, y0);  // Euler formula: y1 = y0 + h*f(x0, y0)
            x0 = x0 + h;
        }

        System.out.printf("\nFinal value at x = %.4f is y = %.6f%n", x0, y0);
    }

    public static void main(String[] args) {
        double x0 = 0;     // Initial x
        double y0 = 1;     // Initial y: y(x0) = y0
        double h = 0.2;    // Step size
        int steps = 5;     // Number of steps

        euler(x0, y0, h, steps);
    }
}
