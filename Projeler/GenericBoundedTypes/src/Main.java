public class Main {
    public static void main(String[] args) {
        BoundedTypeExample<Integer> integerExample = new BoundedTypeExample<>(5);
        double intSquare = integerExample.square();
        System.out.println("Integer Square: " + intSquare);

        BoundedTypeExample<Double> doubleExample = new BoundedTypeExample<>(2.5);
        double doubleSquare = doubleExample.square();
        System.out.println("Double Square: " + doubleSquare);
    }
}