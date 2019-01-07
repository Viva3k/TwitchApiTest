package com.vivaclub.ffzandbetterttv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ConnectToIrc extends Thread {
    private static PrintWriter out;
    private static Scanner in;
    private int port;
    public ConnectToIrc(int Port) {
        this.port = Port;
    }
    public void run() {
        try {
            Socket socket = new Socket(Constant.IRC_TWITC_URL, port);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new Scanner(socket.getInputStream());
        } catch (UnknownHostException ex) {
            System.out.println("UnknownHostException");
        } catch (SocketTimeoutException ex) {
            System.out.println("SocketTimeoutException");
        } catch (IOException ex) {
            System.out.println("IOException");
        }
        WriteStreamChat writeStreamChat = new WriteStreamChat(out);
        writeStreamChat.LoginToChat("mytnyu","oauth:2stfhsarzgqqyv3dwnw14vilefkyo8");
        writeStreamChat.JoinToChat("mytnyu");



        while (in.hasNext()){
            String serverMassage =  in.nextLine();
            System.out.println("МЕТКА - "+ serverMassage);
        }
        return;
    }
    public PrintWriter getOutputStream(){
        return out;
    }
    public Scanner getInputStream(){
        return in;
    }
}
