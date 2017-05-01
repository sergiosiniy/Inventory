package ua.kiev.farmaco.inventory.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import ua.kiev.farmaco.inventory.R;

/**
 * Author:  Serhii Synohub
 * Date:    01.05.2017
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button getNewTask = (Button) findViewById(R.id.get_new_task_button);
        getNewTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent getTaskFromSrv = new Intent(MainActivity.this,Task.class);
                startActivity(getTaskFromSrv);
            }
        });
    }

}
