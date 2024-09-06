package inherit2;

public abstract class Shape {
    private int x;
    private int y;
    public Shape(){}
    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "X: " + x + ", Y: " + y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Abstract Method
    // Must
    public abstract double getArea();
    public abstract double getCircum();
}