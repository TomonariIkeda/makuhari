package com.example.wave;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends Activity {

	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
	
	String[] title = {"YOUNG BLOODZ @渋谷GAME","チームA劇場公演 - ライブ中継","スペイン語入門","HKT48 チームH 劇場公演中継","横浜竜王将棋研究会対局","若草歌舞伎「操り三番叟」解説","Perfume - 未来のミュージアム","映画 「下北すろうらいふ」 トークショー","Siriと会話してみた！","program10","program11","program12"};
	String[] info = {"勢い573  -   00:32/02:45","勢い573  -   00:32/02:45","勢い573  -   00:32/02:45","勢い573  -   00:32/02:45","勢い573  -   00:32/02:45","勢い573  -   00:32/02:45","勢い573  -   00:32/02:45","勢い573  -   00:32/02:45","勢い573  -   00:32/02:45","user10","user11","user12"};
	String[] user = {"user1","user2","user3","user4","user5","user6","user7","user8","user9","user10","user11","user12"};
	int[] img = {R.drawable.youtube_01, R.drawable.youtube_02, R.drawable.youtube_03, R.drawable.youtube_04, R.drawable.youtube_05, R.drawable.youtube_06, R.drawable.youtube_07, R.drawable.youtube_08, R.drawable.youtube_09};
	
	@SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Make sure we're running on Honeycomb or higher to use ActionBar APIs
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            // Show the Up button in the action bar.
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }
        
        ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
        
        for(int i=0; i<9; i++){
        	HashMap<String, String> temp = new HashMap<String, String>();
        	temp.put("key_title", title[i]);
        	temp.put("key_info", info[i]);
        	temp.put("key_user", user[i]);
        	temp.put("key_img", Integer.toString(img[i]));
        	
        	data.add(temp);
        }
        
        SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.item, new String[]{"key_title","key_info", "key_user", "key_img"},new int[]{R.id.title, R.id.info, R.id.user, R.id.imageView1});
        
        ListView varListView = (ListView)findViewById(R.id.listView1);
        varListView.setAdapter(adapter);
        
        OnItemClickListener itemClickListener = new OnItemClickListener(){
        	@Override
        	public void onItemClick(AdapterView<?> parent, View container, int position, long id){
        		
        		// Getting the Container Layout of the ListView
        		LinearLayout linearLayoutParent = (LinearLayout) container;
        		
        		LinearLayout linearLayoutChild = (LinearLayout) linearLayoutParent.getChildAt(1);
        		
        		TextView title = (TextView) linearLayoutChild.getChildAt(0);
        		
        		//Toast.makeText(getBaseContext(), title.getText().toString(), Toast.LENGTH_SHORT).show();
        		
        		Intent intent = new Intent(container.getContext(), PlayActivity.class);
        		intent.putExtra(EXTRA_MESSAGE, title.getText().toString());
        		startActivity(intent);
        	};
        };
        
        varListView.setOnItemClickListener(itemClickListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    

}
