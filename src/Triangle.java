public class Triangle extends Shape{
    double side1;
    double side2;
    double side3;
    public Triangle(double side1,double side2,double side3){
        this.side1=side1;
        this.side2=side2;
        this.side3=side3;
    }
    @Override
    public double perimeter() {
        return side1+side2+side3;
    }
    private double semiperimeter(){
        double p=perimeter();
        return p/2;
    }
    @Override
    public double area() {
        double s=semiperimeter();
        return Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
    }
}
