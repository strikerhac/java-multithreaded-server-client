import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Serverthreads extends Thread{
	private Socket client = null;
	private String filename = null;
	private String message = null;
	private File file = null;
    
	Serverthreads(Socket client){
		this.client = client;
	}
	
	app app = new app();
	
	private void logic() throws IOException {
		BufferedReader inFromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
		
				filename = inFromClient.readLine();
				file = app.createfile(filename); 
				message = inFromClient.readLine();
				while(!message.equals("eof ")) {
					app.writefile(file, message);
					message = inFromClient.readLine();
				}
			
	}
	
	public void run() {
		
		try {
			logic();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
}
		  
        