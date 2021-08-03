package onlineShop.dao;

import onlineShop.entity.Cart;
import onlineShop.entity.CartItem;
import onlineShop.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import onlineShop.entity.SalesOrder;

import java.util.List;

@Repository
public class SalesOrderDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ProductDao productDao;

    public void addSalesOrder(SalesOrder salesOrder) {
        Session session = null;
        try {

            session = sessionFactory.openSession();
            session.beginTransaction();
            for(CartItem cur : salesOrder.getCart().getCartItem()) {
                Product product = cur.getProduct();
                Long newUnit = product.getUnitStock();
                newUnit -= cur.getQuantity();
                product.setUnitStock(newUnit);
                // delete if none left
                if(newUnit > 0) {
                    productDao.updateProduct(product);
                } else if(newUnit ==0){
                    productDao.deleteProduct(product.getId());
                }
            }

            session.save(salesOrder);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public int gettotalSales(Cart cart) {
        int totalSales = 0;
        List<CartItem> cartItems = cart.getCartItem();

        for (CartItem item : cartItems) {
            totalSales += item.getQuantity();
        }
        return totalSales;
    }
}
