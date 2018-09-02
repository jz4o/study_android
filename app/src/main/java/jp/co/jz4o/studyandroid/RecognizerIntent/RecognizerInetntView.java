package jp.co.jz4o.studyandroid.RecognizerIntent;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import jp.co.jz4o.studyandroid.R;

/**
 * 音声認識画面.
 */
public class RecognizerInetntView extends View {
    /**
     * 文字列表示領域.
     */
    private TextView textView;

    /**
     * 音声認識開始ボタン.
     */
    private Button button;

    /**
     * コンストラクタ.
     *
     * @param context 呼び出し元アクティビティ
     */
    public RecognizerInetntView(final Context context) {
        super(context);

        Activity activity = (Activity) context;

        textView = (TextView) activity.findViewById(R.id.textView);
        button = (Button) activity.findViewById(R.id.button);
    }

    /**
     * ボタンにタップしたときの処理を追加.
     *
     * @param listener タップしたときの処理
     */
    public void setButtonOnClickListener(final OnClickListener listener) {
        button.setOnClickListener(listener);
    }

    /**
     * 文字列を画面に表示します.
     *
     * @param text 文字列
     */
    public void setText(final String text) {
        textView.setText(text);
    }
}
