package md.iecs.fcu.lab4;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        submit =(Button)findViewById(R.id.sbt);
        submit.setOnClickListener(changetohello);
    }

    private static final int name_set=1;
    private View.OnClickListener changetohello=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent enterhello=new Intent();
            enterhello.setClass(MainActivity.this,Sayhello.class);
            startActivityForResult(enterhello,name_set);
        }
    };
    protected void onActivityResult(int requestcode,int resultcode,Intent backsth){
        if(backsth==null)
            return;
        switch (requestcode) {
            case name_set:
                Toast nameview = Toast.makeText(MainActivity.this,backsth.getStringExtra("backname"), Toast.LENGTH_SHORT);
                nameview.show();
        }
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
        if(id==R.id.wbbt){
            Uri google=Uri.parse("http://www.google.com.tw");
            Intent gwo = new Intent();
            gwo.setAction(Intent.ACTION_VIEW);
            gwo.setData(google);
            startActivity(gwo);
        }
        return super.onOptionsItemSelected(item);
    }
}
