import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        DataReader dataReader = new DataReader();
        List<List<Integer>> data = new ArrayList<>();
        List<Integer> p, q;

        if(args.length == 0){
            //no filename input
            System.out.println("Error: You have to determine the data source.");
            return;
        }else{
            for(String file:args){
                //read data from files
                data.addAll(dataReader.readFile(file));
            }
            if(data.size() == 0){
                System.out.println("Error: no data.");
                return;
            }
        }
        p = data.get(0);
        q = data.get(1);

        //test data
//        System.out.println("The data:");
//        for(int i:p)
//            System.out.print(i+" ");
//        for(int i:q)
//            System.out.print(i+" ");
//        System.out.println();


        int N = p.size();
        int MAX = 8192;

//        long t1 = 0;
//        long t2 = 0;
//        long t3 = 0;
//
//        for(int t = 0;t<5; t++){
            //QuickFind
            NanoTimer nt1 = new NanoTimer();
            QuickFindUF qfu = new QuickFindUF(MAX);
            for(int i = 0; i<N; i++){
                if(!qfu.connected(p.get(i), q.get(i))){
                    qfu.union(p.get(i), q.get(i));
                    //System.out.println("connect "+p.get(i)+" and "+q.get(i));
                }
            }
            long time1 = nt1.calc();
            System.out.println("The time of QuickFind is "+time1+" ns");
//            t1+=time1;

            //QuickUnion
            NanoTimer nt2 = new NanoTimer();
            QuickUnionUF quu = new QuickUnionUF(MAX);
            for(int i = 0; i<N; i++){
                if(!quu.connected(p.get(i), q.get(i))){
                    quu.union(p.get(i), q.get(i));
                    //System.out.println("connect "+p.get(i)+" and "+q.get(i));
                }
            }
            long time2 = nt2.calc();
            System.out.println("The time of QuickUnion is "+time2+" ns");
//            t2+=time2;

            //Weighted QuickUnion
            NanoTimer nt3 = new NanoTimer();
            WeightedQuickUnionUF wquu = new WeightedQuickUnionUF(MAX);
            for(int i = 0; i<N; i++){
                if(!wquu.connected(p.get(i), q.get(i))){
                    wquu.union(p.get(i), q.get(i));
                    //System.out.println("connect "+p.get(i)+" and "+q.get(i));
                }
            }
            long time3 = nt3.calc();
            System.out.println("The time of Weighted QuickUnion is "+time3+" ns");
//            t3+=time3;
//        }

//        t1 = t1/5;
//        t2 = t2/5;
//        t3 = t3/5;
//        System.out.println("The average time of QuickFind is " +t1+" ns");
//        System.out.println("The average time of QuickUnion is " +t2+" ns");
//        System.out.println("The average time of WQuickUnion is " +t3+" ns");

    }
}
