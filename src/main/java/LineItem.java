/**
 * Line item
 * Corresponds to each record in the file.
 */
public class LineItem {

    private final String itemId;
    private final int merchantId;
    private final int marketplaceId;
    private final Priority priority; // Made it as Enum because I know all possible values
    private final String dataType;

    public LineItem(String itemId, int merchantId, int marketplaceId, Priority priority, String dataType){
        this.itemId = itemId;
        this.merchantId = merchantId;
        this.marketplaceId = marketplaceId;
        this.priority = priority;
        this.dataType = dataType;
    }

    public LineItem(LineItem lineItem){
        itemId = lineItem.getItemId();
        merchantId = lineItem.getMerchantId();
        marketplaceId = lineItem.getMarketplaceId();
        priority = lineItem.getPriority();
        dataType = lineItem.getDataType();
    }

    public String getItemId() {
        return itemId;
    }

    public int getMerchantId() {
        return merchantId;
    }

    public int getMarketplaceId() {
        return marketplaceId;
    }

    public Priority getPriority() {
        return priority;
    }

    public String getDataType() {
        return dataType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LineItem lineItem = (LineItem) o;

        if (merchantId != lineItem.merchantId) return false;
        if (marketplaceId != lineItem.marketplaceId) return false;
        if (!itemId.equals(lineItem.itemId)) return false;
        if (priority != lineItem.priority) return false;
        return dataType.equals(lineItem.dataType);

    }

    @Override
    public int hashCode() {
        int result = itemId.hashCode();
        result = 31 * result + merchantId;
        result = 31 * result + marketplaceId;
        result = 31 * result + priority.hashCode();
        result = 31 * result + dataType.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "LineItem{" +
                "itemId='" + itemId + '\'' +
                ", merchantId=" + merchantId +
                ", marketplaceId=" + marketplaceId +
                ", priority=" + priority +
                ", dataType='" + dataType + '\'' +
                '}';
    }
}

