package com.example.openlocateexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.openlocate.android.core.OpenLocate;

public class TrackingFragment extends Fragment {

    public static TrackingFragment getInstance() {
        return new TrackingFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tracking, null);

        Button startButton = (Button) view.findViewById(R.id.startbtn);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTracking();
                Toast.makeText(getActivity(), "Location Tracking Started", Toast.LENGTH_SHORT).show();

            }
        });

        Button stopButton = (Button) view.findViewById(R.id.stopbtn);
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopTracking();
                Toast.makeText(getActivity(), "Location Tracking Stopped", Toast.LENGTH_SHORT).show();

            }
        });


        return view;
    }


    private void startTracking() {
        OpenLocate.getInstance().startTracking(getActivity());
    }

    private void stopTracking() {
        OpenLocate.getInstance().stopTracking();
    }

}
