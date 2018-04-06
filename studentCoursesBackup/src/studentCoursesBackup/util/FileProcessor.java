package studentCoursesBackup.util;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FileProcessor{
    private Scanner in = null;

    public FileProcessor(String filename) throws Exception{
	File f = new File(filename);
	in = new Scanner(f);
    }

    /**
    *@return next line of the input file
    */    
    public String readLine()throws FileNotFoundException{
	String line = "";
	try{
	    if(in == null){
		throw new RuntimeException("File is closed!");
	    }
	    while(in.hasNext()){
		line = in.next();
		return line;
	    }
	    line = null;
	    closeInScanner();
	    return line;
	}
	catch(Exception e){
	    closeInScanner();
	    throw e;
	}
    }

    public void closeInScanner(){
	 if(in != null){
		in.close();
		in = null;
	 }
    }
}
