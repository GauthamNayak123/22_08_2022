package GenericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	
	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fin=new FileInputStream(AutoConstants.propfilepath);
		Properties prop=new Properties();
		prop.load(fin);
		return prop.getProperty(key);
		
	}
	
}
