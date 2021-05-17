package sg.edu.rp.c346.id20019018.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button btnConfirm;
    Button btnReset;
    TimePicker tp;
    DatePicker dp;
    TextView tvName;
    TextView tvPhone;
    TextView tvSize;
    EditText etName;
    EditText etPhone;
    EditText etSize;
    CheckBox cbSmoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConfirm = findViewById(R.id.btnConfirm);
        btnReset = findViewById(R.id.btnReset);
        tp = findViewById(R.id.tp);
        dp = findViewById(R.id.dp);
        tvName = findViewById(R.id.tvName);
        tvPhone = findViewById(R.id.tvPhone);
        tvSize = findViewById(R.id.tvSize);
        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        etSize = findViewById(R.id.etSize);
        cbSmoke = findViewById(R.id.cbSmoke);

        dp.updateDate(2020,5,1);
        tp.setCurrentHour(19);
        tp.setCurrentMinute(30);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etName.getText().toString().trim().length() != 0 && etPhone.getText().toString().trim().length() != 0
                        && etSize.getText().toString().trim().length() != 0 )
                {
                    String name = etName.getText().toString();
                    int phone = Integer.parseInt(etPhone.getText().toString());
                    int size = Integer.parseInt(etSize.getText().toString());
                    int hour = tp.getCurrentHour();
                    int minute = tp.getCurrentMinute();
                    int day = dp.getDayOfMonth();
                    int month = dp.getMonth()+1;
                    int year = dp.getYear();
                    String table = "";
                    String output = "";

                    if(cbSmoke.isChecked())
                    {
                        table = "Smoking";
                    }
                    else
                    {
                        table = "Non-Smoking";
                    }
                    if(tp.getCurrentMinute() < 10 && (tp.getCurrentHour() == 0 || tp.getCurrentHour() < 10))
                    {
                        output += ("Name: " + name + "\nNumber: " + phone + "\nSize: " + size +
                                "\nTable: " + table +
                                "\nReservation Date: " + day + "/" + month + "/" + year +
                                "\nReservation Time: 0" + hour + ":0" + minute);
                    }
                    else if(tp.getCurrentMinute() < 10 && (tp.getCurrentHour() != 0 || tp.getCurrentHour() > 10))
                    {
                        output += ("Name: " + name + "\nNumber: " + phone + "\nSize: " + size +
                                "\nTable: " + table +
                                "\nReservation Date: " + day + "/" + month + "/" + year +
                                "\nReservation Time: " + hour + ":0" + minute);
                    }
                    else if(tp.getCurrentHour() == 0 || tp.getCurrentHour() < 10)
                    {
                        output += ("Name: " + name + "\nNumber: " + phone + "\nSize: " + size +
                                "\nTable: " + table +
                                "\nReservation Date: " + day + "/" + month + "/" + year +
                                "\nReservation Time: 0" + hour + ":" + minute);
                    }
                    else
                    {
                        output += ("Name: " + name + "\nNumber: " + phone + "\nSize: " + size +
                                "\nTable: " + table +
                                "\nReservation Date: " + day + "/" + month + "/" + year +
                                "\nReservation Time: " + hour + ":" + minute);
                    }
                    Toast.makeText(MainActivity.this, output , Toast.LENGTH_LONG).show();
                }
                else
                {
                    String output = "Error! Please Fill Up All Fields.";
                    Toast.makeText(MainActivity.this, output , Toast.LENGTH_LONG).show();
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dp.updateDate(2020,5,1);
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
                etName.setText("");
                etPhone.setText("");
                etSize.setText("");
                cbSmoke.setChecked(false);
            }
        });
    }
}