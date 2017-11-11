package jp.co.jz4o.studyandroid.ObjectListView;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import jp.co.jz4o.studyandroid.R;

public class StudentAdapter extends BaseAdapter {
    private LayoutInflater inflater = null;
    private ArrayList<Student> students;

    public StudentAdapter(final Context context) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setStudents(final ArrayList<Student> students) {
        this.students = students;
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Student getItem(int position) {
        return students.get(position);
    }

    @Override
    public long getItemId(int position) {
        return students.get(position).getNumber();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.activity_object_list_view_list_item, parent, false);

        TextView studentNumber = (TextView) convertView.findViewById(R.id.student_number);
        studentNumber.setText(String.valueOf(students.get(position).getNumber()));

        return convertView;
    }
}
