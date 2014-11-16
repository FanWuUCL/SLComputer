/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.equiq;

/**
 *
 * @author J
 */
public class EquiqHJKW extends Equiq{
    public EquiqHJKW(){
        this(1);
    }
    
    public EquiqHJKW(int l){
        super();
        level=l;
        id=40999;
        star=3;
        type=0;
        name="黄金苦无";
        att_born=1;
        attGrowth=1;
    }
}
