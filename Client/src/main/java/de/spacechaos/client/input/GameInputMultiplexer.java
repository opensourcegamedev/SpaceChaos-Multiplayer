package de.spacechaos.client.input;

import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.utils.Array;

/**
 * This input multiplexer allows the game to use application wide key binds
 * (e.g. a key for enabling the debug mode).
 */
public class GameInputMultiplexer extends InputMultiplexer {

    public GameInputMultiplexer() {
    }

    /**
     * Removes all input processors.
     */
    public void removeInputProcessors() {
        this.setProcessors(new Array<InputProcessor>());
    }

}