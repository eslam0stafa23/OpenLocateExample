package com.example.openlocateexample;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.openlocate.android.core.OpenLocate;

public class TrackingFragment extends Fragment {


    private Button startButton;
    private Button stopButton;
    private TextView statues;

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

        startButton = (Button) view.findViewById(R.id.start_button);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTracking();
            }
        });

        stopButton = (Button) view.findViewById(R.id.stop_button);
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopTracking();
            }
        });

        statues = (TextView) view.findViewById(R.id.statues_label);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getActivity().setTitle(R.string.app_name);
    }

    private void startTracking() {
        OpenLocate.getInstance().startTracking(getActivity());
        startstatus();
        Toast.makeText(getContext(), "Location Tracking Started", Toast.LENGTH_LONG).show();
    }

    private void stopTracking() {
        OpenLocate.getInstance().stopTracking();
        stopstatues();
        Toast.makeText(getContext(), "Location Tracking Stopped", Toast.LENGTH_LONG).show();
    }

    private void startstatus(){
        statues.setText("Tracking....");

    }

    private void stopstatues(){
        statues.setText("Tracking Stopped");
    }
}