public class EdgeWeightedDigraph {
    private static final String NEWLINE = System.getProperty("line.separator");

    private final int V;
    private int E;
    private Bag<DirectedEdge>[] adj;
    private int[] indgree;

    public EdgeWeightedDigraph(int V){
        this.V = V;
        this.E = 0;
        this.indgree = new int[V];
        adj = (Bag<DirectedEdge>[]) new Bag[V];
        for(int v = 0; v<V; v++){
            adj[v] = new Bag<>();
        }
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public void addEdge(DirectedEdge e){
        int v = e.from();
        int w = e.to();
        adj[v].add(e);
        indgree[w]++;
        E++;
    }

    public Iterable<DirectedEdge> adj(int v){
        return adj[v];
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (DirectedEdge e : adj[v]) {
                s.append(e + "  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

}
