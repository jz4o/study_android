package jp.co.jz4o.studyandroid.PartialTemplate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import jp.co.jz4o.studyandroid.R;

/**
 * レイアウトにて部分テンプレートを使用.
 */
public class PartialTemplateActivity extends AppCompatActivity {

    @Override
    protected final void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partial_template);
        PartialTemplateView view = new PartialTemplateView(this);

        view.setButton1OnClickListener(getButtonClickListener("button1"));
        view.setButton2OnClickListener(getButtonClickListener("button2"));
        view.setButton3OnClickListener(getButtonClickListener("button3"));
    }

    /**
     * ボタンをタップしたときの処理を返す.
     *
     * @param buttonName ボタン名
     * @return ボタンをタップしたときの処理
     */
    private View.OnClickListener getButtonClickListener(final String buttonName) {
        final String msg = buttonName + "がタップされました";
        return new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Toast.makeText(PartialTemplateActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        };
    }
}
