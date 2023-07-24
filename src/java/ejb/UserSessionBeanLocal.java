/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import entity.Cart;
import entity.Category;
import entity.Feedback;
import entity.Item;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HP
 */
@Local
public interface UserSessionBeanLocal {
    
    //User Table Method
    
    public String register(String firstname,String lastname,String username,String email,String password,String gender,String mobile_no,String address,String user_role,String profile_image);
    
    //Cateory
    
    public List<Category> getCategory();
    
    //Item
    
    public List<Item> getItem();
    public Item searchItem(int item_id);
    
    //Feedback
    
    public List<Feedback> findAllFeedback();
    public void addFeedback(int user_id,String message,int cafe_ratting);
    
    //Cart
    public Item selectItem(int item_id);
    public List<Cart> findAllCart();
    public String addToCart(int item_id,int user_id,int qty);
    
    //Order
    public String addOreder(int cart_id,String total_payment,String order_date);
    
}
