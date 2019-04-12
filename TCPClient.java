import java.util.Scanner;
import java.net.*;
import java.io.*;

public class TCPClient {

	public static void main (String args[]) {
		String hostname = "localhost";
		Socket s = null;
		Scanner input;

		for (int i = 1; i <= 5; i++) {
			System.out.println("Ingresar el mensaje a enviar:");
	    	input = new Scanner(System.in);
	    	String message = input.nextLine();

			try{
				int serverPort = 7896;
				s = new Socket(hostname, serverPort);    
				DataInputStream in = new DataInputStream( s.getInputStream());
				DataOutputStream out =new DataOutputStream( s.getOutputStream());
				out.writeUTF(message);					// UTF is a string encoding see Sn. 4.4
				String data = in.readUTF();			// read a line of data from the stream
				System.out.println("Received: "+ data) ; 
			}
			catch (UnknownHostException e){System.out.println("Socket:"+e.getMessage());
			}
			catch (EOFException e){System.out.println("EOF:"+e.getMessage());
			}
			catch (IOException e){System.out.println("readline:"+e.getMessage());
			}
			finally {
				if (s!=null) 
					try {
						s.close();
					}
					catch (IOException e) {
						System.out.println("close:"+e.getMessage());
					}
			}
		}
	}
}