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

    public int getLenSum(){
        return getLenSum(root);
    }

    private int getLenSum(Node x){
        if (x==null) return 0;
        return size(x) + getLenSum(x.left) +getLenSum(x.right);
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

    public void inOrderPrint(){
        inOrderPrint(root);
        System.out.println();
    }

    private void inOrderPrint(Node x){
        if(x==null) return;
        inOrderPrint(x.left);
        System.out.print(x.key+ ", ");
        inOrderPrint(x.right);
    }

    public int size(){
        return size(root);
    }

    private int size(Node x){
        if(x == null) return 0;
        else return x.N;
    }

    public boolean contains(Key key){
        return (get(key) != null);
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void put(Key key, Value val){
        if(key == null) throw new IllegalArgumentException("key cannot be null");
//        if (val == null) delete(key);
        root = put(root, key, val);
        root.color = BLACK;
    }

    private Node put(Node x, Key key, Value val){
        if(x==null) return new Node(key, val, RED, 1);
        int cmp = key.compareTo(x.key);
        if(cmp < 0){
            x.left = put(x.left, key, val);
            if(isRed(x) || isRed(x.right)) x.left.color = BLACK;
        }else if(cmp > 0){
            x.right = put(x.right, key ,val);
            if(isRed(x) || isRed(x.left)) x.right.color = BLACK;
        }else{
            x.val = val;
        }
        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }

    public Value get(Key key){
        Node x = root;
        while(x != null){
            int cmp = key.compareTo(x.key);
            if(cmp<0){
                x = x.left;
            }else if(cmp>0){
                x = x.right;
            }else return x.val;
        }
        return null;
    }

}
