package com.survivingwithandroid.finger;

/**
 * Created by Javid on 17-03-2018.
 */

public class updateUserEntry {

    public String username;

    public updateUserEntry() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public updateUserEntry(String username) {
        this.username = username;
    }
}
