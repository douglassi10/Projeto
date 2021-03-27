package controllers;

import play.*;
import play.mvc.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import org.json.*;
import java.net.URL;

public class Teste extends Controller {

    public static void index() {
        try {
            String url = "https://api.github.com/users";
            URL objeto = new URL(url);
            HttpURLConnection conectar = (HttpURLConnection) objeto.openConnection();
            BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(conectar.getInputStream()));
            String linhaentrada;
            StringBuffer respostaString = new StringBuffer();

            while ((linhaentrada = entrada.readLine()) != null) {
                respostaString.append(linhaentrada);
            }
            //String volt = respostaString.toString();
            // System.out.println(respostaString.toString());
            JSONArray arrayJson = new JSONArray(respostaString.toString());
            //int number = arrayJson.getJSONObject(1).getInt("id");

            //Integer soma =  arrayJson.getJSONObject(1).getInt("id") + arrayJson.getJSONObject(0).getInt("id");

            /*int index = 0;
            JSONObject posicao = new JSONObject();
            while (posicao != null) {
                String num = arrayJson.getJSONObject(index).getString("id");
                System.out.println(num);
                index++;
                posicao = arrayJson.getJSONObject(index);
            }*/

            int teste = arrayJson.getJSONObject(1).getInt("id");
            //String teste = respostaString.toString();
            render(teste);

        } catch (Exception e) {

        }


    }


}