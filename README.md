# Dynamic Scheduling
    Solution to Amazon's Dynamic Scheduling problem statement

### Problem Statement
The goal is to build a scalable distributed system that can batch requests and submit them to downstream consumers efficiently.
### System Requirements
    System will accept input requests and sends to a downstream system.
    Higher priority requests need to be sent to downstream faster than lower priority requests.
    The notifications can be sent on any asynchronous messaging system
    The system should also be able to support queries to get all the attributes for a given item at any time
### Requests
    Requests are streamed with set of parameters which are key value pairs with priority.
### Example
    ITEM_ID,MERCHANT_ID,MARKETPLACE_ID,PRIORITY,DATA_TYPE
    ITEM1,12345,4,LOW,ITEM
    ITEM2,12645,1,HIGH,PRICE
    ITEM3,17345,4,LOW,AUX_ITEM
    ITEM2,12645,5,LOWEST,ITEM
    ITEM3,19345,4,HIGHEST,AUX_ITEM

## Solution
    Write a Client Program that uses the Scheduler API. 
     Scheduler sample = new Scheduler();
        try {
            sample.schedule(<"Path to file">);
        } catch (IOException e) {
            e.printStackTrace();
        }
     while(!sample.isQueuEmpty()){
        Message.send(sample.getItems());
     }
     
    
### Sample Output
    LineItem{itemId='ITEM3', merchantId=19345, marketplaceId=4, priority=HIGHEST, dataType='AUX_ITEM'}
    LineItem{itemId='ITEM2', merchantId=12645, marketplaceId=1, priority=HIGH, dataType='PRICE'}
    LineItem{itemId='ITEM1', merchantId=12345, marketplaceId=4, priority=NORMAL, dataType='ITEM'}
    LineItem{itemId='ITEM1', merchantId=12345, marketplaceId=4, priority=LOW, dataType='ITEM'}
    LineItem{itemId='ITEM2', merchantId=12645, marketplaceId=5, priority=LOWEST, dataType='ITEM'}
    LineItem{itemId='ITEM3', merchantId=17345, marketplaceId=4, priority=LOW, dataType='AUX_ITEM'}
    LineItem{itemId='ITEM1', merchantId=12345, marketplaceId=4, priority=LOW, dataType='ITEM'}
    
### Note
Pending : Scaling and Querying the data is pending