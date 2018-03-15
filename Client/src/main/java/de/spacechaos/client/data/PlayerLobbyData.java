package de.spacechaos.client.data;

/**
 * This class holds all the information about a player in the lobby.
 * 
 * @see OnJoiningLobbyMessage
 */
public class PlayerLobbyData {

    private String username;
    private short teamId;

    public PlayerLobbyData() {
    }

    public PlayerLobbyData(String username, short teamId) {
        super();
        this.username = username;
        this.teamId = teamId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public short getTeamId() {
        return teamId;
    }

    public void setTeamId(short teamId) {
        this.teamId = teamId;
    }

}
