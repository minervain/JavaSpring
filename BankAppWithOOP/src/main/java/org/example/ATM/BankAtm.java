package org.example.ATM;

import java.util.HashMap;

public class BankAtm {
    private HashMap<String,BankAccount> hesaplar;

    public BankAtm() {
    hesaplar=new HashMap<>();

    }
    public void hesapEkle(BankAccount hesap){
        hesaplar.put(hesap.getHesapNo(),hesap);
    }
    public void paraYatir(String hesapNo, double miktar) {
        BankAccount hesap = hesaplar.get(hesapNo);
        if (hesap != null) {
            hesap.paraYatır(miktar);
        } else {
            System.out.println("Hesap bulunamadı.");
        }
    }
    public void paraCek(String hesapNo,double miktar){
        BankAccount hesap=hesaplar.get(hesapNo);
        if(hesap!=null){
            hesap.paraCek(miktar);
        }
        else System.out.println("HESAP BULUNAMADI");
    }
    public double bakiyeSorgula(String hesapNo) {
        BankAccount hesap = hesaplar.get(hesapNo);
        if (hesap != null) {
            System.out.println(hesap.getBakiye());
            return hesap.getBakiye();
        } else {
            System.out.println("Hesap bulunamadı.");
            return -1;
        }
    }
}
