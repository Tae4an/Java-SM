package inherit2;

public class Triangle extends Shape{
    private int w;
    private int h;
    public Triangle() {}
    public Triangle(int x, int y, int w, int h) {
        super(x, y);
        this.w = w;
        this.h = h;
    }

    @Override
    public String toString() {
        return "Triangle [w=" + w + ", h=" + h + "]"+super.toString();
    }

    @Override
    public double getArea() {
        return (this.w * this.h) / 2;
    }

    @Override
    public double getCircum() {
        return Math.sqrt(Math.pow(this.w,2) + Math.pow(this.h,2));
    }
}