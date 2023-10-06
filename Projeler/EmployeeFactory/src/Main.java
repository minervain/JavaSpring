public class Main {
    public static void main(String[] args) {

        Employee calisan1=new Employee("ALİ OSMAN",100,10,10);

        System.out.println(calisan1.toStrng());
        System.out.println("Tax: " + calisan1.tax());
        System.out.println("Bonus: " + calisan1.bonus());
        System.out.println("Maaş artışı: " + calisan1.raiseSalary());



    }
}