/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equiq;

/**
 *
 * @author J
 */
public class EquiqQHCM extends Equiq{
    public EquiqQHCM(){
        this(1);
    }
    
    public EquiqQHCM(int l){
        super();
        level=l;
        id=45127;
        star=4;
        type=1;
        name="漆黑长矛";
        att_born=200;
        def_born=256;
        attGrowth=21;
        defGrowth=26.88;
        slot=3;
        hideProperty[2]=3;
    }
}
