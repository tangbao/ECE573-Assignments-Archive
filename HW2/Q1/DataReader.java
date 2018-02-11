/*
    Read data from files
    Written by Zhongze Tang for DSA HW
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    public List<Integer> readFile(String fileName){
        List<Integer> r = new ArrayList<>();
        try{
            FileInputStream fileInputStream = new FileInputStream(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader buffReader = new BufferedReader(inputStreamReader);
            String temp;
            try{
                while((temp = buffReader.readLine())!=null){
                    int num = Integer.parseInt(temp);
                    r.add(num);
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
