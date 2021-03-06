package studentCoursesBackup.driver;

import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.TreeBuilder;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.myTree.Node;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.lang.RuntimeException;

public class Driver{
    public static void main(String args[]) throws Exception{
	String inputFile = null;
	String deleteFile = null;
	String outputFile1 = null;
	String outputFile2 = null;
	String outputFile3 = null;
	try{
	    if(args.length == 5){
		inputFile = args[0];
		deleteFile = args[1];
		outputFile1 = args[2];
		outputFile2 = args[3];
		outputFile3 = args[4];
	    }
	    else{
		throw new RuntimeException();
	    }
	}
	catch (Exception e){
	    System.err.println("Five argumemts expected!");
	    e.printStackTrace();
	    System.exit(0);
	}
	
	FileProcessor fp_input = new FileProcessor(inputFile);
	FileProcessor fp_delete = new FileProcessor(deleteFile);

	String line = null;
	int key = 0;
	String[] str_array = new String[2];
	HashMap<Integer,ArrayList<String>> student_records = new HashMap<Integer,ArrayList<String>>();
	String course;
	ArrayList<String> courses;
	
	TreeBuilder tree = new TreeBuilder();
	TreeBuilder backup_tree_1 = new TreeBuilder();
	TreeBuilder backup_tree_2 = new TreeBuilder();
	
	Results results_orig = new Results(outputFile1);
	Results results_backup_1 = new Results(outputFile2);
	Results results_backup_2 = new Results(outputFile3);

	Node status, node_orig, backup_node_1, backup_node_2;
	
	while((line = fp_input.readLine()) != null){    
	    str_array = line.split(":");
	    key = Integer.parseInt(str_array[0]);
	    course = str_array[1];
		
	    if(student_records.containsKey(key)){
		courses = student_records.get(key);
		if(!courses.contains(course)){
		    courses.add(course);
		    student_records.put(key, courses);

		    node_orig = tree.searchNode(tree.getRoot(), key);
		    ArrayList<String> temp = node_orig.getCourses();
		    temp.add(course);
		    node_orig.setCourses(temp);

		    node_orig.removeObservers();

		    backup_node_1 = node_orig.clone();
		    backup_node_2 = node_orig.clone();
		    
		    node_orig.registerObserver(backup_node_1);
		    node_orig.registerObserver(backup_node_2);
		}
	    }
	    else{
		courses = new ArrayList<String>();
		courses.add(course);		
		student_records.put(key, courses);
		    
		node_orig = new Node(key, course);
		backup_node_1 = node_orig.clone();
		backup_node_2 = node_orig.clone();

		node_orig.registerObserver(backup_node_1);
		node_orig.registerObserver(backup_node_2);
		    
		tree.insert(node_orig, key);
		backup_tree_1.insert(backup_node_1, key);
		backup_tree_2.insert(backup_node_2, key); 
	    }
	}
	
	while((line = fp_delete.readLine()) != null){    
	    str_array = line.split(":");
	    key = Integer.parseInt(str_array[0]);
	    course = str_array[1];
	
	    tree.delete(key, course);
	}
	    	
	results_orig.writeToFile(tree, tree.getRoot());
	results_backup_1.writeToFile(backup_tree_1, backup_tree_1.getRoot());
	results_backup_2.writeToFile(backup_tree_2, backup_tree_2.getRoot());
    }
}
