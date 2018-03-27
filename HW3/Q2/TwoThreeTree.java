/*
     the basic symbol-table API that uses 2-3 trees that are not necessarily balanced as the underlying data structure
 */


public class TwoThreeTree<Key extends Comparable<Key>, Value> {

    private final static boolean RED = true;
    private final static boolean BLACK = false;

    private Node root;

    private class Node{
        private Key key;
        private Value val;
        private Node left, right;
        private boolean color;
        private int N;

        public Node(Key key, Value val, boolean color, int N){
            this.key = key;
            this.val = val;
            this.color = color;
            this.N = N;
        }
    }

    public TwoThreeTree(){
    }

    /**
     *
     * Functions for Q2, calc the ave path len
     *
     */

    public int getLenSumWithoutRed(){
        return getLenSumWithoutRed(root);
    }

    private int getLenSumWithoutRed(Node x){
        if (x==null) return 0;
        int cnt = size(x) + getLenSumWithoutRed(x.left) +getLenSumWithoutRed(x.right);
        if(isRed(x)) cnt = cnt - size(x);
        return cnt;
    }

    public int getLenSum(){
        return getLenSum(root);
    }

    private int getLenSum(Node x){
        if (x==null) return 0;
        int cnt = size(x) + getLenSum(x.left) +getLenSum(x.right);
        return cnt;
    }


    private boolean isRed(Node x){
        if(x==null) return false;
        return x.color == RED;
    }

    public int cntRed(){
        return cntRed(root);
    }

    private int cntRed(Node x){
        if(x==null) return 0;
        int cnt = cntRed(x.left) + cntRed(x.right);
        if (isRed(x)) cnt++;
        return cnt;
    }

    public int size(){
        return size(root);
    }

    private int size(Node x){
        if(x == null) return 0;
        else return x.N;
    }

    public void put(Key key, Value val){
        if(key == null) throw new IllegalArgumentException("key cannot be null");
        if (val == null) delete(key);
        root = put(root, key, val);
        root.color = BLACK;
    }

    private Node put(Node x, Key key, Value val){
        if(x==null) return new Node(key, val, RED, 1);
        int cmp = key.compareTo(x.key);
        if(cmp < 0){
            x.left = put(x.left, key, val);
            if(isRed(x) || isRed(x.right)) {
                x.left.color = BLACK;
            }
        }else if(cmp > 0){
            x.right = put(x.right, key ,val);
            if(isRed(x) || isRed(x.left)){
                x.right.color = BLACK;
            }
        }else{
            x.val = val;
        }

        x.N = 1 + size(x.left) + size(x.right);

        return x;
    }


    public void delete(Key key){
        //not implement
    }

}
