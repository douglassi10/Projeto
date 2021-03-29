package controllers;

import play.*;
import play.mvc.*;

import java.awt.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.*;


public class Application extends Controller {
    static String logins;
    static int contributions;
    static JSONArray arrayJsonContribuidores = new JSONArray();
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
         
             arrayJson = new JSONArray(respostaString.toString());
             
             int index = 0;
             JSONObject posicao = new JSONObject();
             while (posicao != null) {
                 logins = arrayJson.getJSONObject(index).getString("login");
                 contributions = arrayJson.getJSONObject(index).getInt("contributions");
                 
                 JSONObject contrib = new JSONObject();
                 
                 contrib.put("contributions", contributions);
                 contrib.put("name", logins);
                 arrayJsonContribuidores.put(contrib);
                 System.out.println(contrib);
                 index++;
                 posicao = arrayJson.getJSONObject(index);
             }
                    
         }catch(Exception e){
             //System.out.println("ocorreu um erro!");
         }
         JSONArray contribuidores = arrayJsonContribuidores;
         System.out.println(arrayJsonContribuidores);
         render(contribuidores);
 
    }
 
}