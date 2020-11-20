package com.projeto_padrao.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.projeto_padrao.R;
import com.projeto_padrao.models.Aplicacao;
import com.projeto_padrao.models.Usuario;
import com.projeto_padrao.models.remedio.Recomendacao;
import com.projeto_padrao.models.remedio.Remedio;

import java.util.Calendar;
import java.util.List;

public class RecomendacaoAdpater extends BaseAdapter {


    Context context;
    List<Recomendacao> recomendacaos;
    private LayoutInflater mInflater;


    public RecomendacaoAdpater(Context context, List<Recomendacao> recomendacaos) {
        this.context = context;
        this.recomendacaos = recomendacaos;
    }

    @Override
    public int getCount() {
        return recomendacaos.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Recomendacao recomendacao = recomendacaos.get(position);
        Remedio meuRemedio = Remedio.findById(Remedio.class, recomendacao.getRemedio() );


        Usuario usuarioLogado = Usuario.verificaUsuarioLogado();

        if (usuarioLogado != null) {
            usuarioLogado.setKey(usuarioLogado.getKey());
            usuarioLogado.setId(usuarioLogado.getId());
        }

        final RecomendacaoAdpater.ListContent holder;
        View v = convertView;
        if (v == null) {
            mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = mInflater.inflate(R.layout.recomendacao_item_lista, null);


            holder = new RecomendacaoAdpater.ListContent();
            //View
            holder.recomendacao_item_view = (View) v.findViewById(R.id.recomendacao_item_view);
            holder.recomendacao_item_view2 = (View) v.findViewById(R.id.recomendacao_item_view2);
            //TextView
            holder.recomendacao_lista_texctView_nomeRemedio = (TextView) v.findViewById(R.id.recomendacao_lista_texctView_nomeRemedio);
            //holder.recomendacao_lista_texctView_dose = (TextView) v.findViewById(R.id.recomendacao_lista_texctView_dose)
            holder.recomendacao_lista_texctView_prxdose = (TextView) v.findViewById(R.id.recomendacao_lista_texctView_prxdose);
            holder.recomendacao_lista_texctView_dosesRestantes = (TextView) v.findViewById(R.id.recomendacao_lista_texctView_dosesRestantes);
            //Button
            holder.recomendacao_lista_button_tomar = (Button) v.findViewById(R.id.recomendacao_lista_button_tomar);

            // -----------------  Botão Tomar ------------------------ //
            holder.recomendacao_lista_button_tomar.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    holder.recomendacao_lista_texctView_prxdose.setText(String.valueOf());

                    //verificarHorario
                    //setarHorarioNaRecomendacao


                    recomendacao.editarRecomendacao(usuarioLogado.getKey());


                }
                // -----------------  Fim do Botão TOMAR ------------------------ //

            });


            v.setTag(holder);
        } else {
            holder = (RecomendacaoAdpater.ListContent) v.getTag();
        }
        //Nome do Rémedio
        if (meuRemedio != null){
            holder.recomendacao_lista_texctView_nomeRemedio.setText((meuRemedio.getNome() + " " + meuRemedio.getMg() + "mg"));

        }

        holder.recomendacao_lista_texctView_dosesRestantes.setText(String.valueOf("Faltam " + recomendacao.getQuantidade_restante() + " Doses"));

        return v;
    }


    public class ListContent {
        View recomendacao_item_view;
        TextView recomendacao_lista_texctView_nomeRemedio;
        TextView recomendacao_lista_texctView_Qntcomprimidos;
        TextView recomendacao_lista_texctView_prxdose;
        View recomendacao_item_view2;
        //TextView  recomendacao_lista_texctView_dose;
        TextView recomendacao_lista_button_tomar;
        TextView recomendacao_lista_texctView_dosesRestantes;

    }
}




