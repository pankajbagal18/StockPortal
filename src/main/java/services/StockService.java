package services;

import dataModels.Broker;
import dataModels.Investor;
import dataModels.Stock;

import java.util.List;

public interface StockService {
    int getPrice(Stock stock);
    List<Stock> getAvailableStocks();
    void buyStock(Stock stock, Broker broker, Investor investor);
}
