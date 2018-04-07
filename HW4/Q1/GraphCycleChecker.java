
public class GraphCycleChecker {
    private boolean[] marked;
    private boolean isAcyclic;

    GraphCycleChecker(Graph g){
        marked = new boolean[g.V()];
        isAcyclic = true;
        for(int v = 0; v<g.V(); v++){
            if(!marked[v]){
                dfs(g, v, v);
            }
        }
    }

    private void dfs(Graph g, int v, int w){
        marked[v] = true;
        for(int u : g.adj(v)){
            if (!marked[u]){
                dfs(g, u, v);
            }else if(u != w){
                isAcyclic = false; // contain a circle, it's cyclic.
            }
        }
    }

    public boolean isAcyclic(){
        return isAcyclic;
    }

}
