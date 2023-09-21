import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Defines the panel the drawings will be made in.
 *
 */
public class GraphDisplay extends JPanel
{
    ArrayList<Point> points;
    double localSearchCost;
    int[] localSearchRoute;

//    private int counter = 0;
    public GraphDisplay(ArrayList<Point> points,
                        double localSearchCost,
                        int[] localSearchRoute)
    {
        this.points = points;
        this.localSearchCost = localSearchCost;
        this.localSearchRoute = localSearchRoute;

    }


    public void paint(Graphics g)
    {
        //TO IMPLEMENT

        int labelX = 9;

        int labelY = 19;

        int i = 0;

        int counter = 0;

        g.setColor(Color.RED);

        while(counter != Project3.numberOfVertices) {

            g.fillOval(points.get(i).x*3,points.get(i).y*3,25,25);

            g.drawOval(points.get(i).x*3,points.get(i).y*3,25,25);

            g.setColor(Color.BLACK);

            g.drawString(String.valueOf(i),points.get(i).x*3+labelX,points.get(i).y*3+labelY);

            g.setColor(Color.RED);

            i++;

            counter++;

        }

        g.setColor(Color.BLACK);

        int b = 0;

        int length = Project3.localSearchRouteStorage.length;

        for(int a = 0; a < length-1; a++) {

            b = a+1;

            g.drawLine(3 * Project3.myHashMap.get(Project3.localSearchRouteStorage[a]).x + labelX,3 * Project3.myHashMap.get(Project3.localSearchRouteStorage[a]).y + labelY,3 * Project3.myHashMap.get(Project3.localSearchRouteStorage[b]).x + labelX,3 * Project3.myHashMap.get(Project3.localSearchRouteStorage[b]).y + labelY);

        }


        g.drawLine(3 * Project3.myHashMap.get(Project3.localSearchRouteStorage[length-1]).x + labelX,3 * Project3.myHashMap.get(Project3.localSearchRouteStorage[length-1]).y + labelY,3 * Project3.myHashMap.get(Project3.localSearchRouteStorage[0]).x + labelX,3 * Project3.myHashMap.get(Project3.localSearchRouteStorage[0]).y + labelY);

        int bb = 0;

        int [][] myMat = Project3.generateMatrix(points);

        g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,10));

        for(int aa = 0; aa < length-1; aa++) {

            bb = aa + 1;

            g.drawString(String.valueOf(myMat[Project3.localSearchRouteStorage[aa]][Project3.localSearchRouteStorage[bb]]),(3*(Project3.myHashMap.get(Project3.localSearchRouteStorage[aa]).x + Project3.myHashMap.get(Project3.localSearchRouteStorage[bb]).x)/2 + labelX),(3*(Project3.myHashMap.get(Project3.localSearchRouteStorage[aa]).y + Project3.myHashMap.get(Project3.localSearchRouteStorage[bb]).y)/2 + labelY));

        }

        g.drawString(String.valueOf(myMat[Project3.localSearchRouteStorage[length-1]][Project3.localSearchRouteStorage[0]]),(3*(Project3.myHashMap.get(Project3.localSearchRouteStorage[length-1]).x + Project3.myHashMap.get(Project3.localSearchRouteStorage[0]).x)/2 + labelX),(3*(Project3.myHashMap.get(Project3.localSearchRouteStorage[length-1]).y + Project3.myHashMap.get(Project3.localSearchRouteStorage[0]).y)/2 + labelY));

        int counter2 = 0;

        int h = 0;

        g.setColor(Color.RED);

        int necessaryIncrement = 300;

        while(counter2 != Project3.numberOfVertices) {

            g.fillOval(points.get(h).x*3+necessaryIncrement,points.get(h).y*3+necessaryIncrement,25,25);

            g.drawOval(points.get(h).x*3+necessaryIncrement,points.get(h).y*3+necessaryIncrement,25,25);

            g.setColor(Color.BLACK);

            g.drawString(String.valueOf(h),points.get(h).x*3+labelX+necessaryIncrement,points.get(h).y*3+labelY+necessaryIncrement);

            g.setColor(Color.RED);

            h++;

            counter2++;

        }


        int d = 0;

        int otherLength = Project3.exhaustiveSearchRouteStorage.length;

        for(int c = 0; c < otherLength-1; c++) {

            d = c+1;

            g.drawLine(Project3.myHashMap.get(Project3.exhaustiveSearchRouteStorage[c]).x*3 + labelX+necessaryIncrement,Project3.myHashMap.get(Project3.exhaustiveSearchRouteStorage[c]).y*3 + labelY+necessaryIncrement,Project3.myHashMap.get(Project3.exhaustiveSearchRouteStorage[d]).x*3 + labelX + necessaryIncrement,Project3.myHashMap.get(Project3.exhaustiveSearchRouteStorage[d]).y*3 + labelY + necessaryIncrement);

        }

        g.drawLine(Project3.myHashMap.get(Project3.exhaustiveSearchRouteStorage[otherLength-1]).x*3 + labelX + necessaryIncrement,Project3.myHashMap.get(Project3.exhaustiveSearchRouteStorage[otherLength-1]).y*3 + labelY + necessaryIncrement,Project3.myHashMap.get(Project3.exhaustiveSearchRouteStorage[0]).x*3 + labelX + necessaryIncrement,Project3.myHashMap.get(Project3.exhaustiveSearchRouteStorage[0]).y*3 + labelY + necessaryIncrement);

        int dd = 0;

        int [][] myExhaustiveSearchMatrix = Project3.generateMatrix(points);

        for(int cc = 0; cc < otherLength-1; cc++) {

            dd = cc + 1;

            g.drawString(String.valueOf(myExhaustiveSearchMatrix[Project3.exhaustiveSearchRouteStorage[cc]][Project3.exhaustiveSearchRouteStorage[dd]]),3*(Project3.myHashMap.get(Project3.exhaustiveSearchRouteStorage[cc]).x + Project3.myHashMap.get(Project3.exhaustiveSearchRouteStorage[dd]).x)/2 + labelX + necessaryIncrement,3*(Project3.myHashMap.get(Project3.exhaustiveSearchRouteStorage[cc]).y + Project3.myHashMap.get(Project3.exhaustiveSearchRouteStorage[dd]).y)/2 + labelY + necessaryIncrement);

        }

        g.drawString(String.valueOf(myExhaustiveSearchMatrix[Project3.exhaustiveSearchRouteStorage[otherLength-1]][Project3.exhaustiveSearchRouteStorage[0]]),3*(Project3.myHashMap.get(Project3.exhaustiveSearchRouteStorage[0]).x + Project3.myHashMap.get(Project3.exhaustiveSearchRouteStorage[otherLength-1]).x)/2 + labelX + necessaryIncrement,3*(Project3.myHashMap.get(Project3.exhaustiveSearchRouteStorage[0]).y + Project3.myHashMap.get(Project3.exhaustiveSearchRouteStorage[otherLength-1]).y)/2 + labelY + necessaryIncrement);

        g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,13));

        g.drawString("The graph that uses local search and starts at the "+Project3.localSearchRouteStorage[0]+"th vertex and follows the path of the "+Project3.localSearchRouteStorage[1]+"th vertex is the one shown in the upward left direction",150,765);

        g.drawString("The graph that uses exhaustive search and starts at the "+Project3.exhaustiveSearchRouteStorage[0]+"th vertex and follows the path of the "+Project3.exhaustiveSearchRouteStorage[1]+"th vertex is the one shown in the downward right direction",150,780);

        g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,13));

        g.drawString("The TSP path with the minimum cost using local search is: "+localSearchCost,150,735);

        g.drawString("The TSP path with the minimum cost using exhaustive search is: "+Project3.exhaustiveSearchResult,150,750);

    }


}
