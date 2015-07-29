/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.main;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author J
 */
public class Character {
    public boolean ready;
    public int certification;
    public int id;
    public String name;
    public int vip;
    public int vipMoney;
    public int level;
    public int exp;
    public int currentTeam; // 0:阵容一, 1:阵容二
    public int diam;
    public int gold;
    public int rankMoney;
    public int viv;
    public int strength;
    public int rank;
    public int scavageGold;
    public int attNumber;
    public int attWinNumber;
    public int defNumber;
    public int defWinNumber;
    public int arenaMoney;
    
    public int numGoldenKey;
    public int numSilverKey;
    public int numCopperKey;
    
    public Vector<int[]> heros;
    public Vector<int[]> items;
    public Vector<int[]> gems;
    public Vector<int[]> buildings;
    public Vector<int[]> pets;
    
    public Character(byte[] data){
        ready=false;
        numGoldenKey=0;
        numSilverKey=0;
        numCopperKey=0;
        int pos=4;
        certification=((data[pos]&0xff)<<24) | ((data[pos+1]&0xff)<<16) | ((data[pos+2]&0xff)<<8) | (data[pos+3]&0xff); pos+=4;
        pos+=8;
        id=((data[pos]&0xff)<<24) | ((data[pos+1]&0xff)<<16) | ((data[pos+2]&0xff)<<8) | (data[pos+3]&0xff); pos+=4;
        pos+=4;
        int length=((data[pos]&0xff)<<24) | ((data[pos+1]&0xff)<<16) | ((data[pos+2]&0xff)<<8) | (data[pos+3]&0xff); pos+=4;
        name=new String(data, pos, length); pos+=length;
        vip=((data[pos]&0xff)<<24) | ((data[pos+1]&0xff)<<16) | ((data[pos+2]&0xff)<<8) | (data[pos+3]&0xff); pos+=4;
        vipMoney=((data[pos]&0xff)<<24) | ((data[pos+1]&0xff)<<16) | ((data[pos+2]&0xff)<<8) | (data[pos+3]&0xff); pos+=4;
        level=((data[pos]&0xff)<<24) | ((data[pos+1]&0xff)<<16) | ((data[pos+2]&0xff)<<8) | (data[pos+3]&0xff); pos+=4;
        exp=((data[pos]&0xff)<<24) | ((data[pos+1]&0xff)<<16) | ((data[pos+2]&0xff)<<8) | (data[pos+3]&0xff); pos+=4;
        currentTeam=((data[pos]&0xff)<<24) | ((data[pos+1]&0xff)<<16) | ((data[pos+2]&0xff)<<8) | (data[pos+3]&0xff); pos+=4;
        diam=((data[pos]&0xff)<<24) | ((data[pos+1]&0xff)<<16) | ((data[pos+2]&0xff)<<8) | (data[pos+3]&0xff); pos+=4;
        gold=((data[pos]&0xff)<<24) | ((data[pos+1]&0xff)<<16) | ((data[pos+2]&0xff)<<8) | (data[pos+3]&0xff); pos+=4;
        int i, j, m;
        try{
            pos+=16;
            rankMoney=((data[pos]&0xff)<<24) | ((data[pos+1]&0xff)<<16) | ((data[pos+2]&0xff)<<8) | (data[pos+3]&0xff); pos+=4;
            pos+=12;
            viv=((data[pos]&0xff)<<24) | ((data[pos+1]&0xff)<<16) | ((data[pos+2]&0xff)<<8) | (data[pos+3]&0xff); pos+=4;
            pos+=4;
            strength=((data[pos]&0xff)<<24) | ((data[pos+1]&0xff)<<16) | ((data[pos+2]&0xff)<<8) | (data[pos+3]&0xff); pos+=4;
            pos+=16;
            rank=((data[pos]&0xff)<<24) | ((data[pos+1]&0xff)<<16) | ((data[pos+2]&0xff)<<8) | (data[pos+3]&0xff); pos+=4;
            pos+=44;
            scavageGold=((data[pos]&0xff)<<24) | ((data[pos+1]&0xff)<<16) | ((data[pos+2]&0xff)<<8) | (data[pos+3]&0xff); pos+=4;
            pos+=44;
            length=((data[pos]&0xff)<<24) | ((data[pos+1]&0xff)<<16) | ((data[pos+2]&0xff)<<8) | (data[pos+3]&0xff); pos+=4;
            pos+=length;
            length=((data[pos]&0xff)<<24) | ((data[pos+1]&0xff)<<16) | ((data[pos+2]&0xff)<<8) | (data[pos+3]&0xff); pos+=4;
            pos+=length;
            pos+=4;
            attNumber=((data[pos]&0xff)<<24) | ((data[pos+1]&0xff)<<16) | ((data[pos+2]&0xff)<<8) | (data[pos+3]&0xff); pos+=4;
            attWinNumber=((data[pos]&0xff)<<24) | ((data[pos+1]&0xff)<<16) | ((data[pos+2]&0xff)<<8) | (data[pos+3]&0xff); pos+=4;
            defNumber=((data[pos]&0xff)<<24) | ((data[pos+1]&0xff)<<16) | ((data[pos+2]&0xff)<<8) | (data[pos+3]&0xff); pos+=4;
            defWinNumber=((data[pos]&0xff)<<24) | ((data[pos+1]&0xff)<<16) | ((data[pos+2]&0xff)<<8) | (data[pos+3]&0xff); pos+=4;
            arenaMoney=((data[pos]&0xff)<<24) | ((data[pos+1]&0xff)<<16) | ((data[pos+2]&0xff)<<8) | (data[pos+3]&0xff); pos+=4;
            pos+=20;
            length=((data[pos]&0xff)<<24) | ((data[pos+1]&0xff)<<16) | ((data[pos+2]&0xff)<<8) | (data[pos+3]&0xff); pos+=4;
            pos+=length*12; 
            pos+=4;
            length=((data[pos]&0xff)<<24) | ((data[pos+1]&0xff)<<16) | ((data[pos+2]&0xff)<<8) | (data[pos+3]&0xff); pos+=4;
            
            heros=new Vector<int[]>();
            for(i=0; i<length; i++){
                m=((data[pos]&0xff)<<24) | ((data[pos+1]&0xff)<<16) | ((data[pos+2]&0xff)<<8) | (data[pos+3]&0xff); pos+=4;
                if(m!=19){
                    System.out.println("Error: should be 19, but is "+m);
                    return;
                }
                int[] h=new int[m+4];
                for(j=0; j<m; j++){
                    h[j]=((data[pos]&0xff)<<24) | ((data[pos+1]&0xff)<<16) | ((data[pos+2]&0xff)<<8) | (data[pos+3]&0xff); pos+=4;
                }
                for(j=0; j < h[m-1]; j++) {
                    h[j+m]=((data[pos]&0xff)<<24) | ((data[pos+1]&0xff)<<16) | ((data[pos+2]&0xff)<<8) | (data[pos+3]&0xff); pos+=4;
                }
                heros.add(h);
            }
            
            items=new Vector<int[]>();
            length=((data[pos]&0xff)<<24) | ((data[pos+1]&0xff)<<16) | ((data[pos+2]&0xff)<<8) | (data[pos+3]&0xff); pos+=4;
            //System.out.println("Number of items: "+length);
            for(i=0; i<length; i++){
                m=((data[pos]&0xff)<<24) | ((data[pos+1]&0xff)<<16) | ((data[pos+2]&0xff)<<8) | (data[pos+3]&0xff); pos+=4;
                if(m!=13 && m!=14){
                    System.out.println("Error: should be 13 or 14, but is "+m);
                    return;
                }
                int[] it=new int[18];
                for(j=0; j<18; j++){
                    it[j]=0;
                }
                for(j=0; j<m; j++){
                    it[j]=((data[pos]&0xff)<<24) | ((data[pos+1]&0xff)<<16) | ((data[pos+2]&0xff)<<8) | (data[pos+3]&0xff); pos+=4;
                }
                //System.out.println(i+" "+m+" "+it[m-1]);
                if(m==14 && it[m-1]>0){
                    for(j=0; j<it[m-1]; j++){
                        it[m+j]=((data[pos]&0xff)<<24) | ((data[pos+1]&0xff)<<16) | ((data[pos+2]&0xff)<<8) | (data[pos+3]&0xff); pos+=4;
                    }
                }
                items.add(it);
                setItemNumbers(it);
            }
            
            gems=new Vector<int[]>();
            length=((data[pos]&0xff)<<24) | ((data[pos+1]&0xff)<<16) | ((data[pos+2]&0xff)<<8) | (data[pos+3]&0xff); pos+=4;
            for(i=0; i<length; i++){
                m=((data[pos]&0xff)<<24) | ((data[pos+1]&0xff)<<16) | ((data[pos+2]&0xff)<<8) | (data[pos+3]&0xff); pos+=4;
                if(m!=4){
                    System.out.println("Error: should be 4, but is "+m);
                    return;
                }
                int[] gem=new int[4];
                for(j=0; j<m; j++){
                    gem[j]=((data[pos]&0xff)<<24) | ((data[pos+1]&0xff)<<16) | ((data[pos+2]&0xff)<<8) | (data[pos+3]&0xff); pos+=4;
                }
                gems.add(gem);
            }
            
            buildings=new Vector<int[]>();
            length=((data[pos]&0xff)<<24) | ((data[pos+1]&0xff)<<16) | ((data[pos+2]&0xff)<<8) | (data[pos+3]&0xff); pos+=4;
            for(i=0; i<length; i++){
                m=((data[pos]&0xff)<<24) | ((data[pos+1]&0xff)<<16) | ((data[pos+2]&0xff)<<8) | (data[pos+3]&0xff); pos+=4;
                if(m!=9){
                    System.out.println("Error: should be 9, but is "+m);
                    return;
                }
                int[] build=new int[9];
                for(j=0; j<m; j++){
                    build[j]=((data[pos]&0xff)<<24) | ((data[pos+1]&0xff)<<16) | ((data[pos+2]&0xff)<<8) | (data[pos+3]&0xff); pos+=4;
                }
                buildings.add(build);
            }
            
            pets=new Vector<int[]>();
            length=((data[pos]&0xff)<<24) | ((data[pos+1]&0xff)<<16) | ((data[pos+2]&0xff)<<8) | (data[pos+3]&0xff); pos+=4;
            //System.out.println("Number of items: "+length);
            for(i=0; i<length; i++){
                m=((data[pos]&0xff)<<24) | ((data[pos+1]&0xff)<<16) | ((data[pos+2]&0xff)<<8) | (data[pos+3]&0xff); pos+=4;
                if(m!=6){
                    System.out.println("Error: should be 6, but is "+m);
                    return;
                }
                int[] it=new int[16];
                for(j=0; j<16; j++){
                    it[j]=0;
                }
                for(j=0; j<m; j++){
                    it[j]=((data[pos]&0xff)<<24) | ((data[pos+1]&0xff)<<16) | ((data[pos+2]&0xff)<<8) | (data[pos+3]&0xff); pos+=4;
                }
                //System.out.println(i+" "+m+" "+it[m-1]);
                if(it[m-1]>0){
                    for(j=0; j<it[m-1]; j++){
                        it[m+j]=((data[pos]&0xff)<<24) | ((data[pos+1]&0xff)<<16) | ((data[pos+2]&0xff)<<8) | (data[pos+3]&0xff); pos+=4;
                    }
                }
                pets.add(it);
            }
            ready=true;
        }catch(Exception ex){
            System.out.println("Parsing failed.");
        }
    }
    
    public void setItemNumbers(int[] sth){
        switch(sth[2]){
            case 47108:
                numCopperKey=sth[4];
                break;
            case 47109:
                numSilverKey=sth[4];
                break;
            case 47110:
                numGoldenKey=sth[4];
                break;
        }
    }
    
}
