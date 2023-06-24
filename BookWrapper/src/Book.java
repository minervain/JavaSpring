public class Book implements Comparable{
    @Override
    public int compareTo(Object o) {
        return 0;
    }
    String Kitapismi;
    int SayfaSayisi;
    String YazarinIsmi;
    int YayinTarihi;

    public  Book(String Kitapismi,int SayfaSayisi,String YazarinIsmi,int YayinTarihi){

        this.Kitapismi=Kitapismi;
        this.SayfaSayisi=SayfaSayisi;
        this.YazarinIsmi=YazarinIsmi;
        this.YayinTarihi=YayinTarihi;
    }

    public int getPageCount() {
        return SayfaSayisi;
    }

    @Override
    public String toString() {
        return "Book [Title: " + Kitapismi + ", Page Count: " + SayfaSayisi + ", Author: " + YazarinIsmi + ", Publication Date: " + YayinTarihi + "]";
    }
}
