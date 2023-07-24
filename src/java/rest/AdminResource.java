/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import ejb.AdminSessionBeanLocal;
import entity.Category;
import entity.Item;
import entity.Users;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author HP
 */
@Path("generic")
@RequestScoped
public class AdminResource {
    @EJB AdminSessionBeanLocal asbl;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AdminResource
     */
    public AdminResource() {
    }

    /**
     * Retrieves representation of an instance of rest.AdminResource
     * @return an instance of java.lang.String
     */
    @RolesAllowed({"Admin","User"})
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getCategory/{category_id}")
    public List<Category> getAllcategory(){
        return asbl.getCategory();
    }
    
    @RolesAllowed({"Admin"})
    @POST
    @Path("addCategory/{category_name}")
    public void addCategory(@PathParam("category_name")String category_name) {
        //TODO return proper representation object
        asbl.addCategory(category_name);

    }
    
    @RolesAllowed({"Admin"})
    @PUT
    @Path("updateCategory/{category_id}/{category_name}")
    public void updateCategory(@PathParam("category_id")int category_id,@PathParam("category_name")String category_name){
        asbl.updateCategory(category_id, category_name);
    }
    
    @RolesAllowed({"Admin"})
    @DELETE
    @Path("deleteCategory/{category_id}")
    public void deleteCategory(@PathParam("category_id")int category_id){
        asbl.deleteCategory(category_id);
    }
    
    
    @RolesAllowed({"Admin","User"})
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getItem/{item_id}")
    public List<Item> getAllitem(){
        return asbl.getItem();
    }
    
    @RolesAllowed({"Admin"})
    @PUT
    @Path("insertItem/{item_name}/{item_price}/{item_description}/{item_image}/{category_id}")
    public void addItem(@PathParam("category_id") int category_id,@PathParam("item_name") String item_name,@PathParam("item_price") String item_price,@PathParam("item_description") String item_description,@PathParam("item_image") String item_image){
        asbl.insertItem(item_name, category_id, item_image, item_description, category_id);
    }
    
    @RolesAllowed({"Admin"})
    @PUT
    @Path("updatetItem/{item_id}/{item_name}/{item_price}/{item_description}/{item_image}/{category_id}")
    public void updateItem(@PathParam("item_id") int item_id,@PathParam("category_id") int category_id,@PathParam("item_name") String item_name,@PathParam("item_price") String item_price,@PathParam("item_description") String item_description,@PathParam("item_image") String item_image){
        asbl.updateItem(item_id, item_name, item_id, item_image, item_description, category_id);
    }
    
    @RolesAllowed({"Admin"})
    @DELETE
    @Path("deleteItem/{item_id}")
    public void deleteItem(@PathParam("item_id")int item_id){
        asbl.deleteItem(item_id);
    }
    
    
    
    @RolesAllowed({"Admin"})
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getUsers/{user_id}")
    public List<Users> getAlluser(){
        return asbl.getUsers();
    }
    
    

    /**
     * PUT method for updating or creating an instance of AdminResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
