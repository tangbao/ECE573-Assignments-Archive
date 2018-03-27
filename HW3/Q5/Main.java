import java.io.*;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree<Integer, Integer> st;
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
        System.out.println("select(7)="+st.select(7));
        System.out.println("rank(7)="+st.rank(7));
    }
}
