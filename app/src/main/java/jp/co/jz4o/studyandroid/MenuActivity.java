package jp.co.jz4o.studyandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class MenuActivity extends AppCompatActivity {
    //リストに表示する文字列及び遷移先
    private HashMap<String, Class> hashMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //リストに表示する文字列及び遷移先をHashMapに格納
        //hashMap.put("文字列", ExampleActivity.class);

        ArrayList<String> list = new ArrayList<>();
        for (String key : hashMap.keySet()) {
            list.add(key);
        }
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);

        ListView listView = (ListView) findViewById(R.id.menu_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(startNewActivity);
    }

    /**
     * タップしたリストアイテムに該当する遷移先に遷移.
     */
    private AdapterView.OnItemClickListener startNewActivity = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String key = (String) parent.getAdapter().getItem(position);
            Class klass = hashMap.get(key);

            Intent intent = new Intent(MenuActivity.this, klass);
            startActivity(intent);
        }
    };
}