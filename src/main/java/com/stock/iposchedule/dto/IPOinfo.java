package com.stock.iposchedule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IPOinfo {
    private String company;
    private String date;
    private String finalPrice;
    private String hopePrice;
    private String stockCompanys;
}
