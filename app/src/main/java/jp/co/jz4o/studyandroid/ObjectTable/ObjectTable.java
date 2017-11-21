package jp.co.jz4o.studyandroid.ObjectTable;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

import jp.co.jz4o.studyandroid.R;

/**
 * オブジェクトを元に表示可能なテーブル.
 */
public class ObjectTable extends TableLayout {
    /**
     * テーブルに表示するオブジェクトのリスト.
     */
    private ArrayList<Student> studentList;

    /**
     * 行をタップしたときの処理.
     */
    private OnClickListener rowClickListener;

    /**
     * レイアウトファイルを読み込む.
     */
    private LayoutInflater inflater;

    /**
     * コンストラクタ.
     *
     * @param context 呼び出し元のアクティビティ
     */
    public ObjectTable(final Context context) {
        super(context);
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * コンストラクタ.
     *
     * @param context 呼び出し元のアクティビティ
     * @param attrs   スタイル
     */
    public ObjectTable(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * 行の元となる生徒インスタンスのリストをセットします.
     *
     * @param list 行の元となる生徒インスタンスのリスト
     */
    public final void setStudentList(final ArrayList<Student> list) {
        removeAllViews();

        studentList = list;
        for (Student student : list) {
            addRow(student);
        }
    }

    /**
     * テーブルに行を追加します.
     *
     * @param student 行の元となる生徒インスタンス
     */
    public final void addStudent(final Student student) {
        studentList.add(student);
        addRow(student);
    }

    /**
     * 行の元となっている生徒インスタンスを返します.
     *
     * @param row 該当の行のView
     * @return 該当の行の生徒インスタンス
     */
    public Student getStudent(final TableRow row) {
        int index = indexOfChild(row);
        return studentList.get(index);
    }

    /**
     * 行を追加します.
     *
     * @param student 行の元となる生徒インスタンス
     */
    private void addRow(final Student student) {
        TableRow row = (TableRow) inflater.inflate(R.layout.activity_object_table_row, null);

        ((TextView) row.findViewById(R.id.column1)).setText(String.valueOf(student.getNumber()));
        ((TextView) row.findViewById(R.id.column2)).setText(student.getName());

        row.setOnClickListener(rowClickListener);

        addView(row);
    }

    /**
     * テーブルの行をタップしたときの処理をセットします.
     *
     * @param rowClickListener テーブルの行をタップしたときの処理
     */
    public final void setRowClickListener(final OnClickListener rowClickListener) {
        this.rowClickListener = rowClickListener;

        int rowCount = getChildCount();
        for (int index = 0; index < rowCount; index++) {
            TableRow row = (TableRow) getChildAt(index);
            row.setOnClickListener(rowClickListener);
        }
    }
}
