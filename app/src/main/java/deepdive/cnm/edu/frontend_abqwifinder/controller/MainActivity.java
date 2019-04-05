package deepdive.cnm.edu.frontend_abqwifinder.controller;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import deepdive.cnm.edu.frontend_abqwifinder.R;
import deepdive.cnm.edu.frontend_abqwifinder.service.GoogleSignInService;


public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawer.addDrawerListener(toggle);
    toggle.syncState();

    NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);
  }

  @Override
  public void onBackPressed() {
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    if (drawer.isDrawerOpen(GravityCompat.START)) {
      drawer.closeDrawer(GravityCompat.START);
    } else {
      super.onBackPressed();
    }
  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_options, menu);
    return true;
  }

  public boolean onOptionsItemSelected(MenuItem item) {
    boolean handled = true;
    switch (item.getItemId()) {
      case R.id.action_settings:
        getActionBar();
        break;
      case R.id.sign_out:
        signOut();
        break;
      default:
        handled = super.onOptionsItemSelected(item);
    }
    return handled;
  }

  private void signOut(){
    GoogleSignInService.getInstance().getClient()
        .signOut().addOnCompleteListener(this, (task)-> {
      GoogleSignInService.getInstance().setAccount(null);
      Intent intent = new Intent(this, LoginActivity.class);
      intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
      startActivity(intent);
    });
  }

  @Override
  public boolean onNavigationItemSelected(MenuItem item) {
    Bundle args = new Bundle();
    Context context = getApplicationContext();

    switch (item.getItemId()) {
      case R.id.fragment_home:
        loadFragment(new HomeFragment(), R.id.fragment_container, "fragment_home", null);
        break;
      case R.id.fragment_wifi_favorite:
        Toast.makeText(context, "Feature not yet available", Toast.LENGTH_SHORT).show();
        break;
      case R.id.fragment_search_result:
        loadFragment(new SearchResultFragment(), R.id.fragment_container, "fragment_search_result",
            null);
        Toast.makeText(context, "Loading Search Results", Toast.LENGTH_SHORT).show();
        break;
      case R.id.fragment_profile_settings:
        loadFragment(new ProfileSettingsFragment(), R.id.fragment_container, "fragment_profile_settings",
            null);
        break;

    }

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
  }
  public void loadFragment(Fragment fragment, int container, String tag, Bundle args) {
    FragmentManager manager = getSupportFragmentManager();
    if (args != null) {
      fragment.setArguments(args);
    }
    manager.beginTransaction()
        .replace(container, fragment, tag)
        .commit();
  }
}
