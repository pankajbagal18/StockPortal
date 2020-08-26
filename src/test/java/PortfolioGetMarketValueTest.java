import dataModels.Stock;
import org.junit.Before;
import org.junit.Test;
import application.Portfolio;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import services.StockService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PortfolioGetMarketValueTest {
    @Mock
    private StockService service;
    private Portfolio portfolio;
    private Stock googleStock;
    private Stock msStock;
    @Before
    public void setup()
    {
        //service = mock(StockService.class);
        portfolio = new Portfolio(service);
        List<Stock> stocks = new ArrayList<Stock>();
        googleStock = new Stock("1","Google",10);
        stocks.add(googleStock);
        msStock = new Stock("2","Microsoft",20);
        stocks.add(msStock);
        portfolio.setMyStocks(stocks);
    }

    @Test
    public void testPortfolioStockServiceEnabled()
    {
        assertEquals(service,portfolio.getService());
    }

    @Test
    public void testStockListNotNull()
    {
        assertEquals(portfolio.getMyStocks().isEmpty(),false);
    }

    @Test
    public void testStockAt0()
    {
        assertEquals(portfolio.getMyStocks().get(0),googleStock);
    }

    @Test
    public void testServiceIsNotNull()
    {
        assertEquals(portfolio.getService().equals(null),false);
    }

    @Test
    public void testStockMarketValue()
    {
        when(service.getPrice(googleStock))
                .thenReturn(50);
        assertEquals(portfolio.getStockMarketValue(portfolio.getMyStocks().get(0)),
                500);
    }
}
