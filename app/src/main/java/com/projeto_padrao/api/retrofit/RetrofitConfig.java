package com.projeto_padrao.api.retrofit;

import com.projeto_padrao.api.servicos.RecomendacaoService;
import com.projeto_padrao.api.servicos.EventoService;
import com.projeto_padrao.api.servicos.RemedioService;
import com.projeto_padrao.api.servicos.TarefaService;
import com.projeto_padrao.api.servicos.UserService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.projeto_padrao.statics.ConstantesGlobais.ENDERECO_API;

public class RetrofitConfig {

    private Retrofit retrofit;

    public RetrofitConfig() {

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.level(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    //.addInterceptor(new ConnectivityInterceptor(context))
                    .build();

            this.retrofit = new Retrofit.Builder()
                    .baseUrl(ENDERECO_API)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }



    public UserService setUserService() {
        return this.retrofit.create(UserService.class);
    }

    public TarefaService setTarefaService() {
        return this.retrofit.create(TarefaService.class);
    }

    public EventoService setEventoService() {
        return this.retrofit.create(EventoService.class);
    }

    public RecomendacaoService setRecomendacaoService() {
        return this.retrofit.create(RecomendacaoService.class);
    }

    public RemedioService setRemedioService() {
        return this.retrofit.create(RemedioService.class);
    }



}
