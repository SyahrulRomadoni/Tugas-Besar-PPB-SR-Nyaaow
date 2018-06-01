package com.example.mrssr.bookingwarnetsr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivityListBooking extends AppCompatActivity {

//    private TextView txtpc, txttanggal;
    private RecyclerView lvhape;

    private RequestQueue requestQueue;
    private StringRequest stringRequest;

    ArrayList<HashMap<String, String>> list_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list_booking);

        String url = "http://192.168.42.68/android/nyaaow/tampil_list_booking.php"; // PC
//        String url = "http://192.168.43.122/android/nyaaow/tampil_list_booking.php"; // Laptop

        lvhape = (RecyclerView) findViewById(R.id.lvhape);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        lvhape.setLayoutManager(llm);

        requestQueue = Volley.newRequestQueue(MainActivityListBooking.this);

        list_data = new ArrayList<HashMap<String, String>>();

        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("response ", response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("booking");
                    for (int a = 0; a < jsonArray.length(); a++) {
                        JSONObject json = jsonArray.getJSONObject(a);
                        HashMap<String, String> map = new HashMap<String, String>();
                        map.put("pc", json.getString("booking_pc"));
                        map.put("tanggal", json.getString("tanggal_booking"));
                        list_data.add(map);
                        AdapterList adapter = new AdapterList(MainActivityListBooking.this, list_data);
                        lvhape.setAdapter(adapter);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivityListBooking.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(stringRequest);
    }

//        txtpc = (TextView) findViewById(R.id.pc);
//        txttanggal = (TextView) findViewById(R.id.tanggal);
//
//        requestQueue = Volley.newRequestQueue(MainActivityListBooking.this);
//
//        list_data = new ArrayList<HashMap<String, String>>();
//
//        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                try {
//                    JSONObject jsonObject = new JSONObject(response);
//                    JSONArray jsonArray = jsonObject.getJSONArray("booking");
//                    for (int a = 0; a < jsonArray.length(); a ++){
//                        JSONObject json = jsonArray.getJSONObject(a);
//                        HashMap<String, String> map  = new HashMap<String, String>();
//                        map.put("pc", json.getString("booking_pc"));
//                        map.put("tanggal", json.getString("tanggal_booking"));
//                        list_data.add(map);
//                    }
//                    txtpc.setText(list_data.get(0).get("pc"));
//                    txttanggal.setText(list_data.get(0).get("tanggal"));
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(MainActivityListBooking.this, error.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        requestQueue.add(stringRequest);
//    }
}
