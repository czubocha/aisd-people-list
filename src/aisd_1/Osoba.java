package aisd_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

abstract class Osoba implements Comparable<Osoba> {

    private static List<Osoba> osoby = new ArrayList<Osoba>();
    private final String _imie, _nazwisko;
    private final Plec _plec;
    private final int _wzrost;
    Random generator = new Random();
    private int _wiek;
    private double _zarobki;
    private int _poziomStresu = generator.nextInt(101);

    Osoba(String imie, String nazwisko, Plec plec, int wiek, int wzrost, double zarobki) throws Wyjatek {

        _imie = imie;
        _nazwisko = nazwisko;
        _plec = plec;
        if (wiek >= 18 && wiek <= 150)
            _wiek = wiek;
        else throw new Wyjatek("Wiek " + _imie + " " + _nazwisko + " musi byæ z zakresu 18-150!");
        if (wzrost > 0)
            _wzrost = wzrost;
        else throw new Wyjatek("Wzrost " + _imie + " " + _nazwisko + " musi byæ dodatni!");
        if (zarobki > 0)
            _zarobki = zarobki;
        else throw new Wyjatek("Zarobki " + _imie + " " + _nazwisko + " musz¹ byæ dodatnie!");

        osoby.add(this);
    }

    static List<Osoba> get_osoby() {
        return osoby;
    }

    static Osoba wyzsza(Osoba os1, Osoba os2) {
        return os1._wzrost >= os2._wzrost ? os1 : os2;
    }

    static boolean nosiZoltaSukienke(Osoba os) {
        return os instanceof Kobieta && os.get_kolorSukienki() == Kolor.¿ó³ty ? true : false;
    }

    static void lista() {
        for (Osoba x : osoby) System.out.println(x);
        System.out.println();
    }

    static Osoba osoba(String imie, String nazwisko) {
        for (Osoba x : osoby)
            if (x._nazwisko.equals(nazwisko) && x._imie.equals(imie))
                return x;
        return null;
    }

    static Osoba znajdzNajbogatsza(List<Osoba> osoby) {
        try {
            List<String> najbogatsi = new ArrayList<String>();
            double a = osoby.get(0)._zarobki;
            for (Osoba x : osoby)
                if (x._zarobki > a)
                    a = x._zarobki;
            for (Osoba x : osoby)
                if (x._zarobki == a)
                    najbogatsi.add(x._nazwisko);
            Collections.sort(najbogatsi);
            for (Osoba x : osoby)
                if (najbogatsi.get(0).equals(x._nazwisko))
                    return x;
            return null;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Lista nie mo¿e byæ pusta!");
            return null;
        }
    }

    static Osoba znajdzNajstarsza(List<Osoba> osoby) {
        try {
            List<String> najstarsi = new ArrayList<String>();
            int a = osoby.get(0)._wiek;
            for (Osoba x : osoby)
                if (x._wiek > a)
                    a = x._wiek;
            for (Osoba x : osoby)
                if (x._wiek == a)
                    najstarsi.add(x._nazwisko);
            Collections.sort(najstarsi);
            for (Osoba x : osoby)
                if (najstarsi.get(0).equals(x._nazwisko))
                    return x;
            return null;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Lista nie mo¿e byæ pusta!");
            return null;
        }
    }

    static Osoba znajdzNajwyzsza(List<Osoba> osoby) {
        try {
            List<String> najwyzsi = new ArrayList<String>();
            int a = osoby.get(0)._wzrost;
            for (Osoba x : osoby)
                if (x._wzrost > a)
                    a = x._wzrost;
            for (Osoba x : osoby)
                if (x._wzrost == a)
                    najwyzsi.add(x._nazwisko);
            Collections.sort(najwyzsi);
            for (Osoba x : osoby)
                if (najwyzsi.get(0).equals(x._nazwisko))
                    return x;
            return null;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Lista nie mo¿e byæ pusta!");
            return null;
        }
    }

    static Osoba znajdzNajbogatsza2(List<Osoba> osoby) {
        try {
            List<Osoba> kopia = new ArrayList<Osoba>();
            for (Osoba x : osoby) kopia.add(x);
            Collections.sort(kopia, new Comparator<Osoba>() {
                public int compare(Osoba os1, Osoba os2) {
                    return os1.get_zarobki() == os2.get_zarobki() ? os1.get_nazwisko().compareTo(os2.get_nazwisko()) : Double.compare(os1.get_zarobki(), os2.get_zarobki());
                }
            });
            int i = 0;
            for (Osoba x : kopia)
                if (x._zarobki == kopia.get(kopia.size() - 1)._zarobki)
                    i++;
            return kopia.get(kopia.size() - i);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Lista nie mo¿e byæ pusta!");
            return null;
        }
    }

    static Osoba znajdzNajstarsza2(List<Osoba> osoby) {
        try {
            List<Osoba> kopia = new ArrayList<Osoba>();
            for (Osoba x : osoby) kopia.add(x);
            Collections.sort(kopia, new Comparator<Osoba>() {
                public int compare(Osoba os1, Osoba os2) {
                    return os1.get_wiek() == os2.get_wiek() ? os1.get_nazwisko().compareTo(os2.get_nazwisko()) : Integer.compare(os1.get_wiek(), os2.get_wiek());
                }
            });
            int i = 0;
            for (Osoba x : kopia)
                if (x._wiek == kopia.get(kopia.size() - 1)._wiek)
                    i++;
            return kopia.get(kopia.size() - i);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Lista nie mo¿e byæ pusta!");
            return null;
        }
    }

