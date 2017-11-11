package jp.co.jz4o.studyandroid.ObjectListView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import jp.co.jz4o.studyandroid.R;

/**
 * オブジェクトのリストをリストビューで表示.
 */
public class ObjectListViewActivity extends AppCompatActivity {
    @Override
    protected final void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_list_view);

        String[] studentNames = {"一郎", "二郎", "三郎", "四郎", "五郎"};
        ArrayList<Student> students = new ArrayList<>();
        for (int num = 0; num < studentNames.length; num++) {
            students.add(new Student(num + 1, studentNames[num]));
        }

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
        public void onItemClick(final AdapterView<?> parent, final View view, final int position, final long id) {
            StudentAdapter adapter = (StudentAdapter) parent.getAdapter();
            Student student = adapter.getItem(position);

            String msg = "出席番号" + student.getNumber() + "番は" + student.getName();
            Toast.makeText(ObjectListViewActivity.this, msg, Toast.LENGTH_SHORT).show();
        }
    };
}
