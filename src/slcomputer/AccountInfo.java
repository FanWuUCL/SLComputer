/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer;

/**
 *
 * @author J
 */
public class AccountInfo {
    public String usr;
    public String psd;
    public int fwq;
    
    public AccountInfo(){
        usr="";
        psd="";
        fwq=0;
    }
    
    public String encode(String s){
        String encoded="";
        return encoded;
    }
    
    public String decode(String s){
        String decoded="";
        return decoded;
    }
    
    public String toString(){
        return usr+"\t"+fwq+"\t"+psd;
    }
}
