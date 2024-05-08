package com.examplechallengebinarc4.challengebinarc4.Testing;

import com.examplechallengebinarc4.challengebinarc4.Entity.Order;
import com.examplechallengebinarc4.challengebinarc4.Service.OrderService;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class TestingOrder {

    @Autowired
    private OrderService orderService;

    @Test
    public void addOrder(){
        Order save = new Order();
        save.setDestination_address("Denpasar");

        Map map = orderService.addOrder(save);
        int responseCode = (Integer) map.get("status");
        Assert.assertEquals(200, responseCode);
    }
}
