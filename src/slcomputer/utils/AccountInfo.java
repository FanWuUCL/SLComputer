/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.utils;

import slcomputer.main.SLComputer;

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
    
    public AccountInfo dup(){
        AccountInfo acc=new AccountInfo();
        acc.usr=usr;
        acc.psd=psd;
        acc.fwq=fwq;
        return acc;
    }
    
    public void setAll(String usr, String psd, int fwq){
        this.usr=usr;
        this.psd=psd;
        this.fwq=fwq;
    }
    
    public String convert() throws Exception{
        return SLComputer.des.encrypt(usr+":"+fwq+":"+psd);
    }
    
    public String toString(){
        return usr;
    }
}
