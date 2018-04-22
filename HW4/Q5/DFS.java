/*
    A DFS class for large graph
    use an allocated-independently stack
 */

import java.util.Stack;

public class DFS {
    private boolean[] marked;
    private int[] edgeTo;
    private int cnt = 0;

    DFS(EdgeWeightedGraph G, int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        marked[0] = true;
        while(!stack.empty()){
            int v = stack.pop();
            for(Edge e: G.adj(v)){
                int w = e.other(v);
                if (!marked[w]){
                    cnt++;
                    marked[w] = true;
                    edgeTo[w] = v;
                    stack.push(w);
                }
            }
        }
        System.out.println("DFS visits " + (cnt+1) + " vertices.");
    }
}
