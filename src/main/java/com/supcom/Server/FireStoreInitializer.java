package com.supcom.Server;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
public class FireStoreInitializer {
    static private Firestore db;
    static private final String AccountServicePath = "D:\\cours\\PROJECTS\\TS\\src\\main\\resources\\AccountService.json";


    public static void connect() throws IOException {
        // Use a service account
        InputStream serviceAccount = new FileInputStream(AccountServicePath);
        GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(credentials)
                .build();
        FirebaseApp.initializeApp(options);

        db = FirestoreClient.getFirestore();
    }
    public static Firestore getDb() {
        return db;
    }

}
