/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqXXSYL extends Equip{
    public EquiqXXSYL(){
        this(1);
    }
    
    public EquiqXXSYL(int l){
        super();
        level=l;
        id=40110;
        eid=id;
        star=3;
        type=0;
        name="血腥三月镰";
        att_born=145;
        attGrowth=15.23;
        slot=2;
        hideProperty[2]=2;
    }
}
