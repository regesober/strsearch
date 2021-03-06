package sysemb.trabalho2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView t = (TextView) findViewById(R.id.textView);
        t.setText(test());
    }

    public static final String test() {
        String p = buildString(1000000, "41uiweh12frqwjrfwoie"); // Tamanho 20*1.000.000 = 20 M chars
        String t = buildString(20000000, "b"); // Tamanho 20.000.000*1 = 20 M chars
        char[] pattern = p.toCharArray();
        char[] text = t.toCharArray();
        StringBuilder sb = new StringBuilder();
        long a = System.nanoTime();
        StringSearchAlgorithms.RabinKarpMethod(pattern, text);
        a = System.nanoTime() - a;
        sb.append("RabinKarp: " + a/1000 + " us").append("\n");
        a = System.nanoTime();
        StringSearchAlgorithms.KnuthMorrisPrattSearch(pattern, text);
        a = System.nanoTime() - a;
        sb.append("KnuthMorrisPratt: " + a/1000 + " us").append("\n");
        a = System.nanoTime();
        StringSearchAlgorithms.BoyerMooreHorspoolSearch(pattern, text);
        a = System.nanoTime() - a;
        sb.append("BoyerMooreHorspool: " + a/1000 + " us").append("\n");
        return sb.toString();
    }

    public static final String buildString(int length, String c) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++){
            sb.append(c);
        }
        return sb.toString();
    }

}
