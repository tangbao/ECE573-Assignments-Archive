
public class Main {

    public static void main(String[] args) {
        DataReader dataReader = new DataReader();
        if(args.length != 1){
            System.out.println("Error: data needed.");
            System.exit(1);
        }

        Graph g = dataReader.readFile(args[0]);
//        test input
//        System.out.println(g.toString());

        GraphCycleChecker checker = new GraphCycleChecker(g);

        if(checker.isAcyclic()){
            System.out.println("The graph is acyclic.");
        } else {
            System.out.println("The graph is cyclic.");
        }

    }
}
