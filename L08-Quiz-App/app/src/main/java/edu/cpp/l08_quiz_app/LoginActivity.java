package edu.cpp.l08_quiz_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yusun on 4/26/17.
 */

public class LoginActivity extends Activity {

    @BindView(R.id.nameEditText)
    EditText nameEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.loginButton)
    void loginButtonOnClick() {
        String name = nameEditText.getText().toString();
        if (!name.isEmpty()) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("username", name);
            startActivity(intent);
        }
    }
}
