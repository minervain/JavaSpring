
public class Main {
    public static void main(String[] args) {
        Box<Integer> integerBox = new SimpleBox<>();
        integerBox.add(10);
        int value = integerBox.get();
        System.out.println("Integer value: " + value);

        Box<String> stringBox = new SimpleBox<>();
        stringBox.add("Hello");
        String text = stringBox.get();
        System.out.println("String value: " + text);
    }
}