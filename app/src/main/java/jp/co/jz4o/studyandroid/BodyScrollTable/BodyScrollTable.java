package jp.co.jz4o.studyandroid.BodyScrollTable;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.LinkedList;
import java.util.List;

import jp.co.jz4o.studyandroid.R;

/**
 * ボディ部のみスクロール可能なテーブル.
 */
public class BodyScrollTable extends LinearLayout {
    /**
     * テーブルの各カラムの幅を格納.
     */
    private List<Integer> colWidths;

    /**
     * コンストラクタ.
     *
     * @param context 呼び出し元のアクティビティ
     */
    public BodyScrollTable(final Context context) {
        super(context);
    }

    /**
     * コンストラクタ.
     *
     * @param context 呼び出し元のアクティビティ
     * @param attrs   スタイル
     */
    public BodyScrollTable(final Context context, @Nullable final AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected final void onMeasure(final int widthMeasureSpec, final int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected final void onLayout(final boolean changed, final int l, final int t, final int r, final int b) {
        super.onLayout(changed, l, t, r, b);

        colWidths = new LinkedList<Integer>();

        TableLayout header = (TableLayout) findViewById(R.id.table_header);
        TableLayout body = (TableLayout) findViewById(R.id.table_body);

        getColumnWidth(header);
        getColumnWidth(body);

        setColumnWidth(header);
        setColumnWidth(body);
    }

    /**
     * テーブルの各カラムの幅を取得し、リストに格納します.
     *
     * @param table 取得対象のテーブル
     */
    private void getColumnWidth(final TableLayout table) {
        if (table.getChildCount() > 0) {
            TableRow row = (TableRow) table.getChildAt(0);
            for (int cellnum = 0; cellnum < row.getChildCount(); cellnum++) {
                View cell = row.getChildAt(cellnum);
                TableRow.LayoutParams params = (TableRow.LayoutParams) cell.getLayoutParams();
                Integer cellWidth;
                if (params.span == 1) {
                    cellWidth = cell.getWidth();
                } else {
                    cellWidth = 0;
                }

                if (colWidths.size() <= cellnum) {
                    colWidths.add(cellWidth);
                } else {
                    Integer current = colWidths.get(cellnum);
                    if (cellWidth > current) {
                        colWidths.remove(cellnum);
                        colWidths.add(cellnum, cellWidth);
                    }
                }
            }
        }
    }

    /**
     * テーブルの各カラムの幅を設定します.
     *
     * @param table 設定対象のテーブル
     */
    private void setColumnWidth(final TableLayout table) {
        if (table.getChildCount() > 0) {
            TableRow row = (TableRow) table.getChildAt(0);
            for (int cellnum = 0; cellnum < row.getChildCount(); cellnum++) {
                View cell = row.getChildAt(cellnum);
                TableRow.LayoutParams params = (TableRow.LayoutParams) cell.getLayoutParams();
                params.width = 0;
                for (int span = 0; span < params.span; span++) {
                    params.width += colWidths.get(cellnum + span);
                }
            }
        }
    }
}
