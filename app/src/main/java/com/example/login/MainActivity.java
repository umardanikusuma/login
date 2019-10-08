package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    public EditText editemail;
    public EditText editpass;
    public Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editemail = findViewById(R.id.et_email);
        editpass = findViewById(R.id.et_password);
        btn = findViewById(R.id.btn1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editemail.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "email  tidak boleh kosong", Toast.LENGTH_SHORT).show();
                } else if (editpass.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "password tidak boleh kosong", Toast.LENGTH_SHORT).show();
                } else {
                    AndroidNetworking.post("http://192.168.6.179/latihan/username.php")
                            .addBodyParameter("Email", editemail.getText().toString())
                            .addBodyParameter("Password", editpass.getText().toString())
                            .setPriority(Priority.MEDIUM)
                            .build()
                            .getAsJSONObject(new JSONObjectRequestListener() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    Toast.makeText(MainActivity.this, "sukses", Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onError(ANError error) {
                                    Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                                }
                            });
                }
            }
        });
//
    }
}
