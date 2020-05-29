package com.company;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {

    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("That's not enough arguments! Usage: Initiator <server IP> <server port>");
        } else {
            System.out.println("System running :)");
            InetAddress tempIP;
            try {
                tempIP = InetAddress.getByName(args[0]);
                int tempPort = Integer.parseInt(args[1]);
                Instructor host = new Instructor(tempIP, tempPort);
                host.runInitiator();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
    }
}
