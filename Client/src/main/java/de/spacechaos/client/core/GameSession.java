package de.spacechaos.client.core;

import com.artemis.Entity;
import com.artemis.World;
import com.artemis.WorldConfiguration;
import com.artemis.WorldConfigurationBuilder;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.math.Vector2;

import de.spacechaos.client.data.GameSessionSetup;

/**
 * This class handles all the basic game stuff.
 */
public abstract class GameSession {

    /**
     * Denotes the number of times the game processes the logic in one second.
     */
    private static final int TICK_RATE = 30;
    private static final float INVERSE_TICK_RATE = ((float) 1) / TICK_RATE;
    private GameSessionSetup setup;
    /**
     * Used to calculate the time delta.
     */
    private long lastTime = System.currentTimeMillis();
    private boolean initialized = false;
    private com.artemis.World entityWorld;
    private com.badlogic.gdx.physics.box2d.World physicsWorld;
    private Entity localPlayer;
    /**
     * Used to calculate when the current tick ends.
     */
    private long currentTickTime;

    public GameSession() {
        // ECS
        // spriteRenderSystem = new SpriteRenderSystem();
        WorldConfiguration config = new WorldConfigurationBuilder()
                /*
                 * .withPassive(1, spriteRenderSystem).with(new InputSystem())
                 */
                .build();
        this.entityWorld = new com.artemis.World(config);

        // PHYSICS
        this.physicsWorld = new com.badlogic.gdx.physics.box2d.World(new Vector2(0, 0), true);
        this.physicsWorld.setAutoClearForces(false);
        // this.physicsWorld.setContactListener(new GameContactListener());
    }

    /**
     * Initializes the game session.
     * 
     * @param sessionSetup
     *            The settings of the game session.
     * @param localPlayerId
     *            The {@linkplain PlayerComponent#getUserID() id} of the local
     *            player.
     */
    public void init(GameSessionSetup sessionSetup, short localPlayerId) {
        this.setup = sessionSetup;

        // TODO mit Hilfe der matchData das Spiel aufsetzen, d.h. alle Entities
        // zum ECS hinzuf�gen

        this.initialized = true;
    }

    /**
     * Updates the game session.
     * 
     * @see #fixedUpdate()
     */
    public void update() {
        if (!initialized)
            throw new IllegalStateException("The game session has to get initialized first!");
        long currentTime = System.currentTimeMillis();
        long delta = currentTime - lastTime;
        lastTime = currentTime;

        currentTickTime += delta;

        if (currentTickTime >= INVERSE_TICK_RATE * 1000) {
            fixedUpdate();
            currentTickTime -= INVERSE_TICK_RATE * 1000;
        }
    }

    /**
     * Only updates in the {@linkplain #INVERSE_TICK_RATE fixed tick interval}.
     */
    private void fixedUpdate() {
        entityWorld.setDelta(INVERSE_TICK_RATE);
        entityWorld.process();
    }

    public void render(float delta) {
        if (!initialized)
            throw new IllegalStateException("The game session has to get initialized first!");

        // spriteRenderSystem.process();
    }

    public void renderDebug(PerspectiveCamera debugCamera) {
        // debugRenderSystem.render(physicsWorld,
        // debugCamera.combined.scl(PositionConverter.toPixels(1)));
    }

    public void dispose() {
        entityWorld.dispose();
        physicsWorld.dispose();
    }

    /**
     * @return The game's setup.
     */
    public GameSessionSetup getSetup() {
        return setup;
    }

    /**
     * @return The local player.
     */
    public Entity getPlayer() {
        return localPlayer;
    }

    /**
     * @return The ECS's world.
     */
    public World getWorld() {
        return entityWorld;
    }

}
