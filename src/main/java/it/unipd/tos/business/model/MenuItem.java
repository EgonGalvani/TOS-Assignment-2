////////////////////////////////////////////////////////////////////
// [EGON] [GALVANI] [1187021]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business.model;

public class MenuItem {
    ItemType itemType; 
    String name; 
    double price; 
    
    MenuItem(ItemType itemType, String name, double price) {
        this.itemType = itemType; 
        this.name = name; 
        this.price = price; 
    }
}
