public class Main {

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};
        String[] stringArray = {"Java", "Python", "C++", "JavaScript"};

        System.out.println("Integer Array:");
        GenericMetodsExample.printArray(intArray);

        System.out.println("Double Array:");
        GenericMetodsExample.printArray(doubleArray);

        System.out.println("String Array:");
        GenericMetodsExample.printArray(stringArray);
    }
}