package jp.co.jz4o.studyandroid.ObjectTable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.ArrayList;

import jp.co.jz4o.studyandroid.R;

/**
 * オブジェクトのリストをテーブルで表示.
 */
public class ObjectTableActivity extends AppCompatActivity {
    /**
     * テーブル.
     */
    private ObjectTable objectTable;

    @Override
    protected final void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_table);

        String[] studentNames = {"一郎", "二郎", "三郎", "四郎", "五郎"};
        ArrayList<Student> students = new ArrayList<>();
        for (int num = 0; num < studentNames.length; num++) {
            students.add(new Student(num + 1, studentNames[num]));
        }

        objectTable = (ObjectTable) findViewById(R.id.object_table);
        objectTable.setStudentList(students);
        objectTable.setRowClickListener(showStudentName);
    }

    /**
     * テーブルから生徒を取得し、名前を表示します.
     */
    private View.OnClickListener showStudentName = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {
            Student student = objectTable.getStudent((TableRow) v);
            Toast.makeText(ObjectTableActivity.this, student.getName(), Toast.LENGTH_SHORT).show();
        }
    };
}
