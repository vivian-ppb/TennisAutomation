package utils;

public class SelectionObject {

    private final String type;
    private final String state;
    private final String extId;
    private final String id; //ramp id
    private final String name;
    private final String displayOrder;
    private final boolean displayed;
    private final String probability;
    private final String bettingStatus;
    private final String resultedStatus;
    private final String sgxColumnName;

    private SelectionObject(Builder builder) {
        this.type = builder.type;
        this.state = builder.state;
        this.extId = builder.extId;
        this.id = builder.id;
        this.name = builder.name;
        this.displayOrder = builder.displayOrder;
        this.displayed = builder.displayed;
        this.probability = builder.probability;
        this.bettingStatus = builder.bettingStatus;
        this.resultedStatus = builder.resultedStatus;
        this.sgxColumnName = builder.sgxColumnName;

    }

    public String getType() {return type;}

    public String getState() {return state;}

    public String getExtId() {return extId;}

    public String getId() {return id;}

    public String getName() {return name;}

    public String getDisplayOrder() {return displayOrder;}

    public boolean getDisplayed() {return displayed;}

    public String getProbability() {return probability;}

    public String getBettingStatus() {return bettingStatus;}

    public String getResultedStatus() {return resultedStatus;}

    public String getSgxColumnName() {return sgxColumnName;}

    public static class Builder {
        private String type;
        private String state;
        private String extId;
        private String id;
        private String name;
        private String displayOrder;
        private boolean displayed;
        private String probability;
        private String bettingStatus;
        private String resultedStatus;
        private String sgxColumnName;

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

        public Builder name(String name) {
            this.name = name;
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

        public Builder probability(String probability) {
            this.probability = probability;
            return this;
        }

        public Builder bettingStatus(String bettingStatus) {
            this.bettingStatus = bettingStatus;
            return this;
        }

        public Builder resultedStatus(String resultedStatus) {
            this.resultedStatus = resultedStatus;
            return this;
        }

        public Builder sgxColumnName(String sgxColumnName) {
            this.sgxColumnName = sgxColumnName;
            return this;
        }

        public SelectionObject build() {
            return new SelectionObject(this);
        }
    }
}