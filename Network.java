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

    public Matrix getWeights(){
        return weights;
    }

}
