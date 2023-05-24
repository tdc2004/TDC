package com.chinhtd.asssignmentgd1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dangnhap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);
        Spinner spinner = findViewById(R.id.sp);
        List<String> items = Arrays.asList("Việt Nam - Tiếng Việt", "Singapore - English");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        TextInputEditText txtUser = findViewById(R.id.tk_dn);
        TextInputEditText txtPass = findViewById(R.id.mk_dn);

        Button btn_dn = findViewById(R.id.btnDN);
        btn_dn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tk = txtUser.getText().toString();
                String mk = txtPass.getText().toString();
                if(tk.equals("tongdoanhchinh204") && mk.equals("2011")){
                    Intent intent = new Intent(getApplicationContext(), quanLyNhanSu.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(dangnhap.this, "Tài khoản hoặc mật khẩu không chính xác", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Button btn = findViewById(R.id.btnDK);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),dangki.class);
                startActivity(intent);
            }
        });
        TextInputEditText edtUsername = findViewById(R.id.tk_dn);
        TextInputEditText edtPassword = findViewById(R.id.mk_dn);

        String sUserName = getIntent().getStringExtra(dangki.KEY_USERNAME);
        String sPassword = getIntent().getStringExtra(dangki.KEY_PASSWORD);

        edtUsername.setText(sUserName);
        edtPassword.setText(sPassword);

        String number = getIntent().getStringExtra("thongBao");
        Toast.makeText(this, number + "", Toast.LENGTH_SHORT).show();

    }
}