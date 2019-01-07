package com.vivaclub.ffzandbetterttv;

import java.util.Scanner;

public class ReadStreamChat {
    private static Scanner in;
    public ReadStreamChat(Scanner inP){
        in = inP;
    }
    public void ReadStreamLine(){
        String serverMassage =  in.nextLine();
    }
}
