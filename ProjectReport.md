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

#### Finding node degree distribution
To find the node degree distribution, a HashMap was also used because of its efficency. Then an iteration over the 
HashMap to find their values and store them in another HashMap and print their values. Looking at its time complexity
it will be O(n + m) where n is the number of vertices and m is the vaiance in degree. Fortunatly m cannot possibly
be larger than the number of vertices, which means the time complexity is only O(n).

#### Finding number of components and component size distribution
To find these a method to efficiently traverse through the graph. A Depth First Search made the most sense as the
structure of the graph is for the most part unknown and DFS onlt requires parents nodes of an element to be stored,
which means that DFS is more memory efficent compared to a BFS. Also a Requirement to find the shortest path is not 
necessary in this project so DFS made the most sense to use. A second method is used to iterate all vertices and 
stores them in HashMap. Through this method we can both find the number of componets by iterating over the HashMap
and adding all values of each key. Finding the component size distribution the loop the method updates the component
size as a key and the value is number of components to that key. This has a time complexity of O(|V|+|E|) where |V|
is the number of vertices and |E| is the number of edges.

### Results
The results was found with a unix command that removes all unecessary lines and using the program and printing out
the results in a text file. From looking at the file with the node degree distribution  it is seen that the 
beginning of the graph is very varied and that they have a large amount of occurrences that rapidly decreases and
the higher node degrees only have single digit amounts. From the same file node degree 1 is the most common with
around 2.6 million occurrences and the highest node degree is 855 with only 1 occurence.

Similiarly as the node degree distribution, the component size distribution shows that the smaller componet sizes
is more common and the larger the component size the fewer occurences. A component size of 2 is most common with 533203 
occurences and the largest component sizes only occur once. One interesting observation is that the second
largest components size is 1804, but after that there is a huge jump to the largest with around 2.5 million. Adding 
the total together it seems that 961874 is the total amount of components in the graph. 


