package inherit2;

public class Rectangle extends Shape{
    private int w;
    private int h;
    public Rectangle() {}
    public Rectangle(int x, int y, int w, int h) {
        super(x, y);
        this.w = w;
        this.h = h;
    }

    @Override
    public String toString() {
        return "Rectangle [w=" + w + ", h=" + h + "]"+super.toString();
    }

    @Override
    public double getArea() {
        return this.w * this.h;
    }

    @Override
    public double getCircum() {
        return (this.w + this.h) * 2;
    }
}