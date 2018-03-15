package de.spacechaos.client.screen;

/**
 * Thrown when a pushed {@linkplain BaseScreen screen} is not found.
 * 
 * @see SpaceChaosMultiplayerGame#pushScreen(String)
 */
public class ScreenNotFoundException extends RuntimeException {

    public ScreenNotFoundException(String message) {
        super(message);
    }

}