    static Osoba znajdzNajwyzsza2(List<Osoba> osoby) {
        try {
            List<Osoba> kopia = new ArrayList<Osoba>();
            for (Osoba x : osoby) kopia.add(x);
            Collections.sort(kopia, new Comparator<Osoba>() {
                public int compare(Osoba os1, Osoba os2) {
                    return os1.get_wzrost() == os2.get_wzrost() ? os1.get_nazwisko().compareTo(os2.get_nazwisko()) : Integer.compare(os1.get_wzrost(), os2.get_wzrost());
                }
            });
            int i = 0;
            for (Osoba x : kopia)
                if (x._wzrost == kopia.get(kopia.size() - 1)._wzrost)
                    i++;
            return kopia.get(kopia.size() - i);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Lista nie mo¿e byæ pusta!");
            return null;
        }
    }

    static void wczytywanie(String plik) throws IOException, Wyjatek {
        BufferedReader reader = new BufferedReader(new FileReader(plik));
        String line = null;
        while ((line = reader.readLine()) != null) {
            int i = 1;
            String imie = null;
            String nazwisko = null;
            char plec = 0;
            int wiek = 0;
            int wzrost = 0;
            double zarobki = 0;
            String sukienka = null;
            Scanner scanner = new Scanner(line);
            imie = scanner.next().substring(1);
            nazwisko = scanner.next();
            wiek = scanner.nextInt();
            wzrost = scanner.nextInt();
            zarobki = scanner.nextDouble();
            plec = (char) scanner.next().charAt(0);
            try {
                switch (plec) {
                    case 'm':
                        new Mezczyzna(imie, nazwisko, Plec.mê¿czyzna, wiek, wzrost, zarobki);
                        break;
                    case 'k':
                        if (sukienka == null)
                            new Kobieta(imie, nazwisko, Plec.kobieta, wiek, wzrost, zarobki);
                        else {
                            if (sukienka.startsWith("c"))
                                new Kobieta(imie, nazwisko, Plec.kobieta, wiek, wzrost, zarobki, Kolor.czerwony);
                            else if (sukienka.startsWith("z"))
                                new Kobieta(imie, nazwisko, Plec.kobieta, wiek, wzrost, zarobki, Kolor.¿ó³ty);
                        }
                        break;
                    default:
                        new Nieokreslona(imie, nazwisko, Plec.nieokreœlona, wiek, wzrost, zarobki);
                        break;
                }
            } catch (Wyjatek w) {
                System.err.println(w);
                continue;
            }
            scanner.close();
        }
        reader.close();
        usunDuplikaty();
    }

    static void usunDuplikaty() {
        for (int i = 0; i < osoby.size(); i++)
            for (int j = 0; j < osoby.size(); j++)
                if (i != j && osoby.get(i)._imie.equals(osoby.get(j)._imie) && osoby.get(i)._nazwisko.equals(osoby.get(j)._nazwisko))
                    if (osoby.get(i).get_kolorSukienki() == null)
                        osoby.remove(i);
                    else
                        osoby.remove(j);
    }

    static boolean wyzsziZarabiajaLepiej(List<Osoba> osoby) {
        List<Osoba> kopia = new ArrayList<Osoba>();
        for (Osoba x : osoby) kopia.add(x);
        Collections.sort(kopia, new Comparator<Osoba>() {
            public int compare(Osoba os1, Osoba os2) {
                return os1.get_wzrost() == os2.get_wzrost() ? os1.get_nazwisko().compareTo(os2.get_nazwisko()) : Integer.compare(os1.get_wzrost(), os2.get_wzrost());
            }
        });
        int wysocy = kopia.size() / 2;
        int niscy = kopia.size() - wysocy;
        double zarobkiNiskich = 0;
        double zarobkiWysokich = 0;
        for (int i = 0; i < niscy; i++)
            zarobkiNiskich += kopia.get(i)._zarobki;
        for (int i = niscy; i < kopia.size(); i++)
            zarobkiWysokich += kopia.get(i)._zarobki;
        if ((zarobkiWysokich / wysocy) > (zarobkiNiskich / niscy))
            return true;
        return false;
    }

    static boolean zolteSukienkiZarabiajaLepiej(List<Osoba> osoby) {
        int liczbaZoltych = 0;
        int liczbaInnych = 0;
        double zarobkiZoltych = 0;
        double zarobkiInnych = 0;
        for (Osoba x : osoby)
            if (x instanceof Kobieta && x.get_kolorSukienki() == Kolor.¿ó³ty) {
                liczbaZoltych++;
                zarobkiZoltych += x._zarobki;
            } else {
                liczbaInnych++;
                zarobkiInnych += x._zarobki;
            }
        if ((zarobkiZoltych / liczbaZoltych) > (zarobkiInnych / liczbaInnych))
            return true;
        return false;
    }

    public String toString() {
        return _imie + " " + _nazwisko + ", " + _plec + ", wiek: " + _wiek + ", wzrost: " + _wzrost + ", zarobki: " + _zarobki;
    }

    String get_imie() {
        return _imie;
    }

    Plec get_plec() {
        return _plec;
    }

    int get_poziomStresu() {
        return _poziomStresu;
    }

    void set_poziomStresu(int s) {
        if (s >= 0 && s <= 100)
            _poziomStresu = s;
        else
            System.err.println("Poziom stresu musi byæ z zakresu 0-100");
    }

    Kolor get_kolorSukienki() {
        return null;
    }

    double get_zarobki() {
        return _zarobki;
    }

    String get_nazwisko() {
        return _nazwisko;
    }

    int get_wiek() {
        return _wiek;
    }

    int get_wzrost() {
        return _wzrost;
    }

    abstract void zrelaksujSie();

    public int compareTo(Osoba os) {
        return Double.compare(_zarobki, os._zarobki);
    }

    public boolean equals(Osoba os) {
        if (os._imie.equals(_imie) && os._nazwisko.equals(_nazwisko))
            return true;
        return false;
    }

}