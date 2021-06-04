# Project Report

## Isak Lundin, VT2021

### Problem description
The goal of this project was to help an imaginary collaborator understand a data set better. The data set could
be presented as a graph which allowed some features to be analysed, that being.
- The node degree distribution of the graph.
- The number of components of the graph.
- The component size distribution of the graph.
The data set contains information of a large set of contigs where each line can represent a possible edge. Eace 
line also contains 12 lines of informtion for that edge where column 1,2 which contains vertices and 6,7,8,10,11,12
that contains information of overlapping contigs.

### Solutions and algorithms

#### Removing overlap
The data set contains contigs that is overlapping which does not give information to our final result and take
processing power. Removing this was solved by using a unix command that removes the line if there exist a full 
overlap and only prints out the necessary information.

#### Creating the graph
Now that the data is shortened it is time to use our data set and create a graph with the edges. It made most 
sense to use a HashMap which we can store vertices as keys and a LinkedList with the adjacency list as values to
that key. This is great while working on large data sets of strings as it can store the strings as integers which
takes less memory and has a better time complexity than for example a solution where we store the values in an array.
To build the graph the program read each line from System.in and does two things. First check if the contig has been
seen before and if it has not, it save that to a seperate HashMap that store that value as a integer. Secondly we 
produce an edge between that pair of vertices. This solution have a O(n) time complexity because we have a loop that 
have operations of O(1) time complexity in them because of the HashMap. If the soultion instead used for example
an ArrayList it would have to O(n^2) time complexity as it would also have to search through the entire ArrayList
to find an element.
