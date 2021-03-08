package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.Collator;
import java.util.*;

public class Main {

    private static ArrayList<String> nevek = new ArrayList<>();
    private static ArrayList<Integer> gyakorisagok = new ArrayList<>();



   static ArrayList<KeresztNevek> keresztn = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
	beolvas();
        //System.out.println(nevek);

        //System.out.println(keresztn.get(0).nev+" "+keresztn.get(0).gyakorisag);
        nevekAbcben();
        f3();
        aDBeDB();
        f5();
        f6();
        f7();
    }

    private static void f5() {
        int db=0;
        for (int i:gyakorisagok){
            db=db+i;
        }
        System.out.println(db+ " fiú nevet adtak.");

    }

    private static void f7() {
        int szum=0;
        for (int n:gyakorisagok) {
            szum=szum+n;
        }
        System.out.println(1.0*szum/gyakorisagok.size());
        System.out.printf("Nevek átlagos száma: %.2f\n",1.0*szum/gyakorisagok.size());
        System.out.println("----");
    }

    private static void f6() {
    int max=0;
    int index =0;
    /*
    for (int i :gyakorisagok)
        if (i>max ) max = i;{

        }
        System.out.println(max); */
        for (int i = 0; i < gyakorisagok.size(); i++) {
            if (gyakorisagok.get(i) > max){
                max = gyakorisagok.get(i);
            index = i;
            }
        }
        //System.out.println(max+" "+index);
        System.out.println("leggyakoribb név: "+nevek.get(index)+" "+max+" alkalommal fordult elő");
        System.out.printf("leggyakoribb név: %s %d fordult elő\n",nevek.get(index),max);
    }

    private static void aDBeDB() {
        int aDB=0;
        int eDB=0;
        for (String n:nevek) {
            if (n.charAt(0) == 'A') aDB++;
            if (n.charAt(0) == 'E') eDB++;
        }
        System.out.println("A betűs név:"+aDB);
        System.out.println("E betűs név:"+eDB);
    }

    private static void f3() {
        System.out.println("Anyakönyvezhető férfi nevek száma: "+nevek.size());
    }

    private static void nevekAbcben() {
        ArrayList<String> ujNevek = (ArrayList<String>) nevek.clone();
        Collator hu = Collator.getInstance(Locale.getDefault());

        Collections.sort(ujNevek,hu);
       /* System.out.println(ujNevek);
        System.out.println("---------------------");
        System.out.println(nevek); */
        for (String n:ujNevek) {
            System.out.print(n+" ");
        }
        System.out.println("----------------------");
        for (int i = 0; i < ujNevek.size(); i++) {
            System.out.print(ujNevek.get(i)+" ");
        }
        System.out.println();
    }

    private static void beolvas() throws FileNotFoundException {
        File file = new File("ferfi_nevek.txt");
        Scanner olvas = new Scanner(file);



        while (olvas.hasNext()){
            String nev = olvas.next();
            int gyakorisag = olvas.nextInt();
            nevek.add(nev);
            gyakorisagok.add(gyakorisag);

           // System.out.println(nev+" "+gyakorisag);
            KeresztNevek kn = new KeresztNevek();
            kn.nev=nev;
            kn.gyakorisag=gyakorisag;
            keresztn.add(kn);

        }
        olvas.close();
        //System.out.println(nevek);
    }
}
