package projetoRedesSocketsSimplesSMD;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer {

	public static void main(String[] args) {
		
		int porta= 8787;
		try {
			System.out.println ("BOA NOITE, SOU O SERVIDOR UDP");
			
			
			DatagramSocket servidorUDP= new DatagramSocket(porta);
			System.out.println ("Servidor Funcionando na porta:"+porta);
			
			int i = 0;
			while (true) {
				
				byte[] receiveData = new byte [1024];
				
				DatagramPacket pacoteRecebido= 
						new DatagramPacket(receiveData,receiveData.length);
				
				i++;
				System.out.println("Esperando Pacote de número:"+i);
				servidorUDP.receive(pacoteRecebido); //Servidor vai bloqueado
				
				
				String sentence = new String (pacoteRecebido.getData());
		    	  
		    	System.out.println ("Recebi:"+sentence);
		    	  
		    	byte[] sendData = new byte[1024];
		    	
		    	sendData = "Boa noite meu patrão".getBytes();
		    	
		    	InetAddress enderDestino= pacoteRecebido.getAddress();
		    	int portaDoCliente= pacoteRecebido.getPort();
		    	
		    	DatagramPacket pacSaida= 
		    			new DatagramPacket (sendData,sendData.length,
		    		enderDestino, portaDoCliente);
		    	
		    	System.out.println ("Enviando: "+new String (sendData));
		    	
		    	servidorUDP.send(pacSaida);
		    	
				
			}
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			System.out.println ("Deu erro ao abrir servidor");
			e.printStackTrace();
		}
		
	}

}
