package com.projeto_padrao.api.servicos;

import com.projeto_padrao.models.Usuario;
import com.projeto_padrao.models.eventos.Evento;
import com.projeto_padrao.models.remedio.Recomendacao;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface EventoService {

    @POST("eventos/")
    Call<Evento> salvarEvento(@Body Evento evento,@Header("Authorization") String key);



}
