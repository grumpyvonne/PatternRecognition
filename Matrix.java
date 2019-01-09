//Автор: Шурпач Ольга, группа 621702
public class Matrix {
    private int rows;
    private int columns;
    private int[][] matrix;

    public Matrix(int[][] matrix) {
        rows = matrix.length;
        columns = matrix[0].length;
        for (int row = 0; row < rows; row++) {
            if (matrix[row].length != columns) {
                throw new IllegalArgumentException("Different rows' length.");
            }
        }
        this.matrix = matrix;
    }

    public Matrix transpose() {
        int[][] newMatrix = new int[columns][rows];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                newMatrix[column][row] = matrix[row][column];
            }
        }
        Matrix transposedMatrix = new Matrix(newMatrix);
        return transposedMatrix;
    }

    public Matrix add(Matrix secondMatrix) {
        checkMatrixSize(secondMatrix);
        int[][] newMatrix = new int[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                newMatrix[row][column] = matrix[row][column] + secondMatrix.matrix[row][column];
            }
        }
        Matrix resultMatrix = new Matrix(newMatrix);
        return resultMatrix;
    }


    public Matrix multiply(Matrix secondMatrix) {
        if (secondMatrix.rows != columns) {
            throw new IllegalArgumentException("Wrong size of columns and rows.");
        }
        int[][] resultMatrix = new int[rows][secondMatrix.columns];
        for (int row1 = 0; row1 < rows; row1++) {
            for (int column2 = 0; column2 < secondMatrix.columns; column2++) {
                for (int column1 = 0; column1 < columns; column1++) {
                    resultMatrix[row1][column2] += matrix[row1][column1] * secondMatrix.matrix[column1][column2];
                }
            }
        }
        Matrix result = new Matrix(resultMatrix);
        return result;
    }

    public void checkMatrixSize(Matrix matrix) {
        if (matrix.rows != rows || matrix.columns != columns) {
            throw new IllegalArgumentException("Matrices have different size.");
        }
    }


    public int[][] getMatrix() {
        return matrix;
    }
}