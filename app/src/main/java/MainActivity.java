
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tilek_uulu_amanjanhw26.FragmentA;
import com.example.tilek_uulu_amanjanhw26.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.fragmentForContainer, new FragmentA()).commit();
    }
}


