package idv.jimytc.tamagotji;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ViewSwitcher;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class TamagotJi extends AppCompatActivity {

    @InjectView(R.id.switcher)
    ViewSwitcher mViewSwitcher;
    @InjectView(R.id.input_email)
    EditText mInputEmail;
    @InjectView(R.id.input_password)
    EditText mInputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tamagot_ji);
        ButterKnife.inject(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tamagot_ji, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.login)
    public void switchToList() {
        String email = mInputEmail.getText().toString();
        String password = mInputPassword.getText().toString();
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Utils.showToast(this, "Must have valid email and password");
        } else {
            mViewSwitcher.showNext();
        }
    }
}
