/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import ejb.AdminSessionBeanLocal;
import entity.Cart;
import entity.Category;
import entity.Feedback;
import entity.Invoice;
import entity.Item;
import entity.Ordered;
import entity.Payment;
import entity.Users;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.http.Part;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author HP
 */
@Named(value = "AdminBean")
@SessionScoped
public class AdminBean implements Serializable {

    @EJB
    private AdminSessionBeanLocal asbl;
    
    Response rs;
    List<Users> user;
    GenericType<List<Users>> guser = new GenericType<List<Users>>(){};
    
    List<Category> category;
    GenericType<List<Category>> gcategory = new GenericType<List<Category>>(){};
    
    List<Item> item;
    GenericType<List<Item>> gitem = new GenericType<List<Item>>(){};
    
    List<Cart> cart;
    GenericType<List<Cart>> gcart = new GenericType<List<Cart>>(){};
    
    List<Ordered> ordered;
    GenericType<List<Ordered>> gordered = new GenericType<List<Ordered>>(){};
    
    List<Payment> payment;
    GenericType<List<Payment>> gpayment = new GenericType<List<Payment>>(){};
    
    List<Invoice> invoice;
    GenericType<List<Invoice>> ginvoice = new GenericType<List<Invoice>>(){};
    
    List<Feedback> feedback;
    GenericType<List<Feedback>> gfeedback = new GenericType<List<Feedback>>(){};
    
    
    //Users
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
    
    private String profile_image_folder = "C:\\Users\\HP\\OneDrive\\Desktop\\GitHub\\NC-CAFE-MANAGEMENT-SYSTEM\\Final\\NC_Cafe\\web\\resources\\users";

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
    
    
    
    public List<Users> allUsers(){
        return asbl.getUsers();
    }
    
    public void deleteUser(int user_id){
        asbl.deleteUser(user_id);
    }
    
    //Category
    int category_id;
    String category_name;

    public AdminSessionBeanLocal getAsbl() {
        return asbl;
    }

    public void setAsbl(AdminSessionBeanLocal asbl) {
        this.asbl = asbl;
    }

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
    
    public List<Category> allCategory(){
        return asbl.getCategory();
    }
    
    public String addCategory(){
        try{
            asbl.addCategory(category_name);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        category_name = "";
        return "categorys.jsf";
    }
    
    public String searchCategory(int cid){
        Category category = asbl.searchCategory(cid);
        category_id = category.getCategoryId();
        category_name = category.getCategoryName();
        
        return "update_category.jsf";
        
    }
    
    public String updateCategory(){
        try{
            asbl.updateCategory(category_id, category_name);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        category_name = "";
        return "categorys.jsf";
    }
    
    public void deleteCategory(int category_id){
        asbl.deleteCategory(category_id);
    }
    
    //Item
    
    int item_id;
    String item_name;
    int item_price;
    String item_image;
    String item_description;
    
    private Part uploadedFile;
    private String item_image_folder = "C:\\Users\\HP\\OneDrive\\Desktop\\GitHub\\NC-CAFE-MANAGEMENT-SYSTEM\\NC_Cafe\\web\\resources\\items";

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

    public String getItem_image() {
        return item_image;
    }

    public void setItem_image(String item_image) {
        this.item_image = item_image;
    }

    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    public Part getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(Part uploadedFile) {
        this.uploadedFile = uploadedFile;
    }
    
    public List<Item> allItem(){
        return asbl.getItem();
    }
    
    public String addItem(){
        try{
            InputStream input = uploadedFile.getInputStream();
            String fileName = uploadedFile.getSubmittedFileName();
            
            asbl.insertItem(item_name, item_price, fileName, item_description, category_id);
            
            Files.copy(input,new File(item_image_folder,fileName).toPath());
        }
        catch(IOException e){
            System.out.println(e);
        }
        item_name = "";
       
        item_description = "";
        return "items.jsf";
    }
    

    
    public String searchItem(int iid){
        Item item = asbl.searchItem(iid);
        item_id = item.getItemId();
        item_name = item.getItemName();
        item_price = item.getItemPrice();
        item_image = item.getItemImage();
        item_description = item.getItemDescription();
        category_id = item.getCategoryId().getCategoryId();
        
        return "update_item.jsf";
        
    }
    
    public String updateItem(){
        try{
            InputStream input = uploadedFile.getInputStream();
            String fileName = uploadedFile.getSubmittedFileName();
            
            asbl.updateItem(item_id, item_name, item_price, item_image, item_description, category_id);
            
            Files.copy(input, new File(item_image_folder,fileName).toPath());
        }
        catch(IOException e){
            System.out.println(e);
        }
        return "items.jsf";
    }
    
    public void deleteItem(int item_id){
        asbl.deleteItem(item_id);
    }
    
    //payment
    
    int payment_id;
    String mode;

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
    
    //invoice
    int invoice_id;
    String payment_date;

    public int getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }
    
    public AdminBean() {
    }
    
}
