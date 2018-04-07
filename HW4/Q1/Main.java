
public class Main {

    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph g = new Graph(in);
        System.out.println(g.toString());
    }
}
