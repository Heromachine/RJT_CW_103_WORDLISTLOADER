package com.example.jessi.rjt_cw_103_wordlistloader;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class LoaderActivty extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    SimpleCursorAdapter adpter;
    public static int LOADER_ID = 007;
    Bundle instructions = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader_activty);
        getLoaderManager().initLoader(LOADER_ID, instructions,this);
        ListView listView = findViewById(R.id.listview);
        adpter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1,
                null,
                new String []{"body"},
                new int []{android.R.id.text1},
                0);
        listView.setAdapter(adpter);


    }


    @Override
    public Loader<Cursor> onCreateLoader(int loaderId, Bundle intsns) {
//        if(loaderId == LOADER_ID)
//        {
//
//        }
        Uri uriSms = Uri.parse("content://sms/inbox");
        return new CursorLoader(this,uriSms,null, null, null,null );
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor loadedCursor) {
        adpter.swapCursor(loadedCursor);

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
