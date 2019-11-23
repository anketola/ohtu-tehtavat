
package ohtu.intjoukkosovellus;

import java.util.Arrays;

public class IntJoukko {

    public final static int alkukoko = 5; // aloitustalukon koko
    public final static int kasvatusnopeus = 5;  // taulukon kasvatuskoko 
  
    private int kasvatuskoko;
    private int[] luvut;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioita;

    public IntJoukko() {
        this(alkukoko);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, kasvatusnopeus);
    }
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0 || kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException();
        }
        luvut = new int[kapasiteetti];
        this.kasvatuskoko = kasvatuskoko;
    }

    private void kasvataTaulua() {
        int[] uusiTaulu = new int[luvut.length + kasvatuskoko];
        System.arraycopy(luvut, 0, uusiTaulu, 0, luvut.length);
        luvut = uusiTaulu;
    }
    
    public boolean lisaa(int uusiLuku) {
        if (kuuluu(uusiLuku)) return false;
        if (luvut.length == alkioita) {
            kasvataTaulua();
        }
        luvut[alkioita] = uusiLuku;
        alkioita++;
        return true;
     }

    private int etsiIndeksi(int etsittava) {
        for (int i = 0; i < luvut.length; i++) {
            if (luvut[i] == etsittava) return i;
        }
        return -1;
    }
    
    public boolean kuuluu(int luku) {
        if (etsiIndeksi(luku) == -1) return false;
        return true;
   }

    private void siirraVasemmalle(int indeksi) {
        int apu;
        for (int j = indeksi; j < alkioita - 1; j++) {
            apu = luvut[j];
            luvut[j] = luvut[j + 1];
            luvut[j + 1] = apu;
        }
    }
    
    public boolean poista(int poistettava) {
        if (!kuuluu(poistettava)) return false;
        int poistoIndeksi = etsiIndeksi(poistettava);
        luvut[poistoIndeksi] = 0;
        siirraVasemmalle(poistoIndeksi);
        alkioita--;
        return true;
    }

    public int mahtavuus() {
        return alkioita;
    }

    @Override
    public String toString() {
        String palautusTeksti = "{";
        for (int i = 0; i < alkioita; i++) {
            palautusTeksti += luvut[i];
            if (i < alkioita - 1) {
                 palautusTeksti += ", ";
            } 
        }
        palautusTeksti += "}";
        return palautusTeksti;
    }

    public int[] toIntArray() {
        return Arrays.copyOfRange(luvut, 0, alkioita);
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdiste = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            yhdiste.lisaa(aTaulu[i]);
            yhdiste.lisaa(bTaulu[i]);
        }
        return yhdiste;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko leikkaus = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    leikkaus.lisaa(bTaulu[j]);
                }
            }
        }
        return leikkaus;

    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko erotus = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            erotus.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            erotus.poista(bTaulu[i]);
        }
        return erotus;
    }
        
}
