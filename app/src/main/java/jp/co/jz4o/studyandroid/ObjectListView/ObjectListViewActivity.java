package jp.co.jz4o.studyandroid.ObjectListView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import jp.co.jz4o.studyandroid.R;

public class ObjectListViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_list_view);

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "一郎"));
        students.add(new Student(2, "二郎"));
        students.add(new Student(3, "三郎"));
        students.add(new Student(4, "四郎"));
        students.add(new Student(5, "五郎"));

        StudentAdapter adapter = new StudentAdapter(this);
        adapter.setStudents(students);

        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(showStudentName);
    }

    /**
     * 選択した生徒の名前を表示します.
     */
    private AdapterView.OnItemClickListener showStudentName = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            StudentAdapter adapter = (StudentAdapter) parent.getAdapter();
            Student student = adapter.getItem(position);

            String msg = "出席番号" + student.getNumber() + "番は" + student.getName();
            Toast.makeText(ObjectListViewActivity.this, msg, Toast.LENGTH_SHORT).show();
        }
    };
}
