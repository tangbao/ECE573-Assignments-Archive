public class Main {

    public static void main(String[] args) {
        DataReader dataReader = new DataReader();
        if(args.length != 1){
            System.out.println("Error: data needed.");
            System.exit(1);
        }

        EdgeWeightedGraph g = dataReader.readFile(args[0]);
//        test input
//        System.out.println(g.toString());

        
    }
}
