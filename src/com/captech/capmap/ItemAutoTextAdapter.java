package com.captech.capmap;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

public class ItemAutoTextAdapter extends CursorAdapter implements
		OnItemClickListener {

	public ItemAutoTextAdapter(Context context) {
		super(context, null);
	}

	@Override
	public void onItemClick(AdapterView<?> listView, View view, int position, long id) {
		// Get the cursor, positioned to the corresponding row in the result set
        Cursor cursor = (Cursor) listView.getItemAtPosition(position);

	}

	@Override
	public Cursor runQueryOnBackgroundThread(CharSequence constraint) {
        if (getFilterQueryProvider() != null) {
            return getFilterQueryProvider().runQuery(constraint);
        }
        
        Cursor cursor = mDbHelper.getMatchingStates(
                (constraint != null ? constraint.toString() : null));

        return cursor;
	}

	@Override
	public void bindView(View view, Context context, Cursor cursor) {
		final String text = convertToString(cursor).toString();
		((TextView) view).setText(text);
	}

	@Override
	public CharSequence convertToString(Cursor cursor) {
		// TODO Auto-generated method stub
		return super.convertToString(cursor);
	}

	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
        final LayoutInflater inflater = LayoutInflater.from(context);
        final View view =
                inflater.inflate(android.R.layout.simple_dropdown_item_1line,
                        parent, false);

       return view;
	}

}
