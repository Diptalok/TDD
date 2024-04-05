package generic_Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
	
	public String ReadDataProp(String key)throws IOException {
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	Properties prop = new Properties();
	prop.load(fis);
	return prop.getProperty(key);
	
	}
}

