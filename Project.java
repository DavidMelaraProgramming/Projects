import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Project template to be used as a framework for the solution.
 *
 */
public class Project
{

    public static int counter = 0;

    public static int numberOfVertices = 0;

    static double exhaustiveSearchResult = 0;

    static int [] localSearchRouteStorage;

    static int [] exhaustiveSearchRouteStorage;
    public static Map<Integer,Point> myHashMap = new HashMap<>();

    public static void main(String[] args)
    {
        new Project();
    }

    /**
     * Reads input file with points, instantiates graph, obtain shortest route,
     * and graphs it.
     */
    public Project()
    {
        //read filename

        Scanner in = new Scanner(System.in);
        System.out.print("Name of file: ");

        String filename = in.nextLine();


        //get points from file
        ArrayList<Point> points = getPointsFromFile(filename);

        for(int i = 0; i < points.size(); i++) {

            myHashMap.put(i,points.get(i));

        }

        //obtain adjacency matrix and define graph with it
        int[][] matrix = generateMatrix(points);

        Graph g = new Graph(matrix);

        //compute solution to problem

        int[] localSearchRoute = new int[points.size()];

        double localSearchCost = g.TSP_localSearch(localSearchRoute);

        localSearchRouteStorage = new int[localSearchRoute.length];

        System.arraycopy(localSearchRoute,0,localSearchRouteStorage,0,localSearchRoute.length);

        int [] exhaustiveSearchRoute = new int[points.size()];

        double exhaustiveSearch = g.TSP_exhaustiveSearch(exhaustiveSearchRoute);

        exhaustiveSearchRouteStorage = new int[exhaustiveSearchRoute.length];

        System.arraycopy(exhaustiveSearchRoute,0,exhaustiveSearchRouteStorage,0,exhaustiveSearchRoute.length);

        exhaustiveSearchResult = exhaustiveSearch;

        FrameDisplay frame = new FrameDisplay(points, localSearchCost, localSearchRoute);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        System.out.println("localSearchRoute: "+Arrays.toString(localSearchRoute));

        System.out.println("exhaustiveSearchRoute: "+Arrays.toString(exhaustiveSearchRoute));

    }

    /**
     * Reads points from given input file and returns them in an array list.
     *
     * @param filename name of input file
     * @return array list of points
     */
    public static ArrayList<Point> getPointsFromFile(String filename)
    {
        //TO IMPLEMENT

        ArrayList<Point> myPointsList = new ArrayList<>();

        File input = new File(filename);

        Scanner in = null;

        try {

            in = new Scanner(input);

        } catch (FileNotFoundException e) {

            throw new RuntimeException(e);

        }

        try {

            numberOfVertices = in.nextInt();

        } catch(Exception e) {

            JOptionPane.showMessageDialog(null,"Please provide a valid .txt input file");

        }

        while(in.hasNextLine()) {

            int myX = 0;

            try {

                myX = in.nextInt();

            } catch(Exception e) {

                JOptionPane.showMessageDialog(null,"Please provide a valid .txt input file");

                return null;

            }

            int myY = 0;

            try {

                myY = in.nextInt();

            } catch(Exception e) {

                JOptionPane.showMessageDialog(null,"Please provide a valid .txt input file");

                return null;

            }

            counter += 1;

           myPointsList.add(new Point(myX,myY));

            if(counter ==  numberOfVertices) {
                return myPointsList;
            }

        }

        return null;

    }

    /**
     * Generates a square matrix from the given array list of points.
     * Cell [i][j] of the matrix will contain the distance between points[i] and
     * points[j].
     *
     * @param points array list of points
     * @return matrix of pairwise distances
     */
    public static int[][] generateMatrix(ArrayList<Point> points)
    {
        //TO IMPLEMENT
        int [][] adjacencyMatrix = new int[numberOfVertices][numberOfVertices];

        for(int i = 0; i < numberOfVertices; i++) {

            for(int j = 0; j < numberOfVertices; j++) {


               adjacencyMatrix[i][j] = (int)Math.sqrt(Math.pow(points.get(i).x-points.get(j).x,2) + Math.pow(points.get(i).y-points.get(j).y,2));


            }

        }

        return adjacencyMatrix;

    }


}
