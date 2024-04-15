package org.example.ATM;

public class BankAccount {
    private String hesapNo;
    private  String isim;
    private double bakiye;

    public BankAccount(String hesapNo, String isim, double bakiye) {
        this.hesapNo = hesapNo;
        this.isim = isim;
        this.bakiye = bakiye;
    }

    public String getHesapNo() {
        return hesapNo;
    }

    public void setHesapNo(String hesapNo) {
        this.hesapNo = hesapNo;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public double getBakiye() {
        return bakiye;
    }

    public void setBakiye(double bakiye) {
        this.bakiye = bakiye;
    }

    public void paraYatır(double miktar){

        this.bakiye+=miktar;

    }

    public void paraCek(double miktar) {
        if (miktar > bakiye) {
            System.out.println("İŞLEM BAŞARISIZ TEKRAR DENEYİN");

        } else {
            this.bakiye -= miktar;
        }
    }


}
