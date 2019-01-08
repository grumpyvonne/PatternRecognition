import java.util.ArrayList;
import java.util.List;

public class Network {
    private List<Pattern> patterns;
    private List<Matrix> listOfWeights;
    private Matrix weights;

    public Network() {
        patterns = new ArrayList<>();
        listOfWeights = new ArrayList<>();
    }

    public void learn() {
//        for(int i = 0; i < patterns.size(); i++){
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
//        System.out.println("Образ S: ");
//        S.print();
////        System.out.println("S t: ");
////        S.transpose().print();
//        System.out.println("Ассоциируемый с ним образ T: ");
//        T.print();
//        System.out.println("Их веса W: ");
//        W.print();

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
        while (energy != energyPast) {
            energyPast = energy;
            Matrix outputFirst = outputFirstInputSecond(pattern.getVector());
            Matrix outputSecond = outputSecondInputFirst(outputFirst);
            energy = calculateEnergy(outputFirst, outputSecond);
            iteration++;
            if (energy == energyPast) {
                outputSecond.print();
            }
        }
        System.out.println("Number of iterations: " + iteration);
    }

    private Matrix outputFirstInputSecond(Matrix inputVector) {
        Matrix Y = inputVector.multiply(weights);
        Y = activationFunction(Y);
        System.out.println("Y " + Y.getMatrix().length + " " + Y.getMatrix()[0].length);
        return Y;
    }

    private Matrix outputSecondInputFirst(Matrix inputVector) {
        Matrix X = inputVector.multiply(weights.transpose());
        X = activationFunction(X);
        System.out.println("X " + X.getMatrix().length + " " + X.getMatrix()[0].length);
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

        Matrix E = outputFirstLayer.multiply(weights.transpose()).multiply(outputSecondLayer.transpose());
        for (int i = 0; i < E.getMatrix().length; i++) {
            for (int j = 0; j < E.getMatrix()[0].length; j++) {
                energy += E.getMatrix()[i][j];
            }
        }
        return energy;
    }

    public Matrix getWeights() {
        return weights;
    }

}
