package studio.attect.uiunitreference;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout container = findViewById(R.id.container);

        AppCompatTextView textViewFakeBold = findViewById(R.id.textview_fake_bold);
        textViewFakeBold.getPaint().setFakeBoldText(true);

        for (int i=1;i<=10;i++){
            generateDpBlock(container,i);
        }
        for (int i=10;i<=20;i++){
            generateDpBlock(container,i*2);
        }

        for (int i=20;i<=30;i++){
            generateDpBlock(container,i*4);
        }

        for (int i=40;i<=50;i++){
            generateDpBlock(container,i*5);
        }

        for (int i=50;i<=60;i++){
            generateDpBlock(container,i*8);
        }
        for (int i=60;i<=70;i++){
            generateDpBlock(container,i*9);
        }
    }

    private void generateDpBlock(LinearLayout container,int dp){
        View viewGroup = getLayoutInflater().inflate(R.layout.block_dp,container,false);
        View view = viewGroup.findViewById(R.id.view);
        view.getLayoutParams().width = dp(dp);
        AppCompatTextView name = viewGroup.findViewById(R.id.name);
        name.setText(String.format(getString(R.string.dp_text),dp));
        container.addView(viewGroup);
    }

    public int dp(float dp) {
        return (int) (dp *getResources().getDisplayMetrics().density + 0.5f);
    }
}
