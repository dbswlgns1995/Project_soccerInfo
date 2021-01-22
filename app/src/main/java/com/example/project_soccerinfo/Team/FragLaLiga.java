package com.example.project_soccerinfo.Team;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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

public class FragLaLiga extends Fragment {

    private View view;

    private RecyclerView recyclerView;
    private ArrayList<Team> list = new ArrayList();

    public static FragLaLiga newInstance(){
        FragLaLiga fragLaLiga = new FragLaLiga();
        return fragLaLiga;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_team, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_team);

        new Task_la().execute();

        return view;
    }

    private class Task_la extends AsyncTask<Void, Void, Void> {

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
                Document doc = Jsoup.connect("https://www.goal.com/kr/%ED%94%84%EB%A6%AC%EB%A9%94%EB%9D%BC-%EB%A6%AC%EA%B0%80/%EC%88%9C%EC%9C%84/34pl8szyvrbwcmfkuocjm3r6t").get();
                Elements mElementData= doc.select("tbody").select("tr");

                Log.d("html",mElementData.text());

                for(Element element : mElementData){
                    String rank = element.select("td").text();
                    int idx = rank.indexOf(" ");
                    rank = rank.substring(0, idx);
                    String team = element.select("span.p0c-competition-tables__team--full-name").text();
                    String played = element.select("td.p0c-competition-tables__matches-played").text();
                    String winpoint = element.select("td.p0c-competition-tables__pts").text();
                    String win = element.select("td.p0c-competition-tables__matches-won").text();
                    String draw = element.select("td.p0c-competition-tables__matches-drawn").text();
                    String lose = element.select("td.p0c-competition-tables__matches-lost").text();
                    String goal = element.select("td.p0c-competition-tables__goals-for").text();
                    String against = element.select("td.p0c-competition-tables__goals-against").text();

                    list.add(new Team(rank, team, played, winpoint, win, draw, lose, goal,against));


                }


            }catch(Exception e){
                Toast.makeText(getContext(), "서버 정보를 불러올 수 없습니다.", Toast.LENGTH_LONG);
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            TeamAdapter adapter = new TeamAdapter(list);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);

            progressDialog.dismiss();
        }
    }

}


