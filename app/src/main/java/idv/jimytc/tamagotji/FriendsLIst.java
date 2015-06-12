package idv.jimytc.tamagotji;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.koushikdutta.ion.Ion;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by jimytc on 6/12/15.
 */
public class FriendsLIst extends Activity {
    @InjectView(R.id.gif_fr1)
    ImageView mFr1;

    @InjectView(R.id.gif_fr2)
    ImageView mFr2;

    @InjectView(R.id.gif_fr3)
    ImageView mFr3;

    @InjectView(R.id.gif_fr4)
    ImageView mFr4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_list);
        ButterKnife.inject(this);
        Ion.with(mFr1).load("android.resource://" + getPackageName() + "/" + R.drawable.g1);
        Ion.with(mFr2).load("android.resource://" + getPackageName() + "/" + R.drawable.g2);
        Ion.with(mFr3).load("android.resource://" + getPackageName() + "/" + R.drawable.g2);
        Ion.with(mFr4).load("android.resource://" + getPackageName() + "/" + R.drawable.g1);
    }
}
