package jp.co.jz4o.studyandroid.RecognizerIntent;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;

import jp.co.jz4o.studyandroid.R;

/**
 * 音声認識を行う.
 */
public class RecognizerIntentActivity extends AppCompatActivity {
    /**
     * 音声認識画面.
     */
    private RecognizerInetntView view;

    /**
     * 音声認識を行う際の遷移に用いる識別コード.
     */
    private int recognizerSpeechRequestCode = 1;

    @Override
    protected final void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recognizer_intent);
        view = new RecognizerInetntView(this);

        view.setButtonOnClickListener(buttonClickListener);
    }

    /**
     * 音声認識を開始します.
     */
    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {
            speech();
        }
    };

    /**
     * 音声認識を行います.
     */
    private void speech() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_PREFER_OFFLINE, true);
        intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);

        try {
            startActivityForResult(intent, recognizerSpeechRequestCode);
        } catch (ActivityNotFoundException e) {
            view.setText("please check google app installed...");
        }
    }

    @Override
    protected final void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == recognizerSpeechRequestCode && resultCode == RESULT_OK) {
            // 認識結果を取得
            ArrayList<String> candidates = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            if (candidates.size() > 0) {
                // 認識結果から第1候補を画面に表示
                view.setText(candidates.get(0));
            }
        }
    }
}
