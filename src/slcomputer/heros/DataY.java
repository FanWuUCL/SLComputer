/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.heros;

import java.util.ArrayList;

/**
 *
 * @author J
 */
public class DataY {
    private int number;
    private ArrayList<DataY> list;
    
    public DataY(int n){
        number=n;
        list=null;
    }
    
    public void insertNumber(int n){
        if(list==null){
            list=new ArrayList<DataY>();
            list.add(new DataY(number));
        }
        list.add(new DataY(n));
    }
    
    public int getLength(){
        if(list==null){
            return 1;
        }
        int l=0;
        for(DataY d: list){
            l+=d.getLength();
        }
        return l;
    }
    
    public int getNumberAt(int index){
        if(list==null){
            return number;
        }
        return list.get(index).getNumberAt(0);
    }
    
    public DataY getDataAt(int index){
        if(list==null){
            return null;
        }
        return list.get(index);
    }
    
    public boolean containsNumber(int n){
        if(list==null){
            return number==n;
        }
        for(DataY d: list){
            if(d.containsNumber(n)){
                return true;
            }
        }
        return false;
    }
}
