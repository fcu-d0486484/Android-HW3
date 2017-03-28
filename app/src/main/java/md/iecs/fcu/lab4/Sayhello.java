package md.iecs.fcu.lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Sayhello extends AppCompatActivity {
    Button back;
    EditText output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sayhello_main);
        back=(Button)findViewById(R.id.bbt);
        output=(EditText)findViewById(R.id.name_input);
        back.setOnClickListener(backmain);
    }
    private View.OnClickListener backmain=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent backin=new Intent();
            backin.putExtra("backname",output.getText().toString());
            output.setText("");
            setResult(RESULT_OK,backin);
            finish();
        }
    };
}
