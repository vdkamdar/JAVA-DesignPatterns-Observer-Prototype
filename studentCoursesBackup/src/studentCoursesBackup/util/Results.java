package studentCoursesBackup.util;

import studentCoursesBackup.util.TreeBuilder;
import studentCoursesBackup.myTree.Node;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Results implements FileDisplayInterface, StdoutDisplayInterface{

    private String outputFile;
    private ArrayList<String> outputFileResults = new ArrayList<String>();

    public Results(String outputFile){
	this.outputFile = outputFile;
    }
    
    public void writeToFile(TreeBuilder tree, Node current_node){
	PrintWriter pw = null;
	try{
	    pw = new PrintWriter(this.outputFile);
	}
	catch(FileNotFoundException e){
	    throw new RuntimeException(e);
	    e.printStackTrace();
	    System.exit(0);
	}
	tree.printNodes(current_node, outputFileResults);
	
	for(int i=0; i<outputFileResults.size(); i++){
	    pw.println(outputFileResults.get(i));
	}
	pw.close();
    }

    public void writeToStdout(TreeBuilder tree, Node current_node){
	tree.printNodes(current_node, outputFileResults);
	for(int i=0; i<outputFileResults.size(); i++){
	    System.out.println(outputFileResults.get(i));
	}
    }
}
