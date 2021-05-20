package com.supcom.Server.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collection;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Food extends Entity{

    private String name;
    private String Category;
    private int Price;
    private double Stars;
    @Override
    public  String CollectionName()
    {
        return "Food";
    }

}
