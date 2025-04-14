public class RungeKuttaMethod {

    // Define the differential equation dy/dx = f(x, y)
    public static double f(double x, double y) {
        return x + y;  // Example: dy/dx = x + y
    }

    // Runge-Kutta 4th Order Method implementation
    public static void rungeKutta4(double x0, double y0, double h, int steps) {
        System.out.println("Step\t\tx\t\ty");

        for (int i = 0; i <= steps; i++) {
            System.out.printf("%d\t\t%.4f\t%.6f%n", i, x0, y0);

            double k1 = h * f(x0, y0);
            double k2 = h * f(x0 + h / 2, y0 + k1 / 2);
            double k3 = h * f(x0 + h / 2, y0 + k2 / 2);
            double k4 = h * f(x0 + h, y0 + k3);

            y0 = y0 + (k1 + 2 * k2 + 2 * k3 + k4) / 6;
            x0 = x0 + h;
        }

        System.out.printf("\nFinal value at x = %.4f is y = %.6f%n", x0, y0);
    }

    public static void main(String[] args) {
        double x0 = 0;     // Initial x
        double y0 = 1;     // Initial y
        double h = 0.2;    // Step size
        int steps = 5;     // Number of steps

        rungeKutta4(x0, y0, h, steps);
    }
}
