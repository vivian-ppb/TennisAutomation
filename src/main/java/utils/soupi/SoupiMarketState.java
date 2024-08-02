package utils.soupi;

public class SoupiMarketState {

    String eventStateType;
    String marketType;
    String displayName;
    String marketName;
    String marketTemplateName;

    String marketSet;
    String marketGame;
    String marketPoint;
    String marketLine;

    String displayed;
    String displayOrder;
    Boolean resulted;
    String offeredInRunning;
    String status;

    String rampId;
    String ppMarketId;
    String amelcoEventId;
    String amelcoMarketId;
    Integer marketTypeMappingTypeId;

    public SoupiMarketState(String rampId, String ppMarketId, String amelcoEventId, String amelcoMarketId, String eventStateType,
                            String marketType, String displayName, String marketName, String marketTemplateName,
                            String marketSet, String marketGame, String marketPoint, String marketLine, String displayed,
                            String displayOrder,
                            String resulted,
                            String offeredInRunning, String status, Integer marketTypeMappingTypeId) {
        this.eventStateType = eventStateType;
        this.marketType = marketType;
        this.displayName = displayName;
        this.marketName = marketName;
        this.marketTemplateName = marketTemplateName;
        this.marketSet = marketSet;
        this.marketGame = marketGame;
        this.marketPoint = marketPoint;
        this.marketLine = marketLine;
        this.displayed = displayed;
        this.displayOrder = displayOrder;

        if (resulted == null) {
            //    System.out.println(amelcoEventId + " : Market: " + amelcoMarketId + " : " + marketName + " : Resulted was NULL");
            this.resulted = null;
        } else {
            if (resulted.contains("true")) {
                this.resulted = true;
            } else if (resulted.contains("false")) {
                this.resulted = false;
            }
        }

        this.offeredInRunning = offeredInRunning;
        this.status = status;
        this.rampId = rampId;
        this.ppMarketId = ppMarketId;
        this.amelcoEventId = amelcoEventId;
        this.amelcoMarketId = amelcoMarketId;
        this.marketTypeMappingTypeId = marketTypeMappingTypeId;
    }

    public SoupiMarketState() {

    }

    public String getRampId() {
        return rampId;
    }

    public void setRampId(String rampId) {
        this.rampId = rampId;
    }

    public String getPpMarketId() {
        return ppMarketId;
    }

    public void setPpMarketId(String ppMarketId) {
        this.ppMarketId = ppMarketId;
    }

    public String getAmelcoEventId() {
        return amelcoEventId;
    }

    public void setAmelcoEventId(String amelcoEventId) {
        this.amelcoEventId = amelcoEventId;
    }

    public String getAmelcoMarketId() {
        return amelcoMarketId;
    }

    public void setAmelcoMarketId(String amelcoMarketId) {
        this.amelcoMarketId = amelcoMarketId;
    }

    public String getEventStateType() {
        return eventStateType;
    }

    public void setEventStateType(String eventStateType) {
        this.eventStateType = eventStateType;
    }

    public String getMarketType() {
        return marketType;
    }

    public void setMarketType(String marketType) {
        this.marketType = marketType;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Integer getDisplayOrder() {
        if (displayOrder == null) {
            return null;
        }
        return Integer.parseInt(displayOrder);
    }

    public void setDisplayOrder(Integer displayOrder) {
        if (displayOrder == null) {
            this.displayOrder = null;
        }
        this.displayOrder = displayOrder.toString();
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }


    public String getMarketTemplateName() {
        return marketTemplateName;
    }

    public void setMarketTemplateName(String marketTemplateName) {
        this.marketTemplateName = marketTemplateName;
    }

    public String getMarketSet() {
        return marketSet;
    }

    public void setMarketSet(String marketSet) {
        this.marketSet = marketSet;
    }

    public String getMarketGame() {
        return marketGame;
    }

    public void setMarketGame(String marketGame) {
        this.marketGame = marketGame;
    }

    public String getMarketPoint() {
        return marketPoint;
    }

    public void setMarketPoint(String marketPoint) {
        this.marketPoint = marketPoint;
    }

    public String getMarketLine() {
        return marketLine;
    }

    public void setMarketLine(String marketLine) {
        this.marketLine = marketLine;
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

    public void setResulted(String resulted) {
        if (resulted.contains("true")) {
            this.resulted = true;
        } else if (resulted.contains("false")) {
            this.resulted = false;
        } else {
            this.resulted = null;
        }
    }

    public String getOfferedInRunning() {
        return offeredInRunning;
    }

    public void setOfferedInRunning(String offeredInRunning) {
        this.offeredInRunning = offeredInRunning;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getMarketTypeMappingTypeId() {
        return marketTypeMappingTypeId;
    }

    public void setMarketTypeMappingTypeId(Integer marketTypeMappingTypeId) {
        this.marketTypeMappingTypeId = marketTypeMappingTypeId;
    }

    public void setMarketTypeMappingTypeId(String marketTypeMappingTypeId) {
        this.marketTypeMappingTypeId = Integer.valueOf(marketTypeMappingTypeId);
    }
}