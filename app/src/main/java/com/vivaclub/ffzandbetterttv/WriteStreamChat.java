package com.vivaclub.ffzandbetterttv;

import java.io.PrintWriter;

public class WriteStreamChat {
    private static PrintWriter out;
    public WriteStreamChat(PrintWriter outP){
        out = outP;
        out.write("CAP REQ :twitch.tv/tags twitch.tv/commands twitch.tv/membership\r\n");
        out.flush();
    }
    public void WriteStreamChat(String message){
        out.write(message+"\r\n");
        out.flush();
    }
    public void JoinToChat(String channel){
        out.write("join #"+channel+"\r\n");
        out.flush();
    }
    public void LoginToChat(String NICK, String PASS){
        out.write("PASS "+PASS+"\r\n");
        out.flush();
        out.write("NICK "+NICK+"\r\n");
        out.flush();
    }




}
