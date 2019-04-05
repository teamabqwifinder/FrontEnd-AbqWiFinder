package deepdive.cnm.edu.frontend_abqwifinder.service;


import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import deepdive.cnm.edu.frontend_abqwifinder.AbqWifinderApplication;
import deepdive.cnm.edu.frontend_abqwifinder.R;

public class GoogleSignInService {

  private GoogleSignInClient client;
  private GoogleSignInAccount account;

  private GoogleSignInService() {
    GoogleSignInOptions options =
        new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .requestId()
            .requestIdToken(AbqWifinderApplication.getInstance().getString(R.string.client_id))
            .build();
    client = GoogleSignIn.getClient(AbqWifinderApplication.getInstance(), options);
  }

  public static GoogleSignInService getInstance() {
    return InstanceHolder.INSTANCE;
  }

  public GoogleSignInClient getClient() {
    return client;
  }

  public void setClient(GoogleSignInClient client) {
    this.client = client;
  }

  public GoogleSignInAccount getAccount() {
    return account;
  }

  public void setAccount(GoogleSignInAccount account) {
    this.account = account;
  }

  private static class InstanceHolder {

    private static final GoogleSignInService INSTANCE = new GoogleSignInService();

  }

}
