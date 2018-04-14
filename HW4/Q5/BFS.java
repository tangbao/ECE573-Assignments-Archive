

public class BFS {
    private Queue<Integer> queue = new Queue<>();
    private boolean[] marked;
    private int[] edgeTo;

    BFS(EdgeWeightedGraph G, int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        queue.enqueue(s);
        marked[s] = true;
        while(!queue.isEmpty()){
            int v = queue.dequeue();
            for (Edge e:G.adj(v)){
                int w = e.other(v);
                if(!marked[w]){
                    queue.enqueue(w);
                    marked[w] = true;
                }
            }
        }
    }
}
