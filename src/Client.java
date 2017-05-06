import java.io.IOException;
import java.util.Scanner;

import com.lloseng.ocsf.client.ObservableClient;
/**
 * This is class to be a client that connects to server and sends information.
 * @author PaiizZ
 * @version 5/5/2017
 */
public class Client extends ObservableClient{
	/**
	 * Initialize this client what host server address and port to connect.
	 * 
	 * @param host is address of server
	 * @param port is is port of server.
	 */
	public Client(String host, int port) {
		super(host, port);
	}
	
	/**
	 * Print message from server
	 */
	public void handleMessageFromServer(Object msg){
		System.out.println("> "+msg);
	}
	
	/**
	 * Main for run the client
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Client sever = new Client("192.168.1.5",5001);
		Scanner input = new Scanner(System.in);
		sever.openConnection();
		while(sever.isConnected()){
			String msg = input.nextLine();
			if(msg.equalsIgnoreCase("quit")) {
				sever.closeConnection(); 
				break;
			}
			else sever.sendToServer(msg);
		}
	}
}

