package readFromPropertiesFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfiguration {

	public  Properties prop;
	public  void readConfigurationFile() throws IOException
	{
		prop=new Properties();
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\Resource\\Configuration.properties");
		prop.load(file);
	}	
}
