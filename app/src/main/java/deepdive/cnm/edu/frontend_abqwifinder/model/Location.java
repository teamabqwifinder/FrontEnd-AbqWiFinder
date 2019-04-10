package deepdive.cnm.edu.frontend_abqwifinder.model;

import com.google.gson.annotations.Expose;

/**
 * This class contains getters and setters as well as
 * strings to access addresses and pictures from our database.
 */

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
