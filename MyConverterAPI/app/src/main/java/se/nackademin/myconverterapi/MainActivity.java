package se.nackademin.myconverterapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    String input;
    String secondInput;

    String access = "API Loading";

    String noAccess = "No Fruits with that name";

    EditText editText;

    Button button;

    private TextView answerText;

    // deklarera api

    public static final String BPI_ENDPOINT = "https://jsonblob.com/api/684e8522-483e-11ea-a44d-2ff84279deb2";

    //importera och definiera okhttp

    private OkHttpClient okHttpClient = new OkHttpClient();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);

        button = (Button) findViewById(R.id.button);

        answerText = (TextView) findViewById(R.id.answerText);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                input = editText.getText().toString();

                run();

                //Toast.makeText(MainActivity.this, input, Toast.LENGTH_SHORT).show();


            }
        });


    }

    public void run() {
        if (input.equals("apple")) {
            Toast.makeText(MainActivity.this, access, Toast.LENGTH_SHORT).show();
            load();
            return;
        }

        if (input.equals("banana")) {
            Toast.makeText(MainActivity.this, access, Toast.LENGTH_SHORT).show();
            loadTwo();
            return;
        }

        if (input.equals("strawberry")) {
            Toast.makeText(MainActivity.this, access, Toast.LENGTH_SHORT).show();
            loadThree();
            return;
        }
        else {
            Toast.makeText(MainActivity.this, noAccess, Toast.LENGTH_SHORT).show();
        }


    }


    private void load() {
        Request request = new Request.Builder()
                // import okhttp request
                .url(BPI_ENDPOINT)
                // bpi_endpoint is declared constant adress to json
                .build();


        okHttpClient.newCall(request).enqueue(new Callback() {
            //import okhttp callback
            @Override
            public void onFailure(Call call, IOException e) {
                // import okhttp call
                // import ioexception?
                Toast.makeText(MainActivity.this, "Error during BPI loading : "
                        // import okhttp toast
                        + e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response)
                    throws IOException {
                final String body = response.body().string();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        parseBpiResponse(body);
                    }
                });
            }
        });
    }

    private void parseBpiResponse(String body) {
        try {
            StringBuilder builder = new StringBuilder();

            JSONObject jsonObject = new JSONObject(body);
            // import jsonobject?
            JSONObject timeObject = jsonObject.getJSONObject("lastupdate");
            builder.append(timeObject.getString("year")).append("\n\n");

            JSONObject bpiObject = jsonObject.getJSONObject("fruits");

            JSONObject appleObject = bpiObject.getJSONObject("apple");
            builder.append("Hello, our price for ").append(appleObject.getString("name")).append("\n");
            builder.append("is ").append(appleObject.getString("symbol"));
            builder.append(" ").append(appleObject.getString("price"));

            answerText.setText(builder.toString());

        } catch (Exception e) {

        }
    }
    private void loadTwo() {
        Request request = new Request.Builder()
                // import okhttp request
                .url(BPI_ENDPOINT)
                // bpi_endpoint is declared constant adress to json
                .build();


        okHttpClient.newCall(request).enqueue(new Callback() {
            //import okhttp callback
            @Override
            public void onFailure(Call call, IOException e) {
                // import okhttp call
                // import ioexception?
                Toast.makeText(MainActivity.this, "Error during BPI loading : "
                        // import okhttp toast
                        + e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response)
                    throws IOException {
                final String body = response.body().string();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        parseBpiResponseTwo(body);
                    }
                });
            }
        });
    }

    private void parseBpiResponseTwo(String body) {
        try {
            StringBuilder builder = new StringBuilder();

            JSONObject jsonObject = new JSONObject(body);
            // import jsonobject?
            JSONObject timeObject = jsonObject.getJSONObject("lastupdate");
            builder.append(timeObject.getString("year")).append("\n\n");

            JSONObject bpiObject = jsonObject.getJSONObject("fruits");

            JSONObject bananaObject = bpiObject.getJSONObject("banana");
            builder.append("Hello, our price for ").append(bananaObject.getString("name")).append("\n");
            builder.append("is ").append(bananaObject.getString("symbol"));
            builder.append(" ").append(bananaObject.getString("price"));

            answerText.setText(builder.toString());

        } catch (Exception e) {

        }
    }
    private void loadThree() {
        Request request = new Request.Builder()
                // import okhttp request
                .url(BPI_ENDPOINT)
                // bpi_endpoint is declared constant adress to json
                .build();


        okHttpClient.newCall(request).enqueue(new Callback() {
            //import okhttp callback
            @Override
            public void onFailure(Call call, IOException e) {
                // import okhttp call
                // import ioexception?
                Toast.makeText(MainActivity.this, "Error during BPI loading : "
                        // import okhttp toast
                        + e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response)
                    throws IOException {
                final String body = response.body().string();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        parseBpiResponseThree(body);
                    }
                });
            }
        });
    }

    private void parseBpiResponseThree(String body) {
        try {
            StringBuilder builder = new StringBuilder();

            JSONObject jsonObject = new JSONObject(body);
            // import jsonobject?
            JSONObject timeObject = jsonObject.getJSONObject("lastupdate");
            builder.append(timeObject.getString("year")).append("\n\n");

            JSONObject bpiObject = jsonObject.getJSONObject("fruits");

            JSONObject strawberryObject = bpiObject.getJSONObject("strawberry");
            builder.append("Hello, our price for ").append(strawberryObject.getString("name")).append("\n");
            builder.append("is ").append(strawberryObject.getString("symbol"));
            builder.append(" ").append(strawberryObject.getString("price"));

            answerText.setText(builder.toString());

        } catch (Exception e) {

        }
    }



























}
