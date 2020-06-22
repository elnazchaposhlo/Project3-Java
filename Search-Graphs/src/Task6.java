import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import graphs.In;
import memoryManagement.BTree;

public class Task6
{
	public static void main(String[] args) throws FileNotFoundException
	{

    	BTree<String, String> str = new BTree<String, String>();
        
        In input = new In("ChIP-seq-reads-1M.dat");
        String[] lines = input.readAllLines();
        
        double t1,t2;
        t1 = System.currentTimeMillis();
        
        for(int i=0; i<lines.length; i++){
        	str.put(lines[i], i+"");
        }
        t2 = System.currentTimeMillis();
        
        System.out.println("The CPU Time is: " + (t2 - t1)+" milli second");
        
               
        PrintStream out = new PrintStream(new File("B-tree.dat")); 
        System.setOut(out);
        
        System.out.println(str);
        System.out.println("The size:    " + str.size());
        System.out.println("The height:  " + str.height());
	}
}
