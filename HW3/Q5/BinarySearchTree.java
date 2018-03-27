public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node{
        private Key key;
        private Value val;
        private Node left;
        private Node right;
        private int N;

        Node(Key key, Value val, int N){
            this.key = key;
            this.val = val;
            this.left = null;
            this.right = null;
            this.N = N;
        }
    }

    public BinarySearchTree(){
    }

    public int size(){
        return size(root);
    }

    private int size(Node x){
        if(x==null) return 0;
        return x.N;
    }

    public Value get(Key key){
        Node x = root;
        while(x!=null){
            int cmp = key.compareTo(x.key);
            if(cmp<0) {
                x = x.left;
            }
            else if(cmp>0){
                 x = x.right;
            }
            else {
                 return x.val;
            }
        }
        return null;
    }

    public void put(Key key, Value val){
        if(key == null) throw new IllegalArgumentException("first argument to put() is null");
        if(val == null){
            delete(key);//do not implement
            return;
        }
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val){
        if(x==null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if(cmp<0) {
            x.left = put(x.left, key, val);
        }
        else if(cmp>0) {
            x. right = put(x.right, key, val);
        }
        else {
            x.val = val;
        }
        x.N = 1 + size(x.right) + size(x.left);
        return x;
    }

    public int rank(Key key){
        return rank(root, key);
    }

    private int rank(Node x, Key key){
        int cmp = key.compareTo(x.key);
        if(cmp<0){
            return rank(x.left, key);
        }else if(cmp>0){
            return 1+size(x.left)+rank(x.right, key);
        }else{
            return size(x.left);
        }
    }

    public Key select(int k){
        return select(root, k);
    }

    private Key select(Node x, int k){
        if (x==null) return null;
        int t = size(x.left);
        if(t > k){
            return select(x.left, k);
        }else if (t == k){
            return x.key;
        }else {
            return select(x.right, k-t-1);
        }
    }

    private void delete(Key key){
        //not implement
    }

}
