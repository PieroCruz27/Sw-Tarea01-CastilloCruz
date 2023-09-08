package com.piero.demo.socket.mensaje;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {
	
private final Integer PORT = 13;
	
	public Client() {
	
		try {
			Socket clientSocket;
			
			ServerSocket serverSocket = new ServerSocket(PORT);
			while(true) {
				System.out.println("------------- 1 Iniciando clientSocket ---------------");
				System.out.println("------------- 2 A la espera de  serverSocket ---------");
				clientSocket = serverSocket.accept();
				System.out.println("------------- 3 Llegada de un serverSocket -----------");
				
				//Flujos de comunicación
				BufferedReader entrada = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				PrintWriter salida = new PrintWriter(clientSocket.getOutputStream(),true);
				
				
				String opcion = entrada.readLine();
				System.out.println("------------- 4 opción > "+ opcion +"-----------");
				switch (opcion) {
					case "BASICO": 		salida.println("Paga PEN 10");
					case "Vip": 		salida.println("Paga PEN 150");
					case "EXCLUSIVO": 	salida.println("Paga PEN 550");
				}

				clientSocket.close();
				System.out.println("------------- 5 Finaliza LA atención al serverSocket ----");
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
