////////////////////////////////////////////////////////////////////
// [EGON] [GALVANI] [1187021]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business.model;

import java.util.List;

import it.unipd.tos.business.model.MenuItem;
import it.unipd.tos.business.exception.TakeAwayBillException;;

public interface TakeAwayBill {
  double getOrderPrice(List<MenuItem> itemsOrdered) throws TakeAwayBillException;
}
