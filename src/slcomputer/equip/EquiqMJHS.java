/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqMJHS extends Equip{
    public EquiqMJHS(){
        this(1);
    }
    
    public EquiqMJHS(int l){
        super();
        level=l;
        id=45112;
        star=3;
        type=1;
        name="敏捷护手";
        def_born=110;
        defGrowth=11.55;
        slot=2;
        hideProperty[1]=105;
    }
}
