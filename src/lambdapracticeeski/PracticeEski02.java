package lambdapracticeeski;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PracticeEski02 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(-5,-8,-2,-12,0,1,12,5,6,9,15,8));

        System.out.println(pozitifList(list));
        System.out.println("***************");
        System.out.println("kareleriTekrarsizList(list) = " + kareleriTekrarsizList(list));
        System.out.println("***************");
        System.out.println("kBsirala(List) = " + kBsirala(list));
        System.out.println("***************");
        System.out.println("bKsirala(list) = " + bKsirala(list));
        System.out.println("***************");
        System.out.println("pozitifKupBilerBasmak5(list) = " + pozitifKupBilerBasmak5(list));
        System.out.println("***************");
        System.out.println("pozitifKareBirlerBasmak5_Olmayan(list) = " + pozitifKareBirlerBasmak5_Olmayan(list));
        System.out.println("***************");
        System.out.println("toplam(list) = " + toplam(list));
        System.out.println("***************");
        System.out.println("negatiflerinKaresiPeekli(list) = " + negatiflerinKaresiPeekli(list));
        System.out.println("***************");
        System.out.println("bestenBuyuk(list) = " + bestenBuyuk(list));
        System.out.println("***************");
        System.out.println("sifirdanKucukmu(list) = " + sifirdanKucukmu(list));
        System.out.println("***************");
        System.out.println("yuzeEsitElamanYokmu(list) = " + yuzeEsitElamanYokmu(list));
        System.out.println("***************");
    }
    // S1:listi aralarinda bosluk birakarak yazdiriniz //



    //S2: sadece negatif olanlari yazdir



    //S3: pozitif olanlardan yeni bir liste olustur
    public  static List<Integer> pozitifList(List<Integer> sayi){
        return sayi.stream().filter(t->t>0).collect(Collectors.toList());
    }
    // S4: list in elemanlarin karelerinden yeni bir list olusturalim



    //S5 : list in elemanlarin karelerinden tekrarsiz yeni bir list olusturalim
    public  static List<Integer> kareleriTekrarsizList(List<Integer> sayi){
        return sayi.stream().map(t->t*t).distinct().collect(Collectors.toList());
    }


    //S6: listin elemanlarini kucukten buyuge siralayalim
    public  static List<Integer> kBsirala(List<Integer> sayi) {
        return sayi.stream().sorted().collect(Collectors.toList());
    }
    //S7: listin elemanlarini buyukten kucuge siralayalim
    public  static List<Integer> bKsirala(List<Integer> sayi) {
        return sayi.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }
    // S8: list pozitif elemanlari icn kuplerini bulup birler basamagi 5 olanlardan yeni bir list olusturalim
    public  static List<Integer> pozitifKupBilerBasmak5(List<Integer> sayi) {
        return sayi.stream().filter(t->t>0).map(t->t*t*t).filter(t->t%10==5).collect(Collectors.toList());
    }
    //S9: list pozitif elemanlari icn karelerini bulup birler basamagi 5 olmayanlardan yeni bir list olusturalim
    public  static List<Integer> pozitifKareBirlerBasmak5_Olmayan(List<Integer> sayi) {
        return sayi.stream().filter(t->t>0).map(t->t*t).filter(t->t%10!=5).collect(Collectors.toList());
    }
    // S10 :list elemanlarini toplamini bulalim
    public  static int toplam(List<Integer> sayi) {
        return sayi.stream().reduce(0,(x,y)->x+y);
    }
    // S11 : peek ornegi cozelim - negatiflerin karelerinden list olusturalim
    public  static List<Integer> negatiflerinKaresiPeekli(List<Integer> sayi) {
        return sayi.stream().filter(t->t<0).
                peek(t-> System.out.println("negatifler : "+t)).
                map(t->t*t).
                collect(Collectors.toList());
    }
    // S12 : listeden 5 den buyuk  sayi var mi?
    public  static boolean bestenBuyuk(List<Integer> sayi) {
        return sayi.stream().anyMatch(t->t>5);
    }
    // S13 : listenin tum elemanlari sifirdan kucuk mu?
    public  static boolean sifirdanKucukmu(List<Integer> sayi) {
        return sayi.stream().allMatch(t->t<0);
    }
    // S14: listenin 100 e esit elemani yok mu ?
    public  static boolean yuzeEsitElamanYokmu(List<Integer> sayi) {
        return sayi.stream().noneMatch(t->t==100);
    }
    // S15: listenin sifira esit elemani yok mu?



    // S16:  listenin ilk 5 elemanini topla?



    //S17: listenin son bes elemaninin  listele


}

