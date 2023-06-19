public class Outer  {
    private int outerVariable = 10;

    public void outerMethod() {
        System.out.println("Dış sınıfın metodu");
    }

    public class InnerClass {
        private int innerVariable = 20;

        public void innerMethod() {
            System.out.println("İç sınıfın metodu");
            System.out.println("Dış değişkene erişme: " + outerVariable);
            outerMethod();
        }
    }


}