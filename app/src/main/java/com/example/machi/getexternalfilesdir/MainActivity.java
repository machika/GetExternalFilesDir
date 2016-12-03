package com.example.machi.getexternalfilesdir;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button mGetButton;
    private TextView mResultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mResultView = (TextView)findViewById(R.id.resultview);
        mGetButton = (Button)findViewById(R.id.getbutton);

        mGetButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == mGetButton.getId()) {
            mResultView.setText("");
            doCheck();
        }
    }

    private boolean doCheck() {
        Context appContext = getApplicationContext();
        Context activityContext = this;
        StringBuilder builder = new StringBuilder();

        //App context
        builder.append("External files dirs by application context: ¥n");
        File[] extDirArray = appContext.getExternalFilesDirs(null);
        int i = 0;
        for (File f : extDirArray) {
            builder.append(i + ": " + f.getAbsolutePath() + "¥n");
        }
        builder.append("¥n");

        //Activity context
        builder.append("External files dirs by activity context: ¥n");
        extDirArray = activityContext.getExternalFilesDirs(null);
        i = 0;
        for (File f : extDirArray) {
            builder.append(i + ": " + f.getAbsolutePath() + "¥n");
        }
        mResultView.setText(builder.toString());
        return true;
    }
}
