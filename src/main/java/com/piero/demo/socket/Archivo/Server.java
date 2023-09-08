package com.piero.demo.socket.Archivo;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {
	
	private final Integer PORT = 80;
	private final String IP = "localhost";
	
	public Server() {
		try {
			Socket clientSocket = new Socket(IP, PORT);
			System.out.println("------------- 1 Iniciando la Comunicación ---------------");
			System.out.println("Inet Address : " + clientSocket.getInetAddress());
			
			File fileOrigen = new File("D:/cliente/Java-Piero.png");
			FileInputStream fis = new FileInputStream(fileOrigen);
			DataOutputStream salida = new DataOutputStream(clientSocket.getOutputStream());
			
			int byteLeidos;
			while ( (byteLeidos = fis.read())!= -1) {
				salida.write(byteLeidos);
			}
		
			
			fis.close();
			salida.close();
			
			System.out.println("------------- 2 Finalizando la Comunicaciónnn -------------");
			clientSocket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		new Server();
	}

}
