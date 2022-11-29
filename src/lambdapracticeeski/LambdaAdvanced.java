package lambdapracticeeski;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
public class LambdaAdvanced {

    public static void main(String[] args) {
         /*TASK :
        2 Boyutlu bir Multidimensional array i input kabul edip, arraydeki tüm
        elemanları bir
        listeye kopyalayan ve harf sırasına göre yazdıran bir METHOD yazınız.
        Eg : Input : {{Ali,Veli,Ayse},{Hasan,Can},{Suzan}}
           Output:[Ali, Ayse, Can, Hasan, Suzan, Veli]
         */
        String[][] arr = {{"Ali", "Veli", "Ayse"}, {"Hasan", "Can"}, {"Suzan"}};
        // String [][] arr1= new String[3][5];
        System.out.println(Arrays.stream(arr).
                flatMap(Arrays::stream).
                sorted()
                .collect(Collectors.toList()));

        List<String> l = Arrays.asList("Elma", "Muz", "Portakal", "Cilek", "Limon", "erik");
        System.out.println(l.stream().
                sorted()//ascii degerleri ne gore siralar
                .collect(Collectors.toList()));

        /* TASK :
   Bir integer list oluşturunuz ve bu list’deki tum sayıların karesinin
   toplamını bulan code create ediniz.
    */
        List<Integer> numbers = new ArrayList<>(Arrays.asList(9, 4));
        System.out.println(numbers.stream().map(t -> t * t).reduce(0, (y, g) -> y + g));
        System.out.println(numbers.stream().mapToInt(Math::incrementExact).sum());
        System.out.println(numbers.stream().mapToInt(Math::decrementExact).sum());
        System.out.println(numbers.stream().mapToInt(t -> t * t).sum());
        /* TASK :
         * Verilen arraydeki tekrar eden sayilari, ilki haric silip, tekrarsiz
         * sayilardan olusan bir array haline getiren bir code create ediniz.
         *
         * INPUT : {1,2,2,3,1,4,2,5,6,8,7,5,9,1}
         * OUTPUT : [1,2,3,4,5,6,7,8,9]
         */
        int[] ar = {1, 2, 2, 3, 1, 4, 2, 5, 6, 8, 7, 5, 9, 1};
        Arrays.stream(ar).sorted().distinct().forEach(t -> System.out.print(t + " "));
        System.out.println();
        System.out.println(Arrays.stream(ar).sorted().distinct().sum());

/*  Write a Java program to get a String from user as input and find the maximumCounts occurring character in that string.
         (Ignore case sensitivity)
         Kullanicidan aldiginiz bir string icinde en cok tekrar eden karakteri yazdiran code create ediniz.
       input : Learning java is easy
       output: maximumCounts occurring character is : a
        */
        Scanner sc=new Scanner(System.in);
        String isim=sc.nextLine();
        String [] arrr=isim.split("");
        System.out.println(Arrays.stream(arrr).reduce("", (a, b) -> a == b ? a : b));
        System.out.println(Arrays.stream(arrr).reduce("", (a, b) -> a));


    }

}
