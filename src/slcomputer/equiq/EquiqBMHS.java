/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equiq;

/**
 *
 * @author J
 */
public class EquiqBMHS extends Equiq{
    public EquiqBMHS(){
        this(1);
    }
    
    public EquiqBMHS(int l){
        super();
        level=l;
        id=45122;
        star=5;
        type=1;
        name="冰脉护手";
        def_born=308;
        defGrowth=32.34;
        slot=4;
        hideProperty[1]=408;
    }
}
