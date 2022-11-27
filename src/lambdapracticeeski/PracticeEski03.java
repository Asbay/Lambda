package lambdapracticeeski;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PracticeEski03 {

    public static void main(String[] args) {
        List<String> list=new ArrayList<>();

        list.add("Java");
        list.add("ogrenmek");
        list.add("cok");
        list.add("eglencelidi");
        list.add("lambda");
        list.add("gelince");
        list.add("Daha");
        list.add("da");
        list.add("Cok");
        list.add("Eglenceli");
        list.add("Oldu");
        System.out.println("dcilkHarf(list) = " + dcilkHarf(list));
        System.out.println("**************************");
        System.out.println("yildizliYaz(list) = " + yildizliYaz(list));
        System.out.println("**************************");
        System.out.println("alfabetik(list) = " + alfabetik(list));
        System.out.println("**************************");
        System.out.println("lSilen(list) = " + lSilen(list));
        System.out.println("**************************");
        System.out.println("ilkHarf3Tekrar(list) = " + ilkHarf3Tekrar(list));
        System.out.println("**************************");
        System.out.println("ilkHarfBuyukYalniz(list) = " + ilkHarfBuyukYalniz(list));
        System.out.println("**************************");
        System.out.println("uzunluk4vr6Haric(list) = " + uzunluk4vr6Haric(list));
        System.out.println("**************************");

    }
    // S1: ilk harfi d ve ya c olanlari listeleyelim
    public static List<String> dcilkHarf(List<String> k) {
        return k.stream().filter(t -> t.startsWith("d") || t.startsWith("c")).collect(Collectors.toList());
    }
    //S2: tum stringlerin basina ve sonuna yildiz ekleyerek yazdiralim
    public static List<String> yildizliYaz(List<String> k) {
        return k.stream().map(t->"*"+t+"*"+"\n").collect(Collectors.toList());
    }
    //S3: alfabedik  gore siralayalim list olarak
    public static List<String> alfabetik(List<String> k) {
        return k.stream().sorted().map(t->t+"\n").collect(Collectors.toList());
    }
    //S4: tum 'l' leri silelim yazdiralim
    public static List<String> lSilen(List<String> k) {
        return k.stream().map(t->t.replaceAll("l","")+"\n").collect(Collectors.toList());
    }

    //S5 : icinde e olanlardan yeni bir list olusturunuz



    // S6 : ilk harfini 3 kere tekrar edip yazalim ornek jjjava gibi
    public static List<String> ilkHarf3Tekrar(List<String> k) {
        return k.stream().map(t->t.substring(0,1).toLowerCase()+t.substring(0,1).
                toLowerCase()+t.substring(0,1).
                toLowerCase()+t.substring(1)+"\n").collect(Collectors.toList());
    }
    // S7: tum elemanlarin ilk harfini buyuk digerlerini kucuk yaziniz
    public static List<String> ilkHarfBuyukYalniz(List<String> k) {
        return k.stream().map(t->t.substring(0,1).toUpperCase()+t.substring(1).toLowerCase()+"\n").
                collect(Collectors.toList());
    }
    // S8: uzunlugu 4 ve 6 olanlar haric bir liste olusturunuz
    public static List<String> uzunluk4vr6Haric(List<String> k) {
        return k.stream().filter(t->t.length()!=4 && t.length()!=6).map(t->t+"\n").
                collect(Collectors.toList());

    }

}
