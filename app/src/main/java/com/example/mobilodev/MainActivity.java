package com.example.mobilodev;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextAmount;
    SeekBar seekBarTip;
    TextView textViewTipPercent, textViewTipAmount, textViewTotalAmount;
    Button buttonCalculate;

    int tipPercent = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextAmount = findViewById(R.id.editTextAmount);
        seekBarTip = findViewById(R.id.seekBarTip);
        textViewTipPercent = findViewById(R.id.textViewTipPercent);
        textViewTipAmount = findViewById(R.id.textViewTipAmount);
        textViewTotalAmount = findViewById(R.id.textViewTotalAmount);
        buttonCalculate = findViewById(R.id.buttonCalculate);

        seekBarTip.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tipPercent = progress;
                textViewTipPercent.setText("Bahşiş: " + tipPercent + "%");
            }

            @Override public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        buttonCalculate.setOnClickListener(v -> {
            String amountStr = editTextAmount.getText().toString();
            if (!amountStr.isEmpty()) {
                double amount = Double.parseDouble(amountStr);
                double tip = amount * tipPercent / 100.0;
                double total = amount + tip;

                textViewTipAmount.setText(String.format("Bahşiş Tutarı: ₺%.2f", tip));
                textViewTotalAmount.setText(String.format("Toplam: ₺%.2f", total));
            }
        });
    }
}
