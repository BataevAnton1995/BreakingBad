package com.breakingbad;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.breakingbad.data.managers.network.api.Registration;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;


public class MainActivity extends AppCompatActivity {
    private final String URL="http://91.225.109.172:7070";

    private EditText mMail;
    private EditText mPass;
    private Button mReg;
    private Gson gson = new GsonBuilder().create();
    private Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(URL)
            .build();

    private Registration intf = retrofit.create(Registration.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMail = (EditText) findViewById(R.id.mail);
        mPass = (EditText) findViewById(R.id.pass);
        mReg = (Button) findViewById(R.id.reg);


        mReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, String> mapJson = new HashMap<String, String>();
                mapJson.put("password", "qweqweqwe");
                mapJson.put("socialIdentifier", "native");
                mapJson.put("email", "25655qwe@mail.ru");

                String status = null;
                Call<Object> call = intf.regData(status, mapJson);
                System.out.println(intf.toString()+"<-Gson");
                try {
                    Response<Object> response = call.execute();
                    Map<String, String> map = gson.fromJson(response.body().toString(), Map.class);
                    for (Map.Entry e : map.entrySet()) {
                        System.out.println(e.getKey() + " " + e.getValue());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}