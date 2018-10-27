package jp.co.jz4o.studyandroid.InfiniteScroll;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import jp.co.jz4o.studyandroid.R;

/**
 * 無限スクロール.
 */
public class InfiniteScrollActivity extends Activity {
    /**
     * リストの最大表示数.
     */
    private final int listSize = 100;

    /**
     * 1度にリストに追加する最大数.
     */
    private final int addPerSize = 10;

    /**
     * ボタン.
     */
    private Button listClearButton;

    /**
     * リスト.
     */
    private ListView listView;

    /**
     * リストのアダプター.
     */
    private ArrayAdapter<String> adapter;

    /**
     * リストへの行追加時に表示するプログレスバー.
     */
    private View lodingView;

    @Override
    protected final void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infinite_scroll);

        listClearButton = (Button) findViewById(R.id.list_clear_button);
        listClearButton.setOnClickListener(listClear);

        listView = (ListView) findViewById(R.id.list_view);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        lodingView = getLayoutInflater().inflate(R.layout.activity_infinite_scroll_loading_view, null);

        listView.setAdapter(adapter);
        listView.setOnScrollListener(scrollListener);
    }

    /**
     * リスト初期化処理.
     */
    private View.OnClickListener listClear = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {
            adapter.clear();
        }
    };

    /**
     * スクロール時処理.
     */
    private AbsListView.OnScrollListener scrollListener = new AbsListView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(final AbsListView view, final int scrollState) {
        }

        @Override
        public void onScroll(final AbsListView view,
                             final int firstVisibleItem,
                             final int visibleItemCount,
                             final int totalItemCount) {
            if (totalItemCount == firstVisibleItem + visibleItemCount) {
                addRow();
            }
        }
    };

    /**
     * 行追加処理.
     */
    private void addRow() {
        new AsyncTask<Void, Void, ArrayList<String>>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                if (listView.getFooterViewsCount() == 0 && listView.getCount() < listSize) {
                    listView.addFooterView(lodingView);
                }
            }

            @Override
            protected ArrayList<String> doInBackground(final Void... voids) {
                try {
                    final int sleepTime = 1000;
                    Thread.sleep(sleepTime);
                } catch (Exception e) {
                }

                ArrayList<String> list = new ArrayList<>();
                int addSize = Math.min(addPerSize, listSize - (adapter.getCount() - listView.getFooterViewsCount()));
                for (int i = 1; i <= addSize; i++) {
                    list.add(Integer.toString(adapter.getCount() + i));
                }
                return list;
            }

            @Override
            protected void onPostExecute(final ArrayList<String> list) {
                super.onPostExecute(list);
                adapter.addAll(list);

                if (listSize <= listView.getCount()) {
                    listView.removeFooterView(lodingView);
                }
            }
        }.execute();
    }
}
