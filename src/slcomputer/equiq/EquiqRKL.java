/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equiq;

/**
 *
 * @author J
 */
public class EquiqRKL extends Equiq{
    public EquiqRKL(){
        this(1);
    }
    
    public EquiqRKL(int l){
        super();
        level=l;
        id=45125;
        star=5;
        type=1;
        name="人傀儡";
        def_born=263;
        defGrowth=27.62;
        slot=4;
        hideProperty[1]=340;
    }
}
