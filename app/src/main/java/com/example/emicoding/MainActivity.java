package com.example.emicoding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;
import java.lang.Math;

public class MainActivity extends AppCompatActivity {

    Map<Character,String> morseCodeMap= new HashMap<>();
    EditText input;
    Button button;
    TextView output;
    TextView entro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText) findViewById(R.id.input);
        button = (Button) findViewById(R.id.button);
        output = (TextView) findViewById(R.id.output);
        entro = (TextView) findViewById(R.id.entro);

        morseCodeMap.put('A',".-");
        morseCodeMap.put('B',"-...");
        morseCodeMap.put('C',"-.-.");
        morseCodeMap.put('D',"-..");
        morseCodeMap.put('E',".");
        morseCodeMap.put('F',"..-.");
        morseCodeMap.put('G',"--.");
        morseCodeMap.put('H',"....");
        morseCodeMap.put('I',"..");
        morseCodeMap.put('J',".---");
        morseCodeMap.put('K',"-.-");
        morseCodeMap.put('L',".-..");
        morseCodeMap.put('M',"--");
        morseCodeMap.put('N',"-.");
        morseCodeMap.put('O',"---");
        morseCodeMap.put('P',".--.");
        morseCodeMap.put('Q',"--.-");
        morseCodeMap.put('R',".-.");
        morseCodeMap.put('S',"...");
        morseCodeMap.put('T',"-");
        morseCodeMap.put('U',"..-");
        morseCodeMap.put('V',"...-");
        morseCodeMap.put('W',".--");
        morseCodeMap.put('X',"-..-");
        morseCodeMap.put('Y',"-.--");
        morseCodeMap.put('Z',"--..");
    }

    public void penis(View view){
        String text = getMorseCodeForString(input.getText().toString());
        String entropie = getEntropieFromText(input.getText().toString()).toString();
        output.setText(text);
        entro.setText("Entropie: " + entropie);
    }

    protected String getMorseCodeForString(String input){
        StringBuilder sb = new StringBuilder();
        input= input.toUpperCase();
        for(int i=0; i<input.length();i++){
            sb.append(morseCodeMap.get(input.charAt(i))+" ");
        }
         return sb.toString();
    }
    protected Double getEntropieFromText(String text){
        Map<Character,Integer> map = new HashMap<>();

        for(int i=0;i<text.length();i++) {
            char c = text.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        Double result=0.0;

        for (Integer value: map.values()){
            Double temp=(double)value/text.length();
            Double log= Math.log(temp);
            temp=temp*log;
            result+=temp ;
        }
    return result;
    }
}
