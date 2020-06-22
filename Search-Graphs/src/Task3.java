import graphs.CC;
import graphs.Graph;
import graphs.SymbolGraph;

public class Task3 {
	public static void main(String[] args) {
	      
	        
	        SymbolGraph symGraph = new SymbolGraph("movies.txt", "/");
	        Graph G = symGraph.G();
	        
	        double t1, t2;
			t1 = System.currentTimeMillis();
	        CC cc = new CC(G);
			t2 = System.currentTimeMillis();
			
			System.out.println("CPU Time: " + (t2 - t1) + " milli second");
	        

	        
	        int M = cc.count();
	        System.out.println(M + " components");
	}
}
