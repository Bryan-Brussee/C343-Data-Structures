// a simple class for binary trees
public class BinNodeJr <E extends Comparable<?super E>>{ 
	private E value;
	private BinNodeJr<E> left;
	private BinNodeJr<E> right;
	public BinNodeJr(E e) {
		value = e;
		left = right = null;
	}
	public void setLeft(BinNodeJr<E> node) {
		left = node;
	}
	public void setRight(BinNodeJr<E> node) {
		right = node;
	}
	public boolean find(E q) {
	    // this needs to be fixed so that it's not a random answer!
	    if (value.compareTo(q) == 0)
		{ 
		    return true;
		}
	    else 
		if(this.left == null && this.right == null) 
		    {
			return false;
		    }
	         else if(this.left != null && this.right == null)
		     { 
			 return this.left.find(q);
		     }
	    //else if(this.left == null && this.right!= null){ return this.right.find(q);}
	         else return this.left.find(q) || this.right.find(q);
	}
	    
	 
	        
	
	public static void main(String[] argv) {
	    System.out.println("BinNodeJr test running...");
	    // build a simple example tree:
		// BinNodeJr<Integer> root = new BinNodeJr<Integer>(10);
		// BinNodeJr<Integer> node1 = new BinNodeJr<Integer>(30);
		// BinNodeJr<Integer> node2 = new BinNodeJr<Integer>(40);ar
		// root.setLeft(node1);
		// root.setRight(node2);
		
	    //here is the specified tree: 
	    BinNodeJr<String> root = new BinNodeJr<String>("A");
	    BinNodeJr<String> node1 = new BinNodeJr<String>("B");
	    BinNodeJr<String> node2 = new BinNodeJr<String>("C");
	    BinNodeJr<String> node3 = new BinNodeJr<String>("D");
	    BinNodeJr<String> node4 = new BinNodeJr<String>("E");
	    BinNodeJr<String> node5 = new BinNodeJr<String>("F");
	    BinNodeJr<String> node6 = new BinNodeJr<String>("G");
	    BinNodeJr<String> node7 = new BinNodeJr<String>("H");
	    BinNodeJr<String> node8 = new BinNodeJr<String>("I");
	    BinNodeJr<String> node9 = new BinNodeJr<String>("J");
	    BinNodeJr<String> node10 = new BinNodeJr<String>("K");
	    BinNodeJr<String> node11 = new BinNodeJr<String>("L");
	    BinNodeJr<String> node12 = new BinNodeJr<String>("M");
	    root.setLeft(node1);
	    root.setRight(node2);
	    node1.setLeft(node3);
	    node1.setRight(node4);
	    node2.setLeft(node5);
	    node2.setRight(node6);
	    node3.setLeft(node7);
	    node4.setLeft(node8);
	    node4.setRight(node9);
	    node5.setLeft(node10);
	    node6.setLeft(node11);
	    node6.setRight(node12);
		
	    // find() needs to be implemented
	   System.out.println("is A in the tree? " + root.find("A"));
	   System.out.println("is B in the tree? " + root.find("B"));
	   System.out.println("is C in the tree? " + root.find("C"));
	   System.out.println("is E in the tree? " + root.find("E"));
	   System.out.println("is M in the tree? " + root.find("M"));


	    // find (40) should return true
	   System.out.println("is Z in the tree? " + root.find("Z"));
	   System.out.println("is Q in the tree? " + root.find("Q"));
	   System.out.println("is W in the tree? " + root.find("W"));

	   //System.out.println("is F in the tree? " + root.find("F"));
	    // find (100) should return false
	}
}
