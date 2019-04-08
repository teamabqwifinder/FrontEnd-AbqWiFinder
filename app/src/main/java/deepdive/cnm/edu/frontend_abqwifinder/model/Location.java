package deepdive.cnm.edu.frontend_abqwifinder.model;

import com.google.gson.annotations.Expose;

public class Location {

  @Expose
  private String address;
  @Expose
  private String pictures;

  public String getPictures() {
    return pictures;
  }

  public void setPictures(String pictures) {
    this.pictures = pictures;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
