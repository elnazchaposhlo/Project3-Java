import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import graphs.In;
import graphs.IndexMinPQ;

public class Task5
{
	public static void main(String[] args) throws IOException
	{

		//Question 5 using multi-way merge sort 
		//Reading File Contents and storing it in a string array
		In myFile = new In("ChIP-seq-reads-1M.dat");
		FileWriter myWr = new FileWriter("A.dat");
		String[] lines = myFile.readAllLines();

		int len = lines.length;
		
		String[] temp = new String[len / 4];

		/*Dividing 1M strings into 4 equal
		 * and saving them in a file
		 */
		
		for (int i = 0, j = 0; i < len / 4; i++, j++) {
			if (i == len / 4 - 1)
				myWr.write(lines[i]);
			else
				myWr.write(lines[i] + "\n");
			temp[j] = lines[i];
		}
		myWr.close();
		
		
		Arrays.sort(temp);

		myWr = new FileWriter("AS.dat");
		
		for (int i = 0; i < len / 4; i++) {
			if (i == len / 4 - 1)
				myWr.write(temp[i]);
			else
				myWr.write(temp[i] + "\n");
		}
		myWr.close();
		
		
		myWr = new FileWriter("B.dat");
		for (int i = len / 4, j = 0; i < len / 2; i++, j++) {
			if (i == len / 2 - 1)
				myWr.write(lines[i]);
			else
				myWr.write(lines[i] + "\n");
			temp[j] = lines[i];
		}
		myWr.close();
		
		Arrays.sort(temp);
		myWr = new FileWriter("BS.dat");
		for (int i = 0; i < len / 4; i++) {
			if (i == len / 4 - 1)
				myWr.write(temp[i]);
			else
				myWr.write(temp[i] + "\n");
		}
		myWr.close();
		
		
		myWr = new FileWriter("C.dat");
		for (int i = len / 2, j = 0; i < 3 * len / 4; i++, j++) {
			if (i == 3 * len / 4 - 1)
				myWr.write(lines[i]);
			else
				myWr.write(lines[i] + "\n");
			temp[j] = lines[i];
		}
		myWr.close();
		
		Arrays.sort(temp);
		myWr = new FileWriter("CS.dat");
		for (int i = 0; i < len / 4; i++) {
			if (i == len / 4 - 1)
				myWr.write(temp[i]);
			else
				myWr.write(temp[i] + "\n");
		}
		myWr.close();
		
		
		myWr = new FileWriter("D.dat");
		for (int i = 3 * len / 4, j = 0; i < len; i++, j++) {
			if (i == len - 1)
				myWr.write(lines[i]);
			else
				myWr.write(lines[i] + "\n");
			temp[j] = lines[i];
		}
		myWr.close();
		
		Arrays.sort(temp);
		myWr = new FileWriter("DS.dat");
		for (int i = 0; i < len / 4; i++) {
			if (i == len / 4 - 1)
				myWr.write(temp[i]);
			else
				myWr.write(temp[i] + "\n");
		}
		myWr.close();

		//Merging the sorted files
		double start,end;
		start = System.currentTimeMillis();
		String[] fnames = { "AS.dat", "BS.dat", "CS.dat", "DS.dat" };
		int N = fnames.length;
		In[] streams = new In[N];
		for (int i = 0; i < N; i++)
			streams[i] = new In(fnames[i]);
		
		merge(streams);
		end = System.currentTimeMillis();
		
		System.out.println("CPU Time: " + (end-start) + "ms");
	}
	private static void merge(In[] streams) throws IOException {
		int N = streams.length;
		IndexMinPQ<String> pq = new IndexMinPQ<String>(N);
		for (int i = 0; i < N; i++)
			if (!streams[i].isEmpty())
				pq.insert(i, streams[i].readString());

		FileWriter wr = new FileWriter("ChIP-seq-reads-1M-sorted.dat");

		// Extract and print min and read next from its stream.
		while (!pq.isEmpty()) {
			String st = pq.minKey() + "\n";
			wr.write(st);
			//StdOut.print(st);
			int i = pq.delMin();
			if (!streams[i].isEmpty())
				pq.insert(i, streams[i].readString());
		}

		wr.close();
		//StdOut.println();
	}
}
