package com.jedisebas.aurebesh;

import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;

public class ScrollingActivity extends AppCompatActivity {

    EditText input, output;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        input = (EditText) findViewById(R.id.input);
        output = (EditText) findViewById(R.id.output);

        image = findViewById(R.id.imageView);
        image.setVisibility(View.GONE);
        
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Cleared text field", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                input.setText("");
                output.setText("");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_scrolling, menu);
        MenuItem menuItem = menu.findItem(R.id.myswitch);
        SwitchCompat aswitch = (SwitchCompat) menuItem.getActionView();
        aswitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                image.setVisibility(View.VISIBLE);
            }else {
                image.setVisibility(View.GONE);
            }
        });
        return true;
    }

    String change(String reple) {
        int i;
        String str = reple;
        for (i=0; i<str.length(); i++){
            switch (str.charAt(i)){
                case 'ś':
                    str = str.replace(str.charAt(i), 's');
                    break;
                case 'Ś':
                    str = str.replace(str.charAt(i), 'S');
                    break;
                case 'ć':
                    str = str.replace(str.charAt(i), 'c');
                    break;
                case 'Ć':
                    str = str.replace(str.charAt(i), 'C');
                    break;
                case 'ż':
                case 'ź':
                    str = str.replace(str.charAt(i), 'z');
                    break;
                case 'Ż':
                case 'Ź':
                    str = str.replace(str.charAt(i), 'Z');
                    break;
                case 'ł':
                    str = str.replace(str.charAt(i), 'l');
                    break;
                case 'Ł':
                    str = str.replace(str.charAt(i), 'L');
                    break;
                case 'ó':
                    str = str.replace(str.charAt(i), 'o');
                    break;
                case 'Ó':
                    str = str.replace(str.charAt(i), 'O');
                    break;
                case 'ę':
                    str = str.replace(str.charAt(i), 'e');
                    break;
                case 'Ę':
                    str = str.replace(str.charAt(i), 'E');
                    break;
                case 'ą':
                    str = str.replace(str.charAt(i), 'a');
                    break;
                case 'Ą':
                    str = str.replace(str.charAt(i), 'A');
                    break;
                case 'ń':
                    str = str.replace(str.charAt(i), 'n');
                    break;
                case 'Ń':
                    str = str.replace(str.charAt(i), 'N');
                    break;
            }
        }
        return str;
    }

    public void click(View view) {
        String in, out;
        in = input.getText().toString().trim();
        in = change(in);
        if (in.isEmpty()){
            out = output.getText().toString().trim();
            out = change(out);
            input.setText(out);
        }else {
            output.setText(in);
        }
    }

}
