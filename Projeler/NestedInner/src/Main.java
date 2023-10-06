public class Main {
    public static void main(String[] args) {
        Outer outerObj = new Outer();
        Outer.InnerClass innerObj = outerObj.new InnerClass();

        innerObj.innerMethod();
    }
}