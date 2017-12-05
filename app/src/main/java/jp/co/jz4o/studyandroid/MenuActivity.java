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

import jp.co.jz4o.studyandroid.BodyScrollTable.BodyScrollTableActivity;
import jp.co.jz4o.studyandroid.ObjectListView.ObjectListViewActivity;
import jp.co.jz4o.studyandroid.ObjectTable.ObjectTableActivity;
import jp.co.jz4o.studyandroid.PartialTemplate.PartialTemplateActivity;

/**
 * メニュー画面.
 */
public class MenuActivity extends AppCompatActivity {
    /**
     * リストに表示する文字列及び遷移先.
     */
    private HashMap<String, Class> hashMap = new HashMap<>();

    @Override
    protected final void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //リストに表示する文字列及び遷移先をHashMapに格納
        //hashMap.put("文字列", ExampleActivity.class);
        hashMap.put("リストビューにオブジェクトを使用する", ObjectListViewActivity.class);
        hashMap.put("ボディ部のみスクロール可能なテーブル", BodyScrollTableActivity.class);
        hashMap.put("テーブルにオブジェクトを使用する", ObjectTableActivity.class);
        hashMap.put("部分テンプレートを使用する", PartialTemplateActivity.class);

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
        public void onItemClick(final AdapterView<?> parent, final View view, final int position, final long id) {
            String key = (String) parent.getAdapter().getItem(position);
            Class klass = hashMap.get(key);

            Intent intent = new Intent(MenuActivity.this, klass);
            startActivity(intent);
        }
    };
}
