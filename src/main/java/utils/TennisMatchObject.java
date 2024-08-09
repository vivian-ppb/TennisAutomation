package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TennisMatchObject {

    private final String soupiResponse;
    private final boolean competitionMapped; //Type
    private final boolean booked; //Booking status
    private final String eventDisplayName; //Event name without ||
    private final String eventName; //Event name as in Soupi
    private final boolean display;
    private final Boolean resulted;
    private final boolean offeredInRunning;
    private final String bettingStatus;
    private final String rampId;
    private final String amelcoEventId;
    private final List<Integer> setScores;
    private final String score; //6-4 4-6 2-2 30-A || 6-4 4-6 2-2 *30-A
    private final PlayerOrNone currentServer;
    private final PlayerOrNone firstServer;
    private final int highestSetNumber;
    private final HashMap<String, MarketObject> markets;

    private TennisMatchObject(Builder builder) {
        this.soupiResponse = builder.soupiResponse;
        this.competitionMapped = builder.competitionMapped;
        this.booked = builder.booked;
        this.eventDisplayName = builder.eventDisplayName;
        this.eventName = builder.eventName;
        this.display = builder.display;
        this.resulted = builder.resulted;
        this.offeredInRunning = builder.offeredInRunning;
        this.bettingStatus = builder.bettingStatus;
        this.rampId = builder.rampId;
        this.amelcoEventId = builder.amelcoEventId;
        this.setScores = builder.setScores;
        this.score = builder.score;
        this.currentServer = builder.currentServer;
        this.firstServer = builder.firstServer;
        this.markets = builder.markets;
        this.highestSetNumber = builder.highestSetNumber;
    }


    public String getSoupiResponse() {
        return soupiResponse;
    }

    public boolean isCompetitionMapped() {
        return competitionMapped;
    }

    public boolean getBooked() {
        return booked;
    }

    public String getEventDisplayName() {
        return eventDisplayName;
    }

    public String getEventName() {
        return eventName;
    }

    public boolean getDisplay() {
        return display;
    }

    public Boolean getResulted() {
        return resulted;
    }

    public boolean getOfferedInRunning() {
        return offeredInRunning;
    }

    public String getBettingStatus() {
        return bettingStatus;
    }

    public String getRampId() {
        return rampId;
    }

    public String getAmelcoEventId() {
        return amelcoEventId;
    }

    public List<Integer> getSetScores() {
        return setScores;
    }

    public String getScore() {
        return score;
    }

    public PlayerOrNone getCurrentServer() {
        return currentServer;
    }

    public PlayerOrNone getFirstServer() {
        return firstServer;
    }

    public HashMap<String, MarketObject> getMarkets() {
        return markets;
    }

    public int getHighestSetNumber() {
        return highestSetNumber;
    }

    public static class Builder {
        private String soupiResponse;
        private boolean competitionMapped;
        private boolean booked;
        private String eventDisplayName;
        private String eventName;
        private boolean display;
        private Boolean resulted;
        private boolean offeredInRunning;
        private String bettingStatus;
        private String rampId;
        private String amelcoEventId;
        private List<Integer> setScores = new ArrayList<>();
        private String score;
        private PlayerOrNone currentServer;
        private PlayerOrNone firstServer;
        private HashMap <String, MarketObject> markets = new HashMap<>();
        private int highestSetNumber;

        public Builder soupiResponse(String soupiResponse) {
            this.soupiResponse = soupiResponse;
            return this;
        }

        public Builder competitionMapped(boolean competitionMapped) {
            this.competitionMapped = competitionMapped;
            return this;
        }

        public Builder booked(boolean booked) {
            this.booked = booked;
            return this;
        }

        public Builder eventDisplayName(String eventDisplayName) {
            this.eventDisplayName = eventDisplayName;
            return this;
        }

        public Builder eventName(String eventName) {
            this.eventName = eventName;
            return this;
        }

        public Builder display(boolean display) {
            this.display = display;
            return this;
        }

        public Builder resulted(Boolean resulted) {
            this.resulted = resulted;
            return this;
        }

        public Builder offeredInRunning(boolean offeredInRunning) {
            this.offeredInRunning = offeredInRunning;
            return this;
        }

        public Builder bettingStatus(String bettingStatus) {
            this.bettingStatus = bettingStatus;
            return this;
        }

        public Builder rampId(String rampId) {
            this.rampId = rampId;
            return this;
        }

        public Builder amelcoEventId(String amelcoEventId) {
            this.amelcoEventId = amelcoEventId;
            return this;
        }

        public Builder setScores(List<Integer> setScores) {
            this.setScores = setScores;
            return this;
        }

        public Builder score(String score) {
            this.score = score;
            return this;
        }

        public Builder currentServer(PlayerOrNone currentServer) {
            this.currentServer = currentServer;
            return this;
        }

        public Builder firstServer(PlayerOrNone firstServer) {
            this.firstServer = firstServer;
            return this;
        }

        public Builder markets(HashMap<String, MarketObject> markets) {
            this.markets = markets;
            return this;
        }

        public Builder highestSetNumber(int highestSetNumber) {
            this.highestSetNumber = highestSetNumber;
            return this;
        }

        public TennisMatchObject build() {
            return new TennisMatchObject(this);
        }
    }
}