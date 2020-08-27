package projetoRedesSocketsSimplesSMD;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int porta = 9191;
		
		try {
			ServerSocket welcomeSocket= new ServerSocket (porta);
		    
			int i=0;
			
			while (true) {
				Socket cliente= welcomeSocket.accept();
				i++;
				System.out.println ("Cliente "+i+ " conectado");	
				
				DataInputStream streamCliente= 
						new DataInputStream (cliente.getInputStream());
				
				System.out.println ("Mensagem: "+streamCliente.readUTF());
				
				streamCliente.close();
				
			}
			
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println ("Erro de Comunicação");
			e.printStackTrace();
		}
		
		
	}

}
