public class Main {

    public static void main(String[] args) {
        DataReader dataReader = new DataReader();
        if(args.length != 1){
            System.out.println("Error: data needed.");
            System.exit(1);
        }

        EdgeWeightedGraph G = dataReader.readFile(args[0]);
        DFS dfs = new DFS(G, 0);
        BFS bfs = new BFS(G, 0);

    }
}
