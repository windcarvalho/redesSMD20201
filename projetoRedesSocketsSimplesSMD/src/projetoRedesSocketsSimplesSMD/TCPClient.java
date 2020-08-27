package projetoRedesSocketsSimplesSMD;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			
			Socket cliente = new Socket ("192.168.1.102",9090);
		
			DataOutputStream streamSaida =
					new DataOutputStream(cliente.getOutputStream());
			
			streamSaida.writeUTF("odeio código");
			streamSaida.flush();
			
			streamSaida.close();
			cliente.close();
		
		
		
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
