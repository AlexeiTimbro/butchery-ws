package com.timbro.butcheryws.inventorymanagementsubdomain.datalayer.inventory;

public interface InventoryRepository {

    Inventory findByInventoryIdentifier_InventoryId(String inventoryId);
    Boolean existsByInventoryIdentifier_InventoryId(String inventoryId);
}
