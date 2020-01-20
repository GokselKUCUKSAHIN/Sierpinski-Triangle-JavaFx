public class Sierpinski
{

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
            //draw

            //reset all dot's location
            counter = 0;
            for (int i = 0; i < 3; i++)
            {
                dots[i].setLocation(-100, -100);
            }
        }
    }

    public Dot[] getDots()
    {
        return this.dots;
    }
}