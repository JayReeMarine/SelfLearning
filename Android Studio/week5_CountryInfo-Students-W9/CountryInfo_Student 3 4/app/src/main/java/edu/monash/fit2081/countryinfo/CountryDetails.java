package edu.monash.fit2081.countryinfo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountryDetails extends AppCompatActivity {

    private TextView nameTV;
    private TextView capitalTV;
    private TextView codeTV;
    private TextView populationTV;
    private TextView areaTV;

    private TextView currenciesTv;
    private TextView languageTv;
    private ImageView countryLogo;

    private RequestQueue requestQueue;
    ExecutorService executor;
    Handler uiHandler;

    Button countryBtn;





    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_details);

        getSupportActionBar().setTitle(R.string.title_activity_country_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final String selectedCountry = getIntent().getStringExtra("country");

        nameTV = findViewById(R.id.country_name);
        capitalTV = findViewById(R.id.capital);
        codeTV = findViewById(R.id.country_code);
        populationTV = findViewById(R.id.population);
        areaTV = findViewById(R.id.area);

        currenciesTv = findViewById(R.id.currencies);
        languageTv = findViewById(R.id.languages);

        countryLogo = findViewById(R.id.flag);
        countryBtn = findViewById(R.id.wikiBtn);
        requestQueue = Volley.newRequestQueue(this);




        executor = Executors.newSingleThreadExecutor();
        //Executor handler = ContextCompat.getMainExecutor(this);
        uiHandler = new Handler(Looper.getMainLooper());
        jsonParse(selectedCountry);
    }


    private void jsonParse(String selectCountry) {
        String url = "https://restcountries.com/v2/name/"+selectCountry;
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    JSONObject countryObj = response.getJSONObject(0);
                    String  name = countryObj.getString("name");
                    String capital = countryObj.getString("capital");
                    String code2 = countryObj.getString("alpha2Code");
                    String code3 = countryObj.getString("alpha3Code");
                    int population = countryObj.getInt("population");
                    int area = countryObj.getInt("area");

                    nameTV.setText(name);
                    capitalTV.setText(capital);
                    codeTV.setText(code2);
                    populationTV.setText(population + "");
                    areaTV.setText(area + "");

                    //currency

                    JSONArray currencyArr = countryObj.getJSONArray("currencies");
                    StringBuilder currSb = new StringBuilder();
                    for(int i=0; i<currencyArr.length();i++){
                        JSONObject currObj = currencyArr.getJSONObject(i);
                        String currName = currObj.getString("name");
                        if(currSb.length()>0){
                            currSb.append(", ");
                        }
                        currSb.append(currName);
                    }
                    String currencies = currSb.toString();
                    currenciesTv.setText(currencies);


                    //language
                    JSONArray languageArr = countryObj.getJSONArray("languages");
                    StringBuilder lanSb = new StringBuilder();
                    for(int i=0; i<languageArr.length();i++){
                        JSONObject currObj = languageArr.getJSONObject(i);
                        String langNAme = currObj.getString("name");
                        if(lanSb.length()>0){
                            lanSb.append(", ");
                        }
                        lanSb.append(langNAme);
                    }
                    String languages = lanSb.toString();
                    languageTv.setText(languages);
//                    flagView(code2);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(request);
    }

    public void flagView(View v) {
//        String theDomain = domainTv.getText().toString();
        String request = "https://flagcdn.com/160x120/" + countryCode. toLowerCase() + "•png";
        //Bitmap myBitmap;


        executor.execute(() -> {
            // this code will run in the background
            try {

                java.net.URL url = new java.net.URL(request);
                HttpURLConnection connection = (HttpURLConnection) url
                        .openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream input = connection.getInputStream();

                Bitmap myBitmap = BitmapFactory.decodeStream(input);

                // now lets update the UI
                uiHandler.post(() -> {
                    countryLogo.setImageBitmap(myBitmap);
                });
            } catch (IOException e) {
                e.printStackTrace();
            }


        });
    }

}
