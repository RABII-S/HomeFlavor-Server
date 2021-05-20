package com.supcom.Server.Resource;

import com.supcom.Server.DataStore.FoodDataStore;
import com.supcom.Server.Entity.Food;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/Food")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FoodResource {

    //@Inject
    private FoodDataStore foodDataStore = new FoodDataStore();
   /* getAll */
    @GET
    public List<Food> getAll()
    {
       return foodDataStore.getAll();
    }
    @Path("/{foodId}")
    @GET
    public Food get(@PathParam("foodId") String foodId)
    {
        return foodDataStore.getById(foodId);
    }
    @POST
    public Food create(Food food)
    {
        return  foodDataStore.create(food);
    }
    @PUT
    public Food update(String foodId,Food food)
    {
        return foodDataStore.update(foodId,food);
    }
    @DELETE
    public void delete(String foodId)
    {
        foodDataStore.delete(foodId);
    }
    @Path("/Category/{category}")
    @GET
    public List<Food> getAllByCategory(@PathParam("category") String category)
    {
        return foodDataStore.getAllByCategory(category);
    }
}