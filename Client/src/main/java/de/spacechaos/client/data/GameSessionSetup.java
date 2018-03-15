package de.spacechaos.client.data;

/**
 * Holds all the information about the settings of a game session. The
 * information should stay constant over the whole match.
 */
public class GameSessionSetup {

    /**
     * The random seed used by the game. Needed to synchronize the random events
     * of all clients. Should not change after it is set.
     */
    private long seed;
    /**
     * The game difficulty. Should not change after it is set.
     */
    private GameDifficulty difficulty;
    /**
     * The game mode. Should not change after it is set.
     */
    private GameMode mode;
    /**
     * The map. Should not change after it is set.
     */
    private GameMap map;

    public GameSessionSetup() {
    }

    public GameSessionSetup(GameDifficulty difficulty, GameMode mode, GameMap map, long seed) {
        this.difficulty = difficulty;
        this.mode = mode;
        this.map = map;
        this.seed = seed;
    }

    public long getSeed() {
        return seed;
    }

    public void setSeed(long seed) {
        this.seed = seed;
    }

    public GameDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(GameDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public GameMode getMode() {
        return mode;
    }

    public void setMode(GameMode mode) {
        this.mode = mode;
    }

    public GameMap getMap() {
        return map;
    }

    public void setMap(GameMap map) {
        this.map = map;
    }

    /**
     * An enum describing the game difficulty.
     */
    public enum GameDifficulty {
        EASY, NORMAL, HARD;
    }

    /**
     * An enum describing the game mode.
     */
    public enum GameMode {
        TDM, CTF;
    }

}
