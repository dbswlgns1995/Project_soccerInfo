package com.example.project_soccerinfo.player;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_soccerinfo.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;


public class Frag_P_Premier extends Fragment {

    private View view;

    private RecyclerView recyclerView;
    private ArrayList<Player> arrayList = new ArrayList();

    public static Frag_P_Premier newInstance(){
        Frag_P_Premier frag_p_Premier = new Frag_P_Premier();
        return frag_p_Premier;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_player, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_player);

        new Task_p().execute();
        return view;
    }


    private class Task_p extends AsyncTask<Void, Void, Void>{

        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = new ProgressDialog(getContext());
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setMessage("로딩 중입니다.");
            progressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            try{
                Document doc = Jsoup.connect("https://sports.news.naver.com/wfootball/record/index.nhn?category=epl&year=2020&tab=player").get();
                Elements mElementData= doc.select("tbody").select("tr");

                int i = 1;

                for(Element element : mElementData){

                    String str = element.select("td").text();
                    String[] array = str.split(" ");
                    String rank = array[0];
                    String name = element.select("span.name").text();
                    String team = element.select("span.team").text();
                    String goal = array[array.length - 12];
                    String assist = array[array.length - 11];

                    Log.d("player",str);

                   arrayList.add(new Player(rank, name, team, goal,assist));
                }


            }catch(Exception e){
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            PlayerAdapter adapter = new PlayerAdapter(arrayList);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
            progressDialog.dismiss();
        }
    }
}
