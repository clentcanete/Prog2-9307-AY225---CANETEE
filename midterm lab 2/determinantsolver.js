/**
 * ===============================================
 * 3x3 MATRIX DETERMINANT SOLVER
 * Student: Clent Cañete
 * Course: Programming 2 (BSCS)
 * Assignment: Linear Algebra - Assignment 01
 * Date: 2026
 *
 * Description:
 * Computes the determinant of a 3x3 matrix using
 * cofactor expansion and prints step-by-step output.
 * ===============================================
 */

// Hardcoded matrix
const matrix = [
  [3, 5, 2],
  [1, 4, 3],
  [2, 1, 5]
];

// Print matrix
function printMatrix() {
  console.log("===================================================");
  console.log("  3x3 MATRIX DETERMINANT SOLVER");
  console.log("  Student: Clent Cañete");
  console.log("  Assigned Matrix:");
  console.log("===================================================");

  matrix.forEach(row => {
    console.log(`  | ${row[0]} ${row[1]} ${row[2]} |`);
  });

  console.log("===================================================");
}

// Compute 2x2 determinant
function computeMinor(a, b, c, d) {
  return (a * d) - (b * c);
}

// Solve determinant
function solveDeterminant() {
  console.log("\nExpanding along Row 1:\n");

  // Minors
  const m11 = computeMinor(4, 3, 1, 5);
  console.log(`Step 1 — Minor M11: (4×5) - (3×1) = 20 - 3 = ${m11}`);

  const m12 = computeMinor(1, 3, 2, 5);
  console.log(`Step 2 — Minor M12: (1×5) - (3×2) = 5 - 6 = ${m12}`);

  const m13 = computeMinor(1, 4, 2, 1);
  console.log(`Step 3 — Minor M13: (1×1) - (4×2) = 1 - 8 = ${m13}`);

  // Cofactors
  const c11 = (+1) * matrix[0][0] * m11;
  const c12 = (-1) * matrix[0][1] * m12;
  const c13 = (+1) * matrix[0][2] * m13;

  console.log("\nCofactors:");
  console.log(`C11 = (+1) × 3 × ${m11} = ${c11}`);
  console.log(`C12 = (-1) × 5 × ${m12} = ${c12}`);
  console.log(`C13 = (+1) × 2 × ${m13} = ${c13}`);

  const determinant = c11 + c12 + c13;

  console.log(`\ndet(M) = ${c11} + (${c12}) + ${c13}`);

  console.log("===================================================");
  console.log(`  ✓ DETERMINANT = ${determinant}`);
  console.log("===================================================");

  if (determinant === 0) {
    console.log("The matrix is SINGULAR — it has no inverse.");
  }
}

// Run program
printMatrix();
solveDeterminant();