/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.main;

import java.util.logging.Level;
import java.util.logging.Logger;
import slcomputer.palas.SlClient;
import slcomputer.palas.SlResponse;
import slcomputer.runnable.SocketMaster;
import slcomputer.utils.DesUtils;

/**
 *
 * @author J
 */
public class EnigmaUtil {
    public static int checksum(String s){
        int sum=0;
        for(char c: s.toCharArray()){
            sum+=c;
        }
        return sum%10;
    };
    
    
    public static String checkVip(String usr){
        String vip=null;
        int i;
        int cs=4;
        try{
            SlResponse response = SlClient.checkUser(usr);
            if (response.isValid()) {
                vip=SLComputer.des.decrypt(response.getAccount());
                cs=checksum(vip);
                SocketMaster.arguments[SocketMaster.arguments.length-1]=response.getType()+cs*5;
            } else {
                    vip="";
            }
        }catch(Exception ex){
            vip=null;
        }
        return vip;
    }
}
