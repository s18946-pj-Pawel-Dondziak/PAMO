package pl.pjwstk.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText ETPersonWeight;
    private EditText ETPersonHeight;

    //NOTE : age is irrelevant in BMI calculations
    //private EditText ETPersonAge;
    private Button BCalculate;
    private TextView BMIInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ETPersonWeight = findViewById(R.id.editTextTextPersonWeight);
        ETPersonHeight = findViewById(R.id.editTextTextPersonHeight);
        //ETPersonAge = findViewById(R.id.editTextTextPersonAge);
        BMIInfo = findViewById(R.id.textViewBMIInfo);
        BCalculate = findViewById(R.id.buttonCalculate);
        
        BCalculate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                CalCulateBMI();
            }
        });
    }

    private void CalCulateBMI() {
        float weight = Float.parseFloat(ETPersonWeight.getText().toString());
        float height = Float.parseFloat(ETPersonHeight.getText().toString());
        float bmi = (100*100*weight)/(height*height);

        BMIInfo.setText("Your BMI is: " + String.format("%.2f", bmi));
    }
}