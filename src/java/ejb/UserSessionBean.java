/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.Cart;
import entity.Category;
import entity.Feedback;
import entity.Item;
import entity.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;

/**
 *
 * @author HP
 */
@Stateless
public class UserSessionBean implements UserSessionBeanLocal {

    @PersistenceContext(unitName = "NC_CafePU")
    private EntityManager em;
    private Pbkdf2PasswordHashImpl pb;

    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public String register(String firstname, String lastname, String username, String email, String password, String gender, String mobile_no, String address, String user_role,String profile_image) {
        
        pb = new Pbkdf2PasswordHashImpl();
        String e_password = pb.generate(password.toCharArray());
        
        Users user = new Users();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(e_password);
        user.setGender(gender);
        user.setMobileNo(mobile_no);
        user.setAddress(address);
        user.setProfileImage(profile_image);
        user.setUserRole("User");
        em.persist(user);
       
        return "Inserted";
    }

    @Override
    public List<Category> getCategory() {
        List<Category> allCategory = em.createNamedQuery("Category.findAll").getResultList();
        return allCategory;
    }

    @Override
    public List<Item> getItem() {
        List<Item> allItem = em.createNamedQuery("Item.findAll").getResultList();
        return allItem;
    }

    @Override
    public Item searchItem(int item_id) {
        Item item = em.find(Item.class, item_id);
        return item;
    }
    
    //Cart
    @Override
    public Item selectItem(int item_id) {
        Item i = em.find(Item.class, item_id);
        return i;
    }

    @Override
    public String addToCart(int item_id, int user_id, int qty) {
        Cart c = new Cart();
        Item i = em.find(Item.class, item_id);
        Users  user = (Users) em.createNamedQuery("Users.findByUserId").setParameter("userId", user_id).getSingleResult();
        List<Cart> cart = user.getCartList();
        c.setItemId(i);
        c.setUserId(user);
        c.setQty(qty);
        
        cart.add(c);
        user.setCartList(cart);
        em.persist(c);
        em.merge(user);
        return "i";
    }

    @Override
    public List<Cart> findAllCart() {
        List<Cart> c = em.createNamedQuery("Cart.findAll").getResultList();
        return c;
    }

    //Feedback

    @Override
    public List<Feedback> findAllFeedback() {
        List<Feedback> f = em.createNamedQuery("Feedback.findAll").getResultList();
        return f;
    }

    @Override
    public void addFeedback(int user_id, String message, int cafe_ratting) {
        
        Feedback f = new Feedback();
        Users  user = (Users) em.createNamedQuery("Users.findByUserId").setParameter("userId", user_id).getSingleResult();
        List<Feedback> feedback = user.getFeedbackList();
        f.setUserId(user);
        f.setMessage(message);
        f.setCafeRatting(cafe_ratting);
        
        feedback.add(f);
        user.setFeedbackList(feedback);
        em.persist(f);
        em.merge(user);
    }

    @Override
    public String addOreder(int cart_id, String total_payment, String order_date) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
