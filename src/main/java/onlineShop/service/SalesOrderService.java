package onlineShop.service;

import onlineShop.entity.Cart;
import onlineShop.entity.CartItem;
import onlineShop.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import onlineShop.dao.SalesOrderDao;
import onlineShop.entity.SalesOrder;

import java.util.List;

@Service
public class SalesOrderService {

    @Autowired
    private SalesOrderDao salesOrderDao;

    public void addSalesOrder(SalesOrder salesOrder) {
        salesOrderDao.addSalesOrder(salesOrder);
    }
//    int salesTotal = getSales(cart);
//        if(Integer.parseInt(product.getUnitStock()) > salesTotal) {
//        product.setUnitStock(Integer.toString(Integer.parseInt(product.getUnitStock()) - salesTotal));
//    }
//
//    private int getSales(Cart cart) {
//        int total = 0;
//        List<CartItem> cartItems = cart.getCartItem();
//
//        for (CartItem item : cartItems) {
//            total += item.getQuantity();
//        }
//        return total;
//    }


}
