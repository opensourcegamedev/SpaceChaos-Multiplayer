package de.spacechaos.client.input;

import com.badlogic.gdx.InputProcessor;

/**
 * A convenience implementation of {@link InputProcessor}. Derive from this and
 * only override the methods you need.
 */
public interface DefaultInputProcessor extends InputProcessor {

    /**
     * {@inheritDoc}
     */
    default boolean keyDown(int keycode) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    default boolean keyUp(int keycode) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    default boolean keyTyped(char character) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    default boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    default boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    default boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    default boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    default boolean scrolled(int amount) {
        return false;
    }

}
