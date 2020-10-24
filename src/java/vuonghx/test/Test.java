/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vuonghx.test;

import java.util.List;
import vuonghx.dao.category.CategoryDAO;
import vuonghx.dao.product.ProductDAO;
import vuonghx.entities.Category;

/**
 *
 * @author hoxua
 */
public class Test {
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        
        CategoryDAO catDao = new CategoryDAO();
        
        List<Category> list =  catDao.getAll("Category.findAll");
              
        for(Category item : list){
            System.out.println(item.getName());
        }
        
    }
}
