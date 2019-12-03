package it.unipd.tos;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.business.model.ItemType;
import it.unipd.tos.business.model.MenuItem;

public class AppTest {
    
    App app = new App(); 
    List<MenuItem> orderItems; 
    double orderPrice; 
    
    private final MenuItem panino_primavera = new MenuItem(ItemType.PANINO, "Panino primavera", 4.7);
    private final MenuItem panino_vegetariano = new MenuItem(ItemType.PANINO, "Panino vegetariano", 4.0);
    private final MenuItem arancino = new MenuItem(ItemType.FRITTO, "Arancino", 3.0);
    private final MenuItem olive_ascolane = new MenuItem(ItemType.FRITTO, "Olive ascolane", 2.5);
    private final MenuItem acqua_naturale = new MenuItem(ItemType.BEVANDA, "Acqua naturale", 1.0);
    private final MenuItem fanta = new MenuItem(ItemType.BEVANDA, "Fanta", 2.5);
    
    
    @Before 
    public void clearEnv() {
       orderItems = new ArrayList<>(); 
       orderPrice = 0.0D;
    }
   
    @Test 
    public void testCalcoloDelTotale() throws TakeAwayBillException {
       orderItems.add(panino_primavera); 
       orderItems.add(olive_ascolane); 
       orderItems.add(fanta); 
       
       orderPrice = app.getOrderPrice(orderItems); 
       Assert.assertEquals(9.7D, 9.7D, 0.0D);
    }
   
    @Test 
    public void testCalcoloDelTotaleConListaVuota() throws TakeAwayBillException {      
       orderPrice = app.getOrderPrice(orderItems); 
       Assert.assertEquals(0.0D, orderPrice, 0.0D);
    }
   
    @Test(expected = NullPointerException.class) 
    public void testCalcoloDelTotaleConListaNonInizializzata() throws TakeAwayBillException {
       orderItems = null; 
       orderPrice = app.getOrderPrice(orderItems); 
    }
    
    @Test 
    public void testSulPaninoMenoCaroSeNeVengonoCompratiPiuDiCinque() throws TakeAwayBillException {
        orderItems.add(panino_primavera); 
        orderItems.add(panino_vegetariano); 
        orderItems.add(panino_primavera); 
        orderItems.add(panino_vegetariano); 
        orderItems.add(panino_primavera); 
        orderItems.add(panino_vegetariano); 
        orderItems.add(olive_ascolane); 
        orderItems.add(fanta); 
                
        orderPrice = app.getOrderPrice(orderItems);  
        Assert.assertEquals(29.1D, orderPrice, 0.001D);
    }
    
    @Test 
    public void testSuOrdineConPiuDiCinqueElementiMaMenoDiCinquePanini() throws TakeAwayBillException {
        orderItems.add(panino_primavera); 
        orderItems.add(panino_vegetariano); 
        orderItems.add(panino_primavera); ; 
        orderItems.add(olive_ascolane); 
        orderItems.add(fanta);
        orderItems.add(arancino); 
                
        orderPrice = app.getOrderPrice(orderItems); 
        Assert.assertEquals(21.4D, orderPrice, 0.0D);
    }
    
    @Test 
    public void testPerOrdiniConPrezzoTotaleDiPaniniEFrittiMaggioreDiCinquanta() throws TakeAwayBillException {
        orderItems.add(panino_primavera); 
        orderItems.add(panino_primavera); 
        orderItems.add(panino_primavera); 
        orderItems.add(panino_primavera); 
        orderItems.add(arancino);
        orderItems.add(arancino);
        orderItems.add(arancino);
        orderItems.add(arancino);
        orderItems.add(arancino);
        orderItems.add(arancino);
        orderItems.add(arancino);
        orderItems.add(arancino);
        orderItems.add(arancino);
        orderItems.add(arancino);
        orderItems.add(arancino);
        orderItems.add(arancino);
        orderItems.add(arancino);
        orderItems.add(arancino);
        orderItems.add(arancino);
        orderItems.add(fanta);
        orderItems.add(fanta);
        orderItems.add(fanta);
        orderItems.add(fanta);
        orderItems.add(fanta);
        orderItems.add(fanta);
        orderItems.add(fanta);
     
        orderPrice = app.getOrderPrice(orderItems);
        Assert.assertEquals(73.17D, orderPrice, 0.001D);
    }
    
    @Test
    public void testPerOrdiniInCuiBisognaApplicareEntrambiGliSconti() throws TakeAwayBillException {
        orderItems.add(panino_primavera); 
        orderItems.add(panino_primavera); 
        orderItems.add(panino_primavera); 
        orderItems.add(panino_primavera); 
        orderItems.add(panino_primavera); 
        orderItems.add(panino_primavera); 
        orderItems.add(arancino);
        orderItems.add(arancino);
        orderItems.add(arancino);
        orderItems.add(arancino);
        orderItems.add(arancino);
        orderItems.add(arancino);
        orderItems.add(arancino);
        orderItems.add(arancino);
        orderItems.add(arancino);
        orderItems.add(arancino);
        orderItems.add(arancino);
        orderItems.add(arancino);
        orderItems.add(arancino);
        orderItems.add(arancino);
        orderItems.add(arancino);
        orderItems.add(fanta);
        orderItems.add(fanta);
        orderItems.add(fanta);
        orderItems.add(fanta);
        orderItems.add(fanta);
        orderItems.add(fanta);
        orderItems.add(fanta);
        
        orderPrice = app.getOrderPrice(orderItems); 
        Assert.assertEquals(79.515D, orderPrice, 0.001D);
    }
    
}
