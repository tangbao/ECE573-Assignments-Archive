import java.io.*;

public class Main {

    public static void main(String[] args) {
        RedBlackBST<Integer, Integer> st = new RedBlackBST<>();
        DataReader dataReader = new DataReader();

        String file;
        if(args.length == 0){
            //no filename input
            System.out.println("Error: You have to determine the data source.");
            return;
        }else{
            file = args[0];
        }

        st = dataReader.readFile(file);
        System.out.println(st.select(7));
        System.out.println(st.rank(7));
    }
}
