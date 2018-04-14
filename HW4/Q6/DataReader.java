/*
    Read data from files
    Written by Zhongze Tang for DSA HW

    modified for undirected graph with weight
*/

import java.io.*;

public class DataReader {
    public EdgeWeightedDigraph readFile(String fileName){
        EdgeWeightedDigraph g = null;
        try{
            FileInputStream fileInputStream = new FileInputStream(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader buffReader = new BufferedReader(inputStreamReader);
            String line;
            try{
                line = buffReader.readLine();
                g = new EdgeWeightedDigraph(Integer.parseInt(line));
                line = buffReader.readLine();
                int E = Integer.parseInt(line);

                for(int i = 0; i<E; i++){
                    line = buffReader.readLine();
                    String[] s = line.split(" ");
                    int v = Integer.parseInt(s[0]);
                    int w = Integer.parseInt(s[1]);
                    double we = Double.parseDouble(s[2]);
                    DirectedEdge e = new DirectedEdge(v, w, we);
                    g.addEdge(e);
                }
                buffReader.close();
            }catch (IOException e){
                System.out.println(e.toString());
            }
        } catch (FileNotFoundException e){
            System.out.println(e.toString());
        }

        return g;
    }

}
