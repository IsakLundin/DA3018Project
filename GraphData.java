
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

public class GraphData {
	
	// Hash maps for storing
	HashMap<Integer, LinkedList<Integer>> hashMap = new HashMap<>();	
	HashMap<Integer, Integer> degDist = new HashMap<>();	
	HashMap<Integer, Integer> connectComp = new HashMap<>();
	
	// Method for adding an edge from two vertices.
    // Takes two integers that is the vertex location in the map. 
	public void addEdge(int v, int w) {
		
		// Check if v is already in the map.
		// If so add the v vertex to it's linkedlist.
		if (!hashMap.containsKey(v)) {				
			LinkedList<Integer> ll = new LinkedList<>();
			ll.add(w);
			hashMap.put(v, ll);
		}
		else {
			LinkedList<Integer> ll = hashMap.get(v);
			if (!ll.contains(w)) {
				ll.add(w);
				hashMap.put(v, ll);
			}
		}
		
		// We do the same with w.
		if (!hashMap.containsKey(w)) {
			LinkedList<Integer> ll = new LinkedList<>();
			ll.add(v);
			hashMap.put(w, ll);
		}
		else {
			LinkedList<Integer> ll = hashMap.get(w);
			if (!ll.contains(v)) {
				ll.add(v);
				hashMap.put(w, ll);
			}
		}
	}
	
	// Method to get the node degree of the given vertex.
	// Returns the size of the it's LinkedList.	 
	private int nodeDegree(int v) {
		if (hashMap.containsKey(v)) {
			
			// Finds the size of the LinkedList at location v.
			int degree = hashMap.get(v).size();		
			return degree;
		}
		else {
			return -1;
		}
	}
	
	
	// Method that finds the degree distribution of the graph. 
	// Outputs the degree and the number of vertices with that degree.	 
	void degreeDistribution() {
		for (int n = 0; n < hashMap.size(); n++) {
			int deg = nodeDegree(n);
			if(!degDist.containsKey(deg)) {
				degDist.put(deg, 1);
			}
			else {
				int old = degDist.get(deg);
				degDist.replace(deg, old + 1);
			}
		}
		for (Map.Entry<Integer, Integer> iterate : degDist.entrySet()) {
			int key = iterate.getKey();
			int value = iterate.getValue();
			System.out.format("%d% d\n", key, value);
		}
	}
	
	// Method takes an integer and boolean array that finds all elements connected to it.
	// This is done by using Depth First Search and return LinkedList.
	public LinkedList<Integer> DFS(int v, boolean[] visited){
		LinkedList<Integer> component = new LinkedList<Integer>(); 
		
		// Create a stack for DFS
		Stack<Integer> stack = new Stack<>();
		
		// Push vertex into the stack
		stack.push(v);
		
		while(!stack.empty()) {
			
			// Pop a vertex
			v = stack.peek();
			stack.pop();
			
			// If vertex has not been visited before, add component and mark it as visited.
			if(!visited[v]) {
				component.add(v);
				visited[v] = true;
			}
			// Find all adjacent vertices of the popped vertex, if not visited, push to stack.
			for (int x : hashMap.get(v)) {
				if(!visited[x]) {
					stack.push(x);
				}
			}
		}
		return component;
	}

	
	 // Method for finding the number of connected components distribution in the graph.
	 // The DFS method is used to update the connectcomp map with the number of connected
	 // components of that size.
	void connectedComponents() {
		
		// Use the same boolean for each time we use DFS to know where we have been
		boolean[] visited = new boolean[hashMap.size()];
		
		// We Iterate over all vertices to fill the visited array.
		for ( int v = 0; v < hashMap.size(); v++) {
			if(!visited[v]) {
				LinkedList<Integer> component = DFS(v, visited);
				int cSize = component.size();
				
				// Get size and add to relevant map location.
				if (!connectComp.containsKey(cSize)) {
					connectComp.put(cSize, 1);
				}
				else {
					int old = connectComp.get(cSize);
					connectComp.replace(cSize,  old + 1);
				}
			}
		}
	}
	
	// Method finding the number of connected components in the graph.
	public int ccNumber() {
		int tot = 0;
		
		// Iterate connectComp and add up all values in the current position. 
		for (int value : connectComp.values()) {
			tot = tot + value;
		}
		return tot;
	}
	
	// Method that outputs the component size distribution.
	void CompDist() {
		//int size = ccNumber();
		for (Map.Entry<Integer, Integer> iterate : connectComp.entrySet()) {
			int key = iterate.getKey();
			int value = iterate.getValue();
			System.out.format("%d% d\n", key, value);
		}
	}
		
	// Main function that reads from Stdin that calculate various things about the graph.
	// Should be used with unix.
	public static void main(String[] args) throws NoSuchElementException {
		
		GraphData g = new GraphData();
		
		Scanner sc = new Scanner(System.in);
		int i = 0;
		HashMap<String, Integer> vertex = new HashMap<>();
		
		try {		
			
			// Create the graph based on input from System.in with scanner.
			while (sc.hasNextLine()) {
				
				// The values are vertices in the graph. 
				String u = sc.next();
				String v = sc.next();
				
				// If not found in the vertex map, add it and put the value as i.
				if (!vertex.containsKey(u)) {
					vertex.put(u, i);
					i++;
				}
				
				// Same here. If not found, add it and put value as i.
				if (!vertex.containsKey(v)) {
					vertex.put(v, i);
					i++;
				}
				
				int uNum = vertex.get(u);
				int vNum = vertex.get(v);
				
				// Add the edge between two vertices.
				// Using the integer value of i at the location of the string.
				g.addEdge(uNum,  vNum);
			
			}
			sc.close();
		}
		catch(Exception e) {}
		
		// Prints out values as stdout.
		if (!(args.length == 0)) {

			System.out.println("Not valid input");
			
		}
		// If no argument present the data in full
		else {
			g.connectedComponents();

			System.out.println("The node degree distribution of G:");		
			g.degreeDistribution();
			
			System.out.println("The total number of components in G: " + g.ccNumber());
			
			System.out.println("The component size distribution of G:");
			g.CompDist();		
		}
	}

	
}