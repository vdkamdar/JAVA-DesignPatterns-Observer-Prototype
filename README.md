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

Provide list of citations (urls, etc.) from where you have taken/referred code
(if any).

1. Split strings based on delimiter:
https://stackoverflow.com/questions/7787385/split-java-string-into-two-string-using-delimiter

2. Usage of HashMap:
http://www.java67.com/2013/02/10-examples-of-hashmap-in-java-programming-tutorial.html
https://stackoverflow.com/questions/13216314/hashmap-does-not-work-with-int-char

3. Difference between Map, HashMap, HashTable
https://stackoverflow.com/questions/9588959/difference-between-hashmap-and-map-in-java
https://stackoverflow.com/questions/40471/differences-between-hashmap-and-hashtable

4. Printing HashMap
https://stackoverflow.com/questions/5920135/printing-hashmap-in-java

5. Adding string to existing HashMap
https://stackoverflow.com/questions/29717234/java-adding-another-string-value-to-existing-hashmap-key-without-overwriting

6. Passing HashMap value as an argument
https://stackoverflow.com/questions/22806150/how-to-pass-hashmap-value-to-a-function

6. Reference to implement BST
http://www.sanfoundry.com/java-program-implement-binary-search-tree/
http://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/

7. Usage of this
https://stackoverflow.com/questions/516768/using-this-with-methods-in-java
https://stackoverflow.com/questions/6100402/how-does-an-object-pass-itself-as-a-parameter

8. Trobuleshoot
https://stackoverflow.com/questions/10559539/java-identifier-expected

9. Prototype Pattern/Insights on cloning
https://www.javaworld.com/article/2077578/learn-java/java-tip-76--an-alternative-to-the-deep-copy-technique.html
https://stackoverflow.com/questions/13206094/difference-between-creating-an-object-using-new-keyword-and-using-clone-method
https://stackoverflow.com/questions/5802118/why-we-use-clone-method-in-java
http://forums.devshed.com/java-help-9/create-deep-copy-tree-598440.html
http://www.j2eeonline.com/advanced-java-oop/module2/common-java-exceptions.jsp

10. Usage of ArrayList
https://www.tutorialspoint.com/java/util/arraylist_get.htm
https://www.tutorialspoint.com/java/util/arraylist_clear.htm
http://www.java67.com/2016/07/how-to-find-length-size-of-arraylist-in-java.html
https://stackoverflow.com/questions/14973566/find-the-index-in-an-arraylist-that-contains-a-string
https://stackoverflow.com/questions/19461161/remove-a-string-from-an-array-list
https://stackoverflow.com/questions/3943582/use-of-contains-in-java-arrayliststring

11. Observer pattern
https://www.tutorialspoint.com/design_pattern/observer_pattern.htm
https://www.journaldev.com/1739/observer-design-pattern-in-java

12. Performance and Time Complexities
http://bigocheatsheet.com/
https://stackoverflow.com/questions/14670770/binary-search-tree-over-avl-tree
http://infotechgems.blogspot.com/2011/11/java-collections-performance-time.html

13. File I/O 
Read file line by line: Referred to: https://rosettacode.org/wiki/Read_a_file_line_by_line#Java
Analysed different methods to write to file: http://www.baeldung.com/java-write-to-file
FileNotFound Exception: https://www.tutorialspoint.com/java/java_exceptions.htm