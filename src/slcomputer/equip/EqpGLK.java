/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equip;

/**
 *
 * @author J
 */
public class EqpGLK extends Equip{
    public EqpGLK(){
        super();
        level=1;
        id=42109;
        star=3;
        type=33;
        name="古鲁克";
        tough_born=69;
        attGrowth=0;
        defGrowth=0;
        toughGrowth=3.45;
        slot=2;
        hideProperty[2]=1;
    }
    
    public EqpGLK(int l){
        this();
        level=l;
    }
}
