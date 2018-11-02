package com.roger.service;

import com.roger.SpringBaseTestSuit;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestOrderService extends SpringBaseTestSuit {

    @Autowired(required = false)
    private IOrderService iOrderService;

    @Test
    public void testDeleteById(){
        long id = 1l;
        iOrderService.deleteById(id);
    }
}
