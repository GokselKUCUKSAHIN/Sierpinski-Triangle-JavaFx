import java.util.ArrayList;

public class Sierpinski
{
    private static ArrayList<Triangle> allTriangles = new ArrayList<>();
    private Dot[] dots = new Dot[3];
    private byte counter = 0;

    public Sierpinski()
    {
        // init
        for (int i = 0; i < 3; i++)
        {
            dots[i] = new Dot(-100, -100);
        }
    }

    public void insertADot(double x, double y)
    {
        if (counter >= 0 && counter <= 2)
        {
            dots[counter++].setLocation(x, y);
        }
        if (counter == 3)
        {
            // Clear Pass
            // clearAll();
            Triangle.triangles.clear();
            // Draw
            Triangle triangle = new Triangle(dots[0], dots[1], dots[2]);
            for (int i = 0; i < 364; i++) //1093
            {
                Triangle.triangles.get(i).generate();
            }
            for (Triangle tri: Triangle.triangles)
            {
                allTriangles.add(tri);
            }
            for (Triangle tri : Triangle.triangles)
            {
                tri.draw();
            }

            // reset all dot locations
            counter = 0;
            for (int i = 0; i < 3; i++)
            {
                dots[i].setLocation(-100, -100);
            }
        }
    }
    public static void clearAll()
    {
        for (Triangle triangle : allTriangles)
        {
            triangle.destroy();
        }
        allTriangles.clear();
    }

    public Dot[] getDots()
    {
        return this.dots;
    }
}