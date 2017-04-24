package xyz.alejandoreba.onefragmentapp;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

public class MapFragment extends Fragment{
    private MapView mv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.activity_map_fragment, parent);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        Activity activity = getActivity();
        // This line sets the user agent, a requirement to download OSM maps
        Configuration.getInstance().load(activity, PreferenceManager.getDefaultSharedPreferences(activity));
        mv = (MapView) getView().findViewById(R.id.map1);
        mv.getController().setZoom(12);
        mv.setBuiltInZoomControls(true);
    }

    public void setPosition(Double lat, Double lon)
    {
        mv.getController().setCenter(new GeoPoint(lat,lon));
        Toast.makeText(getActivity(), "Map setted to the new position", Toast.LENGTH_LONG).show();
    }
}
