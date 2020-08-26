package projetoRedesSocketsSimplesSMD;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {

	public static void main(String[] args) {
		
		int porta= 8787;
		try {
			DatagramSocket servidorUDP= new DatagramSocket(porta);
			System.out.println ("Servidor Funcionando na porta:"+porta);
			
			while (true) {
				
				byte[] receiveData = new byte [1024];
				
				DatagramPacket pacoteRecebido= 
						new DatagramPacket(receiveData,receiveData.length);
				
				System.out.println("Esperando Pacote");
				servidorUDP.receive(pacoteRecebido); //Servidor vai bloqueado
				
				
				String sentence = new String (pacoteRecebido.getData());
		    	  
		    	  System.out.println ("Recebi:"+sentence);
				
				
			}
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			System.out.println ("Deu erro ao abrir servidor");
			e.printStackTrace();
		}
		
	}

}
