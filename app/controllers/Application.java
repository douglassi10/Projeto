package controllers;

import play.*;
import play.mvc.*;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.*;

public class Application extends Controller {
    static StringBuffer test = new StringBuffer();
	static String teste = "";
    static String logins;
	static JSONArray arrayJson = null;
    public static void index() {
         try {
             String url = "https://api.github.com/repos/microsoft/healthvault-ios-sdk/contributors";
             URL objeto = new URL(url);
             HttpURLConnection conectar = (HttpURLConnection) objeto.openConnection();
             BufferedReader entrada = new BufferedReader(
                     new InputStreamReader(conectar.getInputStream()));
             String linhaentrada;
             StringBuffer respostaString = new StringBuffer();

             while ((linhaentrada = entrada.readLine()) != null) {
                 respostaString.append(linhaentrada);
             }
             entrada.close();
             //String volt = respostaString.toString();
             // System.out.println(respostaString.toString());
              arrayJson = new JSONArray(respostaString.toString());
             //int number = arrayJson.getJSONObject(1).getInt("id");

             //Integer soma =  arrayJson.getJSONObject(1).getInt("id") + arrayJson.getJSONObject(0).getInt("id");

             int index = 0;
             JSONObject posicao = new JSONObject();
             while (posicao != null) {
                 logins = arrayJson.getJSONObject(index).getString("login");
                 test.append(logins+"\n");
                 //teste += " "+logins+"\n";
                 //System.out.print(test);
                 index++;
                 posicao = arrayJson.getJSONObject(index);
                 
             }
             //String teste = logins;
             //int teste = arrayJson.getJSONObject(1).getInt("id");
             //String teste = respostaString.toString();
             //System.out.println(percorre());

             String te =respostaString.toString();

         }catch(Exception e){
             System.out.println();
         }
         String te = arrayJson.toString();
         //System.out.println(teste);
         render(te);
         
    }
    
   
}