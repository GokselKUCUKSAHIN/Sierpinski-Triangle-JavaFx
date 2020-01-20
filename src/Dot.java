import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class Dot
{

    // DEFAULT Outer edge locations
    private double x = -100;
    private double y = -100;
    private Group body = new Group();

    public static ArrayList<Dot> dots = new ArrayList<>();

    public Dot(double x, double y)
    {
        draw();
        dots.add(this);
    }

    private void draw()
    {
        Circle center = new Circle(x, y, 4, Color.SNOW);
        center.setStroke(Color.SNOW.darker().darker());
        center.setStrokeWidth(0.3);
        Circle ring = new Circle(x, y, 10,Color.TRANSPARENT);
        ring.setStrokeWidth(3);
        ring.setStroke(Color.SNOW);
        this.body.getChildren().addAll(center, ring);
    }

    public Group getNode()
    {
        return this.body;
    }
}
