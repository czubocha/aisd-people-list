package aisd_1;

import java.io.IOException;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws IOException, Wyjatek {
		
		/*Osoba os1 = new Mezczyzna("Tomasz", "Czubocha", Plec.mê¿czyzna, 19, 184, 3050);
		Osoba os2 = new Mezczyzna("Micha³", "Bry³a", Plec.mê¿czyzna, 17, 175, 3050);
		Osoba os3 = new Kobieta("Yulia", "Smirnova", Plec.kobieta, 19, 190, 3050, Kolor.zó³ty);
		Osoba os4 = new Kobieta("Paulina", "Malinowska", Plec.kobieta, 19, 190, 2500, Kolor.niebieski);
		
		System.out.println("Kto jest wy¿szy? "+os1+" czy "+os2);
		System.out.println(Osoba.wyzsza(os1, os2));
		
		System.out.println();
		
		System.out.println("Czy "+os3+" nosi ¿ó³t¹ sukienkê?");
		System.out.println(Osoba.nosiZoltaSukienke(os3));
		System.out.println("Czy "+os4+" nosi ¿ó³t¹ sukienkê?");
		System.out.println(Osoba.nosiZoltaSukienke(os4));
		
		System.out.println();
		
		System.out.println("Poziom stresu "+os1+" przed relaksem:");
		System.out.println(os1.get_poziomStresu());
		os1.zrelaksujSie();
		System.out.println("Poziom stresu "+os1+" po relaksie:");
		System.out.println(os1.get_poziomStresu());
		System.out.println("Poziom stresu "+os3+" przed relaksem:");
		System.out.println(os3.get_poziomStresu());
		os3.zrelaksujSie();
		System.out.println("Poziom stresu "+os3+" po relaksie:");
		System.out.println(os3.get_poziomStresu());
		
		System.out.println();*/
		
		Osoba.wczytywanie("zad1.csv");
		Osoba.wczytywanie("zad2.csv");
		Collections.sort(Osoba.get_osoby());
		Osoba.lista();
		System.out.println(Osoba.wyzsziZarabiajaLepiej(Osoba.get_osoby()));
		System.out.println(Osoba.zolteSukienkiZarabiajaLepiej(Osoba.get_osoby()));
		System.out.println(Osoba.znajdzNajbogatsza(Osoba.get_osoby()));
		System.out.println(Osoba.znajdzNajbogatsza2(Osoba.get_osoby()));	
		System.out.println(Osoba.znajdzNajstarsza(Osoba.get_osoby()));
		System.out.println(Osoba.znajdzNajstarsza2(Osoba.get_osoby()));
		System.out.println(Osoba.znajdzNajwyzsza(Osoba.get_osoby()));
		System.out.println(Osoba.znajdzNajwyzsza2(Osoba.get_osoby()));
		
	}	

}