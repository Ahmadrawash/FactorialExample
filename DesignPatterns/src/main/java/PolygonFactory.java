public class PolygonFactory {
    private Polygon poly;
    public static Polygon getPolygonFactory(int sides, int length) throws Exception
    {
        if (sides < 3) throw new Exception ("exception: invalid number of sides");

        switch(sides)
        {
            case 3:
                return new Triangle(length);
            case 4:
                return new Square(length);
            case 5:
                return new Pentagon(length);
            case 6:
                return new Hexagon(length);
        }
        return null;
    }


}
