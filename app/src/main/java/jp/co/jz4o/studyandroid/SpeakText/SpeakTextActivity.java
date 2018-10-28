package jp.co.jz4o.studyandroid.SpeakText;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

import jp.co.jz4o.studyandroid.R;

/**
 * テキスト読み上げ.
 */
public class SpeakTextActivity extends Activity {
    /**
     * 読み上げ機能.
     */
    private TextToSpeech speaker;

    /**
     * テキスト入力欄.
     */
    private EditText editText;

    @Override
    protected final void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speak_text);

        editText = (EditText) findViewById(R.id.edit_text);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(speakText);

        speaker = new TextToSpeech(this, speakerInit);
    }

    /**
     * 読み上げ機能初期化.
     */
    private TextToSpeech.OnInitListener speakerInit = new TextToSpeech.OnInitListener() {
        @Override
        public void onInit(final int status) {
            if (status == TextToSpeech.SUCCESS) {
                speaker.setLanguage(Locale.JAPANESE);
            }
        }
    };

    /**
     * 読み上げ処理.
     */
    private View.OnClickListener speakText = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {
            String text = editText.getText().toString();
            speaker.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        }
    };
}
