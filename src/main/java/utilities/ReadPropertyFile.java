package utilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class ReadPropertyFile {

    public String getPropertyValue(String property) throws IOException
    {

        Path resourceDirectory = Paths.get("src","test","resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        String configPath= "\\configFiles\\config.properties" ;
        String path = absolutePath+configPath;

        FileReader fr = new FileReader(path);
        Properties p = new Properties();
        p.load(fr);

        return p.getProperty(property);
    }

}
