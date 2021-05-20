package com.supcom.Server.DataStore;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.supcom.Server.Entity.Food;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import com.supcom.Server.FireStoreInitializer;


public class FoodDataStore {

    private static final String collectionName ="Food";
    private static  CollectionReference collectionReference = FireStoreInitializer.getDb().collection(collectionName);

        public Food create(Food food)
        {
         if (!collectionReference.add(food).isCancelled())
             return food;
         throw new NoSuchElementException();

        }

        public  Food update(String foodId,Food food)
        {
            if (!collectionReference.document(foodId).set(food).isCancelled())
                return food;
            throw new NoSuchElementException();
        }
        public   List<Food> getAll() {
            List<Food> all = new ArrayList<Food>();
            List<QueryDocumentSnapshot> documents = new ArrayList<>();
            try { documents = collectionReference.get().get().getDocuments();}
            catch (Exception e)
            {
                System.out.println(e.toString());

            }
            for (QueryDocumentSnapshot document : documents) {
                all.add(document.toObject(Food.class));
            }
            return all;
        }
        public  Food getById(String foodId) {
            Food food;
            try {
                food = collectionReference.document(foodId).get().get().toObject(Food.class);
            } catch (Exception e) {
                System.out.println(e.toString());
                throw new NoSuchElementException();
            }
            return food;

        }
        public void delete(String foodId)
        {
            collectionReference.document(foodId).delete();
        }
        public List<Food> getAllByCategory(String category)
        {
            return getAllByField("category",category);
        }
        public List<Food> getAllByField (String field ,Object value)
        {

            List<Food> all = new ArrayList<Food>();
            Query query = collectionReference.whereEqualTo(field, value);

            ApiFuture<QuerySnapshot> querySnapshot = query.get();
            List<QueryDocumentSnapshot> documents = new ArrayList<>();
            try{documents= querySnapshot.get().getDocuments();}
             catch (Exception e) {
                e.printStackTrace();
            }

            for (DocumentSnapshot document : documents) {
                all.add(document.toObject(Food.class));
            }
            return  all;

        }



}
