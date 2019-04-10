package deepdive.cnm.edu.frontend_abqwifinder.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import deepdive.cnm.edu.frontend_abqwifinder.AbqWifinderApplication;
import deepdive.cnm.edu.frontend_abqwifinder.model.Location;
import java.util.List;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Header;
/**
 * This class contains the list of locations from our database. Also
 * contains an interface that communicates with the back end server.
 *
 */
public interface WiFinderBackendClient {

  @GET("/rest/wifinderbackend/locations")
  Call<List<Location>> get(@Header("Authorization") String formattedIdTokenString);

  class InstanceHolder {

    public static final WiFinderBackendClient INSTANCE;

    static {
      AbqWifinderApplication application = AbqWifinderApplication.getInstance();
      Gson gson = new GsonBuilder()
          .excludeFieldsWithoutExposeAnnotation()
          .create();
      Retrofit retrofit = new Retrofit.Builder()
          .baseUrl("http://10.0.2.2:8080")
          .addConverterFactory(GsonConverterFactory.create(gson))
          .build();
      INSTANCE = retrofit.create(WiFinderBackendClient.class);
    }

  }

}
