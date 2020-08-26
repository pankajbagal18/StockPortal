package services;

import dataModels.Stock;

import java.util.List;

public interface StockService {
    int getPrice(Stock stock);
    List<Stock> getAvailableStocks();
}
