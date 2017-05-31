package br.amacedo.com.fitapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import br.amacedo.com.fitapp.models.Alimento;

/**
 * Created by AndersonMacedo on 18/05/2017.
 */
public class BaixarAlimentos extends AsyncTask<Context, Void, List>
{

    private AlimentoActivity alimentoActivity;

    /**
     * Instantiates a new Baixar alimentos.
     *
     * @param alimentoActivity the alimento activity
     */
    BaixarAlimentos(AlimentoActivity alimentoActivity)
    {
        this.alimentoActivity = alimentoActivity;
    }

    /**
     * Realiza o download da mensagem de resposta em background
     * @param objects
     * @return
     */
    @Override
    protected List doInBackground(Context[] objects)
    {
        AlimentoHttp alimentoHttp = new AlimentoHttp();
        try {
            alimentoHttp.lerAlimentos();
            alimentoActivity.setAlimentos(alimentoHttp.getAlimentos());
            return alimentoHttp.getAlimentos();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

}
