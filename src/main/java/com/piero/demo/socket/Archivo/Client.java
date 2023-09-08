package com.piero.demo.socket.Archivo;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {
private final Integer PORT = 80;
	
	public Client() {
	
		try {
			Socket clientSocket;
			
			ServerSocket serverSocket = new ServerSocket(PORT);
			while(true) {
				System.out.println("------------- 1 Iniciando el clientSocket ---------------");
				System.out.println("------------- 2 A la espera de  serverSocket ---------");
				clientSocket = serverSocket.accept();
				System.out.println("------------- 3 Llegada de un serverSocket -----------");
				
				File fileDestino = new File("D:/server/Java-Piero-2.png");
				FileOutputStream fos = new FileOutputStream(fileDestino);
				DataInputStream entrada = new DataInputStream(clientSocket.getInputStream());
				
				int byteLeidos;
				while ( (byteLeidos = entrada.read())!= -1) {
					fos.write(byteLeidos);
				}
				fos.close();
				
				clientSocket.close();
				System.out.println("------------- 4 Finaliza atención al serverSocket ----");
			}
			
			
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
