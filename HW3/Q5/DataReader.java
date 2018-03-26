/*
    Read data from files
    Written by Zhongze Tang for DSA HW

    modified for Red Black BST
*/

import java.io.*;

public class DataReader {
    public RedBlackBST<Integer, Integer> readFile(String fileName){
        RedBlackBST<Integer, Integer> r = new RedBlackBST<>();
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

    public RedBlackBST<Integer, Integer> readFile(String fileName, int cnt){
        RedBlackBST<Integer, Integer> r = new RedBlackBST<>();
        try{
            FileInputStream fileInputStream = new FileInputStream(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader buffReader = new BufferedReader(inputStreamReader);
            String key;
            try{
                int i = 0;
                while((key = buffReader.readLine())!=null && i<cnt){
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
