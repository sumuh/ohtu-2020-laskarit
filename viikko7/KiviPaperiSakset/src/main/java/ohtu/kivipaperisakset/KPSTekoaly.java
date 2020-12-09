package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSTekoaly extends KiviPaperiSakset {

    Tekoaly tekoaly;

    public KPSTekoaly() {
        tekoaly = new Tekoaly();
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