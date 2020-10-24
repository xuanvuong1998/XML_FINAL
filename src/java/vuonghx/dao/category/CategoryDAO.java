/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vuonghx.dao.category;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import vuonghx.dao.base.BaseDAO;
import vuonghx.entities.Category;
import vuonghx.utils.DBUtils;

/**
 *
 * @author hoxua
 */
public class CategoryDAO extends BaseDAO<Category, Integer>{

    public CategoryDAO() {
    }
    
    private static CategoryDAO instance;
    private static final Object LOCK = new Object();
    
    public static CategoryDAO getInstance() {
        synchronized (LOCK) {   
            if (instance == null) {
                instance = new CategoryDAO();
            }
        }
        return instance;
    }
    
    public synchronized List<Category> getAllCategories(){
        EntityManager em = DBUtils.getEntityManager();
        try {
            List<Category> result = em.createNamedQuery("Category.findAll", Category.class)
                    .getResultList();
            
            return result;
        } catch (Exception e) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return null;
    }
}
