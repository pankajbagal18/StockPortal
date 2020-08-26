package services;

import dataModels.Stock;

import java.util.List;

public class Portfolio {
    private List<Stock> stocks;
    private StockService service;
    public Portfolio(StockService service)
    {
        this.service = service;
    }

    public List<Stock> getStocks()
    {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public StockService getService() {
        return service;
    }

    public void setService(StockService service) {
        this.service = service;
    }

    public int getStockMarketValue(Stock stock)
    {
        return stock.getQuantity()*service.getPrice(stock);
    }
}
