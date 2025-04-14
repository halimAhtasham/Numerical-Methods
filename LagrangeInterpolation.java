public class LagrangeInterpolation {

    // Function to perform Lagrange Interpolation
    public static double lagrangeInterpolation(double[] x, double[] y, double xp) {
        double yp = 0;
        int n = x.length;

        for (int i = 0; i < n; i++) {
            double term = y[i];
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    term *= (xp - x[j]) / (x[i] - x[j]);
                }
            }
            yp += term;
        }

        return yp;
    }

    public static void main(String[] args) {
        // Known data points
        double[] x = {5, 6, 9, 11};
        double[] y = {12, 13, 14, 16};

        double xp = 10;  // Point to interpolate

        double yp = lagrangeInterpolation(x, y, xp);
        System.out.printf("Estimated value at x = %.2f is y = %.4f%n", xp, yp);
    }
}
