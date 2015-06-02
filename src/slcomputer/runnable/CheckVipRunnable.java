/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slcomputer.runnable;

import javax.swing.JOptionPane;
import slcomputer.main.EnigmaUtil;
import slcomputer.main.SLComputer;
import slcomputer.utils.AccountInfo;

/**
 *
 * @author J
 */
public class CheckVipRunnable implements Runnable{
    private AccountInfo account;
    
    public CheckVipRunnable(AccountInfo ai){
        account=ai;
    }

    @Override
    public void run() {
        String usr=EnigmaUtil.checkVip(account.usr);
        if(usr==null){
            JOptionPane.showMessageDialog(SLComputer.mf, "可能由于网络问题导致账号验证失败，请重新尝试。\nVip用户可以登记至多2个账号，只有登记过的账号才能使用此功能。", "版权", JOptionPane.ERROR_MESSAGE);
            return;
        }
        SocketMaster.setGlobalIP(account.fwq);
        SocketMaster.arguments[0]=usr;
        SocketMaster.arguments[1]=account.psd;
        SocketMaster.arguments[2]=account.fwq;
        SocketMaster.cmdGlobal=SocketMaster.c_login;
        SocketMaster sm=new SocketMaster();
        new Thread(sm).start();
    }
    
}
