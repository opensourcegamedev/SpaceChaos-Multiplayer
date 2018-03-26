package de.spacechaos.client.data;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Stores data via a key. Basically a {@linkplain HashMap}.
 * 
 * @see #data
 */
public class DataStore {

    private static final String KEY_CANNOT_BE_NULL_MSG = "Key cannot be null.";
    private static final String KEY_CANNOT_BE_EMPTY_MSG = "Key cannot be empty.";
    private static final String DATA_CANNOT_BE_NULL_MSG = "Data cannot be null.";

    /**
     * The hashmap containing the data.
     */
    protected Map<String, Object> data = new ConcurrentHashMap<>();

    /**
     * Associates the specified data with the specified key in this store. If the
     * data store previously contained a mapping for the key, the old data is
     * replaced by the specified data.
     * 
     * @param key
     *            The key.
     * @param data
     *            The data.
     */
    public void put(String key, Object data) {
        if (key == null) {
            throw new NullPointerException(KEY_CANNOT_BE_NULL_MSG);
        }

        if (key.isEmpty()) {
            throw new IllegalArgumentException(KEY_CANNOT_BE_EMPTY_MSG);
        }

        if (data == null) {
            throw new NullPointerException(DATA_CANNOT_BE_NULL_MSG);
        }

        this.data.put(key, data);
    }

    /**
     * 
     * Returns true if this data store contains a mapping for the specified key.
     * 
     * @param key
     *            The key of the value
     * @return true if data store contains mapping for specified tag
     */
    public boolean contains(String key) {
        if (key == null) {
            throw new NullPointerException(KEY_CANNOT_BE_NULL_MSG);
        }

        if (key.isEmpty()) {
            throw new IllegalArgumentException(KEY_CANNOT_BE_EMPTY_MSG);
        }

        return this.data.containsKey(key);
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this data
     * store contains no mapping for the key.
     * 
     * @param key
     *            The key.
     * @return The value or null if the key wasn't added before.
     */
    public Object get(String key) {
        if (key == null) {
            throw new NullPointerException(KEY_CANNOT_BE_NULL_MSG);
        }

        if (key.isEmpty()) {
            throw new IllegalArgumentException(KEY_CANNOT_BE_EMPTY_MSG);
        }

        return this.data.get(key);
    }

    /**
     * Returns the value to which the specified key is mapped already casted to the
     * specified class, or null if this data store contains no mapping for the key.
     * 
     * @param key
     *            The key.
     * @param clazz
     *            The class to which the data has to be casted.
     * @return The value or null if the key wasn't added before.
     */
    public <T> T get(String key, Class<T> clazz) {
        if (key == null) {
            throw new NullPointerException(KEY_CANNOT_BE_NULL_MSG);
        }

        if (key.isEmpty()) {
            throw new IllegalArgumentException(KEY_CANNOT_BE_EMPTY_MSG);
        }

        Object obj = this.get(key);

        if (obj == null) {
            return null;
        }

        return clazz.cast(obj);
    }
}
