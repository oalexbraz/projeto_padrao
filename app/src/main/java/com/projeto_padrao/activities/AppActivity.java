package com.projeto_padrao.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.projeto_padrao.R;
import com.projeto_padrao.models.Aplicacao;
import com.projeto_padrao.models.Usuario;

import java.util.ArrayList;
import java.util.List;

public class AppActivity extends AppCompatActivity {

    private Usuario usuario;
    private ListView listaDeGrupos;
    private View aplicacao_view_tarefas,aplicacao_view_usuarios;
    private View meusRemedios_view_remedios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aplicacao);



        usuario = Usuario.verificaUsuarioLogado();
        if (usuario != null) {
            usuario.setContext(AppActivity.this);
        }

        identificandoComponentes();
        inicializandoComponentes();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_item_logoff:
                fazerLogoff();
                return true;
            case R.id.menu_item_deletar_conta:
                usuario.deletarUsuario();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void fazerLogoff() {
        usuario.setLogado(false);
        usuario.save();
        Aplicacao.irParaListarLoginActivity(AppActivity.this);
    }

    private void identificandoComponentes() {
        aplicacao_view_tarefas = (View) findViewById(R.id.aplicacao_view_tarefas);
        aplicacao_view_usuarios = (View) findViewById(R.id.aplicacao_view_usuarios);
        meusRemedios_view_remedios = (View) findViewById(R.id.meusRemedios_view_remedios);



    }
    private void inicializandoComponentes() {
        aplicacao_view_tarefas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Aplicacao.irParaListarTarefaActivity(AppActivity.this);
            }
        });
        aplicacao_view_usuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Aplicacao.irParaListarUsuariosActivity(AppActivity.this);
            }
        });

        meusRemedios_view_remedios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Aplicacao.irParaRecomendacaoActivity(AppActivity.this);
            }
        });
    }


    @Override
    public void onBackPressed() {
        Aplicacao.fecharApp(AppActivity.this);

        super.onBackPressed();
    }
}