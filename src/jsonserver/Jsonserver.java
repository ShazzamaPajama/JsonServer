/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jsonserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *
 * @author paul.koroski
 */
public class Jsonserver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServerSocket server;
        PrintWriter ServerOut;
        BufferedReader ServerIn;
        
        //Setup Server And Connection
        try {
            server = new ServerSocket(1337);
            System.out.println("Server Started");
            Socket  user = server.accept();
            System.out.println("User Connected");
            ServerOut = new PrintWriter(user.getOutputStream(), true);
            ServerIn = new BufferedReader(new InputStreamReader(user.getInputStream()));
            
            
            while(true){
                String UserInput = ServerIn.readLine();
                JsonReader reader = Json.createReader(new StringReader(UserInput));
                
                JsonObject json = reader.readObject();
                
                System.out.println(json.get("Message"));
                
                
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Jsonserver.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
    }
    
}
