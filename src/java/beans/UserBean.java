/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import ejb.UserSessionBeanLocal;
import entity.Item;
import java.io.File;
import java.io.InputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.http.Part;

/**
 *
 * @author HP
 */
@Named(value = "UserBean")
@SessionScoped
public class UserBean implements Serializable {

    @EJB
    private UserSessionBeanLocal usbl;

    public UserSessionBeanLocal getUsbl() {
        return usbl;
    }

    public void setUsbl(UserSessionBeanLocal usbl) {
        this.usbl = usbl;
    }
    
    //File
    
    private Part uploadedFile;

    public Part getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(Part uploadedFile) {
        this.uploadedFile = uploadedFile;
    }
    
    private String profile_image_folder = "C:\\Users\\HP\\OneDrive\\Desktop\\GitHub\\NC-CAFE-MANAGEMENT-SYSTEM\\NC_Cafe\\web\\resources\\users";
    
    //User Table
    
    int user_id;
    String firstname;
    String lastname;
    String username;
    String email;
    String password;
    String Confirm_password;
    String gender;
    String mobile_no;
    String address;
    String user_role;
    String profile_image;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm_password() {
        return Confirm_password;
    }

    public void setConfirm_password(String Confirm_password) {
        this.Confirm_password = Confirm_password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }
    
    public String register(){
        try{
            InputStream input = uploadedFile.getInputStream();
            String fileName = uploadedFile.getSubmittedFileName();
//            String userType = "User";
            
            
            usbl.register(firstname, lastname, username, email, password, gender, mobile_no, address, user_role, fileName);
            
            Files.copy(input, new File(profile_image_folder, fileName).toPath());
        }
        catch(Exception e){
            e.printStackTrace();
        }
        firstname = "";
        lastname = "";
        username = "";
        email = "";
        password = "";
        gender = "";
        mobile_no = "";
        address = "";
        user_role = "User";
        
        return "index.jsf";
    }
    
    //Category
    
    int category_id;
    String category_name;
    
    
    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
    
    //Item
    
    int item_id;
    String item_name;
    int item_price;
    String item_description;
    String item_image;

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public int getItem_price() {
        return item_price;
    }

    public void setItem_price(int item_price) {
        this.item_price = item_price;
    }

    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    public String getItem_image() {
        return item_image;
    }

    public void setItem_image(String item_image) {
        this.item_image = item_image;
    }
    
    public List<Item> getAllItem(){
        return usbl.getItem();
    }

    public String SelectItem(int itmid){
        Item item = usbl.searchItem(itmid);
        item_id = item.getItemId();
        item_name = item.getItemName();
        item_price = item.getItemPrice();
        item_description = item.getItemDescription();
        item_image = item.getItemImage();
        category_id = item.getCategoryId().getCategoryId();
        
        return "selecteditem.jsf?faces-redirect=True";
    }
    
    //cart
    int cart_id;
    int qty;

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    
    //Order
    int order_id;
    String total_payment;
    String order_date;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getTotal_payment() {
        return total_payment;
    }

    public void setTotal_payment(String total_payment) {
        this.total_payment = total_payment;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }
    
    //Feedback
    
    int feedback_id;
    String message;
    int cafe_ratting;

    public int getFeedback_id() {
        return feedback_id;
    }

    public void setFeedback_id(int feedback_id) {
        this.feedback_id = feedback_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCafe_ratting() {
        return cafe_ratting;
    }

    public void setCafe_ratting(int cafe_ratting) {
        this.cafe_ratting = cafe_ratting;
    }
    
    
    
    public UserBean() {
    }
    
}
