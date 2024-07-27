package com.wolf.concurrency;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FilterRequest {
    private String name;
    private String code;
    private Long price;
    private int rank;


}
