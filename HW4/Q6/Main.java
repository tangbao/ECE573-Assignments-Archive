public class Main {

    public static void main(String[] args) {
        DataReader dataReader = new DataReader();
        if(args.length != 1){
            System.out.println("Error: data needed.");
            System.exit(1);
        }

        EdgeWeightedDigraph G = dataReader.readFile(args[0]);
        Dijkstra d = new Dijkstra(G, 0);
    }
}
