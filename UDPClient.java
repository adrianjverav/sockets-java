import java.util.Scanner;
import java.net.*;
import java.io.*;

public class UDPClient{

    public static void main(String args[]){
    	// String message = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nisi inventore dicta et, veniam adipisci distinctio, nostrum voluptates illo saepe excepturi deserunt autem, odit consequatur velit optio iure! Minus accusamus rem enim libero non laudantium, in error, consequuntur, eaque veritatis commodi porro nesciunt quo dolore debitis ex explicabo laboriosam quisquam! Provident quaerat aspernatur dignissimos cum corporis sint. Sapiente, tempore! Natus qui, nobis nisi temporibus, hic voluptatem inventore doloremque magni modi asperiores. Iure enim fugiat illo, reiciendis delectus labore officia neque? Perspiciatis tempore sapiente iure praesentium totam harum rerum veniam accusamus aspernatur est sint similique, in a numquam eveniet neque accusantium distinctio nemo facere laudantium incidunt ducimus inventore doloremque aliquid. Laudantium blanditiis dolor tempore quidem earum est, a neque itaque recusandae optio.";
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