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
    private Dot a;
    private Dot b;
    private Dot c;


    public Triangle(Dot a, Dot b, Dot c)
    {
        // Defines
        this.a = a;
        this.b = b;
        this.c = c;

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
            line.setOpacity(0.5);
            line.setStrokeWidth(0.5);
        }
        this.body.getChildren().addAll(triangle[0], triangle[1], triangle[2]);
        triangles.add(this);
    }

    public void draw()
    {
        Main.addNode(this.body);
    }

    public void destroy()
    {
        Main.removeNode(this.body);
    }

    public void generate()
    {
        // Mid Points
        double abX = (triangle[0].getStartX() + triangle[1].getStartX()) / 2;
        double abY = (triangle[0].getStartY() + triangle[1].getStartY()) / 2;
        double bcX = (triangle[1].getStartX() + triangle[2].getStartX()) / 2;
        double bcY = (triangle[1].getStartY() + triangle[2].getStartY()) / 2;
        double caX = (triangle[2].getStartX() + triangle[0].getStartX()) / 2;
        double caY = (triangle[2].getStartY() + triangle[0].getStartY()) / 2;

        // Mid Dots
        Dot ab = new Dot(abX, abY);
        Dot bc = new Dot(bcX, bcY);
        Dot ca = new Dot(caX, caY);

        // Triangles
        new Triangle(a, ab, ca);
        new Triangle(ab, b, bc);
        new Triangle(ca, bc, c);
    }
}