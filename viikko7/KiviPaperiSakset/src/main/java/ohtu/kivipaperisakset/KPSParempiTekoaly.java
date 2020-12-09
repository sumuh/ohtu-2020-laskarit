package ohtu.kivipaperisakset;

import java.util.Scanner;

import java.util.Scanner;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends KiviPaperiSakset {

    TekoalyParannettu tekoaly;

    public KPSParempiTekoaly() {
        tekoaly = new TekoalyParannettu(20);
    }

    @Override
    protected String tokanSiirto() {
        String tokanSiirto;
        tokanSiirto = tekoaly.annaSiirto();

        System.out.println("Tietokone valitsi: " + tokanSiirto);
        tekoaly.asetaSiirto(super.ekanSiirto);

        return tokanSiirto;
    }
}
