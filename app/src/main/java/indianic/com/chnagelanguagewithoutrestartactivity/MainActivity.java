package indianic.com.chnagelanguagewithoutrestartactivity;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvSelectedLanguageName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    //This method is for the initialization of the component
    private void initView() {
        final Button btnChina = (Button) findViewById(R.id.btn_china);
        final Button btnEnglish = (Button) findViewById(R.id.btn_english);
        final Button btnFrance = (Button) findViewById(R.id.btn_france);

        btnChina.setOnClickListener(this);
        btnEnglish.setOnClickListener(this);
        btnFrance.setOnClickListener(this);

        tvSelectedLanguageName = (TextView) findViewById(R.id.activity_name_selected_language_name);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_china:
                Configuration newConfig = new Configuration();
                newConfig.locale = Locale.CHINA;
                onConfigurationChanged(newConfig);
                break;

            case R.id.btn_english:
                Configuration newConfig1 = new Configuration();
                newConfig1.locale = Locale.ENGLISH;
                onConfigurationChanged(newConfig1);
                break;

            case R.id.btn_france:
                Configuration newConfig2 = new Configuration();
                newConfig2.locale = Locale.FRENCH;
                onConfigurationChanged(newConfig2);
                break;
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        getBaseContext().getResources().updateConfiguration(newConfig, getBaseContext().getResources().getDisplayMetrics());
        setContentView(R.layout.activity_main);
        initView();

        // Uncomment the below lines if you want to change the language through java

//        if (newConfig.locale == Locale.ENGLISH) {
//            tvSelectedLanguageName.setText(getString(R.string.language));
//        } else if (newConfig.locale == Locale.FRENCH) {
//            tvSelectedLanguageName.setText(getString(R.string.language));
//        } else if (newConfig.locale == Locale.CHINA) {
//            tvSelectedLanguageName.setText(getString(R.string.language));
//        }
    }
}
