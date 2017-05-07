package com.gyulajuhasz.example.dangerousmulticatch;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private final Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final View testButton = findViewById(R.id.test_button);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    throwRandomException();
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                    Snackbar.make(testButton, "Exception caught", Snackbar.LENGTH_LONG).show();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                    Snackbar.make(testButton, "Exception caught", Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }

    private void throwRandomException() throws NoSuchFieldException, NoSuchMethodException {
        if (random.nextBoolean()) {
            throw new NoSuchFieldException("Catch me if you can!");
        } else {
            throw new NoSuchMethodException("Catch me if you can!");
        }
    }

}
