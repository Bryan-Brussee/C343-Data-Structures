// a simple Java implementation of Graph using adjacency lists
// C343 Summer 2016
//
// original code by Yuzhen Ye - IU CSCI
//


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class AdjGraph implements Graph {
    private boolean digraph; // directed or undirected graph?
    private int totalNodes;
    private Vector<String> nodeList;
    private int totalEdges;
    private Vector<LinkedList<Integer>>  adjList; // adjacency list
    private Vector<Boolean> visited;
    private int compCount;
    private Vector<Integer> nodeEnum; // list of nodes pre visit
    private int count;
    public AdjGraph() {
        init();
    }
    public AdjGraph(boolean ifdigraph) {
        init();
        digraph = ifdigraph;
    }
    public void init() {
        nodeList = new Vector<String>(); 
        adjList = new Vector<LinkedList<Integer>>(); 
        visited = new Vector<Boolean>();
        nodeEnum = new Vector<Integer>();
        compCount = totalNodes = totalEdges = 0;
        digraph = false;
    }
    // add multiple vertices to the graph:
    public void setVertices(String[] nodes) {
        for (int i = 0; i < nodes.length; i ++) {
            nodeList.add(nodes[i]);
            adjList.add(new LinkedList<Integer>());
            visited.add(false);
            totalNodes ++;
        }
    }
    // add one vertex to the graph:
    public void addVertex(String label) {
        nodeList.add(label);
        visited.add(false);
        adjList.add(new LinkedList<Integer>());
        totalNodes ++;
    }
    // add one vertex to the graph:
    public int getNode(String node) {
        for (int i = 0; i < nodeList.size(); i ++) {
            if (nodeList.elementAt(i).equals(node)) return i;
        }
        return -1;
    }
    // return the number of vertices :
    public int length() {
        return nodeList.size();
    }
    // add edge from v1 to v2 :
    public void setEdge(int v1, int v2, int weight) {
        LinkedList<Integer> tmp = adjList.elementAt(v1);
        if (adjList.elementAt(v1).contains(v2) == false) {
            tmp.add(v2);
            adjList.set(v1,  tmp);
            totalEdges ++;
        }
    }
    // add edge from v1 to v2 :
    public void setEdge(String v1, String v2, int weight) {
        if ((getNode(v1) != -1) && (getNode(v2) != -1)) {
            // add edge from v1 to v2 :
            setEdge(getNode(v1), getNode(v2), weight);
            // for digraph, add edge from v2 to v1 as well :
            if (digraph == false) setEdge(getNode(v2), getNode(v1), weight);
        }
    }
    
    // for traversal purposes, it is important to keep track if a vertex has been visited or not:
    public void setVisited(int v) {
        visited.set(v, true);
        nodeEnum.add(v);
    }
    public boolean ifVisited(int v) {
        return visited.get(v);
    }
    public void clearWalk() {
        // clean up before traversing:
        nodeEnum.clear();
        for (int i = 0; i < nodeList.size(); i ++) visited.set(i, false);
    }
    public void walk(String method) {
        clearWalk();
        // traverse the graph:
        for (int i = 0; i < nodeList.size(); i ++) {
            if (ifVisited(i) == false) {
                if (method.equals("BFS")) BFS(i); // i as the start node
                else if (method.equals("DFS")) DFS(i); // i as the start node
                else {
                    System.out.println("unrecognized traversal order: " + method);
                    System.exit(0);
                }
            }
        }
        System.out.println(method + ":");
        displayEnum();
    }
    
    
    // modify walk() ...
    public void walk2(String method) {
        clearWalk();
        // traverse the graph:
	System.out.println(method);
        for (int i = 0; i < nodeList.size(); i ++) {
            if (ifVisited(i) == false) {
                if (method.equals("BFS")) {
		    int BFSNodes = BFS(i); 
		    compCount++;
		    System.out.println("component: " + compCount + " contains " + BFSNodes + " node(s).");
		} // i as the start node
                else if (method.equals("DFS")) {
		    int nodedfs = DFS(i);
		    compCount++;
		    System.out.println("component: " + compCount + " contains " + nodedfs + " node(s).");
		} // i as the start node
                else {
                    System.out.println("unrecognized traversal order: " + method);
                    System.exit(0);
                }
            }
        }
        //System.out.println(method + ":");
	//System.out.println("Total Components: " + compCount);
        displayEnum();
    }
    
    public int DFS(int v) {
        setVisited(v);
	count =1;
        LinkedList<Integer> neighbors = adjList.elementAt(v);
        for (int i = 0; i < neighbors.size(); i ++) {
            int v1 = neighbors.get(i);
            if (ifVisited(v1) == false) {count+=DFS(v1);}
	}	    
	    return count;
    }
    
    
    public int BFS(int s) {
	ArrayList<Integer> toVisit = new ArrayList<Integer>();
	toVisit.add(s);
	int count = 1;
	while(toVisit.size() > 0) {
	    int v = toVisit.remove(0); // first-in, first-visit
	    setVisited(v);
	    LinkedList<Integer> neighbors = adjList.elementAt(v);
	    for (int i = 0; i < neighbors.size(); i ++) {
		int v1 = neighbors.get(i);
		if ((ifVisited(v1) == false) && (toVisit.contains(v1) == false)) {
		    toVisit.add(v1);
		    count++;
		}
	    }
	}
	return count;
    }
    public void display() {
        System.out.println("total nodes: " + totalNodes);
        System.out.println("total edges: " + totalEdges);
    }
    public void displayEnum() {
        for (int i = 0; i < nodeEnum.size(); i ++) {
            System.out.print(nodeList.elementAt(nodeEnum.elementAt(i)) + " ");
        }
        System.out.println();
    }
    public static void main(String argv[]) {
	AdjGraph g = new AdjGraph();
	String[] s = {"A", "B", "C", "D", "E"};
	g.setVertices(s);
	g.setEdge("A", "B", 1);
	g.setEdge("B", "C", 2);
	g.walk2("DFS");
    }
}
