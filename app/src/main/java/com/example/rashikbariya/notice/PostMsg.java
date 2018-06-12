package com.example.rashikbariya.notice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PostMsg extends AppCompatActivity{
    private EditText title, description;
    private Button post;
    private static final String URL = "https://b-rashik.000webhostapp.com/notice_console.php";
    private StringRequest request;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post);

        title = findViewById(R.id.ettitle);
        description = findViewById(R.id.etdescription);
        post = findViewById(R.id.btnPost);


        requestQueue = Volley.newRequestQueue(this);


        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            if(jsonObject.names().get(0).equals("success ")){
//                                Toast.makeText(getApplicationContext(), "SUCCESS"+jsonObject.getString("success"), Toast.LENGTH_SHORT).show();

                            }else {
                                Toast.makeText(PostMsg.this, "data posted", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),Welcome.class));
                            }
                        } catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        HashMap<String, String> hashMap = new HashMap<String, String>();
                        hashMap.put("title", title.getText().toString());
                        hashMap.put("description", description.getText().toString());
                        return hashMap;
                    }
                };
                requestQueue.add(request);
            }
        });



    }
}
