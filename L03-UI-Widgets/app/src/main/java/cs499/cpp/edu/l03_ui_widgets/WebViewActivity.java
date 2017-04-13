package cs499.cpp.edu.l03_ui_widgets;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by yusun on 4/10/17.
 */

public class WebViewActivity extends Activity {

    private EditText urlEditText;
    private Button goButton;
    private WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        webView = (WebView) findViewById(R.id.webView);

        urlEditText = (EditText) findViewById(R.id.urlEditText);
        goButton = (Button) findViewById(R.id.goButton);
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = urlEditText.getText().toString();
                if (!url.startsWith("http")) {
                    url = "http://" + url;
                }
                webView.loadUrl(url);
            }
        });

    }
}
