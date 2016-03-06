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
}

