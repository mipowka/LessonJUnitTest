package org.example;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class OrderServiceTest {
    Logger logger = LoggerFactory.getLogger(OrderServiceTest.class);
    private OrderService orderService;


    @BeforeEach
    void setUp() {
        orderService = new OrderService();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void saveOrder() {
        logger.info("start save order test with param id:5  and item:coffe");
        boolean b = orderService.saveOrder(5, "coffee");
        Assertions.assertTrue(b);
        logger.info("result  = " + b);

        logger.info("start save also order test with param id:5  and item:coffe");
        boolean b2 = orderService.saveOrder(5, "coffee");
        Assertions.assertFalse(b2);
        logger.info("result  = " + b);
    }

    @Test
    void getOrderById() {
        logger.info("Add order wth id 5 and item coffee");
        orderService.saveOrder(5, "coffee");
        logger.info("check by id order in map with param ID 5");
        boolean a = orderService.getOrderById(5);
        Assertions.assertTrue(a);
        logger.info("result =" + a);

        logger.info("check by id order in map with param ID 1");
        boolean b = orderService.getOrderById(1);
        Assertions.assertFalse(b);
        logger.info("result =" + b);
    }

    @Test
    void deleteOrderById() {
        logger.info("Add order wth id 5 and item coffee");
        orderService.saveOrder(5, "coffee");
        logger.info("delete order by id order in map with param ID 5");
        boolean a = orderService.deleteOrderById(5);
        Assertions.assertTrue(a);
        logger.info("result =" + a);

        logger.info("delete order by id order in map with param ID 1");
        boolean b = orderService.deleteOrderById(1);
        Assertions.assertFalse(b);
        logger.info("result =" + b);
    }

    @Test
    void getAllOrders() {
        logger.info("Add order with id 5 and item coffee");
        orderService.saveOrder(5, "coffee");
        logger.info("get all orders order in map");
        Assertions.assertEquals("coffee",orderService.getAllOrders());
        logger.info("result =" + orderService.getAllOrders());

        orderService.deleteOrderById(5);
        logger.info("delete order by id order in map");
        Assertions.assertNull(orderService.getAllOrders());
        logger.info("result =" + orderService.getAllOrders());
    }

    @Test
    void countOfOrders() {
        logger.info("Add order with id 5 and item coffee");
        orderService.saveOrder(5, "coffee");
        logger.info("count of orders order in map");
        Assertions.assertEquals(1,orderService.countOfOrders());
        logger.info("result =" + orderService.countOfOrders());

        orderService.deleteOrderById(5);
        logger.info("delete order by id order in map");
        logger.info("count of orders order in map");
        Assertions.assertEquals(0,orderService.countOfOrders());
        logger.info("result =" + orderService.countOfOrders());

    }
}