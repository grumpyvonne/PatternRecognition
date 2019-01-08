import java.util.ArrayList;
import java.util.List;

public class Network {
    private List<Pattern> patterns;
    private List<Matrix> listOfWeights;
    private Matrix weights;
    private int rowsXToY;
    private int columnsXtoY;
    private int rowsYToX;
    private int columnsYtoX;

    public Network() {
        patterns = new ArrayList<>();
        listOfWeights = new ArrayList<>();
    }

    public void learn() {
        int i = 0;
        while (i < patterns.size()) {
            Pattern firstPattern = patterns.get(i);
            Pattern secondPattern = patterns.get(i + 1);
            associatePair(firstPattern, secondPattern);
            i++;
            i++;
        }
        calculateWeight();
    }

    public void addPattern(Pattern pattern) {
        patterns.add(pattern);
    }

    private void associatePair(Pattern firstPattern, Pattern secondPattern) {
        Matrix S = firstPattern.getVector();
        Matrix T = secondPattern.getVector();
        Matrix W = S.transpose().multiply(T);
        this.rowsXToY = firstPattern.getPatternMatrix().getMatrix().length;
        this.columnsXtoY = firstPattern.getPatternMatrix().getMatrix()[0].length;
        this.rowsYToX = secondPattern.getPatternMatrix().getMatrix().length;
        this.columnsYtoX = secondPattern.getPatternMatrix().getMatrix()[0].length;

        listOfWeights.add(W);
    }

    private void calculateWeight() {
        int[][] array = new int[listOfWeights.get(0).getMatrix().length][listOfWeights.get(0).getMatrix()[0].length];
        weights = new Matrix(array);
        for (Matrix weightOfPair : listOfWeights) {
            weights = weights.add(weightOfPair);
        }
    }

    public void searchPatternByX(Pattern pattern) {
        int energyPast = -1;
        int energy = 0;
        int iteration = 0;
        Matrix outputFirst = outputFirstInputSecond(pattern.getVector());
        while (energy != energyPast) {
            energyPast = energy;
            Matrix outputSecond = outputSecondInputFirst(outputFirst);
            outputFirst = outputSecond.multiply(weights);
            outputFirst = activationFunction(outputFirst);
            energy = calculateEnergy(outputFirst, outputSecond);
            iteration++;
        }
//        outputFirst.print();
        System.out.println("Restored pattern: ");
        printPatternY(outputFirst);
        System.out.println("Number of iterations: " + iteration);
    }

    private Matrix outputFirstInputSecond(Matrix inputVector) {
        Matrix Y = inputVector.multiply(weights);
        Y = activationFunction(Y);
        return Y;
    }

    private Matrix outputSecondInputFirst(Matrix inputVector) {
        Matrix X = inputVector.multiply(weights.transpose());
        X = activationFunction(X);
        return X;
    }

    private Matrix activationFunction(Matrix vector) {
        for (int i = 0; i < vector.getMatrix()[0].length; i++) {
            if (vector.getMatrix()[0][i] > 0) {
                vector.getMatrix()[0][i] = 1;
            } else if (vector.getMatrix()[0][i] < 0) {
                vector.getMatrix()[0][i] = -1;
            }
        }
        return vector;
    }

    private int calculateEnergy(Matrix outputFirstLayer, Matrix outputSecondLayer) {
        int energy = 0;
        Matrix temp = outputFirstLayer.multiply(weights.transpose());
        Matrix E = temp.multiply(outputSecondLayer.transpose());
        for (int i = 0; i < E.getMatrix().length; i++) {
            for (int j = 0; j < E.getMatrix()[0].length; j++) {
                energy += E.getMatrix()[i][j];
            }
        }
        return energy;
    }

    private void printPatternY(Matrix vector) {
        int[][] array = new int[rowsYToX][columnsYtoX];
        int k = 0;
        for (int i = 0; i < rowsYToX; i++) {
            for (int j = 0; j < columnsYtoX; j++) {
                if (k == vector.getMatrix()[0].length) break;
                array[i][j] = vector.getMatrix()[0][k];
                k++;
            }
        }
        Matrix output = new Matrix(array);
        printPattern(output);
    }

    private void printPattern(Matrix bipolarMatrix) {
        for (int i = 0; i < bipolarMatrix.getMatrix().length; i++) {
            for (int j = 0; j < bipolarMatrix.getMatrix()[0].length; j++) {
                if (bipolarMatrix.getMatrix()[i][j] == 1) {
                    System.out.print("@");
                } else if(bipolarMatrix.getMatrix()[i][j]==-1){
                    System.out.print(".");
                }
            }
            System.out.println("");
        }
    }

    public Matrix getWeights() {
        return weights;
    }
}
