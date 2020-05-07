package Utils;

import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class RLogger {

    private static RLogger RLogger = null;
    private static RLogger rLog = null;

    public static RLogger getLogger(Class<?> T) {
        if (RLogger == null) {
            Properties props = new Properties();
            try {

                String envPath = System.getProperty("user.dir") +
                        File.separator + "/src/test/java/Utils/logger.properties";
                System.out.println(envPath);
                InputStream is = new FileInputStream(envPath);
                props.load(is);
            } catch (IOException e) {
                e.printStackTrace();
            }

            PropertyConfigurator.configure(props);
            RLogger = RLogger.getLogger(T);
            rLog = new RLogger();
        }
        return rLog;
    }


    public void info(Object msg) {
        RLogger.info(msg);
    }

    public void debug(Object msg) {
        RLogger.debug(msg);
    }

    public void warn(Object msg) {
        RLogger.warn(msg);
    }

    public void error(Object msg) {
        RLogger.error(msg);
    }
}

