package dataModels;


import lombok.Data;

@Data
public class Stock {
    private String stockId;
    private String name;
    private int quantity;
}
