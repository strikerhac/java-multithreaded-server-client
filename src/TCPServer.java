import java.net.*; 

public class TCPServer { 

	public static void main(String argv[]) throws Exception { 
		  

	    @SuppressWarnings("resource")
		ServerSocket welcomeSocket = new ServerSocket(6789); 
	  
	      while(true) { 
	  
	           Socket connectionSocket = welcomeSocket.accept(); 
	           Serverthreads connection = new Serverthreads(connectionSocket);
	           connection.start();
	          
	      }        
	  }
}
