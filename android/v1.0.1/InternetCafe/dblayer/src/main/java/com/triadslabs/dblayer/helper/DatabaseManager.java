package com.triadslabs.dblayer.helper;

import android.content.Context;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;

/**
 * Created by MuzammilPeer on 1/18/2015.
 */

// this class is not used...integration issue in getHelper method of this class(null pointer exception)
public class DatabaseManager <H extends OrmLiteSqliteOpenHelper> {

    private H helper;

    @SuppressWarnings("unchecked")
    public H getHelper(Context context)
    {
        if(helper == null)
        {
            helper = (H) OpenHelperManager.getHelper(context);
        }
        return helper;
    }

    public void releaseHelper(H helper)
    {
        if (helper != null) {
            OpenHelperManager.releaseHelper();
            helper = null;
        }
    }

}