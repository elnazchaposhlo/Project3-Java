import graphs.DijkstraSP;
import graphs.DirectedEdge;
import graphs.EdgeWeightedDigraph;
import graphs.EdgeWeightedGraph;
import graphs.In;
import graphs.KruskalMST;

public class Task2
{
	public static void main(String[] args)
	{
		
        In input1 = new In("mediumEWG.txt");
        EdgeWeightedDigraph graph = new EdgeWeightedDigraph(input1);
        
        int s = 0;
        double t1,t2;
        
        
        t1 = System.currentTimeMillis();
        DijkstraSP dji = new DijkstraSP(graph, s);
        //generate shortest path
        for(s = 0; s < graph.V(); s++) {
        	
        for (int t = 0; t < graph.V(); t++) {
            
        	if (dji.hasPathTo(t)) {
                if (dji.hasPathTo(t)) {
                    for (DirectedEdge e : dji.pathTo(t)) {
                    }
                }
            }
            else {
            }
        }
        }
        t2 = System.currentTimeMillis();
        System.out.println("The CPU Time for Dijkstra's algorithm: " + (t2-t1)+" milli second");
	
     
      		In input2 = new In("10000EWG.txt");
      		EdgeWeightedGraph G = new EdgeWeightedGraph(input2);

      		long t3, t4;
      		t3 = System.currentTimeMillis();
      		KruskalMST kru = new KruskalMST(G);
      		t4 = System.currentTimeMillis();

      		System.out.println("The CPU Time for Kruskal's algorithm: " + (t4 - t3) + " milli second");
	}
}
