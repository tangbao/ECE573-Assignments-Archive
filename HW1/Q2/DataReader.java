/*
    Read data from files
    Written by Zhongze Tang for DSA HW

    updated for UF, two numbers in a line
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    public List<List<Integer>> readFile(String fileName){
        List<List<Integer>> r = new ArrayList<>();
        List<Integer> p = new ArrayList<>();
        List<Integer> q = new ArrayList<>();
        try{
            FileInputStream fileInputStream = new FileInputStream(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader buffReader = new BufferedReader(inputStreamReader);
            String temp;
            try{
                while((temp = buffReader.readLine())!=null){
                    String[] pair = temp.split(" ");
                    p.add(Integer.parseInt(pair[0]));
                    q.add(Integer.parseInt(pair[1]));
                }
                buffReader.close();
            }catch (IOException e){
                System.out.println(e.toString());
            }
        } catch (FileNotFoundException e){
            System.out.println(e.toString());
        }

        r.add(p);
        r.add(q);
        return r;
    }
}
