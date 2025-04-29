package com.example.mobilodev;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextTutar;
    SeekBar seekBarBahsis;
    TextView textViewBahsisYuzde, textViewBahsisTutari, textViewToplamTutar;
    Button hesaplaButonu;

    int bahsisYuzde = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTutar = findViewById(R.id.editTextTutar);
        seekBarBahsis = findViewById(R.id.seekBarBahsis);
        textViewBahsisYuzde = findViewById(R.id.textViewBahsisYuzde);
        textViewBahsisTutari = findViewById(R.id.textViewBahsisTutari);
        textViewToplamTutar = findViewById(R.id.textViewToplamTutar);
        hesaplaButonu = findViewById(R.id.hesaplaButonu);

        seekBarBahsis.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                bahsisYuzde = progress;
                textViewBahsisYuzde.setText("Bahşiş: " + bahsisYuzde + "%");
            }

            @Override public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        hesaplaButonu.setOnClickListener(v -> {
            String tutarStr = editTextTutar.getText().toString();
            if (!tutarStr.isEmpty()) {
                double tutar = Double.parseDouble(tutarStr);
                double bahsis = tutar * bahsisYuzde / 100.0;
                double toplam = tutar + bahsis;

                textViewBahsisTutari.setText(String.format("Bahşiş Tutarı: ₺%.2f", bahsis));
                textViewToplamTutar.setText(String.format("Toplam: ₺%.2f", toplam));
            }
        });
    }
}
