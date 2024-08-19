package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class OrderService {

    private Map<Integer,String> ordersMap = new HashMap<Integer,String>();


    boolean saveOrder(int id, String order){
        if(ordersMap.containsKey(id)){
            return false;
        }

        ordersMap.put(id,order);
         return true;
    }

    boolean getOrderById(int id){
        if(!ordersMap.containsKey(id)){
            return false;
        }

        ordersMap.get(id);
        return true;
    }

    boolean deleteOrderById(int id){
        if(!ordersMap.containsKey(id)){
            return false;
        }

        ordersMap.remove(id);
        return true;
    }

    String getAllOrders(){
        Set<Map.Entry<Integer, String>> entries = ordersMap.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            return entry.getValue();
        }
        return null;
    }

    int countOfOrders(){
        return ordersMap.size();
    }


    //метод получения заказа по ид
    //метод удаления заказа по id
    // метод получения всех заказов
    //кол во заказов
    //написать тесты к каждому методу и логирования  тестах

    //залить на гитхаб и скинуть ссылку на проверку

}
