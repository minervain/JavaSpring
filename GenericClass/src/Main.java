public class Main {
    public static void main(String[] args) {
        Pair<String, Integer> pair1 = new Pair<>("Java", 10);
        System.out.println(pair1.getFirst()); // Java
        System.out.println(pair1.getSecond()); // 10

        Pair<Boolean, Double> pair2 = new Pair<>(true, 3.14);
        System.out.println(pair2.getFirst()); // true
        System.out.println(pair2.getSecond()); // 3.14

        Pair<Character, String> pair3 = new Pair<>('A', "Hello");
        System.out.println(pair3.getFirst()); // A
        System.out.println(pair3.getSecond()); // Hello


}}