package de.spacechaos.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import de.spacechaos.client.core.SpaceChaosMultiplayerGame;
import de.spacechaos.client.util.CrashLogUtils;
import de.spacechaos.client.util.MicroOptions;

/**
 * Starts the application for the desktop-based builds.
 * 
 * @author damios
 */
public class DesktopLauncher {

    /**
     * The start-method for the whole application. Currently supported start
     * arguments:
     * <ul>
     * <li>--debug: sets the game to debug mode.
     * <li>--novid: skips the splash screen.
     * </ul>
     *
     * @param args
     *            The start arguments.
     */
    public static void main(String[] args) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "SpaceChaos Multiplayer";
        config.height = 720;
        config.width = 1280;
        config.resizable = false;
        config.addIcon("ui/images/icon.png", Files.FileType.Absolute);

        boolean debug = false;
        if (args != null && args.length > 0) {
            if (args[0].equalsIgnoreCase("debug")) {
                debug = true;
            }
        }

        MicroOptions options = new MicroOptions();
        options.option("novid").describedAs("no splashscreen").isUnary();
        options.option("debug").describedAs("enables debugmode").isUnary();
        try {
            options.parse(args);
        } catch (MicroOptions.OptionException e) {
            System.err.println("Usage:");
            System.err.println(options.usageString());
            System.exit(-1);
        }

        try {
            // Start the game
            new LwjglApplication(new SpaceChaosMultiplayerGame(options.has("debug"), !options.has("novid")), config);
        } catch (Exception e) {
            Gdx.app.error("SpaceChaos", "An unexpected error occurred starting the game", e);

            CrashLogUtils.writeCrashLogToFile(e, true);
        }
    }

}
