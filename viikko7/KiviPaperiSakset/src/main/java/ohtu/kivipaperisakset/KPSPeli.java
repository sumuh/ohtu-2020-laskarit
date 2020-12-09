package ohtu.kivipaperisakset;

public class KPSPeli {

    public static KiviPaperiSakset luoKPSPelaajaVsPelaaja() {
        return new KPSPelaajaVsPelaaja();
    }

    public static KiviPaperiSakset luoKPSTekoaly() {
        return new KPSTekoaly();
    }

    public static KiviPaperiSakset luoKPSParempiTekoaly() {
        return new KPSParempiTekoaly();
    }
}
