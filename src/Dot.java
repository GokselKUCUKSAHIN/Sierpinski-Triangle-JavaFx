import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class Dot
{

    // DEFAULT Outer edge locations
    private double x;
    private double y;
    private Group body = new Group();

    //public static ArrayList<Dot> dots = new ArrayList<>();

    public Dot(double x, double y)
    {
        this.x = x;
        this.y = y;
        draw();
        //dots.add(this);
    }

    private void draw()
    {
        this.body.setLayoutX(x);
        this.body.setLayoutY(y);
        Circle center = new Circle(0, 0, 2.5, Color.SNOW);
        center.setStroke(Color.SNOW.darker().darker());
        center.setStrokeWidth(0.3);
        Circle ring = new Circle(0, 0, 6.3, Color.TRANSPARENT);
        ring.setStrokeWidth(1.2);
        ring.setStroke(Color.SNOW);
        this.body.getChildren().addAll(center, ring);
    }

    public void setLocation(double x, double y)
    {
        this.body.setLayoutX(x);
        this.body.setLayoutY(y);
    }

    public Group getNode()
    {
        return this.body;
    }
}
