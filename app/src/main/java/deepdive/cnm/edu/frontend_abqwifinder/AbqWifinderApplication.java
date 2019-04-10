package deepdive.cnm.edu.frontend_abqwifinder;

import android.app.Application;
/**
 * This class contains a static method that creates an instance for
 * AbqWifinderApplication
 *
 */
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
