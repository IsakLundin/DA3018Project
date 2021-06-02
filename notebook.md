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

### Coding part
- Made a function that uses Depth First Search to look through a graph and finds all connected elements.
- This is then used in another function that finds the number of connected components in the graph.
- Created a function that finds the number of components in the graph by iterating and adding to a total.
- For the Component distribution I made a function the uses entrySet and gets the key and value.
- Now need to use the main function so that it prints out the right thing I want.

### Ideas
I created a Main function that prints out the correct data and has been tested on the test data.

This should then individually print out the results in different file so it will be easier to then get the data

in a histogram. I should probably create different java file for each required part in the assignment or try to 

find out how to print out each part in different file from the same java file.

When I have the files I should code something that takes the data and puts it in a histogram. I am not sure

if how hard that is in java, but I know I can do that in Python with matplot. Will probably try to do that in

java, but if it takes to much time I will just do it in Python.
