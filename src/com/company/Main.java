package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<String> nevek = new ArrayList<>();
    private static ArrayList<Integer> gyakorisagok = new ArrayList<>();



   static ArrayList<KeresztNevek> keresztn = new ArrayList<>();
    public static void main(String[] args) throws FileNotFoundException {
	beolvas();
        //System.out.println(nevek);

        System.out.println(keresztn.get(0).nev+" "+keresztn.get(0).gyakorisag);

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
