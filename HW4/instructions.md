1. Write a program that answers the following for an undirected graph: Is a graph acyclic?  Run your program on graph (linked after Q2)

2. Implement and execute Prim's and Kruskal's algorithms on the graph linked below (the third field is the weight of an edge). Which performs better? Explain your answer.

Use Graph [linked here](https://sakai.rutgers.edu/access/content/group/9a721e60-ef8e-412a-835b-14c0ab9020f0/HW-Dataset/mediumEWG.txt)  for Q1 and 2 [If the previous link does not work, equivalently download  from:
https://sakai.rutgers.edu/access/content/group/f73f2fd4-280d-4e7c-8cf2-9cc34bcffcff/HW-DataSet/mediumEWG.txt]

3. For the edge-weighted directed acyclic graph given below, compute (i.e., manually trace) both the longest path and the shortest path.

8  
13  
5 4 0.35  
4 7 0.37  
5 7 0.28  
5 1 0.32  
4 0 0.38  
0 2 0.26  
3 7 0.39  
1 3 0.29  
7 2 0.34  
6 2 0.40  
3 6 0.52  
6 0 0.58  
6 4 0.93  

4. (a) For the digraph with negative weights, compute (i.e. manually
trace) the progress of the Bellman-Ford Algorithm.  

8  
15  
4 5  0.35  
5 4  0.35  
4 7  0.37  
5 7  0.28  
7 5  0.28  
5 1  0.32  
0 4  0.38  
0 2  0.26  
7 3  0.39  
1 3  0.29  
2 7  0.34  
6 2 -1.20  
3 6  0.52  
6 0 -1.40  
6 4 -1.25  

4. (b) For the digraph with a negative cycle, compute (i.e. manually
trace) the progress of the Bellman-Ford Algorithm.  

8  
15  
4 5  0.35  
5 4 -0.66  
4 7  0.37  
5 7  0.28  
7 5  0.28  
5 1  0.32  
0 4  0.38  
0 2  0.26  
7 3  0.39  
1 3  0.29  
2 7  0.34  
6 2  0.40  
3 6  0.52  
6 0  0.58  
6 4  0.93  

5. Implement a DFS and BFS traversal for the data-set of the undirected road network of New York City. The graph contains 264346 vertices and 733846 edges. It is connected, contains parallel edges, but no self-loops. The edge weights are travel times and are strictly positive.   

6. Implement the shortest path using Djikstra's Algorithm for the graph in HW5 Q 4(b).  Then run your implementation of Djikstra's on HW5 4(a). What happens? Explain.
