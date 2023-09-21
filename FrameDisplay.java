import javax.swing.*;
import java.util.ArrayList;

/**
 * Defines a frame to which a panel with drawings will be added.
 *
 */
public class FrameDisplay extends JFrame
{
    int WIDTH = 450;
    int HEIGHT = 450;

    public FrameDisplay(ArrayList<Point> points,
                        double localSearchCost,
                        int[] localSearchRoute)
    {

        setTitle("Graph Display");
        setSize(4*WIDTH, 2*HEIGHT);

        GraphDisplay panel = new GraphDisplay(points,localSearchCost,localSearchRoute);

        add(panel);

    }



}
