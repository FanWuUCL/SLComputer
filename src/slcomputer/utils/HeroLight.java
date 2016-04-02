/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.utils;

import slcomputer.heros.Hero;
import slcomputer.main.SLComputer;

/**
 *
 * @author J
 */
public class HeroLight {
    public int ref;
    public int id;
    public String name;
    public String property;
    public int hp;
    
    public void setName(int id){
        name="???";
        for(Hero h:SLComputer.allHero){
            if(h.id==id){
                name=h.name;
                break;
            }
        }
    }
    
    public void setProperty(int p){
        if(p<=-3 || p>=30){
            property="神";
        }
        else if(p<0 || p>=20){
            property="全";
        }
        else{
            switch(p%10){
                case 0:
                    property="雷";
                    break;
                case 1:
                    property="土";
                    break;
                case 2:
                    property="水";
                    break;
                case 3:
                    property="火";
                    break;
                case 4:
                    property="风";
                    break;
            }
            if(p>=10){
                property="超"+property;
            }
        }
    }
}
