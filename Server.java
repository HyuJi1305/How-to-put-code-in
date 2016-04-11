/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui3sochan;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author NHNH
 */
public class Server {
    public static void main(String[] args) throws IOException{
        System.out.println("Server Starting.....");
        ServerSocket ss = new ServerSocket(2345);
        System.out.println("Server Started!");
        Socket sv = ss.accept();
        DataInputStream nhan = new DataInputStream(sv.getInputStream());
        DataOutputStream gui = new DataOutputStream(sv.getOutputStream());
        int so1, so2, so3;
        while(true){
            so1 = nhan.readInt();
            System.out.println(so1);
            if(so1 % 2 == 0){
                System.out.println("dung");
                gui.writeUTF("dung");
                break;
            }else{
                System.out.println("sai");
                gui.writeUTF("sai");
            }
        }
        while(true){
            so2 = nhan.readInt();
            if(so2 % 2 == 0){
                gui.writeUTF("dung");
                break;
            }else{
                gui.writeUTF("sai");
            }
        }
        while(true){
            so3 = nhan.readInt();
            if(so3 % 2 == 0){
                gui.writeUTF("dung");
                break;
            }else{
                gui.writeUTF("sai");
            }
        }
        System.out.println(so1 +so2 +so3);
        gui.writeInt(so1 +so2 +so3);
    }
}
