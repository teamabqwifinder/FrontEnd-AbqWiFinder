package deepdive.cnm.edu.frontend_abqwifinder.controller;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import deepdive.cnm.edu.frontend_abqwifinder.AbqWifinderApplication;
import deepdive.cnm.edu.frontend_abqwifinder.R;
import deepdive.cnm.edu.frontend_abqwifinder.model.Location;
import deepdive.cnm.edu.frontend_abqwifinder.service.GoogleSignInService;
import deepdive.cnm.edu.frontend_abqwifinder.service.WiFinderBackendClient.InstanceHolder;
import java.io.IOException;
import java.util.List;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


  public HomeFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment

    return inflater.inflate(R.layout.fragment_home, container, false);
  }

}
