/*
    A simple undirected graph for 573 HW4 Q1
 */


public class Graph{

    private final int V; // cannot change the value of V later
    private int E;

    private Bag<Integer>[] adj;

    Graph(int V){
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];

        for(int v = 0; v<V; v++){
            adj[v] = new Bag<>();
        }
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public String toString(){
        String graph;
        graph = "The number of vertices is: " + V + "\n"
                + "The number of edges is: " + E + "\n";
        for(int v = 0; v<V; v++){
            graph = graph + "Vertex " + v ;
            for(int w: adj(v)){
                graph = graph + " →" + w;
            }
            graph = graph + "\n";
        }
        return graph;
    }


}