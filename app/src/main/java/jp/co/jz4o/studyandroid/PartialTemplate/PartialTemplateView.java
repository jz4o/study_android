package jp.co.jz4o.studyandroid.PartialTemplate;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;

import jp.co.jz4o.studyandroid.R;

/**
 * 部分テンプレート使用画面.
 */
public class PartialTemplateView extends View {
    /**
     * 各ボタン.
     */
    private Button button1, button2, button3;

    /**
     * コンストラクタ.
     *
     * @param context 呼び出し元のアクティビティ
     */
    public PartialTemplateView(final Context context) {
        super(context);

        Activity activity = (Activity) context;

        button1 = (Button) activity.findViewById(R.id.button1);
        button2 = (Button) activity.findViewById(R.id.button2);
        button3 = (Button) activity.findViewById(R.id.button3);
    }

    /**
     * ボタン1にタップしたときの処理を追加.
     *
     * @param listener タップしたときの処理
     */
    public void setButton1OnClickListener(final OnClickListener listener) {
        setButtonOnClickListener(button1, listener);
    }

    /**
     * ボタン2にタップしたときの処理を追加.
     *
     * @param listener タップしたときの処理
     */
    public void setButton2OnClickListener(final OnClickListener listener) {
        setButtonOnClickListener(button2, listener);
    }

    /**
     * ボタン3にタップしたときの処理を追加.
     *
     * @param listener タップしたときの処理
     */
    public void setButton3OnClickListener(final OnClickListener listener) {
        setButtonOnClickListener(button3, listener);
    }

    /**
     * ボタンにタップしたときの処理を追加.
     *
     * @param button   ボタン
     * @param listener タップしたときの処理
     */
    private void setButtonOnClickListener(final Button button, final OnClickListener listener) {
        button.setOnClickListener(listener);
    }
}
