package com.nanda.selectallrecyclerview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import com.nanda.selectallrecyclerview.R;
import com.nanda.selectallrecyclerview.adapter.MultiSelectAdapter;
import com.nanda.selectallrecyclerview.model.PersonItem;
import com.nanda.selectallrecyclerview.utils.CommonUtils;
import com.nanda.selectallrecyclerview.utils.UiUtils;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MultiSelectAdapter.CallbackManager {

  @BindView(R.id.recyclerview) RecyclerView recyclerView;
  @BindView(R.id.btn_selected_items) Button btnSelectedItems;
  @BindView(R.id.cb_select_all) CheckBox cbSelectAll;

  private MultiSelectAdapter adapter;
  private boolean isAllSelectedFromAdapter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    adapter = new MultiSelectAdapter(this, this);
    recyclerView.setItemAnimator(null);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setAdapter(adapter);

    adapter.notifyAdapter(CommonUtils.getPersonList());
  }

  @OnClick(R.id.btn_selected_items) public void onButtonclick() {
    List<PersonItem> selectedItemsList = adapter.getSelctedItemsList();

    if (selectedItemsList == null) {
      return;
    }

    if (selectedItemsList.size() > 0) {
      UiUtils.showToast(this, "" + selectedItemsList.size());
    } else {
      UiUtils.showToast(this, "No item selected");
    }
  }

  @OnCheckedChanged(R.id.cb_select_all)
  public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

    if (isChecked) {
      if (!isAllSelectedFromAdapter) adapter.selectAllItems();
    } else {
      if (!isAllSelectedFromAdapter) adapter.deSelectAllItems();
    }
  }

  @Override public void onSelectOrDeSelectAll(boolean isAllSelected, boolean isFromAdapter) {

    isAllSelectedFromAdapter = isFromAdapter;

    if (isAllSelected) {
      cbSelectAll.setChecked(true);
    } else {
      cbSelectAll.setChecked(false);
    }

    isAllSelectedFromAdapter = false;
  }
}
