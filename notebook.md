# Notebook

## 23/5-21
- Created Repository
- Added a file for testing with 1000 first lines of the original data by using
$ head -1000 filename > ProjectTestFile

## 24/5-21
Had help from TA about the project and got some questions answered.
- I should remove the line if either the first or the second config is overlapping entirely.
- I have to convert the vertex string into integer, perhaps with hashing (Need to look into this more). 
- Either create a Hash Table or maybe a graph with Arraylist with the vertex and neighbors as values.
- I will definitely need more help with how to get the test data working with code.

### Answer about the assignment
- Node degree distribution: This means how many neighbors every node has.
- Number of components: This means how many disconnected graphs there are.
- Component size distribution: This means how many of these disconnected graphs has x amount of nodes.

## 1/6-21
Took a break from the project to focus on course finals. But now back to work.
- Used a good unix command that checks if there is overlap in the two identifiers and remove them if there is with
- awk '{ if ($7-$6 < $8 && $11-$10 < $12) }' filename
- The new data can be stored in a new file that will be easier to test and write code for.

### Coding part
- Using a HashMap to save the vertecies as integers and storing all their adjacent vertecies in a LinkedList.
- As I have already removed overlapping edges with a unix command I don't need to think about that in my code.
- So I create a function that take to integers and create edges between the vertecies from stdin.
- We also check if they are already in the map or not.
- Created a function that degree distribution of the graph.
- For that I need a helper function that gets the size of a keys linkedlist.
- Using Scanner to read from stdin.
- The degree distribution seems to work for smaller sets atleast.

## 2/6-21
Made some discoveries about the datafile we recieved.
- The data file which should have around 11 million lines actually has around 64 million lines.
- And after I removed overlap it is still around 22 million lines left.
- I have 16 GB Ram, so it should be fine. But it will probably take alot longer to use code on the file.
