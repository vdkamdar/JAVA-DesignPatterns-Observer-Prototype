# JAVA-DesignPatterns-Observer-Prototype #

Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=FIRST -Darg1=SECOND -Darg2=THIRD -Darg3=FOURTH -Darg5=FIFTH

-----------------------------------------------------------------------

## To create tarball for submission
ant -buildfile src/build.xml tarzip or tar -zcvf vidhi_kamdar_assign_2.tar.gz vidhi_kamdar_assign_2

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.

[Date: 03/10/2017]

-----------------------------------------------------------------------
Brief on implementation of Observer Pattern and Protoype Pattern:
-> Driver: Read a line from file. If node does not exist, Create new node-Create backup nodes-Register observers-Insert nodes into three trees.
								  If node exists, Update node courses-Remove observers-Create backup nodes-Register observers-Insert nodes into three trees.
->TreeBuilder: Inserts node
->Driver: Processes file input and calls delete.
->TreeBuilder: Deletes the course-Calls NotifyAll in Node-which
->Node: Notifies all observers-Calls Update-Update courses for the backup nodes.


Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)

Data Structure for creating tree: Unbalanced Binary Search Tree
Why I choose unbalanced Binary Search Tree over AVL: AVL consumes more memory as it has to maintain balance factor and each operation can be more slower in order to perform rotations.
BST in the average case has O(log n), worst case has O(n) time complexity while AVL has O(log n). As BST consumes less memory and is easy to debug,
and know that the worst case will be rare here, hence BST is better to implement than AVL. 

Data structure for storing input while reading from file: HashMap<Integer, ArrayList<String>>
HashMap is not synchronized. We dont't  have multi-threading environment here, so it's fine.
HashMap allows one null key and any number of null values: There is a possibility that there are no courses assigned to a student.
HashMap doesn't maintain insertion order like LinkedHashMap. We don't need to , hence this is fine. Output has to be sorted according to bnumber which is taken care by insert operation.
Big O Time complexity: containsKey - O(1); get() - O(1)

ArrayList<String> for storing results:
ArrayList is not fixed size, hence we can modify it more frequently when needed.Storing results needs constant change in size of the list according to the test cases.Even if we set an initial size, we can still modify the size
Big O Time complexity:O(n) under normal circumstances

-----------------------------------------------------------------------
