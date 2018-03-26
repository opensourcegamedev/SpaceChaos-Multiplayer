package de.spacechaos.client.core;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.google.common.eventbus.EventBus;

import de.spacechaos.client.screen.BaseScreen;
import de.spacechaos.client.screen.BaseUIScreen;
import de.spacechaos.client.screen.LoadingScreen;
import de.spacechaos.client.screen.MainMenuScreen;
import de.spacechaos.client.screen.ScreenNotFoundException;
import de.spacechaos.client.screen.SplashScreen;
import de.spacechaos.client.setting.GameSettings;
import net.dermetfan.gdx.assets.AnnotationAssetManager;

/**
 * This class starts the game by creating all the necessary screens and then
 * displaying the menu. The assets of the screens are loaded automatically when
 * the screens are first shown, but can also be loaded by the
 * {@link LoadingScreen LoadingScreen}.
 * <p>
 * Only {@link BaseScreen}s are supported.
 */
public class SpaceChaosMultiplayerGame extends Game {

    private SpriteBatch batch;
    /**
     * The asset manager.
     */
    private final AnnotationAssetManager assetManager = new AnnotationAssetManager(new InternalFileHandleResolver());
    /**
     * A map with all initialized screens.
     */
    private Map<String, BaseScreen> screens = new ConcurrentHashMap<>();

    private int viewportWidth;
    private int viewportHeight;

    private OrthographicCamera uiCamera;
    private PerspectiveCamera gameCamera;

    private GameSettings settings;

    private boolean debug, showSplashscreen;

    private InputMultiplexer inputProcessor = new InputMultiplexer();

    private Skin uiSkin;

    private GameSession session;

    /**
     * The event bus.
     */
    private EventBus eventBus;

    public SpaceChaosMultiplayerGame(boolean debug, boolean showSplashscreen) {
        super();

        this.debug = debug;
        this.showSplashscreen = showSplashscreen;
    }

    @Override
    public void create() {
        if (debug)
            Gdx.app.setLogLevel(Application.LOG_DEBUG);
        else
            Gdx.app.setLogLevel(Application.LOG_INFO);

        // Initialize sprite batch
        this.batch = new SpriteBatch();

        // Initialize asset manager
        FileHandleResolver resolver = new InternalFileHandleResolver();
        this.assetManager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
        this.assetManager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));

        this.viewportWidth = Gdx.graphics.getWidth();
        this.viewportHeight = Gdx.graphics.getHeight();

        // Initialize cameras
        this.uiCamera = new OrthographicCamera(viewportWidth, viewportHeight);
        this.uiCamera.translate(viewportWidth / 2F, viewportHeight / 2F, 0);
        this.uiCamera.update();

        this.gameCamera = new PerspectiveCamera(67, viewportWidth, viewportHeight);
        this.gameCamera.translate(viewportWidth / 2F, viewportHeight / 2F, 0);
        // this.camera.update();
        this.batch.setProjectionMatrix(this.gameCamera.combined);

        // Create the game's event bus
        this.eventBus = new EventBus();

        // Load game settings
        this.settings = new GameSettings("projekt-gg");

        // Set input processor
        Gdx.input.setInputProcessor(inputProcessor);

        // Add screens
        addScreen("splash", new SplashScreen());
        addScreen("mainMenu", new MainMenuScreen());
        addScreen("loading", new LoadingScreen());

        // Push screen
        if (showSplashscreen)
            pushScreen("splash");
        else
            pushScreen("loading");
    }

    /**
     * Adds a screen to the game.
     * 
     * 
     * @param name
     *            The name of the screen.
     * @param screen
     *            The screen.
     */
    public void addScreen(String name, BaseScreen screen) {
        screen.init(this, this.getAssetManager());

        this.screens.put(name, screen);
    }

    /**
     * Pushes a screen to be the active screen. The screen has to be added to the
     * game beforehand via {@link #addScreen(String, BaseScreen)}.
     * <p>
     * {@link Screen#hide()} is called on the previously {@linkplain Game#screen
     * active screen} and {@link Screen#show()} is called on the new active screen.
     * 
     * @param name
     *            The name of the pushed screen.
     */
    public void pushScreen(String name) {
        BaseScreen pushedScreen = this.screens.get(name);

        if (pushedScreen == null) {
            throw new ScreenNotFoundException("Could not find a screen named '" + name
                    + "'. Add the screen first via #addScreen(String, BaseScreen).");
        }

        if (screen != null) {
            screen.hide();
        }

        if (!pushedScreen.isLoaded()) {
            assetManager.load(pushedScreen);
            assetManager.finishLoading();
            pushedScreen.finishLoading();
        }

        pushedScreen.show();
        this.screen = pushedScreen;
    }

    /**
     * Returns a screen in the game.
     * 
     * @param name
     *            The name of the screen.
     * @return The screen.
     */
    public BaseScreen getScreen(String name) {
        BaseScreen screen = this.screens.get(name);

        if (screen == null) {
            throw new ScreenNotFoundException("Could not find a screen named '" + name
                    + "'. Add the screen first via #addScreen(String, BaseScreen).");
        }

        return screen;
    }

    @Override
    public final void dispose() {
        this.screen = null;
        for (Screen s : screens.values()) {
            s.pause();
            s.dispose();
        }

        this.batch.dispose();
    }

    /**
     * @return The asset manager used by the game.
     */
    public AnnotationAssetManager getAssetManager() {
        return this.assetManager;
    }

    /**
     * @return The camera used in the actual game.
     */
    public PerspectiveCamera getGameCamera() {
        return this.gameCamera;
    }

    /**
     * @return The camera used by the UI screens.
     * @see BaseUIScreen#render(float)
     */
    public Camera getUICamera() {
        return this.uiCamera;
    }

    /**
     * @return An instance of the game settings handler.
     */
    public GameSettings getSettings() {
        return settings;
    }

    /**
     * Sets the UI skin.
     * 
     * @param skin
     *            The UI skin.
     */
    public void setUISkin(Skin skin) {
        this.uiSkin = skin;
    }

    /**
     * @return The UI skin that got loaded in the {@link LoadingScreen}.
     */
    public Skin getUISkin() {
        return uiSkin;
    }

    public SpriteBatch getSpriteBatch() {
        return batch;
    }

    /**
     * @return The initial viewport width.
     */
    public int getViewportWidth() {
        return this.viewportWidth;
    }

    /**
     * @return The initial viewport height.
     */
    public int getViewportHeight() {
        return this.viewportHeight;
    }

    /**
     * @return The current game session. Can be null if no game is played at the
     *         moment.
     */
    public GameSession getCurrentSession() {
        return session;
    }

    /**
     * Is used to set the current game session.
     * 
     * @param session
     *            The current game session.
     */
    public void setCurrentSession(GameSession session) {
        this.session = session;
    }

    /**
     * @return The event bus.
     */
    public EventBus getEventBus() {
        return eventBus;
    }

    /**
     * Returns the input multiplexer of the game. Should be used instead of
     * {@link Input#setInputProcessor(InputProcessor)}.
     * 
     * @return The game's input multiplexer.
     */
    public InputMultiplexer getInputMultiplexer() {
        return inputProcessor;
    }

    /**
     * @return Whether the debug flag is set and thus debug stuff should get
     *         rendered.
     */
    public boolean showDebugStuff() {
        return debug;
    }

}
