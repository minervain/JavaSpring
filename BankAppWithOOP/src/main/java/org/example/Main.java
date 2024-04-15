    package org.example;

    import org.example.ATM.BankAccount;
    import org.example.ATM.BankAtm;

    public class Main {
        public static void main(String[] args) {
            BankAtm Cardfinans=new BankAtm();
            BankAccount hesap1=new BankAccount("1","Ali Osman UÇAR",0);
            BankAccount hesap2=new BankAccount("2","Ali Osman UÇAR",0);

            Cardfinans.hesapEkle(hesap1);

            Cardfinans.paraYatir("1",500);
            Cardfinans.paraCek("1",400);
            Cardfinans.bakiyeSorgula("1");
            BankAtm Akbank=new BankAtm();

            Akbank.hesapEkle(hesap2);

            Akbank.paraYatir("2",500);
            Akbank.paraCek("2",100);
            Akbank.bakiyeSorgula("2");


        }
    }