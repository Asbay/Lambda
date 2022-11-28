
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Lambda02 {
    public static void main(String[] args) {
        List<Integer> sayi = new ArrayList<>(Arrays.asList(4,2,6,11,-5,7,3,15));
        ciftKarePrint(sayi);
        System.out.println("\n ********+");
        tekKupBirFazlaPrint(sayi);
        System.out.println("\n ********+");
        maxElBul(sayi);
        System.out.println("\n ********+");
        StructuredMaxElBul(sayi);
        System.out.println("\n ********+");
        ciftKareMaxPrint(sayi);
        System.out.println("\n ********+");
        elTopla(sayi);
        System.out.println("\n ********+");
        ciftCarp(sayi);
        System.out.println("\n ********+");
        minBul(sayi);
        System.out.println("\n ********+");
        bestenBykTekKck(sayi);
        System.out.println("\n ********+");
        ciftKareKbSortPrint(sayi);


    }
    // Task-1 : Functional Programming ile listin cift elemanlarinin  karelerini
    // ayni satirda aralarina bosluk bırakarak print ediniz

    public static void ciftKarePrint(List<Integer> sayi){

        sayi.
                stream().
                filter(Lambda01 ::ciftBul).   //akisdaki cift sayilari filitreledik
                map(t -> t*t).                // yeni bir strim geldi...map() ;;  aksiyon öncesi elemanlar aksiyon sonrası degişime ugrar
                forEach(Lambda01 ::yazdir);   ////Lambda01 classinda olusturdugumuz yazdir methodunu cagirdik.
    }
    // Task : Functional Programming ile listin tek elemanlarinin  kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak print ediniz

    public static void tekKupBirFazlaPrint(List<Integer> sayi){

        sayi.stream().
                filter(t -> t % 2 != 0).
                map(t -> (t * t * t)+1).
                forEach(Lambda01 :: yazdir);   //  forEach(t -> System.out.print(t + " "));
    }

    // Task-3 : Functional Programming ile listin cift elemanlarinin karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz

    public static void ciftKareKokPrint(List<Integer> sayi){

        sayi.
                stream().
                filter(Lambda01 :: ciftBul).
                map(Math ::sqrt).//double döndürür. O yüzden Lambda01 classindan yazdir(int a) methodu kullanilmaz
                forEach(t -> System.out.print(t+ " "));
    }

    // Task-4 : list'in en buyuk elemanini yazdiriniz

    public static void maxElBul(List<Integer> sayi){
        //listte bisey yoksa null pointeer exception gelir
        Optional<Integer> maxSayi = sayi.
                                         stream().
                                         reduce(Math :: max);   //eger benim resultim tek bir deger ise o zaman reduce terminal operatoru kullanilir
        System.out.println(maxSayi);   //output: Optional[15]
    }

    //ayni methodu structured yapi ile cözelim
    public static void StructuredMaxElBul(List<Integer> sayi) {


        int max = Integer.MIN_VALUE;  //otomatik en kücük sayidir
        System.out.println("max = " + max);   //max.soutv yapinca bu satir otomatik cikti
        for( int i = 0; i< sayi.size(); i++){
            if(sayi.get(i)> max) max = sayi.get(i);  // ifden sonra kod tek satirsa süslü parantez koyma
        }
        System.out.println("en büyük sayi: "+ max);
    }

    // Task-5 : List'in cift elemanlarin karelerinin en buyugunu print ediniz
    public static void ciftKareMaxPrint(List<Integer> sayi) {

        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(a -> a * a).
                reduce(Integer::max));   //reduce(Math::max)); de yazabilirdik ama Integer yazinca daha hizli calisir cünkü Math de double vs oldugu icin daha yavas olur
    }

    // Task-6: List'teki tum elemanlarin toplamini yazdiriniz.Lambda Expression...
    public static void elTopla(List<Integer> sayi) {

        int toplam = sayi.
                stream().
                reduce(0, (a, b) -> a + b);
        System.out.println("toplam = " + toplam);
    /*
* a ilk degerini her zaman atanan degerden (ilk parametre) alır,
    bu örnekte 0 oluyor
* b degerini her zamana  stream()'dan akısdan alır
* a ilk degerinden sonraki her değeri action(işlem)'dan alır

*/
    }


    // Task-7 : List'teki cift elemanlarin carpimini  yazdiriniz.

    public static void ciftCarp(List<Integer> sayi) {

        System.out.println(sayi.stream().
                filter(Lambda01::ciftBul).
                reduce(Math::multiplyExact)); //  Optional[48] //multiplyExact elimizde olanlarin hepsini carpip sonuc olarak verir
                                              //method reference kullanildi

        //reduce ile yapilan ikinci yol
        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(1, (a, b) -> (a * b)));  //48  // lambda expression  kullanildi

    }

    // Task-8 : List'teki elemanlardan en kucugunu  print ediniz.
    public static void minBul(List<Integer> sayi) {

        System.out.println(sayi.
                stream().
                reduce(Integer::min));   //reduce(Math ::min));bunu da kullanabiliriz ama daha uzun surede calisir

        //method cagirarak yapilan 2. yol
        System.out.println(sayi.stream().reduce(Lambda02::byMiracMin));

    }

    public static int byMiracMin(int a, int b){

        return a<b ? a : b ;
    }

    // Task-9 : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.

    public static void bestenBykTekKck(List<Integer> sayi) {

        System.out.println(sayi.
                stream().
                filter(a -> (a > 5) && (a % 2 == 1)).
                reduce(Lambda02::byMiracMin));
    }

    // Task-10 : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.

    public static void ciftKareKbSortPrint(List<Integer> sayi) {

        sayi.
                stream().                     //akisi baslattik
                filter(Lambda01 :: ciftBul).  //akis icindeki cift sayilari aldik
                map(t -> t*t).                //sayilarin karesi ile devam ediyoruz akista
                sorted().                     //akis icindeki sayilari kücükten büyüge siraladik
                forEach(Lambda01 :: yazdir);  //akisdaki sayilari ekrana yazdir



    }











    }


