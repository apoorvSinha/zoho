package Base;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class App_log {
    public static Logger logger = Logger.getLogger(App_log.class.getName());

    public App_log(){
        FileHandler fh;
        try{
            fh = new FileHandler("./src/test/resources/logs/Application.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (IOException e) {
            logger.log(Level.WARNING, "Exception :: "+ e);
        }

    }
}
