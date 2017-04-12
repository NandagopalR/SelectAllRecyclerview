package com.nanda.selectallrecyclerview.utils;

import com.nanda.selectallrecyclerview.model.PersonItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CommonUtils {

  public static List<PersonItem> getPersonList() {

    List<PersonItem> personItemList = new ArrayList<>();

    personItemList.add(new PersonItem(TextUtils.generateUniqueClientId(), "Kalpesh", 1234567890));
    personItemList.add(new PersonItem(TextUtils.generateUniqueClientId(), "Rajiv", 1234567590));
    personItemList.add(new PersonItem(TextUtils.generateUniqueClientId(), "Raja", 1234567490));
    personItemList.add(new PersonItem(TextUtils.generateUniqueClientId(), "Nanda", 1234562890));
    personItemList.add(new PersonItem(TextUtils.generateUniqueClientId(), "Pavan", 1234555890));
    personItemList.add(new PersonItem(TextUtils.generateUniqueClientId(), "Selva", 1234577890));
    personItemList.add(new PersonItem(TextUtils.generateUniqueClientId(), "Shyam", 1234522890));
    personItemList.add(new PersonItem(TextUtils.generateUniqueClientId(), "Karthik", 1234567891));
    personItemList.add(new PersonItem(TextUtils.generateUniqueClientId(), "Prabhu", 1234567866));
    personItemList.add(new PersonItem(TextUtils.generateUniqueClientId(), "Vinoth", 1034567866));
    personItemList.add(new PersonItem(TextUtils.generateUniqueClientId(), "Shankar", 1134567866));
    personItemList.add(new PersonItem(TextUtils.generateUniqueClientId(), "Vicky", 1134567861));
    personItemList.add(new PersonItem(TextUtils.generateUniqueClientId(), "Gobi", 1234567861));
    personItemList.add(new PersonItem(TextUtils.generateUniqueClientId(), "Ezhil", 1114567861));
    personItemList.add(new PersonItem(TextUtils.generateUniqueClientId(), "Elango", 1124567861));
    personItemList.add(new PersonItem(TextUtils.generateUniqueClientId(), "Balu", 1124567862));
    personItemList.add(new PersonItem(TextUtils.generateUniqueClientId(), "Prakash", 1124567863));
    personItemList.add(new PersonItem(TextUtils.generateUniqueClientId(), "Rajesh", 1124567866));

    return personItemList;
  }

  public static List<PersonItem> getUpdatedPersonList() {

    List<PersonItem> personItemList = new ArrayList<>();

    personItemList.add(
        new PersonItem(TextUtils.generateUniqueClientId(), "Kalpesh Patel", 934567890));
    personItemList.add(
        new PersonItem(TextUtils.generateUniqueClientId(), "Rajiv Manivannan", 924567590));
    personItemList.add(
        new PersonItem(TextUtils.generateUniqueClientId(), "Raja Mohammed", 954567490));
    personItemList.add(new PersonItem(TextUtils.generateUniqueClientId(), "Nandagopal", 904562890));
    personItemList.add(new PersonItem(TextUtils.generateUniqueClientId(), "Pavan", 1234555890));
    personItemList.add(new PersonItem(TextUtils.generateUniqueClientId(), "Selva", 1234577890));
    personItemList.add(new PersonItem(TextUtils.generateUniqueClientId(), "Shyam", 1234522890));
    personItemList.add(new PersonItem(TextUtils.generateUniqueClientId(), "Karthik", 1234567891));
    personItemList.add(new PersonItem(TextUtils.generateUniqueClientId(), "Prabhu", 1234567866));
    personItemList.add(new PersonItem(TextUtils.generateUniqueClientId(), "Ezhil", 1234567811));
    personItemList.add(new PersonItem(TextUtils.generateUniqueClientId(), "Prakash", 1266567811));
    personItemList.add(new PersonItem(TextUtils.generateUniqueClientId(), "Ram", 1266522811));
    personItemList.add(new PersonItem(TextUtils.generateUniqueClientId(), "Vicky", 1266522899));

    return personItemList;
  }

  public static List<PersonItem> getPersonListSortedByName() {
    final List<PersonItem> actorList = getPersonList();

    Collections.sort(actorList, new Comparator<PersonItem>() {
      @Override public int compare(PersonItem a1, PersonItem a2) {
        return a1.getPersoName().compareTo(a2.getPersoName());
      }
    });

    return actorList;
  }
}
