import java.util.Scanner;
import java.net.*;
import java.io.*;

public class UDPClient{

    public static void main(String args[]){
    	String hostname = "228.5.6.7";
		DatagramSocket aSocket = null;
		Scanner input;
		
		try {
			System.out.println("Ingresar el mensaje a enviar:");
	    	input = new Scanner(System.in);
			String message = input.nextLine();

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