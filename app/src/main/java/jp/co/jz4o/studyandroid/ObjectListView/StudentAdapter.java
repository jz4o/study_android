package jp.co.jz4o.studyandroid.ObjectListView;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import jp.co.jz4o.studyandroid.R;

/**
 * 生徒クラスをリスト表示するためのアダプター.
 */
public class StudentAdapter extends BaseAdapter {
    /**
     * レイアウトファイル取得用のInflater.
     */
    private LayoutInflater inflater = null;

    /**
     * 生徒クラスのリスト.
     */
    private ArrayList<Student> students;

    /**
     * コンストラクタ.
     *
     * @param context 呼び出し元のアクティビティ
     */
    public StudentAdapter(final Context context) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * 生徒クラスのリストをセットします.
     *
     * @param students 生徒クラスのリスト
     */
    public final void setStudents(final ArrayList<Student> students) {
        this.students = students;
    }

    @Override
    public final int getCount() {
        return students.size();
    }

    @Override
    public final Student getItem(final int position) {
        return students.get(position);
    }

    @Override
    public final long getItemId(final int position) {
        return students.get(position).getNumber();
    }

    @Override
    public final View getView(final int position, final View convertView, final ViewGroup parent) {
        View listItemView = inflater.inflate(R.layout.activity_object_list_view_list_item, parent, false);

        TextView studentNumber = (TextView) listItemView.findViewById(R.id.student_number);
        studentNumber.setText(String.valueOf(students.get(position).getNumber()));

        return listItemView;
    }
}
