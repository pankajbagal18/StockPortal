package dataModels;

import lombok.Data;

@Data
public class Investor {
    private Long id;
    private String name;
    private Double balance;
}
