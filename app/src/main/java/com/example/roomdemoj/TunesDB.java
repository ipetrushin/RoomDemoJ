package com.example.roomdemoj;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities={Tune.class}, version=2)
public abstract class TunesDB extends RoomDatabase {
    abstract Playlist playlist();

    private static final String DB_NAME="tunes.db";
    private static volatile TunesDB INSTANCE=null;

    synchronized static TunesDB get(Context ctxt) {

        if (INSTANCE==null) {
            INSTANCE=create(ctxt, false);
        }
        return(INSTANCE);
    }
    static TunesDB create(Context ctxt, boolean memoryOnly) {
        RoomDatabase.Builder<TunesDB> b;
        if (memoryOnly) {
            b = Room.inMemoryDatabaseBuilder(ctxt.getApplicationContext(),
                    TunesDB.class);
        }
        else {
            b=Room.databaseBuilder(ctxt.getApplicationContext(), TunesDB.class,
                    DB_NAME);
        }
        return(b.build());

    }
}