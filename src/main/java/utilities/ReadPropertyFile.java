package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

    public String getPropertyValue(String property) throws IOException
    {
        FileReader fr = new FileReader("C:\\Users\\Nagaraju_Dasari\\Desktop\\TAMP-Advanced\\src\\test\\resources\\configFiles\\config.properties");
        Properties p = new Properties();
        p.load(fr);

        return p.getProperty(property);
    }

}
