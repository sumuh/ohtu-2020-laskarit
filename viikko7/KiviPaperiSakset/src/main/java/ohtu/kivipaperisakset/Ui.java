package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Ui {

    private final Scanner scanner = new Scanner(System.in);
    private KPSPeli peli = new KPSPeli();

    public void suorita() {

        while (true) {

            System.out.println(vaihtoehdot());

            String vastaus = scanner.nextLine();

            if (vastaus.matches("a|b|c")) {
                System.out.println(viesti());
            }

            if (vastaus.endsWith("a")) {
                aloitaKaksinpeli();
            } else if (vastaus.endsWith("b")) {
                aloitaYksinpeli();
            } else if (vastaus.endsWith("c")) {
                aloitaPahaYksinpeli();
            } else {
                break;
            }

        }

    }

    public String viesti() {
        return "peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s";
    }

    public String vaihtoehdot() {
        return "\nValitse pelataanko"
                + "\n (a) ihmistä vastaan "
                + "\n (b) tekoälyä vastaan"
                + "\n (c) parannettua tekoälyä vastaan"
                + "\nmuilla valinnoilla lopetetaan";
    }

    public void aloitaKaksinpeli() {
        KiviPaperiSakset kaksinpeli = peli.luoKPSPelaajaVsPelaaja();
        kaksinpeli.pelaa();
    }

    public void aloitaYksinpeli() {
        KiviPaperiSakset yksinpeli = peli.luoKPSTekoaly();
        yksinpeli.pelaa();
    }

    public void aloitaPahaYksinpeli() {
        KiviPaperiSakset pahaYksinpeli = peli.luoKPSParempiTekoaly();
        pahaYksinpeli.pelaa();
    }

}
