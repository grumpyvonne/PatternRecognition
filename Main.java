//Автор: Шурпач Ольга, группа 621702
public class Main {
    public static void main(String arg[]) {
        Network network = new Network();
        String[] string1 = {
                ".#####....######....#####....#####.",
                "...#......#....#....#........#.....",
                "...#......#....#....#........#.....",
                "...#......######....#####....#####.",
                "...#......#.#.......#........#.....",
                "...#......#..#......#........#.....",
                "...#......#...#.....#........#.....",
                "...#......#....#....#####....#####."
        };
        String[] string11 = {
                "................",
                "....#######.....",
                "..############..",
                ".##############.",
                "################",
                "################",
                "################",
                "################",
                "################",
                ".##############.",
                "..############..",
                ".....#######....",
                ".......##.......",
                ".......##.......",
                ".......##.......",
                ".......##.......",
                ".......##.......",
                ".....######....."
        };
//        String[] string1 = {
//                ".@@@.",
//                ".@.@.",
//                ".@.@."
//        };
//        String[] string11 = {
//                ".@@@@.",
//                ".@..@.",
//                ".@@@@.",
//                ".@...."
//        };
        String[] string2 = {
                "..##........##.....#.....#......#..",
                "..#.#......#.#....#.#....##.....#..",
                "..#..#....#..#...#...#...#.#....#..",
                "..#...#..#...#...#...#...#..#...#..",
                "..#....##....#..#.....#..#...#..#..",
                "..#..........#..#######..#....#.#..",
                "..#..........#..#.....#..#.....##..",
                "..#..........#..#.....#..#......#.."
        };
        String[] string22 = {
                "................",
                "....#########...",
                "....#.#...#.#...",
                "....#.......#...",
                "....#..###..#...",
                "....#########...",
                "........#.......",
                "........#.......",
                "..#############.",
                "........#.......",
                "........#.......",
                "........#.......",
                "........#.......",
                ".......#.#......",
                "......#...#.....",
                ".....#.....#....",
                "....#.......#...",
                "...#.........#.."
        };
        String[] string3 = {
                ".#....#..######..##.....##..######.",
                ".#....#..#....#..#.#...#.#..#......",
                ".#....#..#....#..#.#..#..#..#......",
                ".######..#....#..#..##...#..######.",
                ".#....#..#....#..#.......#..#......",
                ".#....#..#....#..#.......#..#......",
                ".#....#..#....#..#.......#..#......",
                ".#....#..######..#.......#..######."
        };
        String[] string33 = {
                "................",
                ".......#........",
                "......#.#..###..",
                ".....#...#.#.#..",
                "....#.....##.#..",
                "...#.......#.#..",
                "..#.........##..",
                ".#############..",
                ".#.#####.....#..",
                ".#.#...#.....#..",
                ".#.#...#.....#..",
                ".#.#####.....#..",
                ".#......######..",
                ".#......#....#..",
                ".#......#....#..",
                ".#......#....#..",
                ".#......#....#..",
                ".#############.."
        };


//        String[] string2 = {
//                "@..@@",
//                "@.@.@",
//                "@@..@"
//        };
//        String[] string22 = {
//                "..@@..",
//                "..@@..",
//                "..@@..",
//                "..@@.."
//        };

//        String[] string3 = {
//                "@...@",
//                "@@@@@",
//                "@...@"
//        };
//        String[] string33 = {
//                "@@...@",
//                "@.@..@",
//                "@..@.@",
//                "@...@@"
//        };
//        String[] string4 = {
//                "@@@@@",
//                "@@@@@",
//                "@...."
//        };
//        String[] string44 = {
//                "@@@@@@",
//                "@@@@@@",
//                "@@@@@.",
//                "@@..@@"
//        };
        String[] test1 = {
                "...###....######....#####....#####.",
                ".#.#......#.##.#....#.#.#....#.....",
                ".#.#......#.#..#....#...#....#.....",
                "...#......######....#####....#####.",
                "...#.#....#.#..#....#........#.#.#.",
                "...#.#....####......#........#...#.",
                "...#......#...#.....#........#...#.",
                "...#......#....#....#####....#####."
        };
        String[] test2 = {
                "..############.....#.....#......#..",
                "..#.#......#.#....#.#....##.....#..",
                "..#..#....#..#...#####..........#..",
                "..#...#..#...#...#...#...#..#...#..",
                "..#.............#.....#..#...#..#..",
                "..#.............##..###..#....#....",
                "..#..........#..#.....#..#.........",
                "..#..........#..#.....#..#......#.."
        };
        String[] test3 = {
                ".######..######..##.######..######.",
                ".#....#..#....#..#.#####.#..#.##.#.",
                ".#....#..#.##.#..#.####..#..#....#.",
                ".######..#....#..#..##...#..######.",
                ".#....#..#....#..#.......#..#......",
                ".#....#..#....#..#.......#..#......",
                ".#....#..#....#..#.......#..#......",
                ".######..######..#.......#..######."
        };
        String[] test4 = {
                "................",
                "....#######.....",
                "..##...#######..",
                ".########...###.",
                "###..##..####.##",
                "#######..####..#",
                "############..##",
                "#....###########",
                "..###...########",
                ".##########...#.",
                "....##########..",
                ".....##..###....",
                ".......##.......",
                ".......##.......",
                "................",
                "................",
                ".......##.......",
                ".....######....."
        };
        String[] test5 = {
                "......#..#......",
                "....#########...",
                ".#..#.......#...",
                "..###.......#...",
                "#####..###..#...",
                "##..#.#####.#...",
                "........#.......",
                "........#.......",
                "..#######.......",
                "........#..#....",
                "........#.#.#...",
                "........####....",
                "........########",
                ".......#.####...",
                "......#...#.....",
                "......#....#....",
                "......#.....#...",
                "#######......#.."

        };
        String[] test6 = {
                "................",
                "................",
                "......#.#.......",
                ".....#...#......",
                "....###..##.....",
                "...#.#...#.#....",
                "..#..#####..#...",
                ".#####....####..",
                ".#...........#..",
                ".#...........#..",
                ".#.##..#.....#..",
                ".#.#####........",
                ".............#..",
                ".....##......#..",
                "......#......#..",
                ".#....#......#..",
                ".#....#......#..",
                ".#..####..####.."

        };
        Pattern testP1 = new Pattern(test1);
        Pattern testP2 = new Pattern(test2);
        Pattern testP3 = new Pattern(test3);
        Pattern testP4 = new Pattern(test4);
        Pattern testP5 = new Pattern(test5);
        Pattern testP6 = new Pattern(test6);
        Pattern pattern1 = new Pattern(string1);
        Pattern pattern11 = new Pattern(string11);
        Pattern pattern2 = new Pattern(string2);
        Pattern pattern22 = new Pattern(string22);
        Pattern pattern3 = new Pattern(string3);
        Pattern pattern33 = new Pattern(string33);
        network.addPattern(pattern1);
        network.addPattern(pattern11);
        network.addPattern(pattern2);
        network.addPattern(pattern22);
        network.addPattern(pattern3);
        network.addPattern(pattern33);
        network.learn();

        System.out.println("Введенный образ: ");
        pattern1.printPattern();
        network.searchPatternByX(pattern1);

        System.out.println("Введенный образ: ");
        testP1.printPattern();
        network.searchPatternByX(testP1);

        System.out.println("Введенный образ: ");
        testP2.printPattern();
        network.searchPatternByX(testP2);

        System.out.println("Введенный образ: ");
        testP3.printPattern();
        network.searchPatternByX(testP3);

        System.out.println("Введенный образ: ");
        testP4.printPattern();
        network.searchPatternByY(testP4);

        System.out.println("Введенный образ: ");
        testP5.printPattern();
        network.searchPatternByY(testP5);

        System.out.println("Введенный образ: ");
        testP6.printPattern();
        network.searchPatternByY(testP6);
    }
}
