package com.nanda.selectallrecyclerview.utils;

import java.util.UUID;

/**
 * Created by nandagopal on 2/28/17.
 */
public class TextUtils {

  public static String generateUniqueClientId() {
    return UUID.randomUUID().toString();
  }
}
