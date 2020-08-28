package application;

import Exceptions.NoOptimalStockFound;
import Exceptions.NoStocksAvailable;
import dataModels.Stock;
import lombok.Getter;
import lombok.Setter;
import services.StockService;

import java.util.List;

@Getter
@Setter
public class Portfolio {
    private List<Stock> myStocks;
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
        if(availableStocks == null ||availableStocks.isEmpty())
            System.out.println("Stocks are not available. Please Try again later.");
        else
            availableStocks.forEach((stock)-> System.out.println("* "+stock+" *"));
    }

//    Criteria for optimal stock :
//    stock quantity less than 10 and price less than 100
//    if multiple such stocks are available
//    then select stock with max(qty*price)

    public Stock suggestOptimalStock() {
        List<Stock> availableStocks = service.getAvailableStocks();
        if (availableStocks == null || availableStocks.isEmpty())
            throw new NoStocksAvailable();
        else
        {
            Stock optimalStock = null;
            int optimalPrice = 0;
            for (Stock stock:availableStocks)
            {
                int price = service.getPrice(stock);
                int qty = stock.getQuantity();
                if(price<100&&qty<10&&optimalPrice<(qty*price)) {
                    optimalStock = stock;
                    optimalPrice = qty*price;
                }
            }
            if(optimalStock==null || optimalPrice==0)
            {
                throw new NoOptimalStockFound();
            }
            else
                return optimalStock;
        }
    }
}
