package com.company;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Instructor {
    private InetAddress serverIP;
    private int serverPort;

    public Instructor(InetAddress serverIP, int serverPort) {
        this.serverIP = serverIP;
        this.serverPort = serverPort;
    }

    public void runInitiator(){
        GUI screen = new GUI(this);
    }

    public void sendNewWork(int duration) {
        String message = "NEWWORK," + duration;
        try {
            DatagramPacket packet = new DatagramPacket(message.getBytes(), message.getBytes().length, serverIP, serverPort);
            DatagramSocket socket = new DatagramSocket();
            socket.send(packet);
            socket.close();
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
    public void shutdown() {
        String message = "SHUTDOWN";
        try {
            DatagramPacket packet = new DatagramPacket(message.getBytes(), message.getBytes().length, serverIP, serverPort);
            DatagramSocket socket = new DatagramSocket();
            socket.send(packet);
            socket.close();
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
}
