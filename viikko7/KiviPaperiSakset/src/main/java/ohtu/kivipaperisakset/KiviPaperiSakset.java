package ohtu.kivipaperisakset;

import java.util.Scanner;

public abstract class KiviPaperiSakset {

    protected static final Scanner scan = new Scanner(System.in);

    protected String ekanSiirto;

    public void pelaa() {

        Tuomari tuomari = new Tuomari();

        String ekanSiirto = ekanSiirto();
        String tokanSiirto = tokanSiirto();

        while(onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            ekanSiirto = ekanSiirto();
            tokanSiirto = tokanSiirto();
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);

    }

    protected String ekanSiirto() {
        System.out.println("Ensimmäisen pelaajan siirto: ");
        return scan.nextLine();
    }

    abstract protected String tokanSiirto();

    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

}
