package com.nanda.selectallrecyclerview.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by nandagopal on 4/12/17.
 */

public class UiUtils {

  public static void showToast(Context context, String input) {
    Toast.makeText(context, input, Toast.LENGTH_SHORT).show();
  }
}
