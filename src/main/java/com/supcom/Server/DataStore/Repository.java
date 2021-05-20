package com.supcom.Server.DataStore;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.supcom.Server.Entity.Entity;
import com.supcom.Server.FireStoreInitializer;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/*
public class Repository<T extends Entity> {
    private final Object TOB = ((T) new Entity());
    private final String collectionName =((T) new Entity()).CollectionName();
    private final CollectionReference collectionReference = FireStoreInitializer.getDb().collection(collectionName);

    public T create(T t)
    {
        if (!collectionReference.add(t).isCancelled())
            return t;
        throw new NoSuchElementException();

    }

    public  T update(String tId,T t)
    {
        if (!collectionReference.document(tId).set(t).isCancelled())
            return t;
        throw new NoSuchElementException();
    }
    public List<T> getAll() {
        List<T> all = new ArrayList<T>();
        List<QueryDocumentSnapshot> documents = new ArrayList<>(); ;
        try { documents = collectionReference.get().get().getDocuments();}
        catch (Exception e)
        {
            System.out.println(e.toString());

        }
        for (QueryDocumentSnapshot document : documents) {
            all.add(document.toObject(T.class));
        }
        return all;
    }
    public  T getById(String TId) {
        T T;
        try {
            T = collectionReference.document(TId).get().get().toObject(T.class);
        } catch (Exception e) {
            System.out.println(e.toString());
            throw new NoSuchElementException();
        }
        return T;

    }
    public void delete(String TId)
    {
        collectionReference.document(TId).delete();
    }





}*/
