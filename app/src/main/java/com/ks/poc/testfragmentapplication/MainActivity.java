package com.ks.poc.testfragmentapplication;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    // Prevent user press Back button to back the Fragment display.
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        //create a dialog to ask yes no question whether or not the user wants to exit
    }

    // Disable the Back button to avoid backing the fragment.
    @Override
    protected void onStart() {
        Toast.makeText(MainActivity.this, "MainActivity onStart", Toast.LENGTH_SHORT).show();
        super.onStart();
    }

    @Override
    protected void onResume() {
        Toast.makeText(MainActivity.this, "MainActivity onResume", Toast.LENGTH_SHORT).show();
        super.onResume();
    }

    @Override
    protected void onPause() {
        Toast.makeText(MainActivity.this, "MainActivity onPause", Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    @Override
    protected void onStop() {
        Toast.makeText(MainActivity.this, "MainActivity onStop", Toast.LENGTH_SHORT).show();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(MainActivity.this, "MainActivity onDestroy", Toast.LENGTH_SHORT).show();
        super.onDestroy();
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            finishAndRemoveTask();
//        }
    }

    @Override
    protected void onRestart() {
        Toast.makeText(MainActivity.this, "MainActivity onRestart", Toast.LENGTH_SHORT).show();
        super.onRestart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toast.makeText(MainActivity.this, "MainActivity onCreate", Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.fragment_container) != null) {

            Log.d("MainActivity","fragment_container existed.");
            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                Toast.makeText(MainActivity.this, "savedInstanceState != null", Toast.LENGTH_SHORT).show();
                return;
            }
            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            // Passing data to fragment
            Bundle bundle = new Bundle();
            bundle.putString("edttext", "From Activity");
            OneFragment oneFragment = new OneFragment();
            oneFragment.setArguments(bundle);

            // Add the fragment to the 'fragment_container' FrameLayout
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, oneFragment, "One");
            fragmentTransaction.addToBackStack("One");
            fragmentTransaction.commit();
            fragmentManager.executePendingTransactions();
            CompoundClass testObject = new CompoundClass(true,"initialzed",999,new Date());
            oneFragment.setTestObj(testObject);
            Toast.makeText(MainActivity.this, "OneFragment created (new one)", Toast.LENGTH_SHORT).show();
        } else {
            Log.d("MainActivity","fragment_container does NOT existed.");
            Toast.makeText(MainActivity.this, "fragment_container does NOT existed.", Toast.LENGTH_SHORT).show();
        }
    }

    public void oneButtonClicked(View view) {
        Log.d("MainActivity","Display View#1");
        if (findViewById(R.id.fragment_container) != null) {
            FragmentManager fragmentManager = getFragmentManager();
            OneFragment myFragment = (OneFragment) fragmentManager.findFragmentByTag("One");
            if (myFragment != null) {
                if (!myFragment.isVisible()) {
                    Toast.makeText(MainActivity.this, "OneFragment existed and visible. Reuse existing.", Toast.LENGTH_SHORT).show();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, myFragment, "One");
                    fragmentTransaction.addToBackStack("One");
                    fragmentTransaction.commit();
                    // THIS IS REQUIRED TO GET THE FRAGMENT TO APPLY IMMEDIATELY SO THAT THE SUBSEQUENT CHANGE ON UI COMPONENT CAN BE DONE
                    fragmentManager.executePendingTransactions();
                    // **********************************************************
                    myFragment.ev.setText("Changed to One...");
                    myFragment.displayObject();
                }
            } else {
                Toast.makeText(MainActivity.this, "OneFragment does not exist. Create new one.", Toast.LENGTH_SHORT).show();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                OneFragment fragment = new OneFragment();
                fragmentTransaction.replace(R.id.fragment_container, fragment, "One");
                fragmentTransaction.addToBackStack("One");
                fragmentTransaction.commit();
                // THIS IS REQUIRED TO GET THE FRAGMENT TO APPLY IMMEDIATELY SO THAT THE SUBSEQUENT CHANGE ON UI COMPONENT CAN BE DONE
                fragmentManager.executePendingTransactions();
                // **********************************************************
                fragment.ev.setText("Changed to One...");
                fragment.displayObject();
            }
        } else {
            Log.d("MainActivity","fragment_container does NOT existed.");
        }
    }

    public void twoButtonClicked(View view) {
        Log.d("MainActivity","Display View#2");
        if (findViewById(R.id.fragment_container) != null) {
            FragmentManager fragmentManager = getFragmentManager();
            TwoFragment myFragment = (TwoFragment)getFragmentManager().findFragmentByTag("Two");
            if (myFragment != null) {
                if (!myFragment.isVisible()) {
                    Toast.makeText(MainActivity.this, "TwoFragment existed and visible. Reuse existing.", Toast.LENGTH_SHORT).show();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, myFragment, "Two");
                    fragmentTransaction.addToBackStack("Two");
                    fragmentTransaction.commit();
                    fragmentManager.executePendingTransactions();
                }
            } else {
                Toast.makeText(MainActivity.this, "TwoFragment does not exist. Create new one.", Toast.LENGTH_SHORT).show();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new TwoFragment(), "Two");
                fragmentTransaction.addToBackStack("Two");
                fragmentTransaction.commit();
                fragmentManager.executePendingTransactions();
            }
        } else {
            Log.d("MainActivity","fragment_container does NOT existed.");
        }
        Configuration config = getResources().getConfiguration();
        Toast.makeText(MainActivity.this, "CONFIG: orientation -> " + config.orientation, Toast.LENGTH_SHORT).show();
    }

    public void threeButtonClicked(View view) {
        Log.d("MainActivity","Display View#3");
        if (findViewById(R.id.fragment_container) != null) {
            FragmentManager fragmentManager = getFragmentManager();
            ThreeFragment myFragment = (ThreeFragment)getFragmentManager().findFragmentByTag("Three");
            if (myFragment != null) {
                if (!myFragment.isVisible()) {
                    Toast.makeText(MainActivity.this, "ThreeFragment existed and visible. Reuse existing.", Toast.LENGTH_SHORT).show();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, myFragment, "Three");
                    fragmentTransaction.addToBackStack("Three");
                    fragmentTransaction.commit();
                    fragmentManager.executePendingTransactions();
                }
            } else {
                Toast.makeText(MainActivity.this, "ThreeFragment does not exist. Create new one.", Toast.LENGTH_SHORT).show();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new ThreeFragment(), "Three");
                fragmentTransaction.addToBackStack("Three");
                fragmentTransaction.commit();
                fragmentManager.executePendingTransactions();
            }
        } else {
            Log.d("MainActivity","fragment_container does NOT existed.");
        }
    }
}
