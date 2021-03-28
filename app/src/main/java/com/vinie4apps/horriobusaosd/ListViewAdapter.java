package com.vinie4apps.horriobusaosd;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.vinie4apps.horriobusaosd.Linhas.Bairro_Boa_Vista;
import com.vinie4apps.horriobusaosd.Linhas.Bairro_da_Glória;
import com.vinie4apps.horriobusaosd.Linhas.Bairro_Vila_Esperança;
import com.vinie4apps.horriobusaosd.Linhas.Bairro_Santo_Antônio;
import com.vinie4apps.horriobusaosd.Linhas.Barra;
import com.vinie4apps.horriobusaosd.Linhas.Bairro_Capitão_Nestor;
import com.vinie4apps.horriobusaosd.Linhas.Bairro_de_Fátima;
import com.vinie4apps.horriobusaosd.Linhas.CAIC;
import com.vinie4apps.horriobusaosd.Linhas.Bairro_Córrego_do_Ouro;
import com.vinie4apps.horriobusaosd.Linhas.Bairro_Const_Horta;
import com.vinie4apps.horriobusaosd.Linhas.Campo_Alegre;
import com.vinie4apps.horriobusaosd.Linhas.Francesa;
import com.vinie4apps.horriobusaosd.Linhas.João_Calixto;
import com.vinie4apps.horriobusaosd.Linhas.Patrimônio_da_Serra;
import com.vinie4apps.horriobusaosd.Linhas.Perobas;
import com.vinie4apps.horriobusaosd.Linhas.Patrimônio_dos_Paiva;
import com.vinie4apps.horriobusaosd.Linhas.Rio_Pinho;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {


    Context mContext;
    LayoutInflater inflater;
    List<Model> modellist;
    ArrayList<Model> arrayList;


    public ListViewAdapter(Context context, List<Model> modellist) {
        mContext = context;
        this.modellist = modellist;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<Model>();
        this.arrayList.addAll(modellist);
    }

    public class ViewHolder{
        TextView mTitleTv;
        ImageView mIconIv;
    }

    @Override
    public int getCount() {
        return modellist.size();
    }

    @Override
    public Object getItem(int i) {
        return modellist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int postition, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view==null){
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.row, null);

            //locate the views in row.xml
            holder.mTitleTv = view.findViewById(R.id.linhas);
            holder.mIconIv = view.findViewById(R.id.corbus);


            view.setTag(holder);

        }
        else {
            holder = (ViewHolder)view.getTag();
        }

        holder.mTitleTv.setText(modellist.get(postition).getTitle());


        holder.mIconIv.setImageResource(modellist.get(postition).getIcon());


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (modellist.get(postition).getTitle().equals("Bairro Boa Vista")){
                    Intent intent = new Intent(mContext, Bairro_Boa_Vista.class);
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Bairro da Glória")){
                    Intent intent = new Intent(mContext, Bairro_da_Glória.class);
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Bairro Vila Esperança")){
                    Intent intent = new Intent(mContext, Bairro_Vila_Esperança.class);
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Bairro Santo Antônio")){
                    Intent intent = new Intent(mContext, Bairro_Santo_Antônio.class);
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Barra")){
                    Intent intent = new Intent(mContext, Barra.class);
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Bairro Capitão Nestor")){
                    Intent intent = new Intent(mContext, Bairro_Capitão_Nestor.class);
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Bairro de Fátima")){
                    Intent intent = new Intent(mContext, Bairro_de_Fátima.class);
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("CAIC")){
                    Intent intent = new Intent(mContext, CAIC.class);
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Bairro Córrego do Ouro")){
                    Intent intent = new Intent(mContext, Bairro_Córrego_do_Ouro.class);
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Bairro Const. Horta")){
                    Intent intent = new Intent(mContext, Bairro_Const_Horta.class);
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Campo Alegre")){
                    Intent intent = new Intent(mContext, Campo_Alegre.class);
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Francesa")){
                    Intent intent = new Intent(mContext, Francesa.class);
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Patrimônio da Serra")){
                    Intent intent = new Intent(mContext, Patrimônio_da_Serra.class);
                    mContext.startActivity(intent);
                }

                if (modellist.get(postition).getTitle().equals("Perobas")){
                    Intent intent = new Intent(mContext, Perobas.class);
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Patrimônio dos Paiva")){
                    Intent intent = new Intent(mContext, Patrimônio_dos_Paiva.class);
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Rio Pinho")){
                    Intent intent = new Intent(mContext, Rio_Pinho.class);
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("João Calixto")){
                    Intent intent = new Intent(mContext, João_Calixto.class);
                    mContext.startActivity(intent);
                }

                }
            });


        return view;
        }

                //filtro

        public void filter(String charText){
            charText = charText.toLowerCase(Locale.getDefault());
            modellist.clear();
            if (charText.length()==0){
                modellist.addAll(arrayList);
            }
            else {
                for (Model model : arrayList){
                    if (model.getTitle().toLowerCase(Locale.getDefault())
                            .contains(charText)){
                        modellist.add(model);
                    }
                }
            }
            notifyDataSetChanged();
        }

    }