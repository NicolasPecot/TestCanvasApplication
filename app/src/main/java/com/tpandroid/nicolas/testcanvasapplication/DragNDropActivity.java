package com.tpandroid.nicolas.testcanvasapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class DragNDropActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_ndrop);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drag_ndrop, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_draw){
            // Créer une nouvelle activité pour le drag & drop
            Intent intent = new Intent(DragNDropActivity.this, DessinActivity.class);
            startActivity(intent);
        }
        return item.getItemId() != R.id.menu_dragdrop || super.onOptionsItemSelected(item);
    }
}
