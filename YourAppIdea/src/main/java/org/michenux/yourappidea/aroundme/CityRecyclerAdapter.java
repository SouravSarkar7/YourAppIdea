package org.michenux.yourappidea.aroundme;

import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.michenux.drodrolib.db.CursorRecyclerViewAdapter;
import org.michenux.drodrolib.db.utils.CursorUtils;
import org.michenux.yourappidea.R;

public class CityRecyclerAdapter extends CursorRecyclerViewAdapter<CityRecyclerAdapter.CityViewHolder> {
    public CityRecyclerAdapter(Cursor cursor) {
        super(cursor);
    }

    @Override
    public CityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_listitem, parent, false);
        return new CityViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CityViewHolder viewHolder, Cursor cursor) {
        String cityName = CursorUtils.getString(CityContentProvider.NAME_COLUMN, cursor);
        viewHolder.getNameView().setText(cityName);

        String countryName = CursorUtils.getString(CityContentProvider.COUNTRY_COLUMN, cursor);
        viewHolder.getCountryView().setText(countryName);
    }

    public static class CityViewHolder extends RecyclerView.ViewHolder {
        private TextView mNameView;
        private TextView mCountryView;

        public CityViewHolder(View itemView) {
            super(itemView);
            mNameView = (TextView) itemView.findViewById(R.id.city_name);
            mCountryView = (TextView) itemView.findViewById(R.id.city_country);
        }

        public TextView getNameView() {
            return mNameView;
        }

        public TextView getCountryView() {
            return mCountryView;
        }
    }
}
