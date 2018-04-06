package studentCoursesBackup.myTree;

import java.util.ArrayList;
import java.lang.CloneNotSupportedException;

public class Node implements ObserverI, SubjectI, Cloneable{
    private int b_number;
    private ArrayList<String> courses;
    private ArrayList<Object> observers;
    private Node left, right;

    public Node(int b_number, String course){
	this.left = null;
	this.right = null;
	this.b_number = b_number;
	this.courses = new ArrayList<String>();
	(this.courses).add(course);
	this.observers = new ArrayList<Object>();
    }

    /*
     *@return int - b_number
     **/
    
    public int getBnumber(){
	return b_number;
    }

    /*
     *@return ArrayList<String> - courses
     **/

    public ArrayList<String> getCourses(){
	return courses;
    }

    public void setCourses(ArrayList<String> courses){
	this.courses = courses;
    }

    /*
     *@returns Node - left
     **/
    
    public Node getLeft(){
	return left;
    }

    public void setLeft(Node left){
	this.left = left;	
    }

     /*
     *@returns Node - right
     **/
    
    public Node getRight(){
	return right;
    }

    public void setRight(Node right){
	this.right = right;
    }

    public void registerObserver(ObserverI o){
	observers.add(o);
    }
    
    public void removeObserver(ObserverI o){
	if(observers.indexOf(o) >= 0){
	    observers.remove(observers.indexOf(o));
        }
    }

    public void removeObservers(){
	observers.clear();
    }
    
    public void notifyAll(ArrayList<String> courses){
	Node temp = null;
	for(int i=0; i<observers.size(); i++){
	    temp = (Node)observers.get(i);
	    temp.update(courses);
	}
    }

    public void update(ArrayList<String> courses){
	this.courses = courses;
    }

    /*
     *@returns Node - cloned Node
     **/
    
    public Node clone(){
	Node node_backup;
	try{
	    node_backup = (Node)super.clone();
	}
	catch(CloneNotSupportedException e){
	    throw new AssertionError(e);
	    e.printStackTrace();
	    System.exit(0);
	}
	return node_backup;
    }
}
