
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] taulukko;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        alusta(KAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        alusta(kapasiteetti, OLETUSKASVATUS);
    }
    
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        alusta(kapasiteetti, kasvatuskoko);
    }
    
    //alustaa taulukon annetuilla arvoilla
    public void alusta(int kapasiteetti, int kasvatuskoko) {
        
        tarkastaArvot(kapasiteetti, kasvatuskoko);
        
        taulukko = new int[kapasiteetti];
        for (int i = 0; i < taulukko.length; i++) {
            taulukko[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }
    
    // tarkastaa, että kapasiteetilla ja kasvatuskoolla on validit arvot
    public void tarkastaArvot(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasiteetti ei voi olla negatiivinen");
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kasvatuskoko ei voi olla negatiivinen");
        }
    }

    // lisää luvun joukkoon, jos sitä ei vielä ole siellä
    public boolean lisaa(int luku) {
        if (!kuuluu(luku)) {
            taulukko[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm % taulukko.length == 0) {
                kasvataKokoa();
            }
            return true;
        }
        return false;
    }
    
    // kasvattaa taulukon kokoa määritellyn kasvatuskoon mukaan
    private void kasvataKokoa() {
        int[] vanhaTaulukko = taulukko;
        int[] uusiTaulukko = new int[taulukko.length + kasvatuskoko];
        kopioiTaulukko(vanhaTaulukko, uusiTaulukko);
        taulukko = uusiTaulukko;
    }
    
    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    //katsoo, kuuluuko parametrina annettu luku joukkoon
    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == taulukko[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        int kohta = etsiLuvunIndeksi(luku);
        if (kohta != -1) {
            siirraTaaksepain(kohta);
            alkioidenLkm--;
            return true;
        }
        return false;
    }
    
    // palauttaa indeksin, jossa luku on tai -1 jos lukua ei ole taulukossa
    public int etsiLuvunIndeksi(int luku) {
        int indeksi = -1;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == taulukko[i]) {
                indeksi = i;
                break;
            }
        }
        return indeksi;
    }
    
    // siirtää jokaisen luvun annetusta kohdasta eteenpäin yhdellä taaksepäin
    public void siirraTaaksepain(int kohta) {
        int apu;
        for (int j = kohta; j < alkioidenLkm - 1; j++) {
            apu = taulukko[j];
            taulukko[j] = taulukko[j + 1];
            taulukko[j + 1] = apu;
        }
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + taulukko[0] + "}";
        } else {
            String tuotos = "{";
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                tuotos += taulukko[i] + ", ";
            }
            tuotos += taulukko[alkioidenLkm - 1] + "}";
            return tuotos;
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = taulukko[i];
        }
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdiste = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            yhdiste.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            yhdiste.lisaa(bTaulu[i]);
        }
        return yhdiste;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko leikkaus = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        for (int i = 0; i < a.alkioidenLkm; i++) {
            if (b.kuuluu(aTaulu[i])) {
                leikkaus.lisaa(aTaulu[i]);
            }
        }
        return leikkaus;
    }
    
    public static IntJoukko erotus (IntJoukko a, IntJoukko b) {
        IntJoukko erotus = new IntJoukko();
        int[] aTaulu = a.toIntArray();
            for (int i = 0; i < a.alkioidenLkm; i++) {
                if (!b.kuuluu(aTaulu[i])) {
                    erotus.lisaa(aTaulu[i]);
                }
            }
        return erotus;
    }
        
}
