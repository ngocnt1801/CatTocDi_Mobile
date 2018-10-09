package day11.tiendat.day11_database;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MyPreferenceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_preference);
    }

    public void clickToLoad(View view) {
        Intent intent = new Intent(this, DatTTReferenceActivity.class);
        startActivity(intent);

    }

    public void clickToDisplay(View view) {
        SharedPreferences shared = getSharedPreferences("day11.tiendat.day11_database_preferences", MODE_PRIVATE);
        String result = shared.getString("edtPref", ""); // s : , s1: deafualt value
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }

    public void clickToModify(View view) {
        SharedPreferences shared = getSharedPreferences("day11.tiendat.day11_database_preferences", MODE_PRIVATE);
        EditText edtValue = findViewById(R.id.edtValue);
        SharedPreferences.Editor editor = shared.edit();
        editor.putString("edtPref", edtValue.getText().toString());
        editor.commit();
    }
}
