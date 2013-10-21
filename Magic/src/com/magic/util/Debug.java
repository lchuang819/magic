package com.magic.util;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Debug {

	public static final String noModuleModule = "NoModule";

	public static final int ALWAYS = 0;
	public static final int VERBOSE = 1;
	public static final int TIMING = 2;
	public static final int INFO = 3;
	public static final int IMPORTANT = 4;
	public static final int WARNING = 5;
	public static final int ERROR = 6;
	public static final int FATAL = 7;

	public static final String[] levels = { "Always", "Verbose", "Timing",
			"Info", "Important", "Warning", "Error", "Fatal" };

	public static final Level[] levelObjs = { Level.INFO, Level.DEBUG,
			Level.INFO, Level.INFO, Level.INFO, Level.WARN, Level.ERROR,
			Level.FATAL };

	public static void log(int level, Throwable t, String msg, String module,
			String callingClass) {

		Logger logger = Logger.getLogger(module);

		logger.log(callingClass, levelObjs[level], msg, t);
	}

	public static void log(int level, Throwable t, String msg, String module) {
		log(level, t, msg, module, "com.magic.util.Debug");
	}

	public static void log(String msg) {
		log(Debug.ALWAYS, null, msg, noModuleModule);
	}

	public static void log(Throwable t) {
		log(Debug.ALWAYS, t, null, noModuleModule);
	}

	public static void log(String msg, String module) {
		log(Debug.ALWAYS, null, msg, module);
	}

	public static void log(Throwable t, String module) {
		log(Debug.ALWAYS, t, null, module);
	}

	public static void log(Throwable t, String msg, String module) {
		log(Debug.ALWAYS, t, msg, module);
	}

	public static void logInfo(String msg, String module) {
		log(Debug.INFO, null, msg, module);
	}

	public static void logInfo(Throwable t, String module) {
		log(Debug.INFO, t, null, module);
	}

	public static void logInfo(Throwable t, String msg, String module) {
		log(Debug.INFO, t, msg, module);
	}

	public static void logError(String msg, String module) {
		log(Debug.ERROR, null, msg, module);
	}

	public static void logError(Throwable t, String module) {
		log(Debug.ERROR, t, null, module);
	}

	public static void logError(Throwable t, String msg, String module) {
		log(Debug.ERROR, t, msg, module);
	}

	public static void logFatal(String msg, String module) {
		log(Debug.FATAL, null, msg, module);
	}

	public static void logFatal(Throwable t, String module) {
		log(Debug.FATAL, t, null, module);
	}

	public static void logFatal(Throwable t, String msg, String module) {
		log(Debug.FATAL, t, msg, module);
	}

	public static void logVerbose(String msg, String module) {
		log(Debug.VERBOSE, null, msg, module);
	}

	public static void logVerbose(Throwable t, String module) {
		log(Debug.VERBOSE, t, null, module);
	}

	public static void logVerbose(Throwable t, String msg, String module) {
		log(Debug.VERBOSE, t, msg, module);
	}

	public static void logWarning(String msg, String module) {
		log(Debug.WARNING, null, msg, module);
	}

	public static void logWarning(Throwable t, String module) {
		log(Debug.WARNING, t, null, module);
	}

	public static void logWarning(Throwable t, String msg, String module) {
		log(Debug.WARNING, t, msg, module);
	}

	public static void logTiming(String msg, String module) {
		log(Debug.TIMING, null, msg, module);
	}

	public static void logTiming(Throwable t, String module) {
		log(Debug.TIMING, t, null, module);
	}

	public static void logTiming(Throwable t, String msg, String module) {
		log(Debug.TIMING, t, msg, module);
	}
	
	public static void logImportant(String msg, String module) {
        log(Debug.IMPORTANT, null, msg, module);
    }

    public static void logImportant(Throwable t, String module) {
        log(Debug.IMPORTANT, t, null, module);
    }

    public static void logImportant(Throwable t, String msg, String module) {
        log(Debug.IMPORTANT, t, msg, module);
    }
    

}
