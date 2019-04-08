package deepdive.cnm.edu.frontend_abqwifinder.controller;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import deepdive.cnm.edu.frontend_abqwifinder.AbqWifinderApplication;
import deepdive.cnm.edu.frontend_abqwifinder.R;
import deepdive.cnm.edu.frontend_abqwifinder.controller.dummy.DummyContent;
import deepdive.cnm.edu.frontend_abqwifinder.controller.dummy.DummyContent.DummyItem;

import deepdive.cnm.edu.frontend_abqwifinder.model.Location;
import deepdive.cnm.edu.frontend_abqwifinder.service.GoogleSignInService;
import deepdive.cnm.edu.frontend_abqwifinder.service.WiFinderBackendClient.InstanceHolder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Response;

/**
 * A fragment representing a list of Items. <p /> Activities containing this fragment MUST implement
 * the {@link OnListFragmentInteractionListener} interface.
 */
public class LocationListFragment extends Fragment {

  // TODO: Customize parameters
  private int mColumnCount = 1;

  private OnListFragmentInteractionListener mListener;
  private List<Location> locations;
  private RecyclerView view;
  private LocationRecyclerViewAdapter adapter;

  /**
   * Mandatory empty constructor for the fragment manager to instantiate the fragment (e.g. upon
   * screen orientation changes).
   */
  public LocationListFragment() {
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    view = (RecyclerView) inflater.inflate(R.layout.fragment_location_list, container, false);

    // Set the adapter
    if (view instanceof RecyclerView) {
      Context context = view.getContext();
      RecyclerView recyclerView = (RecyclerView) view;
      recyclerView.setLayoutManager(new LinearLayoutManager(context));

      locations = new ArrayList<>();
      adapter = new LocationRecyclerViewAdapter(locations, mListener);
      recyclerView.setAdapter(adapter);
      new LocationGetterTask().execute();
    }
    return view;
  }


  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    if (context instanceof OnListFragmentInteractionListener) {
      mListener = (OnListFragmentInteractionListener) context;
    } else {
      //throw new RuntimeException(context.toString()
        //  + " must implement OnListFragmentInteractionListener");
    }
  }

  @Override
  public void onDetach() {
    super.onDetach();
    mListener = null;
  }

  /**
   * This interface must be implemented by activities that contain this fragment to allow an
   * interaction in this fragment to be communicated to the activity and potentially other fragments
   * contained in that activity.
   * <p/>
   * See the Android Training lesson <a href= "http://developer.android.com/training/basics/fragments/communicating.html"
   * >Communicating with Other Fragments</a> for more information.
   */
  public interface OnListFragmentInteractionListener {

    // TODO: Update argument type and name
    void onListFragmentInteraction(Location item);
  }

  public class LocationGetterTask extends AsyncTask<Void, Void, List<Location>> {

    @Override
    protected List<Location> doInBackground(Void... voids) {
      String token = AbqWifinderApplication.getInstance().getString(R.string.authorization_value_format,
          GoogleSignInService.getInstance().getAccount().getIdToken());
      try {
        Response<List<Location>> response = InstanceHolder.INSTANCE.get(token).execute();
        return response.body();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return null;
    }

    @Override
    protected void onPostExecute(List<Location> result) {
      locations.clear();
       locations.addAll(result);
      adapter.notifyDataSetChanged();
    }
  }
}
