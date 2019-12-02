////////////////////////////////////////////////////////////////////
// [EGON] [GALVANI] [1187021]
////////////////////////////////////////////////////////////////////

package it.unipd.tos;

import java.util.List;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.business.model.MenuItem;
import it.unipd.tos.business.model.TakeAwayBill;

public class App implements TakeAwayBill {
   
    @Override
    public double getOrderPrice(List<MenuItem> itemsOrdered) throws TakeAwayBillException {
        
        double orderPrice = 0.0D; 
        for(MenuItem item : itemsOrdered) {
            orderPrice += item.getPrice(); 
        }
        
        return orderPrice; 
    }
    
}
