package configuration;

import java.io.InputStream;
import java.util.Properties;

public class DataConfiguration {

  private final Properties properties = new Properties();
  private String configName;

  public DataConfiguration() {
    try {
      InputStream ip = getClass()
          .getClassLoader()
          .getResourceAsStream("config.properties");
      properties.load(ip);

      this.configName = properties.getProperty("active");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public String getData(String name) {
    try {
      InputStream ip = getClass().getClassLoader()
          .getResourceAsStream(this.configName + ".properties");
      properties.load(ip);

      return properties.getProperty(name);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
