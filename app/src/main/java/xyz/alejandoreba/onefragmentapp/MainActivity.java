package xyz.alejandoreba.onefragmentapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        MapFragment mapFragment = (MapFragment)getFragmentManager().findFragmentById(R.id.mapFragment);
        if(item.getItemId() == R.id.london) {
            mapFragment.setPosition(51.51,-0.1);
            return true;
        }else if (item.getItemId() == R.id.paris){
            mapFragment.setPosition(48.85, 2.34);
            return true;
        }else if (item.getItemId() == R.id.newyork){
            mapFragment.setPosition(40.75,-74.0);
            return true;

        }
        return false;
    }
}
