package deepdive.cnm.edu.frontend_abqwifinder;

import android.app.Application;

public class AbqWifinderApplication extends Application {

  private static AbqWifinderApplication instance = null;

  @Override
  public void onCreate() {
    super.onCreate();
    instance = this;
  }


  public static AbqWifinderApplication getInstance() {
    return instance;
  }
}
