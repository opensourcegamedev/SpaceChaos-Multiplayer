package de.spacechaos.client.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.SkinLoader;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader.FreeTypeFontLoaderParameter;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.ObjectMap;

import net.dermetfan.gdx.assets.AnnotationAssetManager.Asset;

/**
 * This screen takes care of loading the assets for the game. Assets have to be
 * {@linkplain AssetManager#load(AssetDescriptor) added to the loading queue} in
 * the {@link #onInit} method.
 */
public class LoadingScreen extends BaseScreen {

    // Loading screen assets
    @Asset(Texture.class)
    private static final String BACKGROUND_TEXTURE_PATH = "ui/backgrounds/market.jpg";
    @Asset(Texture.class)
    private static final String BAR_ORANGE_TEXTURE_PATH = "ui/images/bar-top.png";
    @Asset(Texture.class)
    private static final String BAR_BLUE_TEXTURE_PATH = "ui/images/bar-bottom.png";
    private Texture backgroundTexture;
    private Texture orangeBarTexture;
    private Texture blueBarTexture;
    private float progress;

    // UI skin assets
    public final AssetDescriptor<BitmapFont> MAIN_FONT_19_PATH() {
        FreeTypeFontLoaderParameter font = new FreeTypeFontLoaderParameter();
        font.fontFileName = "fonts/AlemdraSC/AlmendraSC-Regular.ttf";
        font.fontParameters.size = 19;
        return new AssetDescriptor<BitmapFont>("mainFont19.ttf", BitmapFont.class, font);
    }

    private static final String SKIN_PATH = "ui/skin/skin.json";
    private static final String SKIN_TEXTURE_ATLAS_PATH = "ui/skin/skin.atlas";

    @Override
    protected void onInit() {
        backgroundTexture = assetManager.get(BACKGROUND_TEXTURE_PATH);
        orangeBarTexture = assetManager.get(BAR_ORANGE_TEXTURE_PATH);
        blueBarTexture = assetManager.get(BAR_BLUE_TEXTURE_PATH);

        // Add assets to loading queue
        assetManager.load(MAIN_FONT_19_PATH());
        assetManager.load(game.getScreen("mainMenu"));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.getSpriteBatch().begin();
        game.getSpriteBatch().setProjectionMatrix(game.getUICamera().combined);

        // Draw the background
        game.getSpriteBatch().draw(this.backgroundTexture, 0, 0, game.getViewportWidth(), game.getViewportHeight());

        // Get useful values
        float viewPortWidth = game.getViewportWidth();
        float viewPortHeight = game.getViewportHeight();
        float imageWidth = this.orangeBarTexture.getWidth();
        float imageHeight = this.orangeBarTexture.getHeight();

        // Check if the asset manager is done
        if (game.getAssetManager().update()) {
            onFinishedLoading();
        }

        progress = Interpolation.linear.apply(progress, game.getAssetManager().getProgress(), 0.1f);

        // The actual drawing
        game.getSpriteBatch().draw(this.blueBarTexture, (viewPortWidth / 2) - (imageWidth / 2) + 1,
                (viewPortHeight / 4) - imageHeight / 2);
        game.getSpriteBatch().draw(this.orangeBarTexture, (viewPortWidth / 2) - (imageWidth / 2),
                (viewPortHeight / 4) - imageHeight / 2, imageWidth * progress, imageHeight);

        this.game.getSpriteBatch().end();
    }

    private void onFinishedLoading() {
        BitmapFont main19Font = assetManager.get(MAIN_FONT_19_PATH());

        ObjectMap<String, Object> fontMap = new ObjectMap<>();
        fontMap.put("main-19", main19Font);
        assetManager.load(SKIN_PATH, Skin.class, new SkinLoader.SkinParameter(SKIN_TEXTURE_ATLAS_PATH, fontMap));
        assetManager.finishLoadingAsset(SKIN_PATH);

        game.setUISkin(assetManager.get(SKIN_PATH));

        // Notify loaded screens
        game.getScreen("serverBrowser").finishLoading();

        game.pushScreen("mainMenu");
    }

    @Override
    public void show() {
        // unused
    }

    @Override
    public void hide() {
        // unused
    }

    @Override
    public void dispose() {
        // unused
    }

}
