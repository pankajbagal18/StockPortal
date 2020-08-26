import Exceptions.NoOptimalStockFound;
import Exceptions.NoStocksAvailable;
import application.Portfolio;
import dataModels.Stock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import services.StockService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PortfolioSuggestOptimalStockTest {
    @Mock
    private StockService service;
    private Portfolio portfolio;
    private Stock googleStock;
    private Stock msStock;
    private Stock facebookStock;
    private Stock whatsAppStock;
    List<Stock> stocks;

    @Before
    public void setup()
    {
        portfolio = new Portfolio(service);
        stocks = new ArrayList<>();
        googleStock = new Stock("1", "Google", 9);
        msStock = new Stock("2","Microsoft",20);
        facebookStock = new Stock("3","Facebook",8);
        whatsAppStock = new Stock("4","WhatsApp",5);
        stocks.add(googleStock);
        stocks.add(msStock);
        stocks.add(facebookStock);
        stocks.add(whatsAppStock);
    }

    @Test(expected = NoStocksAvailable.class)
    public void testNoStockAvailable()
    {
        assertNull(portfolio.suggestOptimalStock());
    }

    @Test
    public void testWithCriteriaQuantityLte10AndPriceLte100()
    {
        when(service.getPrice(googleStock)).thenReturn(50);
        when(service.getPrice(msStock)).thenReturn(500);
        when(service.getAvailableStocks()).thenReturn(stocks);
        assertEquals(googleStock.getStockId(),portfolio.suggestOptimalStock().getStockId());
    }
    @Test
    public void testWithCriteriaQuantityLte10AndPriceLte100testWith4Stocks()
    {
        when(service.getPrice(googleStock)).thenReturn(50);
        when(service.getPrice(msStock)).thenReturn(500);
        when(service.getPrice(facebookStock)).thenReturn(80);
        when(service.getAvailableStocks()).thenReturn(stocks);
        when(service.getPrice(whatsAppStock)).thenReturn(70);
        assertEquals(facebookStock,portfolio.suggestOptimalStock());
    }
    @Test(expected = NoOptimalStockFound.class)
    public void testNoOptimalStockPresent()
    {
        when(service.getPrice(googleStock)).thenReturn(150);
        when(service.getPrice(msStock)).thenReturn(500);
        when(service.getAvailableStocks()).thenReturn(stocks);
        portfolio.suggestOptimalStock();
    }
}
