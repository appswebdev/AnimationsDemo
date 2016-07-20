package college.edu.tomer.animationsdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Animation fadeIn;
    Animation move;
    private Button btnAnimate;
    private Animation rotate;
    private Animation zoomIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btnAnimate = (Button) findViewById(R.id.btnAnim);

        loadAnimations();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab != null)
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    animateButton();
                }
            });
    }

    private void loadAnimations() {
        fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        move = AnimationUtils.loadAnimation(this, R.anim.move);
        rotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        zoomIn = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
    }

    private void animateButton() {

        if (btnAnimate != null)
            btnAnimate.startAnimation(zoomIn);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
