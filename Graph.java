import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Implements a Graph. Uses an adjacency matrix to represent the graph.
 *
 * @author David Melara, 6233684, Section: UO1
 */
public class Graph implements GraphInterface
{

    private int[][] matrix; //adjacency matrix
    private int verticesNumber;

    /**
     * Default constructor. Defines an empty graph of 5 vertices.
     */
    public Graph()
    {
        //TO IMPLEMENT
        verticesNumber = 5;
        matrix = new int[verticesNumber][verticesNumber];

    }

    /**
     * Parameterized constructor. Defines an empty graph of n vertices.
     *
     * @param n number of vertices in the graph
     */
    public Graph(int n)
    {
        //TO IMPLEMENT
        verticesNumber = n;
        matrix = new int[verticesNumber][verticesNumber];
    }

    /**
     * Parameterized constructor. Creates a graph as defined by the matrix
     * parameter.
     *
     * @param matrix given adjacency matrix
     */
    public Graph(int[][] matrix)
    {
        //TO IMPLEMENT
        verticesNumber = matrix.length;
        this.matrix = matrix;
    }



    /**
     * Adds an edge between given vertices with given weight.
     *
     * @param v given vertex
     * @param w given vertex
     * @param weight given weight
     */
    public void addEdge(int v, int w, int weight)
    {
        //TO IMPLEMENT
        matrix[v][w] = weight;
        matrix[w][v] = weight;

    }

    /**
     * Finds vertices adjacent to a given vertex.
     *
     * @param v given vertex
     * @return list of vertices adjacent to v stored in an array; size of array
     * = number of adjacent vertices
     */
    public int[] findAdjacencyVertices(int v)
    {
        //TO IMPLEMENT
        int[] vert = new int[verticesNumber];
        int total = 0;

        for (int i=0; i<verticesNumber; i++)
        {
            if (matrix[v][i] != 0)
            {
                vert[total] = i;
                total++;
            }
        }

        return Arrays.copyOf(vert, total);

    }

    /**
     * Returns the number of vertices of this graph.
     *
     * @return number of vertices of this graph
     */
    public int getNumberOfVertices()
    {
        //TO IMPLEMENT
        return verticesNumber;

    }

    /**
     * Returns weight of edge between given vertices.
     *
     * @param v given vertex
     * @param w given vertex
     * @return
     */
    public int getWeight(int v, int w){

        return matrix[v][w];

    }

    /**
     * Removes edge between given vertices.
     *
     * @param v given vertex
     * @param w given vertex
     */
    public void removeEdge(int v, int w)
    {
        //TO IMPLEMENT

        matrix[v][w] = 0;
        matrix[w][v] = 0;

    }

    /**
     * Returns a string description of this graph.
     *
     * @return string description of the graph
     */
    public String toString()
    {
        //TO IMPLEMENT
        String s = "";

        for (int i=0; i<verticesNumber; i++)
        {
            for (int j=0; j<verticesNumber; j++)
            {
                s += matrix[i][j] + " ";
            }
            s += "\n";
        }

        return s;
    }

    /**
     * Calculates distance of given route.
     *
     * @param a route
     *
     * @return distance of route
     */
    private int totalDistance(int[] a)
    {
        //TO IMPLEMENT

        int n = verticesNumber;

        int totalWeight = 0;

        for(int i = 0; i < n; i++) {

            int weight = matrix[a[i]][a[(i + 1) % n]];
            totalWeight += weight;


        }

        return totalWeight;

    }

    private void totalDistance(int[] a, ArrayList<Point>emptyList)
    {
        //TO IMPLEMENT

        int n = verticesNumber;

        int totalWeight = 0;

        for(int i = 0; i < n; i++) {

            int weight = matrix[a[i]][a[(i + 1) % n]];
            totalWeight += weight;
            emptyList.add(new Point(a[i],a[(i+1)%n]));

        }

    }


    /**
     * Given an array, generates random permutation of values in [0, n-1],
     * where n is size of given array; random permutation will be stored
     * in the array. Uses Fisher-Yates shuffle algorithm.
     *
     * @param a output array
     */

    public void randomPermutation(int [] a) {

        //TO IMPLEMENT

        for(int i = 0; i < a.length; i++)
            a[i] = i;

        Random rnd = new Random();

        for(int i = a.length-1; i > 0; i--) {

            int randomLocation = rnd.nextInt(i+1);

            if(randomLocation != i) {

                int temp = a[i];

                a[i] = a[randomLocation];

                a[randomLocation] = temp;

            }

        }

    }


    /**
     * Finds a shortest route that visits every vertex
     * exactly once and returns to the starting point.
     * Uses local search, so optimal solution is not
     * obtained, in general.
     *
     * @param shortestRoute array with a shortest path (return value)
     *
     * @return shortest distance
     */

    public int TSP_localSearch(int[] shortestRoute)
    {
        //TO IMPLEMENT

        int bestDistance;

        int [] a = new int[verticesNumber];

        randomPermutation(a);

        System.arraycopy(a,0,shortestRoute,0,verticesNumber);

        bestDistance = totalDistance(shortestRoute);

        boolean betterSolutionFound;

        do {

            betterSolutionFound = false;

            PermutationNeighborhood pn = new PermutationNeighborhood(shortestRoute);

            while(pn.hasNext()) {

                a = pn.next();

                int currentDistance = totalDistance(a);

                if(currentDistance < bestDistance) {

                    System.arraycopy(a,0,shortestRoute,0,verticesNumber);

                    bestDistance = currentDistance;

                    betterSolutionFound = true;

                }

            }

        }while(betterSolutionFound);


        return bestDistance;

    }

    public int [][] getMatrix() {

        return matrix;

    }


    public int TSP_exhaustiveSearch(int [] shortestRoute) {

        for(int i = 0; i < verticesNumber; i++) {

            shortestRoute[i] = i;

        }

        int [] a = new int[verticesNumber];

        TSP_exhaustiveSearch(shortestRoute,a,0);

        return totalDistance(shortestRoute);

    }

    private ArrayList<Integer> constructCandidateSet(int [] a, int k) {

        ArrayList<Integer> candidates = new ArrayList<>();

        boolean [] b = new boolean[a.length];

        for(int i = 0; i < k; i++) {
            b[a[i]] = true;
        }

        for(int i = 0; i < a.length; i++) {
            if(!b[i]) candidates.add(i);
        }

        return candidates;

    }
    private void TSP_exhaustiveSearch(int [] shortestRoute, int [] a, int k) {

        if(k == a.length) {

            if(totalDistance(a) < totalDistance(shortestRoute)) {
                System.arraycopy(a,0,shortestRoute,0,verticesNumber);
            }

        } else {

            ArrayList<Integer> Sk = constructCandidateSet(a,k);

            for(int s : Sk) {

                a[k] = s;
                TSP_exhaustiveSearch(shortestRoute,a,k+1);

            }

        }



    }









}
