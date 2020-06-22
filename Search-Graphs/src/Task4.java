import graphs.Graph;
import graphs.SymbolGraph;

public class Task4 {
	public static void main(String[] args) {
		//Question 4 search in a Symbol Graph
		SymbolGraph symGraph = new SymbolGraph("movies.txt", "/");
		Graph G = symGraph.G();

		//To search movies starred by Leonardo DiCaprio 
		String str1 = "DiCaprio, Leonardo";
		if (symGraph.contains(str1)) {
			int source = symGraph.index(str1);
			System.out.println("Movies starred by :" + str1);
			for (int v : G.adj(source)) {
				System.out.println("   " + symGraph.name(v));
			}
		} else {
			System.out.println("The input does not contain '" + str1 + "'\n");
		}
		System.out.println("");

		//To search movies starred by Julia Roberts
		String str2 = "Roberts, Julia (I)";
		if (symGraph.contains(str2)) {
			int source = symGraph.index(str2);
			System.out.println("Movies starred by :" + str2);
			for (int v : G.adj(source)) {
				System.out.println("   " + symGraph.name(v));
			}
		} else {
			System.out.println("input does not contain '" + str2 + "'\n");
		}
		System.out.println("\n");

		//To search movies starred by  Hugh Grant
		String str3 = "Grant, Hugh (I)";
		if (symGraph.contains(str3)) {
			int s = symGraph.index(str3);
			System.out.println("Movies starred by :" + str3);
			for (int v : G.adj(s)) {
				System.out.println("   " + symGraph.name(v));
			}
		} else {
			System.out.println("input does not contain '" + str3 + "'\n");
		}
		System.out.println("");

		//To search movies starred by both  Julia Roberts and Hugh Grant
		System.out.println("Movies starred by both "+str2+" and "+str3);
		if (symGraph.contains(str2)) {
			int s = symGraph.index(str2);
			for (int v : G.adj(s)) {
				String temp = symGraph.name(v);
				int a1 = symGraph.index(temp);
				for(int v1:G.adj(a1)){ 
					String temp1 = symGraph.name(v1);
					if(temp1.equals(str3)){
						
						System.out.println("   " + temp);
					}
				}
			}
		} else {
			System.out.println("Not Found");
		}
		System.out.println("\n");

	}
}

