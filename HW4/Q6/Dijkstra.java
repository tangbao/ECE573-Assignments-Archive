import java.util.Stack;

public class Dijkstra {

    private double[] distTo;
    private DirectedEdge[] edgeTo;
    private IndexMinPQ<Double> pq;

    public Dijkstra(EdgeWeightedDigraph G, int s){
        distTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];

        for (int v=0; v<G.V(); v++){
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0;

        pq = new IndexMinPQ<>(G.V());
        pq.insert(s, distTo[s]);
        while (!pq.isEmpty()){
            int v = pq.delMin();
            for(DirectedEdge e:G.adj(v)){
                relax(e);
            }
        }

        printResult(G, s);
    }

    private void relax(DirectedEdge e){
        int v = e.from();
        int w = e.to();
        if(distTo[w] > distTo[v] + e.getWeight()){
            distTo[w] = distTo[v] + e.getWeight();
            edgeTo[w] = e;
            if(pq.contains(w))
                pq.decreaseKey(w, distTo[w]);
            else
                pq.insert(w, distTo[w]);
        }
    }

    private double distTo(int v){
        return distTo[v];
    }

    private boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    private Iterable<DirectedEdge> pathTo(int v){
        if(!hasPathTo(v)) return null;
        Stack<DirectedEdge> path = new Stack<>();
        for(DirectedEdge e = edgeTo[v]; e!=null; e=edgeTo[e.from()]){
            path.push(e);
        }
        return path;
    }

    private void printResult(EdgeWeightedDigraph G, int s){
        for (int t = 0; t < G.V(); t++) {
            if (hasPathTo(t)) {
                System.out.printf("%d to %d (%.2f)  ", s, t, distTo(t));
                for (DirectedEdge e : pathTo(t)) {
                    System.out.print(e + "   ");
                }
                System.out.println();
            }
            else {
                System.out.printf("%d to %d         no path\n", s, t);
            }
        }
    }

}
