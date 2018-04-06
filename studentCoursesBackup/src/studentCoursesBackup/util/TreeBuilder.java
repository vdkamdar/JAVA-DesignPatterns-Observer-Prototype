package studentCoursesBackup.util;

import studentCoursesBackup.myTree.Node;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TreeBuilder{
    private Node root;
    
    public TreeBuilder(){
	root = null;
    }

    public Node getRoot(){
	return root;
    }
    
    public void insert(Node node_orig, int b_number){	
	if(root == null){
	    root = node_orig;
	}
	else{
	    insertNode(root, b_number, node_orig);
	}
    }

    public void insertNode(Node node, int b_number, Node node_orig){
	int nodeBnumber = node.getBnumber();
	Node left = node.getLeft();
	Node right = node.getRight();
	
	if(b_number < nodeBnumber){
	    if(left == null){
		node.setLeft(node_orig);
	    }
	    else{
		insertNode(left, b_number, node_orig);
	    }
	}
	else if(b_number > nodeBnumber){
	    if(right == null){
		node.setRight(node_orig);
	    }
	    else{
		insertNode(right, b_number, node_orig);
	    }
	}
    }

    /**
     * @return Node - null if node not present, else returns the node
     */

    public Node searchNode(Node node, int b_number){

	if(node == null){
	    return node;
	}

	else if(node.getBnumber() == b_number){
	    return node;
	}
	
	else if(node.getBnumber() > b_number){
	    return searchNode(node.getLeft(), b_number);
	}

	else{
	    return searchNode(node.getRight(), b_number);
	}
    }

    public void delete(int bNumber, String course){
	Node status = searchNode(root, bNumber);
	if(status != null){
	    ArrayList<String> courses = status.getCourses();
	    courses.remove(course);
	    status.setCourses(courses);
	    status.notifyAll(courses);
	}
    }
    
    public void printNodes(Node current_node, ArrayList<String> outputFileResults){	
	if(root == null){
	    return;
	}
	else if(current_node != null){
	    printNodes(current_node.getLeft(), outputFileResults);
	    
	    outputFileResults.add(Integer.toString(current_node.getBnumber())+":"+current_node.getCourses());
	    
	    printNodes(current_node.getRight(), outputFileResults); 
	}
    }
}
