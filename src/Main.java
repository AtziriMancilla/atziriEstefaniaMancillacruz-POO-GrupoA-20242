//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Circle circle=new Circle(5);
        Rectangle rectangle=new Rectangle(3,5);
        Square square=new Square(10);
        Triangle triangle=new Triangle(5,5,8);
        System.out.printf("El area del circulo es: %f, su perimetro es: %f\n",circle.area(),circle.perimeter());
        System.out.printf("El area del rectangulo es: %f, su perimetro es: %f\n",rectangle.area(),rectangle.perimeter());
        System.out.printf("El area del cuadrado es: %f, su perimetro es: %f\n",square.area(),square.perimeter());
        System.out.printf("El area del triangulo es: %f, su perimetro es: %f",triangle.area(),triangle.perimeter());
    }
}