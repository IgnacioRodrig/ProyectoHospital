package logging;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.*;
import java.util.logging.FileHandler;

public class MyLogger {
    final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private final static Level LOGGER_LVL = Level.FINEST;
    private final static Level CONSOLE_LVL = Level.WARNING;
    private final static Level FILE_LVL = Level.INFO;
    private final static String LOGGING_FILE = "./lib/logging.properties";
    
    static public void setup() throws IOException {
    	Logger rootLogger = Logger.getLogger("");
    	Handler[] handlers = rootLogger.getHandlers();
    	for(Handler handler : handlers) {rootLogger.removeHandler(handler);}
    	LOGGER.setLevel(LOGGER_LVL);
    	ConsoleHandler consoleH = new ConsoleHandler();
    	SimpleFormatter formatterTxt = new SimpleFormatter();
    	consoleH.setFormatter(formatterTxt);
    	consoleH.setLevel(CONSOLE_LVL);
    	LOGGER.addHandler(consoleH);
    	if (LOGGER_LVL != Level.OFF && FILE_LVL != Level.OFF) {
    	    LocalDateTime ldt = LocalDateTime.now();
    	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HHmmss");
    	    FileHandler fileH = new FileHandler("./log/log_"+ ldt.format(formatter) +".log");
    	    XMLFormatter formatterXML = new XMLFormatter();
    	    fileH.setFormatter(formatterXML);
    	    fileH.setLevel(FILE_LVL);
    	    LOGGER.addHandler(fileH);
    	}
    	LOGGER.info("Logger is configured");
    }

    static public void setupFromFile(){
    	Logger rootLogger = Logger.getLogger("");
    	Handler[] handlers = rootLogger.getHandlers();
    	for(Handler handler : handlers) {
    	    rootLogger.removeHandler(handler);
    	}

    	try {
    	    InputStream stream = new FileInputStream(LOGGING_FILE);
    	    LogManager.getLogManager().readConfiguration(stream);
    	} catch (IOException e) {
    	    e.printStackTrace();
    	}
    	LOGGER.info("Logger is configured");
    }
}