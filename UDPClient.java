import java.net.*;
import java.io.*;

public class UDPClient{

    public static void main(String args[]){
    	String message = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptatum esse fuga in, ex officia magnam, laboriosam soluta quibusdam sit tempora, ipsum tempore iste quo culpa sequi molestias alias repellendus! Aliquam sit cum magnam nam, voluptate necessitatibus ea laboriosam natus, molestias.";
    	String hostname = "localhost";
		DatagramSocket aSocket = null;
		
		try {
			aSocket = new DatagramSocket();    
			byte [] m = message.getBytes();
			InetAddress aHost = InetAddress.getByName(hostname);
			int serverPort = 6789;		                                                 
			DatagramPacket request = new DatagramPacket(m, message.length(), aHost, serverPort);
			aSocket.send(request);			                        
			byte[] buffer = new byte[100];
			DatagramPacket reply = new DatagramPacket(buffer, buffer.length);	
			aSocket.receive(reply);
			System.out.println("Reply: " + new String(reply.getData()));	
		}
		catch (SocketException e){
			System.out.println("Socket: " + e.getMessage());
		}
		catch (IOException e){
			System.out.println("IO: " + e.getMessage());
		}
		finally {
			if(aSocket != null)
				aSocket.close();
		}
	}		      	
}