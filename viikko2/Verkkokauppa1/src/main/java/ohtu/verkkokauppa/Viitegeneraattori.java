package ohtu.verkkokauppa;

public class Viitegeneraattori implements ViitegeneraattorInterface {

    private int seuraava;
    
    public Viitegeneraattori(){
        seuraava = 1;    
    }
    
    @Override
    public int uusi(){
        return seuraava++;
    }
}
