package deepdive.cnm.edu.frontend_abqwifinder.model;

import com.google.gson.annotations.Expose;

public class Location {

  @Expose
  private String address;

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
