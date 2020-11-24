package com.projeto_padrao.models;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.projeto_padrao.activities.AppActivity;
import com.projeto_padrao.activities.autenticacao.LoginActivity;
import com.projeto_padrao.activities.autenticacao.RegisterActivity;
import com.projeto_padrao.activities.remedio.NaoUsuarioActivity;
import com.projeto_padrao.activities.remedio.RecomendacaoActivity;
import com.projeto_padrao.activities.tarefa.ListarTarefasActivity;
import com.projeto_padrao.activities.usuario.ListarUsuariosActivity;
import com.projeto_padrao.activities.usuario.UsuarioDetalheActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Aplicacao {

    String currentDateTimeString = java.text.DateFormat.getDateTimeInstance().format(new Date());

    private Context context;
    private Class<?> activityDestino;

    public Aplicacao(Context context, Class<?> activityDestino) {
        this.context = context;
        this.activityDestino = activityDestino;
    }

    public static void aguardar(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Aplicacao(Context context) {
        this.context = context;
    }

    public static void irParaListarUsuariosActivity(Context context) {
        Intent intent = new Intent(context, ListarUsuariosActivity.class);
        context.startActivity(intent);
    }
    public static void irParaRecomendacaoActivity(Context context) {
        Intent intent = new Intent(context, RecomendacaoActivity.class);
        context.startActivity(intent);
    }
    public static void irParaListarLoginActivity(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }
    public static void irParaAppActivity(Context context) {
        Intent intent = new Intent(context, AppActivity.class);
        context.startActivity(intent);
    }
    public static void irParaRegisterActivity(Context context) {
        Intent intent = new Intent(context, RegisterActivity.class);
        context.startActivity(intent);
    }
    public static void irParaLoginActivity(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }
    public static void irParaNaoUsuarioActivity(Context context) {
        Intent intent = new Intent(context, NaoUsuarioActivity.class);
        context.startActivity(intent);
    }
    public static void irParaListarTarefaActivity(Context context) {
        Intent intent = new Intent(context, ListarTarefasActivity.class);
        context.startActivity(intent);
    }
    public static void irParaUsuarioDetalheActivity(Context context, Long id) {
        Intent intent = new Intent(context, UsuarioDetalheActivity.class);
        Bundle b = new Bundle();
        b.putLong("id", id);
        intent.putExtras(b);
        context.startActivity(intent);
    }

    public static String veritificarHorario() {

        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        Log.d("Testedata", "Data testada");


        return date;
    }


    public static void fecharApp(Context context) {
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(homeIntent);
    }
}
