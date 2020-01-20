import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.ArrayList;

public class Triangle
{

    private Line[] triangle = new Line[3];
    private Group body = new Group();
    public static ArrayList<Triangle> triangles = new ArrayList<>();

    public Triangle(Dot a, Dot b, Dot c)
    {
        // Dots
        double aX = a.getNode().getLayoutX();
        double aY = a.getNode().getLayoutY();
        double bX = b.getNode().getLayoutX();
        double bY = b.getNode().getLayoutY();
        double cX = c.getNode().getLayoutX();
        double cY = c.getNode().getLayoutY();
        // Lines
        triangle[0] = new Line(aX, aY, bX, bY); // AB Line
        triangle[1] = new Line(bX, bY, cX, cY); // BC Line
        triangle[2] = new Line(cX, cY, aX, aY); // CA Line
        // Settings
        for (Line line : triangle)
        {
            line.setStroke(Color.SNOW);
            line.setStrokeWidth(1.1);
        }
        this.body.getChildren().addAll(triangle[0], triangle[1], triangle[2]);
        triangles.add(this);
    }

    public void draw()
    {
        Main.addNode(this.body);
    }

    /*public Node getBody()
    {
        return this.body;
    }*/
}
