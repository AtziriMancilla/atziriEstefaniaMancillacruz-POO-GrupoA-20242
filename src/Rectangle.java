public class Rectangle implements Shape{
    double width;
    double length;
    public Rectangle(double width,double length){
        this.width=width;
        this.length=length;
    }
    @Override
    public double perimeter() {
        return 2 * (width +length);
    }

    @Override
    public double area() {
        return width * length;
    }
}
