/**
 * ===============================================
 * 3x3 MATRIX DETERMINANT SOLVER
 * Student: Clent Cañete
 * Course: Programming 2 (BSIT)
 * Assignment: Linear Algebra - Assignment 01
 * Date: 2026
 *
 * Description:
 * This program computes the determinant of a 3x3 matrix
 * using cofactor expansion along the first row.
 * It prints a step-by-step solution in a readable format.
 * ===============================================
 */

public class determinantsolver {

    // Hardcoded assigned matrix
    static int[][] matrix = {
        {3, 5, 2},
        {1, 4, 3},
        {2, 1, 5}
    };

    public static void main(String[] args) {
        printMatrix();
        solveDeterminant();
    }

    // Prints the matrix in formatted form
    public static void printMatrix() {
        System.out.println("===================================================");
        System.out.println("  3x3 MATRIX DETERMINANT SOLVER");
        System.out.println("  Student: Clent Cañete");
        System.out.println("  Assigned Matrix:");
        System.out.println("===================================================");

        for (int i = 0; i < 3; i++) {
            System.out.printf("  | %2d %2d %2d |\n",
                matrix[i][0], matrix[i][1], matrix[i][2]);
        }

        System.out.println("===================================================");
    }

    // Computes 2x2 determinant (minor)
    public static int computeMinor(int a, int b, int c, int d) {
        return (a * d) - (b * c);
    }

    // Solves determinant using cofactor expansion
    public static void solveDeterminant() {

        System.out.println("\nExpanding along Row 1:\n");

        // Step 1
        int m11 = computeMinor(4, 3, 1, 5);
        System.out.println("Step 1 — Minor M11: (4×5) - (3×1) = 20 - 3 = " + m11);

        // Step 2
        int m12 = computeMinor(1, 3, 2, 5);
        System.out.println("Step 2 — Minor M12: (1×5) - (3×2) = 5 - 6 = " + m12);

        // Step 3
        int m13 = computeMinor(1, 4, 2, 1);
        System.out.println("Step 3 — Minor M13: (1×1) - (4×2) = 1 - 8 = " + m13);

        // Cofactors
        int c11 = (+1) * matrix[0][0] * m11;
        int c12 = (-1) * matrix[0][1] * m12;
        int c13 = (+1) * matrix[0][2] * m13;

        System.out.println("\nCofactors:");
        System.out.println("C11 = (+1) × 3 × " + m11 + " = " + c11);
        System.out.println("C12 = (-1) × 5 × " + m12 + " = " + c12);
        System.out.println("C13 = (+1) × 2 × " + m13 + " = " + c13);

        int determinant = c11 + c12 + c13;

        System.out.println("\ndet(M) = " + c11 + " + (" + c12 + ") + " + c13);

        System.out.println("===================================================");
        System.out.println("  ✓ DETERMINANT = " + determinant);
        System.out.println("===================================================");

        if (determinant == 0) {
            System.out.println("The matrix is SINGULAR — it has no inverse.");
        }
    }
}