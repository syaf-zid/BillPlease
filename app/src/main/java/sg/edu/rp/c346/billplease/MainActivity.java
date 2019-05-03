package sg.edu.rp.c346.billplease;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    // Step 1: Declare the field variables
    EditText amountInput, paxInput;
    ToggleButton gstBtn, serviceBtn;
    TextView displayTotal, displayEach;
    Button splitBtn, resetBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Step 2: Link the field variables to UI components in layout
        amountInput = findViewById(R.id.editAmount);
        paxInput = findViewById(R.id.editPax);

        gstBtn = findViewById(R.id.toggleGST);
        serviceBtn = findViewById(R.id.toggleService);

        displayTotal = findViewById(R.id.displayTotal);
        displayEach = findViewById(R.id.displaySplit);

        splitBtn = findViewById(R.id.splitButton);
        resetBtn = findViewById(R.id.resetButton);



        splitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double amount = Double.parseDouble(amountInput.getText().toString());
                int pax = Integer.parseInt(paxInput.getText().toString());

                if(serviceBtn.isChecked()) {
                    amount = amount * 1.10;
                }

                if(gstBtn.isChecked()) {
                    amount = amount * 1.07;
                }

                double avg = amount / pax;
                displayTotal.setText("Total amount is $" + amount);
                displayEach.setText("Each pax pays $" + avg);
            }
        });
    }

}
