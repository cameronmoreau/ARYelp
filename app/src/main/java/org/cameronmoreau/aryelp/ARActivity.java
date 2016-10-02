package org.cameronmoreau.aryelp;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.beyondar.android.fragment.BeyondarFragment;
import com.beyondar.android.view.BeyondarViewAdapter;
import com.beyondar.android.view.OnClickBeyondarObjectListener;
import com.beyondar.android.world.BeyondarObject;
import com.beyondar.android.world.GeoObject;
import com.beyondar.android.world.World;

import java.util.ArrayList;

/**
 * Created by Cameron on 10/1/16.
 */

public class ARActivity extends AppCompatActivity implements OnClickBeyondarObjectListener {

    BeyondarFragment beyondar;
    World world;

    ArrayList<BeyondarObject> arItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.simple_camera);
        checkPermissions();

        arItems = new ArrayList<>();

        world = new World(this);
        world.setDefaultImage(R.mipmap.ic_food_light);
        world.setGeoPosition(30.612763, -96.340797);

        ARItemViewAdapter adapter = new ARItemViewAdapter(this);

        beyondar = (BeyondarFragment) getFragmentManager().findFragmentById(R.id.beyondarFragment);
        beyondar.setOnClickBeyondarObjectListener(this);
        beyondar.setBeyondarViewAdapter(adapter);
        beyondar.setWorld(world);
        beyondar.showFPS(true);

        addFakeItems();

        // Add items to world
        for(BeyondarObject item : arItems) {
            world.addBeyondarObject(item);
        }
    }

    void addFakeItems() {
        GeoObject go1 = new GeoObject(1);
        go1.setGeoPosition(30.612548, -96.340620);
        go1.setName("Starbucks");

        GeoObject go2 = new GeoObject(2);
        go2.setGeoPosition(30.612524, -96.340826);
        go2.setName("Canes");

        arItems.add(go1);
        arItems.add(go2);
    }

    void checkPermissions() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CAMERA)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CAMERA},
                        1);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.d("Permission accepted", permissions.toString());
    }

    @Override
    public void onClickBeyondarObject(ArrayList<BeyondarObject> arrayList) {
        Toast.makeText(this, "Clicked on " + arrayList.get(0).getName(), Toast.LENGTH_SHORT).show();
    }

    private class ARItemViewAdapter extends BeyondarViewAdapter {
        LayoutInflater inflater;

        public ARItemViewAdapter(Context context) {
            super(context);
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(BeyondarObject beyondarObject, View view, ViewGroup viewGroup) {
            view = inflater.inflate(R.layout.ar_item, null);

            TextView textView = (TextView) view.findViewById(R.id.tv_name);
            textView.setText(beyondarObject.getName());

            // Once the view is ready we specify the position
            setPosition(beyondarObject.getScreenPositionTopRight());

            return view;
        }
    }
}
