import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class app {
	String filedata;

	public File createfile(String filename) throws IOException {
		File file = new File(filename);
	    file.createNewFile();
		return file;
		//"The file has been created successfully :)";
	}
	
	public void writefile(File filename, String message) throws IOException {
		FileWriter writer = new FileWriter(filename,true); 
	    writer.append(message); 
	    writer.flush();
        writer.close();
	}

}
