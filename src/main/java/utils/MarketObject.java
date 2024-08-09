package utils;

import java.util.List;

public class MarketObject {

    private final String type;
    private final String state;
    private final String extId;
    private final String id; //ramp id
    private final String displayName;
    private final String displayOrder;
    private final boolean displayed;
    private final boolean resulted;
    private final String bettingStatus;
    private final boolean offeredInRunning;
    private final List<SelectionObject> selections;

    private MarketObject(Builder builder) {
        this.type = builder.type;
        this.state = builder.state;
        this.extId = builder.extId;
        this.id = builder.id;
        this.displayName = builder.displayName;
        this.displayOrder = builder.displayOrder;
        this.displayed = builder.displayed;
        this.resulted = builder.resulted;
        this.bettingStatus = builder.bettingStatus;
        this.offeredInRunning = builder.offeredInRunning;
        this.selections = builder.selections;
    }


    public String getType() {
        return type;
    }

    public String getState() {
        return state;
    }

    public String getExtId() {
        return extId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getId() {
        return id;
    }

    public String getDisplayOrder() {
        return displayOrder;
    }

    public boolean getDisplayed() {
        return displayed;
    }

    public boolean getResulted() {
        return resulted;
    }

    public String getBettingStatus() {
        return bettingStatus;
    }

    public boolean getOfferedInRunning() {
        return offeredInRunning;
    }

    public List<SelectionObject> getSelections() {
        return selections;
    }


    public static class Builder {
        private String type;
        private String state;
        private String extId;
        private String displayName;
        private String id;
        private String displayOrder;
        private boolean displayed;
        private boolean resulted;
        private String bettingStatus;
        private boolean offeredInRunning;
        private List<SelectionObject> selections;

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder state(String state) {
            this.state = state;
            return this;
        }

        public Builder extId(String extId) {
            this.extId = extId;
            return this;
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder displayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        public Builder displayOrder(String displayOrder) {
            this.displayOrder = displayOrder;
            return this;
        }

        public Builder displayed(boolean displayed) {
            this.displayed = displayed;
            return this;
        }

        public Builder resulted(boolean resulted) {
            this.resulted = resulted;
            return this;
        }

        public Builder bettingStatus(String bettingStatus) {
            this.bettingStatus = bettingStatus;
            return this;
        }

        public Builder offeredInRunning(boolean offeredInRunning) {
            this.offeredInRunning = offeredInRunning;
            return this;
        }

        public Builder selections(List<SelectionObject> selections) {
            this.selections = selections;
            return this;
        }

        public MarketObject build() {
            return new MarketObject(this);
        }
    }
}