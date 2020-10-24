/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vuonghx.dao.product;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import vuonghx.dao.base.BaseDAO;
import vuonghx.entities.Product;
import vuonghx.utils.DBUtils;

/**
 *
 * @author hoxua
 */
public class ProductDAO extends BaseDAO<Product, Integer> {

    public ProductDAO() {
    }

    private static ProductDAO instance = null;

    private static final Object LOCK = new Object();

    private static ProductDAO getInstance() {
        synchronized (LOCK) {
            if (instance == null) {
                instance = new ProductDAO();
            }
        }

        return instance;
    }
    
    
}
