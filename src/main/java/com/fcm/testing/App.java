package com.fcm.testing;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream.PutField;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;

public class App 
{
    public static void main( String[] args ) throws IOException, FirebaseMessagingException
    {
        System.out.println( "Hello World!" );
        
        FileInputStream serviceAccount = new FileInputStream("src/main/java/serviceAccountKey.json");
        System.out.println("json file read.");
        
        FirebaseOptions options = new FirebaseOptions.Builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .setDatabaseUrl("https://gbk-project.firebaseio.com/")
            .build();
        System.out.println(options.toString());
        System.out.println("Firebase options set.");
        FirebaseApp.initializeApp(options);
        System.out.println("Firebase app initialized.");
        //.setCredentials(GoogleCredentials.getApplicationDefault())
        	    
        String registrationToken = "AAAA89hUTvQ:APA91bHIGeyh5GcLddj9io7sXnTLsoyEtLHgd5h3aoBS14CGAft5Sh4Nz0627ajM_j7ArVZKRTEkGEeZlIOeVKU797qSlUYrL4wgNoYl7BOpLsFex2UdSrfyssszldXFQRue0DA5weu1";
        String topic = "global";

     Message message = Message.builder()
    		 .putData("message","Happy")
    		 .setTopic(topic)
         .build();
  
     System.out.println("Message is set.");
     String response = FirebaseMessaging.getInstance().send(message);
      System.out.println("Successfully sent message: " + response);
    }
}
