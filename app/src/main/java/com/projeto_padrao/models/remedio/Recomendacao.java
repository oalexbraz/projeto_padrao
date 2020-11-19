package com.projeto_padrao.models.remedio;

import android.content.Context;
import android.util.Log;
import android.widget.ListView;


import com.orm.SugarRecord;
import com.projeto_padrao.activities.remedio.RecomendacaoActivity;
import com.projeto_padrao.adapters.RecomendacaoAdpater;
import com.projeto_padrao.api.retrofit.RetrofitConfig;
import com.projeto_padrao.models.Usuario;


import org.jetbrains.annotations.NotNull;


import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Recomendacao extends SugarRecord {

    private Long remedio;
    private String intervalo;
    private Long usuario;
    private Date ultima_hora_que_tomou;
    private int quantidade_restante;
 

    public Date getUltima_hora_que_tomou() {
        return ultima_hora_que_tomou;
    }

    public void setUltima_hora_que_tomou(Date ultima_hora_que_tomou) {
        this.ultima_hora_que_tomou = ultima_hora_que_tomou;
    }

    public int getQuantidade_restante() {
        return quantidade_restante;
    }

    public void setQuantidade_restante(int quantidade_restante) {
        this.quantidade_restante = quantidade_restante;
    }

    public Long getUsuario() {
        return usuario;
    }



    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }

    //É OBRIGATÓRIO A CRIAÇÃO DE UM CONSTRUTOR VAZIO PARA SALVAR NO BANCO INTERNO
    public Recomendacao() {
    }


    public Recomendacao(Long remedio, String intervalo, Long usuario, Date ultima_hora_que_tomou, int quantidade_restante) {
        this.remedio = remedio;
        this.intervalo = intervalo;
        this.usuario = usuario;
        this.ultima_hora_que_tomou = ultima_hora_que_tomou;
        this.quantidade_restante = quantidade_restante;
    }

    public static void listarRecomendacaoRemoto(@NotNull Usuario usuario, ListView recomendacao_lista_listview, Context context) {
        Call<List<Recomendacao>> call = new RetrofitConfig().setRecomendacaoService().listarRecomendacao("Token " + usuario.getKey());
        call.enqueue(new Callback<List<Recomendacao>>() {
            @Override
            public void onResponse(Call<List<Recomendacao>> call, Response<List<Recomendacao>> response) {
                if (response.isSuccessful()) {
                    List<Recomendacao> recomendacaos = response.body();

                    if (recomendacaos != null){
                        for(Recomendacao recomendacao1: recomendacaos){
                            recomendacao1.save();
                        }
                    }


                    Log.d("listarRecomendacao", "listar");

                    RecomendacaoAdpater adaptador = new RecomendacaoAdpater( context, recomendacaos);
                    recomendacao_lista_listview.setAdapter(adaptador);


                }
            }

            @Override
            public void onFailure(Call<List<Recomendacao>> call, Throwable t) {
                Log.d("listarRecomendacao", "listar");

            }
        });

    }


    public List<Recomendacao> listarRecomendacaoDoBanco() {

        return Recomendacao.listAll(Recomendacao.class);

    }


    public int getQnt_comprimidos() {
        return qnt_comprimidos;
    }

    public void setQnt_comprimidos(int qnt_comprimidos) {
        this.qnt_comprimidos = qnt_comprimidos;
    }

    public String getHorario_tomei(Date date) {
       return null;
    }

    public String getHorario_inicial() {
        return horario_inicial;
    }

    public void setHorario_inicial(String horario_inicial) {
        this.horario_inicial = horario_inicial;
    }

    public String getPrxHorario() {
        return prxHorario;
    }

    public void setPrxHorario(String prxHorario) {
        this.prxHorario = prxHorario;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }




    public String getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(String intervalo) {
        this.intervalo = intervalo;
    }

    public int getDose() {
        return dose;
    }

    public void setDose(int dose) {
        this.dose = dose;
    }

    public Long getRemedio() {
        return remedio;
    }

    public void setRemedio(Long remedio) {
        this.remedio = remedio;
    }
}