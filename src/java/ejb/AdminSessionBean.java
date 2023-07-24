/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.Cart;
import entity.Category;
import entity.Invoice;
import entity.Item;
import entity.Ordered;
import entity.Payment;
import entity.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author HP
 */
@Stateless
public class AdminSessionBean implements AdminSessionBeanLocal {

    @PersistenceContext(unitName = "NC_CafePU")
    private EntityManager em;
    String gettinguserId;

    public void persist(Object object) {
        em.persist(object);
    }
    
    @Override
    public String getUserIdfromUsername(String username) {
        List<Users> user = em.createNamedQuery("Users.findByUsername").setParameter("username", username).getResultList();
        for(Users users : user){
            gettinguserId = users.getUserId().toString();
            System.out.println("User Id is " + gettinguserId);
        }
        return gettinguserId;
    }

    @Override
    public List<Category> getCategory() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        List<Category> allCategory = em.createNamedQuery("Category.findAll").getResultList();
        return allCategory;
    }

    @Override
    public String addCategory(String category_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Category category = new Category();
        category.setCategoryName(category_name);
        em.persist(category);
        return "Inserted";
    }
    
    @Override
    public Category searchCategory(int category_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Category category = em.find(Category.class, category_id);
        return category;
    }

    @Override
    public String updateCategory(int category_id, String category_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Category category = em.find(Category.class, category_id);
        category.setCategoryName(category_name);
        em.merge(category);
        return "updated";
        
    }

    @Override
    public String deleteCategory(int category_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Category category = em.find(Category.class, category_id);
        em.remove(category);
        return "Deleted";
    }

    @Override
    public List<Item> getItem() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        List<Item> allItem = em.createNamedQuery("Item.findAll").getResultList();
        return allItem;
    }
    
    @Override
    public String insertItem(String item_name, int item_price, String item_image, String item_description, int category_id) {
        Item item = new Item();
        item.setItemName(item_name);
        item.setItemPrice(item_price);
        item.setItemImage(item_image);
        item.setItemDescription(item_description);
        Category category = em.find(Category.class, category_id);
        item.setCategoryId(category);
        em.persist(item);
        return "Inserted";
    }
    
    

//    @Override
//    public String addItem(String item_name,int item_price,String item_image, String item_description, int category_id) {
//        
//        Item item = new Item();
//        item.setItemName(item_name);
//        item.setItemPrice(item_price);
//        item.setItemImage(item_image);
//        item.setItemDescription(item_description);
//        Category category = em.find(Category.class, category_id);
//        item.setCategoryId(category);
//        em.persist(item);
//        
//        return "inserted";
//        
//    }

    @Override
    public Item searchItem(int item_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
        Item item = em.find(Item.class, item_id);
        return item;
    }

    @Override
    public String updateItem(int item_id, String item_name,int item_price,String item_image, String item_description, int category_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
        Item item = em.find(Item.class, item_id);
        item.setItemId(item_id);
        item.setItemName(item_name);
        item.setItemPrice(item_price);
        item.setItemImage(item_image);
        item.setItemDescription(item_description);
        Category category = em.find(Category.class, category_id);
        item.setCategoryId(category);
        em.merge(item);
        return "updated";
        
    }

    @Override
    public String deleteItem(int item_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
        Item item = em.find(Item.class, item_id);
        em.remove(item);
        return "deleted";
    }
    
    
    //Users
    
    @Override
    public List<Users> getUsers() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
        List<Users> allUsers = em.createNamedQuery("Users.findAll").getResultList();
        return allUsers;
    }

    @Override
    public String deleteUser(int user_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
        Users user = em.find(Users.class, user_id);
        em.remove(user);
        return "deleted";
    }

//    @Override
//    public List<Cart> getCartItem() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public Item searchCartItem(int item_id) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public String addToCart(int item_id, int user_id) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

    @Override
    public List<Ordered> getOrder() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String deleteOrder(int order_id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Payment> getPayment() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String addPayment(int order_id, int user_id, String mode) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Invoice> getInvoice() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String addInvoice(int payment_id, String invoice_date) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }




    

}
