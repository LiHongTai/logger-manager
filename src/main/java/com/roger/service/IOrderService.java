package com.roger.service;

import com.roger.entity.OrderDTO;

public interface IOrderService {

    int deleteById(Long id);
    int save(OrderDTO orderDTO);
    int update(OrderDTO orderDTO);
    OrderDTO findById(Long id);
}
