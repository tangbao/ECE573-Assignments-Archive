/*
    Kruskal's algo to calc MST.

    Some codes from https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/KruskalMST.java.html
 */

public class KruskalMST {

    private double weight;
    private Queue<Edge> mst = new Queue<>();

    public KruskalMST(EdgeWeightedGraph G){
        MinPQ<Edge> pq = new MinPQ<>();
        for(Edge e:G.edges()){
            pq.insert(e);
        }

        UF uf = new UF(G.V());
        while(!pq.isEmpty() && mst.size() < G.V() - 1){
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if(!uf.connected(v, w)){
                uf.union(v, w);
                mst.enqueue(e);
                weight += e.getWeight();
            }
        }
    }

    public double getWeight(){
        return weight;
    }

    public Iterable<Edge> edges(){
        return mst;
    }


}
