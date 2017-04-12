package com.nanda.selectallrecyclerview.model;

/**
 * Created by nandagopal on 4/12/17.
 */

public class PersonItem {

  private String personId;
  private String persoName;
  private long mobileNumber;

  private boolean isMultiSelect = false;

  public PersonItem(String personId, String persoName, long mobileNumber) {
    this.personId = personId;
    this.persoName = persoName;
    this.mobileNumber = mobileNumber;
  }

  public boolean isMultiSelect() {
    return isMultiSelect;
  }

  public void setMultiSelect(boolean multiSelect) {
    isMultiSelect = multiSelect;
  }

  public String getPersonId() {
    return personId;
  }

  public void setPersonId(String personId) {
    this.personId = personId;
  }

  public String getPersoName() {
    return persoName;
  }

  public void setPersoName(String persoName) {
    this.persoName = persoName;
  }

  public long getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(long mobileNumber) {
    this.mobileNumber = mobileNumber;
  }
}
