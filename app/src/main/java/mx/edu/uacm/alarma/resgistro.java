package mx.edu.uacm.alarma;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class resgistro extends AppCompatActivity {

    private Button btnQr;

    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resgistro);
        btnQr =findViewById(R.id.btnqr);
        txt=findViewById(R.id.textView3);
        btnQr.setOnClickListener(mOnClickListener);


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null)
            if (result.getContents() != null){
                txt.setText("El código qr es:\n" + result.getContents());
            }else{
                txt.setText("Error al escanear el código qr");
            }
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnqr:
                    new IntentIntegrator(resgistro.this).initiateScan();
                    break;


            }
        }
    };
}
