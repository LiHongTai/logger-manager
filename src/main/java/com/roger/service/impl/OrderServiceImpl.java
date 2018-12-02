package com.roger.service.impl;

import com.roger.annotation.LogEnable;
import com.roger.annotation.LogEvent;
import com.roger.entity.OrderDTO;
import com.roger.enumeration.EventType;
import com.roger.enumeration.ModuleType;
import com.roger.service.IOrderService;
import org.springframework.stereotype.Component;

@Component
@LogEnable
@LogEvent(module = ModuleType.ORDER)
public class OrderServiceImpl implements IOrderService {

    @LogEvent(event = EventType.DELETE,desc = "根据ID删除订单")
    @Override
    public int deleteById(Long id) {
        System.out.println("****执行删除操作*****");
        return 0;
    }

    @LogEvent(event = EventType.INSERT,desc = "保存订单")
    @Override
    public int save(OrderDTO orderDTO) {
        System.out.println("****执行保存操作*****");
        return 0;
    }

    @Override
    public int update(OrderDTO orderDTO) {
        System.out.println("****执行更新操作*****");
        return 0;
    }

    @Override
    public OrderDTO findById(Long id) {
        System.out.println("****执行查询操作*****");
        return null;
    }
}
