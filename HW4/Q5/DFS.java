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
        while(!stack.empty()){
            int v = stack.pop();
            marked[v] = true;
            for(Edge e: G.adj(v)){
                int w = e.other(v);
                if (!marked[w]){
                    edgeTo[w] = v;
                    stack.push(w);
                }
            }
        }
    }
}
