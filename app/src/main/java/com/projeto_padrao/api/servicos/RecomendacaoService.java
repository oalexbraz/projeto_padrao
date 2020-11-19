package com.projeto_padrao.api.servicos;

import com.projeto_padrao.models.remedio.Recomendacao;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;


public interface RecomendacaoService {

    @GET("recomendacoes/")
    Call<List<Recomendacao>> listarRecomendacao(@Header("Authorization") String key);




}
