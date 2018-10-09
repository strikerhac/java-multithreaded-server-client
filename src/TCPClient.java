import java.io.*; 
import java.net.*; 
import java.util.Scanner;
public class TCPClient { 

	    @SuppressWarnings({ })
		public static void main(String argv[]) throws Exception 
	    { 		
	    		String message = "1";
		        String filename;
		        int establish_connection = 1;
		        Socket clientSocket;
		        @SuppressWarnings("resource")
				Scanner input = new Scanner(System.in);
		        
		        while(establish_connection == 1) {
		        clientSocket = new Socket("localhost", 6789);
		        
		        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream()); 
		        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); 
		        
		        
		        
				        	System.out.println("Enter your File name:");
				        	filename = inFromUser.readLine();
				        	outToServer.writeBytes(filename + ".txt\n");
				        	System.out.println("Text file successfully created:)");
				        	System.out.println("To finish writing the file type eof!!!\nOtherwise Enter your data:");
				        	
				        	while(!message.equals("eof ")) {
				        		message = inFromUser.readLine();
				        		message = message + " ";
					        	outToServer.writeBytes(message + "\n");
					        	if(!message.equals("eof "))
					        	System.out.println("To finish writing the file type eof!!!\nEnter your data:");
				        	}
				        	
				        	if(!message.equals("eof "))
				        	System.out.println(inFromServer.readLine());
			        
			        message = "1";
			        System.out.println("To connect with the server press 1\nTo exit press 0");
			        establish_connection = input.nextInt();
			        if(establish_connection == 0) {
			        	clientSocket.close();
			        	System.out.println("File write successfully completed :)");
			        }
		        }
		        
	             

	    }
}
