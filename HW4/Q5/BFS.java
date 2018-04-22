

public class BFS {
    private Queue<Integer> queue = new Queue<>();
    private boolean[] marked;
    private int[] edgeTo;
    private int cnt = 0;

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
                    cnt++;
                    queue.enqueue(w);
                    marked[w] = true;
                }
            }
        }
        System.out.println("BFS visits " + (cnt+1) + " vertices.");
    }
}
