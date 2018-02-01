package rs.aleph.android.example17.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import rs.aleph.android.example17.R;
import rs.aleph.android.example17.providers.FruitProvider;

// Each Fragment extends Fragment class
public class MasterFragment extends Fragment {

    // Container activity must implement this interface
    public interface OnItemSelectedListener {

        public void onItemSelected(int position);
    }

    OnItemSelectedListener listener;

    // onAttach method is a life-cycle method that is called when a fragment is first attached to its context.
    @Override
    public void onAttach(Activity activity) {

        super.onAttach(activity);

        // Shows a toast message (a pop-up message)
        Toast.makeText(getActivity(), "MasterFragment.onAttach()", Toast.LENGTH_SHORT).show();

        try {
            listener = (OnItemSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnItemSelectedListener");
        }
    }

    // onCreate method is a life-cycle method that is called when creating the fragment.
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Shows a toast message (a pop-up message)
        Toast.makeText(getActivity(), "MasterFragment.onCreate()", Toast.LENGTH_SHORT).show();
    }

    // onCreateView method is a life-cycle method that is called to have the fragment instantiate its user interface view.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Shows a toast message (a pop-up message)
        Toast.makeText(getActivity(), "MasterFragment.onCreateView()", Toast.LENGTH_SHORT).show();

        if (container == null) {
            return null;
        }

        View view = inflater.inflate(R.layout.fragment_master, container, false);

        return view;
    }

    // onActivityCreated method is a life-cycle method that is called when the fragment's activity has been created and this fragment's view hierarchy instantiated.
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        // Shows a toast message (a pop-up message)
        Toast.makeText(getActivity(), "MasterFragment.onActivityCreated()", Toast.LENGTH_SHORT).show();

        // Loads fruits from array resource
        final List<String> fruitNames = FruitProvider.getFruitNames();

        // Creates an ArrayAdaptar from the array of String
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item, fruitNames);
        ListView listView = (ListView) getActivity().findViewById(R.id.listofFruits);

        // Assigns ArrayAdaptar to ListView
        listView.setAdapter(dataAdapter);

        // Updates DetailFragment
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listener.onItemSelected(position);
            }
        });

    }

    // onStart method is a life-cycle method that is called when the Fragment is visible to the user.
    @Override
    public void onStart() {
        super.onStart();

        // Shows a toast message (a pop-up message)
        Toast.makeText(getActivity(), "MasterFragment.onStart()", Toast.LENGTH_SHORT).show();
    }

    // onResume method is a life-cycle method that is called when the fragment is visible to the user and actively running.
    @Override
    public void onResume() {
        super.onResume();

        // Shows a toast message (a pop-up message)
        Toast.makeText(getActivity(), "MasterFragment.onResume()", Toast.LENGTH_SHORT).show();
    }

    // onPause method is a life-cycle method that is called when the Fragment is no longer resumed.
    @Override
    public void onPause() {
        super.onPause();

        // Shows a toast message (a pop-up message)
        Toast.makeText(getActivity(), "MasterFragment.onPause()", Toast.LENGTH_SHORT).show();
    }

    // onStop method is a life-cycle method that is called when the Fragment is no longer started.
    @Override
    public void onStop() {
        super.onStop();

        // Shows a toast message (a pop-up message)
        Toast.makeText(getActivity(), "MasterFragment.onStop()", Toast.LENGTH_SHORT).show();
    }

    // onDestroyView method is a life-cycle method that is called when the view previously created by onCreateView(LayoutInflater, ViewGroup, Bundle) has been detached from the fragment.
    @Override
    public void onDestroyView() {

        super.onDestroyView();

        // Shows a toast message (a pop-up message)
        Toast.makeText(getActivity(), "MasterFragment.onDestroyView()", Toast.LENGTH_SHORT).show();
    }

    // onDestroy method is a life-cycle method that is called when the fragment is no longer in use.
    @Override
    public void onDestroy() {
        super.onDestroy();

        // Shows a toast message (a pop-up message)
        Toast.makeText(getActivity(), "MasterFragment.onDestroy()", Toast.LENGTH_SHORT).show();
    }

    // onDetach method is a life-cycle method that is called when the fragment is no longer attached to its activity.
    @Override
    public void onDetach() {
        super.onDetach();

        // Shows a toast message (a pop-up message)
        Toast.makeText(getActivity(), "MasterFragment.onDetach()", Toast.LENGTH_SHORT).show();
    }

    // onSaveInstanceState method is a life-cycle method that is called to ask the fragment to save its current dynamic state, so it can later be reconstructed in a new instance of its process is restarted.
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);

        // Shows a toast message (a pop-up message)
        Toast.makeText(getActivity(), "MasterFragment.onSaveInstanceState()", Toast.LENGTH_SHORT).show();
    }

}