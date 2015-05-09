/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.heros;

/**
 *
 * @author J
 */
public class HeroBLDSW extends Hero{
    public HeroBLDSW(){
        this(1);
    }
    
    public HeroBLDSW(int l){
        super();
        level=l;
        hid=10295;
        id=hid;
        name="白磷大蛇丸";
    }
}
