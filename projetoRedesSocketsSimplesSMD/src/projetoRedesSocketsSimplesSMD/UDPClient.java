package projetoRedesSocketsSimplesSMD;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPClient {

	public static void main(String[] args) {
		try {
			DatagramSocket clienteUDP = new DatagramSocket ();
			System.out.println ("Abrindo Conexão");
			
			InetAddress ipDoServidor = InetAddress.getByName ("localhost");
			byte[] sendData= new byte [1024];
			
			sendData = "Boa noite Moçada".getBytes();
			DatagramPacket pacoteDeEnvio = 
					new DatagramPacket (sendData, sendData.length, ipDoServidor,8787);
			
			System.out.println ("Criando o pacote");
			
			clienteUDP.send(pacoteDeEnvio);
			
			System.out.println ("Pacote Enviado");
			
			clienteUDP.close();
			
					
		} catch (Exception e) {
			System.out.println ("Deu erro no cliente");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
