// a simple Java implementation of MiniGraph using adjacency lists
// C343 Summer 2016
 
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class MyMiniGraph implements MiniGraph {
    private int totalNodes;
    private Vector<String> nodeList;
    private int totalEdges;
    private Vector<LinkedList<Integer>>  adjList; // Adjacency list
    
    public MyMiniGraph() {
        init();
    }
    public void init() {
	totalNodes = 0;
	nodeList = new Vector<String>();
	totalEdges = 0;
	adjList = new Vector<LinkedList<Integer>>();
    }
    public void setVertex(String[] nodes) {
	for (int i = 0; i < nodes.length; i++) {
	    nodeList.add(nodes[i]);
	    adjList.add(new LinkedList<Integer>());
	    totalNodes++;
	}
    }
    
    // public void setEdge(int v1, int v2, int weight) {
    // 	LinkedList<Integer> temp = adjList.elementAt(v1);
    // 	if (adjList.contains(v2) == false) {
    // 	    temp.add(v2);
    // 	    adjList.set(v2, temp);
    // 	    totalEdges++;
    // 	}
    // }
    
    public void setEdge(int v1, int  v2, int weight){
    	LinkedList<Integer> temp = adjList.elementAt(v1-1);
    	if (adjList.contains(v2-1) == false) {
    	    temp.add(v2);
    	    adjList.set(v1-1, temp);
    	    totalEdges++;
    	}
    }    
    public void display(){
	System.out.println("% Java Minigraph");
	System.out.println("total nodes: "+ totalNodes);
	System.out.println("total edges: "+ totalEdges);
	   

    }
    //print array??
    public void displayVE(){
	int v = 1;
	for (int i = 0; i < adjList.size(); i++) {
	    
	    System.out.println(v + ": " + adjList.get(i));
	    v++;
	}

    }
    public static void main(String argv[]) {
        //
        // test your implementation:
        //
        MyMiniGraph g = new MyMiniGraph();
        String[] s = {"A", "B", "C", "D", "E"};
        g.setVertex(s);
        g.setEdge(1,  2,  10);
        g.setEdge(2,  3,  7);
        g.display();
         
        // where a printout from the g.display() method should produce:
        //
        //  % java MyMiniGraph
        //  total nodes: 5
        //  total edges: 2
 
        g.displayVE();
    }
    
}
