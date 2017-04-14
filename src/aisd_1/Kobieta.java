package aisd_1;

import java.util.Random;

class Kobieta extends Osoba{

	Random generator = new Random();
	
	private Kolor _kolorSukienki;
	
	Kobieta(String imie, String nazwisko, Plec plec, int wiek, int wzrost, double zarobki) throws Wyjatek {
		super(imie, nazwisko, plec, wiek, wzrost, zarobki);
	}
	
	Kobieta(String imie, String nazwisko, Plec plec, int wiek, int wzrost, double zarobki, Kolor kolorSukienki) throws Wyjatek {
		super(imie, nazwisko, plec, wiek, wzrost, zarobki);
		_kolorSukienki = kolorSukienki;
	}
	
	public String toString(){
		return get_imie()+" "+get_nazwisko()+", "+get_plec()+", wiek: "+get_wiek()+", wzrost: "+get_wzrost()+", zarobki: "+get_zarobki();
	}
	
	Kolor get_kolorSukienki() {
		return _kolorSukienki;
	}
	
	void zrelaksujSie(){
		if (generator.nextInt(2) == 1)
			set_poziomStresu((int)(0.1*get_poziomStresu()));
	}
}