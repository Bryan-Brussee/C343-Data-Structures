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
    private Vector<Integer> nodeEnum; // list of nodes pre visit
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
        totalNodes = totalEdges = 0;
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
        //
        //     TODO:
        //
        // ... your test code here ...
        //
    }


    public void DFS(int v) {
        setVisited(v);
        LinkedList<Integer> neighbors = adjList.elementAt(v);
        for (int i = 0; i < neighbors.size(); i ++) {
            int v1 = neighbors.get(i);
            if (ifVisited(v1) == false) DFS(v1); 
        }
    }
    public void BFS(int s) {
        ArrayList<Integer> toVisit = new ArrayList<Integer>();
        toVisit.add(s);
        while(toVisit.size() > 0) {
            int v = toVisit.remove(0); // first-in, first-visit
            setVisited(v);
            LinkedList<Integer> neighbors = adjList.elementAt(v);
            for (int i = 0; i < neighbors.size(); i ++) {
                int v1 = neighbors.get(i);
                if ((ifVisited(v1) == false) && (toVisit.contains(v1) == false)) {
                    toVisit.add(v1);
                }
            }
        }
    }

    public void myFloyd() {
	int[][] D = new int[totalNodes][totalNodes];
	for (int i = 0; i < D.length; i++) {//initialize with max values
	    for (int j = 0; j < D[i].length; j++) {
		D[i][j] = Integer.MAX_VALUE;
		D[i][i] = 0;
	    }}

	for (int i = 0; i < adjList.size(); i++) { // override max values with edges
	    for (int j = 0; j < adjList.get(i).size(); j++) {
		D[i][adjList.get(i).get(j)] = 1;}}

	for (int k = 0; k < totalNodes; k++) { //DO YOU COMPUTE??
	    for (int i = 0; i < totalNodes; i++) {
		for (int j = 0; j < totalNodes; j++) {
		    if ((D[i][k] != Integer.MAX_VALUE) &&
			(D[k][j] != Integer.MAX_VALUE) &&
			(D[i][j] > (D[i][k] + D[k][j])))
			D[i][j] = D[i][k]+D[k][j];
		}}}
			
	for (int i = 0; i < D.length; i++) {
	    for (int j = 0; j < D[i].length; j++) {
		System.out.print(D[i][j] + " ");
	    }
	    System.out.println();
	}
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
	String[] s = {"J1", "J2", "J3", "J4", "J5", "J6", "J7"};
	g.setVertices(s);
	g.setEdge("J1", "J2", 1);
	g.setEdge("J1", "J3", 2);
	g.setEdge("J2", "J6", 2);
	g.setEdge("J2", "J5", 2);
	g.setEdge("J2", "J4", 2);
	g.setEdge("J3", "J4", 2);
	g.setEdge("J4", "J5", 2);
	g.setEdge("J5", "J7", 2);
	g.myFloyd();
    }
}
