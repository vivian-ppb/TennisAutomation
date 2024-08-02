package utils.soupi;

public class SoupiSelectionState {

    String selectionType;
    String selectionName;
    String amelcoSelectionId;
    boolean selectionDisplayed;
    String amelcoMarketId;
    String marketId;
    String bettingStatus;
    String selectionId;
    String characteristic;
    Integer displayOrder;
    Double probability;
    String resultedStatus;

    public SoupiSelectionState(String selectionType,
                               String selectionName,
                               String amelcoSelectionId,
                               boolean selectionDisplayed,
                               String amelcoMarketId,
                               String marketId,
                               String bettingStatus,
                               String selectionId,
                               String characteristic,
                               Integer displayOrder,
                               Double probability,
                               String resultedStatus) {
        this.selectionType = selectionType;
        this.selectionName = selectionName;
        this.amelcoSelectionId = amelcoSelectionId;
        this.selectionDisplayed = selectionDisplayed;
        this.amelcoMarketId = amelcoMarketId;
        this.marketId = marketId;
        this.bettingStatus = bettingStatus;
        this.selectionId = selectionId;
        this.characteristic = characteristic;
        this.displayOrder = displayOrder;
        this.probability = probability;
        this.resultedStatus = resultedStatus;
    }

    public SoupiSelectionState() {

    }

    public String getResultedStatus() {
        return resultedStatus;
    }

    public void setResultedStatus(String resultedStatus) {
        this.resultedStatus = resultedStatus;
    }

    public String getSelectionType() {
        return selectionType;
    }

    public void setSelectionType(String selectionType) {
        this.selectionType = selectionType;
    }

    public String getSelectionName() {
        return selectionName;
    }

    public void setSelectionName(String selectionName) {
        this.selectionName = selectionName;
    }

    public String getAmelcoSelectionId() {
        return amelcoSelectionId;
    }

    public void setAmelcoSelectionId(String amelcoSelectionId) {
        this.amelcoSelectionId = amelcoSelectionId;
    }

    public boolean isSelectionDisplayed() {
        return selectionDisplayed;
    }

    public void setSelectionDisplayed(boolean selectionDisplayed) {
        this.selectionDisplayed = selectionDisplayed;
    }

    public String getAmelcoMarketId() {
        return amelcoMarketId;
    }

    public void setAmelcoMarketId(String amelcoMarketId) {
        this.amelcoMarketId = amelcoMarketId;
    }

    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }

    public String getBettingStatus() {
        return bettingStatus;
    }

    public void setBettingStatus(String bettingStatus) {
        this.bettingStatus = bettingStatus;
    }

    public String getSelectionId() {
        return selectionId;
    }

    public void setSelectionId(String selectionId) {
        this.selectionId = selectionId;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }

    public Double getProbability() {
        return probability;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
    }
}