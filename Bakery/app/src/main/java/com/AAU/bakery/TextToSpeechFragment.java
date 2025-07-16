package com.AAU.bakery;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.Locale;
public class TextToSpeechFragment extends Fragment {
    EditText et_enter_your_text;
    SeekBar sb_pitch, sb_speed;
    Button btn_speak;
    TextToSpeech textToSpeech;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_text_to_speech, container, false);
        et_enter_your_text = view.findViewById(R.id.et_enter_your_text);
        sb_pitch = view.findViewById(R.id.sb_text_to_speech_pitch);
        sb_speed = view.findViewById(R.id.sb_text_to_speech_speed);
        btn_speak = view.findViewById(R.id.btn_text_to_speech_speak);

        btn_speak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speakText();
            }
        });
        textToSpeech = new TextToSpeech(getActivity(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = textToSpeech.setLanguage(Locale.US);
                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Toast.makeText(getActivity(), "Language is not supported", Toast.LENGTH_SHORT).show();
                    } else {
                        speakText();
                    }
                } else {
                    Toast.makeText(getActivity(), "Failed to initialised", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
    private void speakText() {
        String text = et_enter_your_text.getText().toString();
        float pitch = (float) sb_pitch.getProgress() / 50;
        if (pitch < 0.1) {
            pitch = 0.1f;
        }
        textToSpeech.setPitch(pitch);
        float speed = (float) sb_speed.getProgress() / 50;
        if (speed < 0.1) {
            speed = 0.1f;
        }
        textToSpeech.setSpeechRate(speed);
        if ("".equals(text)) {
            text = "Please enter some text to speak";
        }
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
    }
}