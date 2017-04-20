package edu.cpp.l05_http;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button getBusInfoButton;
    private TextView busInfoTextView;
    private ListView busListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);

        getBusInfoButton = (Button) findViewById(R.id.getBusInfoButton);
        busListView = (ListView) findViewById(R.id.busListView);



        final AsyncTask<Void, Void, Void> getBusInfoAsyncTask = new AsyncTask<Void, Void, Void>() {
            private StringBuilder textBuilder = new StringBuilder();
            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    URL url = new URL("https://broncoshuttle.com/Route/3164/Vehicles");
                    HttpURLConnection httpURLConnection =
                            (HttpURLConnection) url.openConnection();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try (Reader reader = new BufferedReader(new InputStreamReader
                            (inputStream, Charset.forName(StandardCharsets.UTF_8.name())))) {
                        int c = 0;
                        while ((c = reader.read()) != -1) {
                            textBuilder.append((char) c);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                String responseStr = textBuilder.toString();
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
                JavaType type = objectMapper.getTypeFactory().
                        constructCollectionType(List.class, RouteInfo.class);
                try {
                    List<RouteInfo> routes = objectMapper.readValue(responseStr, type);
                    ArrayAdapter<RouteInfo> arrayAdapter = new ArrayAdapter<RouteInfo>(MainActivity.this,android.R.layout.simple_list_item_1,routes);
                    busListView.setAdapter(arrayAdapter);

                    //busInfoTextView.setText(routes.get(0).getLatitude() + ", " + routes.get(0).getLongitude());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        getBusInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getBusInfoAsyncTask.execute();
            }
        });
    }
}
