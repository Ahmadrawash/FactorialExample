public class Polygon {
    public Polygon() {
    }

    public int getSides() {
        return sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    int sides;
    int length;

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    String shape;

    public Polygon(int length)
    {
        this.length = length;
    }


}
