package br.amacedo.com.fitapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import br.amacedo.com.fitapp.models.Alimento;

/**
 * Created by AndersonMacedo on 17/05/2017.
 */

public class AlimentoHttp
{
    public static final String URLRAND = "https://api.myjson.com/bins/159yxt";


    public List<Alimento> alimentos;

    private static HttpsURLConnection connect(String endereco) throws IOException
    {

        URL url = new URL(endereco);
        HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();

        connection.setReadTimeout(10 * 1000);
        connection.setConnectTimeout(15 * 1000);
        connection.setRequestMethod("GET");
        connection.setDoInput(true);
        connection.setDoOutput(false);
        connection.connect();
        return connection;
    }

    public  void lerAlimentos() throws IOException, JSONException {
        HttpsURLConnection conexao = connect(URLRAND);

        int response = conexao.getResponseCode();

        if(response == HttpsURLConnection.HTTP_OK)
        {
            InputStream is = conexao.getInputStream();
            JSONObject json = new JSONObject(bytes2String(is));
            this.setAlimentos(lerAlimentoJson(json));
        }

    }

    public static List<Alimento> lerAlimentoJson(JSONObject json) throws JSONException {
        List<Alimento> alimentos = new ArrayList<>();


        JSONArray array = json.getJSONArray("alimento");

        for (int i = 0; i < array.length() ; i++)
        {
            JSONObject jsonAlimento = (JSONObject) array.get(i);

            Alimento alimento = new Alimento();
            alimento.setNome(jsonAlimento.getString("nome"));
            alimento.setCalorias(jsonAlimento.getInt("calorias"));
            alimento.setTipo(jsonAlimento.getString("tipo"));
            alimentos.add(alimento);
        }


        return alimentos;
    }

    private static String bytes2String(InputStream is) throws IOException {
        byte [] buffer = new byte[10 * 1024];
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        int lidos;

        while( (lidos = is.read(buffer)) != -1 )
        {
            out.write(buffer, 0, lidos);
        }

        return new String(out.toByteArray(), "UTF-8");
    }

    public List<Alimento> getAlimentos() {
        return alimentos;
    }

    public void setAlimentos(List<Alimento> alimentos) {
        this.alimentos = alimentos;
    }

}
