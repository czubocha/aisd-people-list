package aisd_1;

public class Mezczyzna extends Osoba {
	
	Mezczyzna(String imie, String nazwisko, Plec plec, int wiek, int wzrost, double zarobki) throws Wyjatek {
		super(imie, nazwisko, plec, wiek, wzrost, zarobki);
	}
	
	void zrelaksujSie(){
		set_poziomStresu((int)(0.4*get_poziomStresu()));
	}
	
}