package jp.co.jz4o.studyandroid.DynamicScreenTitle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import jp.co.jz4o.studyandroid.R;

/**
 * 画面タイトルを動的に設定する.
 */
public class DynamicScreenTitleActivity extends AppCompatActivity {

    @Override
    protected final void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_screen_title);

        // 画面の各要素を取得
        final EditText editText = (EditText) findViewById(R.id.editText);
        Button button = (Button) findViewById(R.id.button);

        // ボタンタップ時の処理
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                // テキスト入力欄の内容を画面タイトルに設定
                setTitle(editText.getText().toString());
            }
        });
    }
}
