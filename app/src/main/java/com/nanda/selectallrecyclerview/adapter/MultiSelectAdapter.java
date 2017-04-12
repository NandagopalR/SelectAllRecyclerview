package com.nanda.selectallrecyclerview.adapter;

import android.content.Context;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.nanda.selectallrecyclerview.R;
import com.nanda.selectallrecyclerview.adapter.callback.MultiSelectCallback;
import com.nanda.selectallrecyclerview.model.PersonItem;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by nandagopal on 4/12/17.
 */

public class MultiSelectAdapter
    extends RecyclerView.Adapter<MultiSelectAdapter.MultiSelectViewHolder> {

  private Context context;
  private LayoutInflater inflater;
  private List<PersonItem> personItemList;
  private Set<String> selectedItemsList;
  private CallbackManager callbackManager;

  public MultiSelectAdapter(Context context, CallbackManager callbackManager) {
    this.context = context;
    this.callbackManager = callbackManager;
    inflater = LayoutInflater.from(context);
    personItemList = new ArrayList<>();
    selectedItemsList = new HashSet<>();
  }

  public interface CallbackManager {
    void onSelectOrDeSelectAll(boolean isAllSelected, boolean isFromAdapter);
  }

  @Override public MultiSelectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = inflater.inflate(R.layout.item_multi_select, parent, false);
    return new MultiSelectViewHolder(view);
  }

  @Override public void onBindViewHolder(MultiSelectViewHolder holder, int position) {
    PersonItem item = personItemList.get(position);
    holder.bindDataToView(item, position);
  }

  @Override public int getItemCount() {
    return personItemList.size();
  }

  public void notifyAdapter(List<PersonItem> newList) {
    MultiSelectCallback callback = new MultiSelectCallback(personItemList, newList);
    DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(callback);

    this.personItemList.clear();
    this.personItemList.addAll(newList);
    diffResult.dispatchUpdatesTo(this);
  }

  public List<PersonItem> getSelctedItemsList() {

    if (personItemList == null) return null;

    List<PersonItem> selectedItemsList = new ArrayList<>();

    for (int i = 0, personItemListSize = personItemList.size(); i < personItemListSize; i++) {
      PersonItem item = personItemList.get(i);

      if (item.isMultiSelect()) {
        selectedItemsList.add(item);
      }
    }

    return selectedItemsList;
  }

  public void selectAllItems() {
    if (personItemList == null) return;

    for (int i = 0, personItemListSize = personItemList.size(); i < personItemListSize; i++) {
      PersonItem item = personItemList.get(i);

      if (!item.isMultiSelect()) item.setMultiSelect(true);

      if (!selectedItemsList.contains(item.getPersonId())) {
        selectedItemsList.add(item.getPersonId());
      }
    }
    notifyDataSetChanged();
  }

  public void deSelectAllItems() {
    if (personItemList == null) return;

    for (int i = 0, personItemListSize = personItemList.size(); i < personItemListSize; i++) {
      PersonItem item = personItemList.get(i);

      if (item.isMultiSelect()) item.setMultiSelect(false);

      if (selectedItemsList.contains(item.getPersonId())) {
        selectedItemsList.remove(item.getPersonId());
      }
    }
    notifyDataSetChanged();
  }

  class MultiSelectViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_person_name) TextView tvPersonName;
    @BindView(R.id.tv_person_mobile) TextView tvPersonMobile;
    @BindView(R.id.cb_person) CheckBox cbPerson;

    public MultiSelectViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }

    public void bindDataToView(final PersonItem item, final int position) {
      tvPersonName.setText(item.getPersoName());
      tvPersonMobile.setText(String.valueOf(item.getMobileNumber()));

      cbPerson.setChecked(item.isMultiSelect());
      cbPerson.setTag(position);

      cbPerson.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View view) {

          CheckBox checkBox = (CheckBox) view;
          int clickedPosition = (int) checkBox.getTag();
          boolean isChecked = checkBox.isChecked();

          if (isChecked) {
            if (!selectedItemsList.contains(item.getPersonId())) {
              selectedItemsList.add(item.getPersonId());
            }
          } else {
            if (selectedItemsList.contains(item.getPersonId())) {
              selectedItemsList.remove(item.getPersonId());
            }
          }

          personItemList.get(clickedPosition).setMultiSelect(isChecked ? true : false);

          if (personItemList.size() == selectedItemsList.size()) {
            if (callbackManager != null) callbackManager.onSelectOrDeSelectAll(true, true);
          } else {
            if (callbackManager != null) callbackManager.onSelectOrDeSelectAll(false, true);
          }
        }
      });
    }
  }
}
