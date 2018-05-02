package de.spacechaos.client.util;

import com.badlogic.gdx.Gdx;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * This class holds utility methods for dealing with crash logs.
 * 
 * @author damios
 */
public class CrashLogUtils {

    public static final File CRASH_LOG_FILE = new File("./crash.log");
    private static final Charset CHARSET = Charset.isSupported("UTF-8") ? Charset.forName("UTF-8")
            : Charset.defaultCharset();

    private CrashLogUtils() {}

    /**
     * Writes a crash log to the {@linkplain #CRASH_LOG_FILE crash log file}.
     * Appends to any existing logs.
     * 
     * @param e
     *            The exception.
     * @see #writeCrashLogToFile(Exception, boolean)
     */
    public static void writeCrashLogToFile(Exception e) {
        writeCrashLogToFile(e, false);
    }

    /**
     * Writes a crash log to the {@linkplain #CRASH_LOG_FILE crash log file}.
     * Appends to any existing logs.
     * 
     * @param e
     *            The exception.
     * @param forceExit
     *            Whether the application should get shut down.
     */
    public static void writeCrashLogToFile(Exception e, boolean forceExit) {
        try {
            FileUtils.writeStringToFile(CRASH_LOG_FILE, e.getLocalizedMessage(), CHARSET, true);
        } catch (IOException e1) {
            Gdx.app.error("SpaceChaos", "An error occurred saving the crash log", e);
        }

        if (forceExit)
            throw new RuntimeException("ForceExit set to true");
    }

}
