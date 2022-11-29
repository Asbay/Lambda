import java.util.stream.IntStream;

public class Lambda05 {


    public static void main(String[] args) {

        System.out.println(topla(5));
        System.out.println(toplaCincix(5));
        System.out.println(toplaCift(5));
        ikininIlkXKuvvetPrint(3);
        System.out.println();
        istenenSayiIlkXKuvvetPrint(3,3);
        System.out.println();
        System.out.println(istenenSayiFactorial(5));

    }

    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar (x dahil) tamsayilari toplayan bir program create ediniz.


    //Structured

    public static int topla(int x){

        int toplam =0;

        for(int i =0; i<=x ; i++){

            toplam = toplam + i;
        }
        return toplam;
    }
    //functional

    public static int toplaCincix(int x){

        return
        IntStream.    // bu yazildiginda saki int lar bir listteymis gibi dusunulup devam ediyo
                range(1,x+1).   // range(a,b) --> a"dan b"ye kadar ( b dahil degil) int degerler akisa alindi
                 sum();         //akisdan gelen degerler toplami
    }

    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.
    public static int toplaCift(int x) {

        return
                IntStream.
                        range(1, x + 1).filter(Lambda01::ciftBul).// yada --> filter(t -> t % 2 == 0).
                        sum();
    }

    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.

    //1. way
    public static int ilkPztfCiftSayi(int x){
        return IntStream.
                rangeClosed(1,x*2).
                filter(Lambda01::ciftBul).
                sum();
    }

    //2. way
    public static int toplaIlkXCift(int x){
        return IntStream.
                iterate(2, t->t+2).   // 2 den baslar sonsuza kadar elemanlari 2 artirarak akisa alir--> 2, 4, 6, 8,...
                limit(x).                  // x ile sinirliyoruz ilk mesela x cift sayi
                sum();                     // akisadan gelen degerleri topluyorum
    }

//TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.

    public static int IlkXPztfTekTamSayi(int x){
        return IntStream.
                iterate(1,t->t+2).// 1 den sonsuza kadar elemanları 2 artırarak akışa alır --> 1, 3, 5, 7 ,.....
                        limit(x). // x ile sınırlıyorum
                        sum(); // akışdan gelen bütün değerleri topluyorum
    }

    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi  create ediniz. mesela x=3 ise 2,4,8, verecek

    public static void ikininIlkXKuvvetPrint(int x) { // 2,4,8,16,32
        IntStream.
                iterate( 2, t->t*2 ). // iterasyon için sartımızı yazdık
                limit(x). // x değeri ile sınırladık
                forEach(Lambda01::yazdir); //Lamnbda01 clasındaki yazdır() metodunu çağırarak ekrana yazdık
    }

    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.

    public static void istenenSayiIlkXKuvvetPrint(int istenenSayi, int x){

        IntStream.iterate(istenenSayi, t -> t *istenenSayi).limit(x).forEach(Lambda01 :: yazdir);

    }
    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.

    public static int istenenSayiFactorial(int x){

        return IntStream.
                rangeClosed(1,x).   //rangeClosed(1,5) --> 1, 2, 3, 4, 5
                reduce(1,(t,u)-> t*u);
    }


    }
