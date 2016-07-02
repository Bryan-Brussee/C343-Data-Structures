// a simple BST tree class named BSTJr, for CSCI C343 Summer 2016
//
// starting code for Homework 04:
// students need to implement balance checking for hw04
//
// original code by Yuzhen Ye, 2016

import java.lang.Math;

public class BSTJr <K extends Comparable<?super K>> {
    BinNode<K> root;
    BinNode<K> curr;
    //for balance checking: if a node is unbalanced, the tree will be unbalanced
    BinNode<K> unbalanced = null;
    public BSTJr() {
	root = null;
	curr = null;
    }
    public void build(K[] ks) {
	for(int i = 0; i < ks.length; i ++) insert(ks[i]);
    }
    public void insert(K k) {
	BinNode<K> t = new BinNode<K>(k);
	if(root == null) {
	    root = curr = t;
	}
	else {
	    curr = search(root, k);
	    if(k.compareTo(curr.getKey()) < 0) curr.setLeft(t);
	    else curr.setRight(t);
	}
    }
    public BinNode<K> search(BinNode<K> entry, K k) {
	if(entry == null) return null;
	else { 
	    entry.setSize(entry.getSize() + 1); 
	    //update the size of the subtree by one
	    if(entry.isLeaf()) return entry;
	    if(k.compareTo(curr.getKey()) < 0) {
		if(entry.getLeft() != null) return search(entry.getLeft(), k);
		else return entry;
	    }
	    else {
		if(entry.getRight() != null) return search(entry.getRight(), k);
		else return entry;
	    }
	}
    }
    public void display() { 
	if(root == null) return;
	System.out.println("Preorder enumeration: key(size-of-the-subtree)");
	preorder(root); 
	System.out.println();
    }
    public void preorder(BinNode<K> entry) {
	System.out.print(entry.getKey() + "(" + entry.getSize() + ") ");
	if(entry.getLeft() != null) preorder(entry.getLeft());
	if(entry.getRight() != null) preorder(entry.getRight());
    }

    public boolean balance(BinNode<K> node) {
	//base case
	if (node == null) {return true;}
	//iterate through the left subtree
	boolean lbalance = balance(node.getLeft());
	//iterate through the right subtree
	boolean rbalance = balance(node.getRight());
	//counts the depth of the left and right subtrees and adds +1
	//(to count for  the root node) to the longer strand
	if (lbalance && rbalance == true) {return true;}
	    } else {
		this.unbalanced == node;
		return false;
	}
    }
    //For each node, calculate the heights of its left subtree and its right subtree. 
    //If the difference between the two heights is greater than 1, then the node is unbalanced.
    //A tree is unbalanced if at least one node is unbalanced.
    public boolean checkBalance(BinNode<K> node) {
	//base case
	if (node == null) { return true; }
	//calculates the height of left subtree
	int lheight = height(node.getLeft());
	//calculates the height of the right subtree
	int rheight = height(node.getRight());

	//we can only say a tree is balanced when
	//the difference between the height of the left and right subtree
	//is no greater than one. 
	if (Math.abs(lheight - rheight) <= 1)
	    {return true;}
	return false;
    }

	public boolean newBalance(BinNode<K> node) {
		if (node == null){};
		int lheight = height



	}
	
    public static void main(String[] argv) {
	BSTJr<Integer> tree = new BSTJr<Integer>();
	Integer[] ks = {20, 10, 30, 35, 11, 29, 31};
	tree.build(ks);
	int test = tree.height(tree.root);
	System.out.println("The height of this tree is " + test);
	boolean test2 = tree.checkBalance(tree.root);
	System.out.println("This tree is balanced: " + test2); 
	tree.display();
    }
}
