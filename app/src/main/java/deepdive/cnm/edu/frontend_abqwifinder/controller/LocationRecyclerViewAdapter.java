package deepdive.cnm.edu.frontend_abqwifinder.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import deepdive.cnm.edu.frontend_abqwifinder.R;
import deepdive.cnm.edu.frontend_abqwifinder.controller.LocationListFragment.OnListFragmentInteractionListener;
import deepdive.cnm.edu.frontend_abqwifinder.controller.dummy.DummyContent.DummyItem;

import deepdive.cnm.edu.frontend_abqwifinder.model.Location;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}. TODO: Replace the implementation with code
 * for your data type.
 */
public class LocationRecyclerViewAdapter extends
    RecyclerView.Adapter<LocationRecyclerViewAdapter.ViewHolder> {

  private final List<Location> mValues;
  private final OnListFragmentInteractionListener mListener;
  private ImageView imageView;
  private RatingBar ratingBar;

  public LocationRecyclerViewAdapter(List<Location> items,
      OnListFragmentInteractionListener listener) {
    mValues = items;
    mListener = listener;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.fragment_location, parent, false);
    return new ViewHolder(view, imageView, ratingBar);
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, int position) {
    holder.mItem = mValues.get(position);
    //holder.mIdView.setText();
    holder.mContentView.setText(mValues.get(position).getAddress());

    holder.mView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (null != mListener) {
          // Notify the active callbacks interface (the activity, if the
          // fragment is attached to one) that an item has been selected.
          mListener.onListFragmentInteraction(holder.mItem);
        }
      }
    });
  }

  @Override
  public int getItemCount() {
    return mValues.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    public final View mView;
    public final TextView mIdView;
    public final TextView mContentView;
    public Location mItem;
    public final ImageView imageView;
    public final RatingBar ratingBar;

    public ViewHolder(View view, ImageView imageView, RatingBar ratingBar) {
      super(view);
      mView = view;
      mIdView = (TextView) view.findViewById(R.id.item_number);
      mContentView = (TextView) view.findViewById(R.id.content);
      this.imageView = imageView;
      this.ratingBar = ratingBar;
    }

    @Override
    public String toString() {
      return super.toString() + " '" + mContentView.getText() + "'";
    }
  }
}
