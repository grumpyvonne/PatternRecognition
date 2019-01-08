public class Main {
    public static void main(String arg[]) {
        Network network = new Network();
        String[] string1 = {
                ".@@@.",
                ".@.@.",
                ".@.@."
        };
        String[] string11 = {
                ".@@@@.",
                ".@..@.",
                ".@@@@.",
                ".@...."
        };
        String[] string2 = {
                "@..@@",
                "@.@.@",
                "@@..@"
        };
        String[] string22 = {
                "..@@..",
                "..@@..",
                "..@@..",
                "..@@.."
        };
        String[] string3 = {
                "@...@",
                "@@@@@",
                "@...@"
        };
        String[] string33 = {
                "@@...@",
                "@.@..@",
                "@..@.@",
                "@...@@"
        };
        String[] string4 = {
                "@@@@@",
                "@@@@@",
                "@...."
        };
        String[] string44 = {
                "@@@@@@",
                "@@@@@@",
                "@@@@@.",
                "@@..@@"
        };
        Pattern pattern1 = new Pattern(string1);
        Pattern pattern11 = new Pattern(string11);
        Pattern pattern2 = new Pattern(string2);
        Pattern pattern22 = new Pattern(string22);
        Pattern pattern3 = new Pattern(string3);
        Pattern pattern33 = new Pattern(string33);
        Pattern pattern4 = new Pattern(string4);
        Pattern pattern44 = new Pattern(string44);
        network.addPattern(pattern1);
        network.addPattern(pattern11);
        network.addPattern(pattern2);
        network.addPattern(pattern22);
        network.addPattern(pattern3);
        network.addPattern(pattern33);
        network.addPattern(pattern4);
        network.addPattern(pattern44);
        network.learn();
        System.out.println("ВЕСА: ");
        network.getWeights().print();
    }
}
