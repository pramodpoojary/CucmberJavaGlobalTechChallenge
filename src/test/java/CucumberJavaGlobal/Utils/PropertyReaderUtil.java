package CucumberJavaGlobal.Utils;

import java.io.FileReader;
import java.util.Properties;

public class PropertyReaderUtil {
	public static String getProperty(String key) {
		FileReader reader = null;
		Properties properties = null;
		String value = null;
		try {
			reader = new FileReader("src/test/resources/Configuration.properties");
			properties = new Properties();
			properties.load(reader);
			value = properties.getProperty(key);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		return value;
	}

}
