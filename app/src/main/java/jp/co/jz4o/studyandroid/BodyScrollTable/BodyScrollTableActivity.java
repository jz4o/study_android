package jp.co.jz4o.studyandroid.BodyScrollTable;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import jp.co.jz4o.studyandroid.R;

/**
 * ボディ部だけスクロール可能なテーブル.
 */
public class BodyScrollTableActivity extends AppCompatActivity {
    /**
     * テーブル(ボディ部).
     */
    private TableLayout tableBody;

    /**
     * レイアウトファイルを読み込む.
     */
    private LayoutInflater inflater;

    @Override
    protected final void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_scroll_table);

        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        tableBody = (TableLayout) findViewById(R.id.table_body);

        addTableRow("カム1", "カラム2　　　1", "カラム3");
        addTableRow("カム1", "カラム2", "カラム3");
        addTableRow("カム1", "カラム2", "カラム3");
        addTableRow("カム1", "カラム2", "カラム3");
        addTableRow("カム1", "カラムーーーーーーーーーー2", "カラム3");
        final int rowSize = 50;
        for (int i = 0; i < rowSize; i++) {
            addTableRow("カム1", "カラム2", "カラム3");
        }
    }

    /**
     * テーブルに行を追加します.
     *
     * @param column1 1番目のカラム
     * @param column2 2番目のカラム
     * @param column3 3番目のカラム
     */
    private void addTableRow(final String column1, final String column2, final String column3) {
        TableRow row = (TableRow) inflater.inflate(R.layout.activity_body_scroll_table_table_row, null);

        ((TextView) row.findViewById(R.id.column1)).setText(column1);
        ((TextView) row.findViewById(R.id.column2)).setText(column2);
        ((TextView) row.findViewById(R.id.column3)).setText(column3);

        tableBody.addView(row);
    }
}
