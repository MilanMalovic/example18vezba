package rs.aleph.android.example17.activities;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.Toast;

import rs.aleph.android.example17.R;
import rs.aleph.android.example17.fragments.DetailFragment;
import rs.aleph.android.example17.fragments.MasterFragment;

// Each activity extends Activity class
public class FirstActivity extends Activity implements MasterFragment.OnItemSelectedListener {

	boolean landscape = false;

	// onCreate method is a lifecycle method called when he activity is starting
	@Override
	protected void onCreate(Bundle savedInstanceState) 	{

		// Each lifecycle method should call the method it overrides
		super.onCreate(savedInstanceState);

		// Shows a toast message (a pop-up message)
		Toast.makeText(getBaseContext(), "FirstActivity.onCreate()", Toast.LENGTH_SHORT).show();

		// Draws layout
		setContentView(R.layout.activity_first);

		// If the activity is started for the first time create master fragment
		if (savedInstanceState == null) {
			// FragmentTransaction is a set of changes (e.g. adding, removing and replacing fragments) that you want to perform at the same time.
			FragmentTransaction ft = getFragmentManager().beginTransaction();
			MasterFragment masterFragment = new MasterFragment();
			ft.add(R.id.master_view, masterFragment, "Master_Fragment_1");
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			ft.commit();
		}

		// If the device is in the landscape mode and the detail fragment is null create detail fragment
		if (findViewById(R.id.detail_view) != null) {
			landscape = true;
			getFragmentManager().popBackStack();

			DetailFragment detailFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.detail_view);
			if (detailFragment == null) {
				FragmentTransaction ft = getFragmentManager().beginTransaction();
				detailFragment = new DetailFragment();
				ft.replace(R.id.detail_view, detailFragment, "Detail_Fragment_1");
				ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
				ft.commit();
			}
		}
	}

	// onStart method is a lifecycle method called after onCreate (or after onRestart when the
	// activity had been stopped, but is now again being displayed to the user)
	@Override
	protected void onStart() {

		super.onStart();

		// Shows a toast message (a pop-up message)
		Toast.makeText(getBaseContext(), "FirstActivity.onStart()", Toast.LENGTH_SHORT).show();
	}

	// onRestart method is a lifecycle method called after onStop when the current activity is
	// being re-displayed to the user
	@Override
    protected void onRestart() {

		super.onRestart();

		// Shows a toast message (a pop-up message)
		Toast.makeText(getBaseContext(), "FirstActivity.onRestart()", Toast.LENGTH_SHORT).show();
    }

	// onResume method is a lifecycle method called after onRestoreInstanceState, onRestart, or
	// onPause, for your activity to start interacting with the user
	@Override
	protected void onResume() {

		super.onResume();

		// Shows a toast message (a pop-up message)
		Toast.makeText(getBaseContext(), "FirstActivity.onResume()", Toast.LENGTH_SHORT).show();
	}

	// onPause method is a lifecycle method called when an activity is going into the background,
	// but has not (yet) been killed
	@Override
	protected void onPause() {

		super.onPause();

		// Shows a toast message (a pop-up message)
		Toast.makeText(getBaseContext(), "FirstActivity.onPause()", Toast.LENGTH_SHORT).show();
	}

	// onStop method is a lifecycle method called when the activity are no longer visible to the user
	@Override
	protected void onStop() {

		super.onStop();

		// Shows a toast message (a pop-up message)
		Toast.makeText(getBaseContext(), "FirstActivity.onStop()", Toast.LENGTH_SHORT).show();
	}

	// onDestroy method is a lifecycle method that perform any final cleanup before an activity is destroyed
	@Override
	protected void onDestroy() {

		super.onDestroy();

		// Shows a toast message (a pop-up message)
		Toast.makeText(getBaseContext(), "FirstActivity.onDestroy()", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onItemSelected(int position) {

		// Shows a toast message (a pop-up message)
		Toast.makeText(getBaseContext(), "FirstActivity.onItemSelected()", Toast.LENGTH_SHORT).show();

		if (landscape) {
			// If the device is in the landscape mode updates detail fragment's content.
			DetailFragment detailFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.detail_view);
			detailFragment.updateContent(position);
		} else {
			// If the device is in the portrait mode sets detail fragment's content and replaces master fragment with detail fragment in a fragment transaction.
			DetailFragment detailFragment = new DetailFragment();
			detailFragment.setContent(position);
			FragmentTransaction ft = getFragmentManager().beginTransaction();
			ft.replace(R.id.master_view, detailFragment, "Detail_Fragment_2");
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			ft.addToBackStack(null);
			ft.commit();
		}
	}
}
