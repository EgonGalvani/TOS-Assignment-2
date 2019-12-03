////////////////////////////////////////////////////////////////////
// [EGON] [GALVANI] [1187021]
////////////////////////////////////////////////////////////////////

package it.unipd.tos;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.business.model.ItemType;
import it.unipd.tos.business.model.MenuItem;
import it.unipd.tos.business.model.TakeAwayBill;

public class App implements TakeAwayBill {
   
    @Override
    public double getOrderPrice(List<MenuItem> itemsOrdered) throws TakeAwayBillException {
        
        // calcolo del totale
        double orderPrice = 0.0D; 
        for(MenuItem item : itemsOrdered) {
            orderPrice += item.getPrice(); 
        }
        
        // sconto per ordini con più di 5 panini 
        List<MenuItem> panini = itemsOrdered.stream()
                                .filter(e -> e.getItemType() == ItemType.PANINO)
                                .collect(Collectors.toList());  
        if(panini.size() > 5) {
            orderPrice -= 0.5 * panini.stream().mapToDouble(MenuItem::getPrice).min().getAsDouble();
        }
        
        return orderPrice; 
    }
    
}
