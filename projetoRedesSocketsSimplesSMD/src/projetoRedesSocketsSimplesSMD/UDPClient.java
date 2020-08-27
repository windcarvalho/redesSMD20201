package projetoRedesSocketsSimplesSMD;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPClient {

	public static void main(String[] args) {
		try {
			System.out.println ("BOA NOITE, SOU O CLIENTE UDP");
			
			
			DatagramSocket clienteUDP = new DatagramSocket ();
			
			System.out.println ("Cliente Abrindo Conexão");
			
			InetAddress ipDoServidor = InetAddress.getByName ("localhost");
			byte[] sendData= new byte [1024];
			
			System.out.println ("Criando o pacote");
			
			sendData = "Boa noite Moçada".getBytes();
			DatagramPacket pacoteDeEnvio = 
					new DatagramPacket (sendData, sendData.length, ipDoServidor,8787);
			
			System.out.println ("Esperando um enter para enviar");
			System.in.read(); //Esperando um caractere
			
			
			clienteUDP.send(pacoteDeEnvio);
			
			System.out.println ("Pacote Enviado");
			
			
			byte[] receiveData = new byte[1024];
			
			DatagramPacket pac= new DatagramPacket(receiveData, 
					receiveData.length);
			System.out.println ("Esperando uma resposta");
			clienteUDP.receive(pac);
			
			String resposta = new String (receiveData);
			System.out.println ("Resposta: "+resposta);
			
			clienteUDP.close();
			
					
		} catch (Exception e) {
			System.out.println ("Deu erro no cliente");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
