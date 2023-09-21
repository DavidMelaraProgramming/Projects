# Projects

Title: 
Symmetric Traveling Salesman Problem with GUI Java

Description: 

The Travelling Salesman is one of the most prominent and famous unsolved problems in Computer Science. 
The idea is to find the optimal path given a certain amount of nodes (commonly less than 20). More specifically,
if you are given 10 points in the map of the United States, you would want to find the shortest path. It might
sound deceptively simple, but it has driven so many mathematicians to spend their entire career to a single project.
For a small number of nodes, such as 5, the brute force solution is easy. It is just a matter of trying all the
possible paths. This would be really easy. The paths is (n-1)!/2. So for 5 nodes, it will not be hard. But the issue
is that we want to be able to calculate the optimal path for millions of nodes. It is just not logical to try all
possibilities if the total paths is (n-1)!/2. To do so, we need to apply other methods such as local search. It is
important to note that the exhaustive method will always give the right answer, but it is not optimal even for a few
dozens of nodes. My program works remarkably for 12 nodes and below. The best solutions from the best Computer 
Scientists in the world run in exponential time complexity, which makes it extremely inefficient.

How to run the program:

In order to run the program, it is simply necessary to write a valid input .txt file.
For instance, if the user wants to test 10 points, then the first number of the input .txt file would be

10

And this would be followed by the points, two values per each of the 10 rows. The first value is x coordinate, and
the second value is y coordinate. A valid .txt input file would be the following:

10
100 50
200 40
270 30
140 20
290 55
343 63
120 50
336 80
270 60
110 23

Notice that the 10 is the number of points

The next row has a 100, which is the x coordinate of the first point.
The second number of that same row is 50, which is the y coordinate.

(x,y) = (100,50)

The next row has a 200 and a 40. The 200 would be the x coordinate 
of the second point and the 40 the y coordinate of the second point
(x,y) = (200,4)

When the program is played, it asks for a name of a .txt file. If you uploaded it to the project
and type the name for the user input, it will very rapidly calculate the optimal path based on 
exhaustive search and most of the times the optimal path based on local search. The reason for it
being most of the times is that local search is not guaranteed to give the optimal path. Sometimes 
it delivers the best path, but sometimes (at the cost of providing better efficiency than exhaustive search)
it delivers a good approximation to the optima path. For instance, if the optimal path is 108, sometimes
local search might give 108, but other times it might give something slightly bigger (still a good approximation) 
due to the fact that it is not checking all of the possibilities. It is more efficient than exhaustive search,
but it sometimes provides simple a decent approximation. Other times it does deliver the best path.


Credits:

Credits are given to the Reducible youtube channel, to Nicholas Christofides for his method that is guaranteed to be 
no more than 3/2 times the optimal path. Credits are also given to the developers of the minimum spanning tree and the
one-tree. 
