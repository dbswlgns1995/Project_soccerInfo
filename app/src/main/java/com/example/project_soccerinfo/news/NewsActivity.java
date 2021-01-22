package com.example.project_soccerinfo.news;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.project_soccerinfo.R;
import com.example.project_soccerinfo.Team.MainActivity;
import com.example.project_soccerinfo.player.PlayerActivity;
import com.google.android.material.navigation.NavigationView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class NewsActivity extends AppCompatActivity{

    private RecyclerView recyclerView;
    private ArrayList<News> arrayList = new ArrayList<>();

    Toolbar toolbar;
    private DrawerLayout mDrawerLayout;

    private long backBtnTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        // 액션바 설정
        toolbar = (Toolbar) findViewById(R.id.n_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false); // 기존 title 지우기
        actionBar.setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼 만들기
        actionBar.setHomeAsUpIndicator(R.drawable.menu); // 메뉴 아이콘

        mDrawerLayout = (DrawerLayout) findViewById(R.id.n_drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.n_nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                mDrawerLayout.closeDrawers();

                int id = menuItem.getItemId();
                String title = menuItem.getTitle().toString();

                if(id == R.id.item1){
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }
                else if(id == R.id.item2){
                    startActivity(new Intent(getApplicationContext(), PlayerActivity.class));
                    finish();
                }
                else if(id == R.id.item3){
                }
                return true;
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_news);


        Task_news task_news = new Task_news();
        task_news.execute();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ // 왼쪽 상단 버튼 눌렀을 때
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        long curTime = System.currentTimeMillis();
        long gapTime =  curTime - backBtnTime;

        if(0 <= gapTime && 2000 >= gapTime){
            super.onBackPressed();
        }
        else{
            backBtnTime = curTime;
            Toast.makeText(this, "한번 더 누르면 종료됩니다.",Toast.LENGTH_SHORT).show();
        }
    }



    private class Task_news extends AsyncTask<Void, Void, Void> {

        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = new ProgressDialog(NewsActivity.this);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setMessage("로딩 중입니다.");
            progressDialog.show();
        }


        @Override
        protected Void doInBackground(Void... voids) {

            try{
                Document doc = Jsoup.connect("https://news.joins.com/sports/worldsoccer/list/1?filter=All").get();
                Elements mElementData= doc.select("ul.type_b.clearfx").select("li");

                Log.d("html",mElementData.text());

                for(Element element : mElementData){

                    String img = element.select("img").attr("src");
                    String link = "https://news.joins.com" + element.select("h2.headline.mg > a").attr("href");
                    String title = element.select("h2.headline.mg").text();

                    Log.d("html",img + "\n" + link + "\n" + title);

                    arrayList.add(new News(img, link, title));
                }

            }catch(Exception e){
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            NewsAdapter adapter = new NewsAdapter(arrayList);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(NewsActivity.this);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
            progressDialog.dismiss();
        }
    }

}

