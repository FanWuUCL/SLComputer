/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EquiqSZFY extends Equip{
    public EquiqSZFY(){
        this(1);
    }
    
    public EquiqSZFY(int l){
        super();
        level=l;
        id=40138;
        eid=id;
        star=5;
        type=0;
        name="神之飞鸢";
        att_born=352;
        attGrowth=39.2;
        slot=4;
        hideProperty[0]=408;
    }
}
