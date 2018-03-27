/*
    Read data from files
    Written by Zhongze Tang for DSA HW

    modified for BST
*/

import java.io.*;

public class DataReader {
    public BinarySearchTree<Integer, Integer> readFile(String fileName){
        BinarySearchTree<Integer, Integer> r = new BinarySearchTree<>();
        try{
            FileInputStream fileInputStream = new FileInputStream(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader buffReader = new BufferedReader(inputStreamReader);
            String key;
            try{
                int i = 0;
                while((key = buffReader.readLine())!=null){
                    int num = Integer.parseInt(key);
                    r.put(num, i++);
                }
                buffReader.close();
            }catch (IOException e){
                System.out.println(e.toString());
            }
        } catch (FileNotFoundException e){
            System.out.println(e.toString());
        }

        return r;
    }

}
