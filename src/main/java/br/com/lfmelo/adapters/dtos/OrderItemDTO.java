package br.com.lfmelo.adapters.dtos;

import lombok.Data;

@Data
public class OrderItemDTO {
    private Long productId;
    private Integer quantity;
    private String note;
}
