package application;

import dataModels.Stock;
import lombok.Getter;
import lombok.Setter;
import services.StockService;

import java.util.List;

@Getter
@Setter
public class Portfolio {
    private List<Stock> stocks;
    private StockService service;
    public Portfolio(StockService service)
    {
        this.service = service;
    }
    public int getStockMarketValue(Stock stock)
    {
        return stock.getQuantity()*service.getPrice(stock);
    }

    public void printAvailableStocks()
    {
        List<Stock> availableStocks = service.getAvailableStocks();
        if(availableStocks.equals(null)||availableStocks.isEmpty())
            System.out.println("Stocks are not available. Please Try again later.");
        else
            availableStocks.forEach((stock)-> System.out.println("* "+stock+" *"));
    }
}
