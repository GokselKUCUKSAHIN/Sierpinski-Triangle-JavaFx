import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.shape.Line;

public class Triangle
{

    private Line[] triangle = new Line[3];
    private Group body = new Group();

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
    }

    public Node getBody()
    {
        return this.body;
    }

}
