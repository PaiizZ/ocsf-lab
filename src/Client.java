import java.io.IOException;
import java.util.Scanner;

import com.lloseng.ocsf.client.ObservableClient;

public class Client extends ObservableClient{

	public Client(String host, int port) {
		super(host, port);
	}
	public void handleMessageFromServer(Object msg){
		System.out.println(msg);
	}
	public static void main(String[] args) throws IOException {
		Client sever = new Client("158.108.136.102",5001);
		Scanner input = new Scanner(System.in);
		sever.openConnection();
		while(sever.isConnected()){
			String msg = input.nextLine();
			if(msg.equalsIgnoreCase("quit")){
				sever.closeConnection();
				break;
			}
			sever.sendToServer(msg);	
		}
	}
}

