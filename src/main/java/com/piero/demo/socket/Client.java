package com.piero.demo.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {

	
private final Integer PORT = 13;
	
	public Client() {
	
		try {
			Socket clientSocket;
			
			ServerSocket serverSocket = new ServerSocket(PORT);
			while(true) {
				System.out.println("------------- 1 Iniciando ServerSocket ---------------");
				System.out.println("------------- 2 A la espera de  serverSocket ---------");
				clientSocket = serverSocket.accept();
				System.out.println("------------- 3 Llegada de un serverSocket -----------");
				
				
				
				clientSocket.close();
				System.out.println("------------- 4 Finaliza atención al serverSocket ----");
			}
			
			
			//DSD
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Client();
	}
}
