package studentCoursesBackup.util;

import java.io.FileNotFoundException;
import studentCoursesBackup.util.TreeBuilder;
import studentCoursesBackup.myTree.Node;
import java.util.HashMap;
import java.util.ArrayList;

public interface FileDisplayInterface{
    public void writeToFile(TreeBuilder tree, Node current_node) throws FileNotFoundException;
}
