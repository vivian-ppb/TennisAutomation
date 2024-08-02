package utils;

import java.util.ArrayList;
import java.util.List;

public class TennisMatch {

    private String soupiResponse;
    private boolean competitionMapped; //The type
    private boolean booked; //Booking status
    private String eventDisplayName; //State name reformatted without ||
    private String eventName;

    private String displayed;
    private Boolean resulted;
    private String offeredInRunning;
    private String bettingStatus;

    private String rampId;
    private String amelcoEventId;
    private List<SetScore> setScores = new ArrayList<>(); //6-4 4-6 2-2 30-A || 6-4 4-6 2-2 *30-A
    private String score;
    private PlayerOrNone currentServer;
    private PlayerOrNone firstServer;


    public String getSoupiResponse() {
        return soupiResponse;
    }

    public void setSoupiResponse(String soupiResponse) {
        this.soupiResponse = soupiResponse;
    }

    public boolean isCompetitionMapped() {
        return competitionMapped;
    }

    public void setCompetitionMapped(boolean competitionMapped) {
        this.competitionMapped = competitionMapped;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public String getEventDisplayName() {
        return eventDisplayName.replace("|", "");
    }

    public void setEventDisplayName(String eventDisplayName) {
        this.eventDisplayName = eventDisplayName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDisplayed() {
        return displayed;
    }

    public void setDisplayed(String displayed) {
        this.displayed = displayed;
    }

    public Boolean getResulted() {
        return resulted;
    }

    public void setResulted(Boolean resulted) {
        this.resulted = resulted;
    }

    public String getOfferedInRunning() {
        return offeredInRunning;
    }

    public void setOfferedInRunning(String offeredInRunning) {
        this.offeredInRunning = offeredInRunning;
    }

    public String getBettingStatus() {
        return bettingStatus;
    }

    public void setBettingStatus(String bettingStatus) {
        this.bettingStatus = bettingStatus;
    }

    public String getRampId() {
        return rampId;
    }

    public void setRampId(String rampId) {
        this.rampId = rampId;
    }

    public String getAmelcoEventId() {
        return amelcoEventId;
    }

    public void setAmelcoEventId(String amelcoEventId) {
        this.amelcoEventId = amelcoEventId;
    }

    public List<SetScore> getSetScores() {
        return setScores;
    }

    public void setSetScores(List<SetScore> setScores) {
        this.setScores = setScores;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public PlayerOrNone getCurrentServer() {
        return currentServer;
    }

    public void setCurrentServer(PlayerOrNone currentServer) {
        this.currentServer = currentServer;
    }

    public PlayerOrNone getFirstServer() {
        return firstServer;
    }

    public void setFirstServer(PlayerOrNone firstServer) {
        this.firstServer = firstServer;
    }
}