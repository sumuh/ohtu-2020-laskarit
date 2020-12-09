package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends KiviPaperiSakset {

    @Override
    protected String tokanSiirto() {
        System.out.println("Toisen pelaajan siirto: ");
        return super.scan.nextLine();
    }
}