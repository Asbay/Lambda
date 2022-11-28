import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Lambda03 {

    public static void main(String[] args) {

        List<String> menu = new ArrayList<>(Arrays.asList("trileçe","havucDilim","güvec","kokorec",
                "küşleme","arabAşı","waffle","künefe"));


        alfBykTekrsz(menu);
        System.out.println();
        chrSayisiTersSiraliUnique(menu);
        System.out.println();
        chrSayisiBykSirali(menu);
        System.out.println();
        harfSayisi7denAzKontrol(menu);
        System.out.println();
        charSayisiEnBykElPrint(menu);
    }


    // Task -1 : List elemanlarini alfabetik buyuk harf ve  tekrarsiz print ediniz.

    public static void alfBykTekrsz(List<String> yemek){
        yemek.stream().                         //akis basladi
                map(String :: toUpperCase).     //buyuk harfe cevrildi
                sorted().                       // alfabetik siralandi
                distinct().                     //elemanlarin tekrarsiz olmasi saglandi
                forEach(t -> System.out.println(t+ " "));  //print
    }

    // Task -2 : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..

    public static void    chrSayisiTersSiraliUnique(List<String> ikram){

        ikram.stream().
                map(String :: length).
                sorted(Comparator.reverseOrder()).
                distinct().
                forEach(Lambda01 :: yazdir);
    }
    // Task-3 : List elemanlarini character sayisina gore kckten byk e gore print ediniz..

    public static void chrSayisiBykSirali(List<String> ikram) {

        ikram.stream().
                sorted(Comparator.comparing(String :: length)).    //string ifadeleri karakter sayilarina göre kücükten büyüge gore siraladik
                forEach(t -> System.out.println(t+ " "));
    }

    // ******************************************************************************************
// *********************** anyMatch() *** allMatch() **** noneMatch() ************************
    //*******************************************************************************************

    //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
    //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    //noneMatch()--> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.

    // Task-4 : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.

    public static void harfSayisi7denAzKontrol(List<String> ikram) {
        System.out.println(ikram.
                stream().
                allMatch(t -> t.length() <= 7) ? "list elamanları 7 ve daha az harfden oluşuyor" :
                "list elemanları 7 harfdenbüyük");
    }

    // Task-5 : List elelmanlarinin hepsinin "w" ile baslamasını noneMatch() ile kontrol ediniz.
    public static void wIleBaslayanElKontrol(List<String> ikram) {
        System.out.println(ikram.
                stream().
                noneMatch(t -> t.startsWith("w")) ? "w ile yemek ismi mi olur" :
                "w ile yemek icat ettik");
    }
    // Task-6 : List elelmanlarinin "x" ile biten en az bir elemanı kontrol ediniz.
    public static void xIleBitenElKontrol(List<String> ikram) {
        System.out.println(ikram.stream().anyMatch(t -> t.endsWith("x")) ? "maşallah" : "x ile yemek ismi mi biter");
    }
    // Task-7 : Karakter sayisi en buyuk elemani yazdiriniz.

    public static void charSayisiEnBykElPrint(List<String> ikram) {

        Stream<String> sonIsim = ikram.
                stream(). // akış sağlandı
                        sorted(Comparator.comparing(t->t.toString().length()).
                        reversed()). // karakter sayısına göre terden sıralandı
                        limit(1);// limit metodu kullanılarak sadece ilk eleman çağrıldı
        // limit() metodunun dönen değeri Stream<String> yapıdadır

        System.out.println(Arrays.toString(sonIsim.toArray()));
        // sonIsim.toArray() --> Stream olan akış Artray e çevrildi
        // Arrays.toString(sonIsim.toArray()) --> Arrayı string yapıya çeviriyor

    }

    // Task-8 : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
    public static void ilkElHrcSonHrfSiraliPrint(List<String> ikram){
        ikram.
                stream(). // akış sağlandı
                sorted(Comparator.comparing(t->t.charAt(t.length()-1))). // son harfine göre alfabetik sıralandı
                skip(1). // akışdaki ilk eleman hariç tutuldu
                forEach(Lambda01::yazdir); // ekrana print edildi
    }






}
