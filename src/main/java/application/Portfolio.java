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
}
