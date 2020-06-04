package com.example.thongtincanhan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtHoten, edtCmnd, edtBS;
    CheckBox ckbDB, ckbDS, ckbDC;
    RadioGroup radioButton;
    Button btnGui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtHoten = findViewById(R.id.edthoten);
        edtCmnd = findViewById(R.id.edtcmnd);
        edtBS = findViewById(R.id.edtttbs);
        btnGui = findViewById(R.id.btngui);
        ckbDB = findViewById(R.id.ckbdb);
        ckbDS = findViewById(R.id.ckbds);
        ckbDC = findViewById(R.id.ckbdc);
        radioButton = findViewById(R.id.radbangcap);
        btnGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showthongtin();
            }
        });

    }

    public void showthongtin() {
        if (kiemtraten() && kiemtracmnd() && kiemtrasothich()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Thông tin cá nhân");

            String hoten = edtHoten.getText().toString();
            String cmnd = edtCmnd.getText().toString();
            String ttbs = edtBS.getText().toString();
            builder.setMessage(hoten + "\n" + cmnd + "\n" + showbangcap() + "\n" + showsothich() + "\n--------------------------\n" + "Thông tin bổ sung:\n" + ttbs + "\n");
            builder.setNegativeButton("Đóng", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();

        }


    }
    public String showsothich() {
        String s = "";
        if (ckbDB.isChecked()) {
            s += "Đọc báo-";
        }
        if (ckbDS.isChecked()) {
            s += "Đọc sách-";
        }
        if (ckbDC.isChecked()) {
            s += "Đọc coding";
        }
        return s;

    }
    public String showbangcap() {
        String s = "";
        int ischeacked = radioButton.getCheckedRadioButtonId();
        switch (ischeacked) {
            case R.id.radtc: {
                s += "Trung Cấp";
                break;
            }
            case R.id.radcd: {
                s += "Cao Đẳng";
                break;
            }
            case R.id.raddh: {
                s += "Đại Học";
                break;
            }
            default: {
                s = "";
            }
        }
        return s;
    }

    public boolean kiemtraten() {
        String strkt = edtHoten.getText().toString();
        if (strkt.length() < 3) {
            Toast.makeText(MainActivity.this, "Họ tên phải có ít nhất 3 kí tự", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }

    }

    public boolean kiemtracmnd() {
        String strkt = edtCmnd.getText().toString();
        if (strkt.length() < 9) {
            Toast.makeText(MainActivity.this, "Chứng minh nhân dân phải có 9 chữ số", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }



    public boolean kiemtrasothich() {
        String s = "";
        if (ckbDB.isChecked() || ckbDS.isChecked() || ckbDC.isChecked()) { //kiem tra cho chon so thich khong
            s += "11";
        }
        if (s.equals("")) {
            Toast.makeText(MainActivity.this, "Phải chọn ít nhất 1 sở thích", Toast.LENGTH_SHORT).show();
            return false;
        } else return true;

    }
}
