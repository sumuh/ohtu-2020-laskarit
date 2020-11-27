/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

/**
 *
 * @author sussos
 */
public abstract class Komento {
    
    protected Sovelluslogiikka logiikka;
    
    public Komento(Sovelluslogiikka logiikka) {
        this.logiikka = logiikka;
    }
    
    public abstract void suorita();
    
}
