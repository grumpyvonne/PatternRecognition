//Автор: Шурпач Ольга, группа 621702
import java.util.ArrayList;
import java.util.List;

public class Pattern {
    private Matrix patternMatrix;
    private Matrix vector;
    private String[] string;

    public Pattern(String[] string) {
        this.string = string;
        convertToBipolarMatrix();
    }

    private void convertToBipolarMatrix() {
        int[][] symbols = new int[string.length][string[0].length()];
        patternMatrix = new Matrix(symbols);
        for (int lines = 0; lines < string.length; lines++) {
            String line = string[lines];
            for (int col = 0; col < line.length(); col++) {
                if (line.charAt(col) == '#') {
                    patternMatrix.getMatrix()[lines][col] = 1;
                } else if (line.charAt(col) == '.') {
                    patternMatrix.getMatrix()[lines][col] = -1;
                }
            }
        }
        convertToVector();
    }

    private void convertToVector() {
        int[][] elements = new int[1][string.length * string[0].length()];
        vector = new Matrix(elements);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < patternMatrix.getMatrix().length; i++) {
            for (int j = 0; j < patternMatrix.getMatrix()[0].length; j++) {
                list.add(patternMatrix.getMatrix()[i][j]);
            }
        }
        for (int el = 0; el < vector.getMatrix()[0].length; el++) {
            vector.getMatrix()[0][el] = list.get(el);
        }
    }

    public void printPattern() {
        for (int lines = 0; lines < string.length; lines++) {
            String line = string[lines];
            for (int column = 0; column < line.length(); column++) {
                System.out.print(line.charAt(column));
            }
            System.out.println("");
        }
        System.out.println("\n");
    }

    public Matrix getPatternMatrix() {
        return patternMatrix;
    }

    public Matrix getVector() {
        return vector;
    }
}
