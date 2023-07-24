/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import entity.*;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author HP
 */
@Local
public interface AdminSessionBeanLocal {
    
    //Users
    public List<Users> getUsers();
    public String deleteUser(int user_id);
    public String getUserIdfromUsername(String username);
    
    
    //Category
    
    public List<Category> getCategory();
    public String addCategory(String category_name);
    public Category searchCategory(int category_id);
    public String updateCategory(int category_id,String category_name);
    public String deleteCategory(int category_id);
    
    //Item
    
    public List<Item> getItem();
    public String insertItem(String item_name,int item_price,String item_image,String item_description,int category_id);
    public Item searchItem(int item_id);
    public String updateItem(int item_id,String item_name,int item_price,String item_image,String item_description,int category_id);
    public String deleteItem(int item_id);
    
    
    //Order
    List<Ordered> getOrder();
    public String deleteOrder(int order_id);
    
    //Payment
    
    List<Payment> getPayment();
    public String addPayment(int order_id,int user_id,String mode);
    
    //Invoice
    List<Invoice> getInvoice();
    public String addInvoice(int payment_id,String invoice_date);
    
    
    
    
}
