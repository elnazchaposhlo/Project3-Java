import graphs.DepthFirstOrder;
import graphs.Digraph;
import graphs.In;

public class Task1
{
	public static void main(String[] args)
	{
		In input = new In("mediumDG.txt");
        Digraph graph = new Digraph(input);

    	
        double t1,t2;
        t1 = System.nanoTime();
        DepthFirstOrder dfs = new DepthFirstOrder(graph);
        t2 = System.nanoTime();
        
        t1 = System.nanoTime();
        System.out.println(dfs.pre());
        t2 = System.nanoTime();
        System.out.println("The CPU Time preorder: "+(t2-t1)+" nano second");
        
        t1 = System.nanoTime();
        System.out.println(dfs.post());
        t2 = System.nanoTime();
        System.out.println("The CPU Time postorder: "+(t2-t1)+" nano second");
	}
}