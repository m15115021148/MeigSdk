package com.meigsmart.meigsdk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.meigsmart.meiglibs.install.RequestResult;
import com.meigsmart.meiglibs.install.SDKInit;


public class MainActivity extends AppCompatActivity {

    private SDKInit init;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init = new SDKInit();
        TextView tv = findViewById(R.id.tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login("865647027454869","en","info.e3phone.iPhone","华为4");
            }
        });
    }

    /**
     * 登录
     */
    private void login(String token,String lang,String bundle_id,String userName) {

        init.login(token, lang, bundle_id, userName, new RequestResult() {
            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onSuccess(Object object) {

            }
        });

    }
}
