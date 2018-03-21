package com.survivingwithandroid.finger;

/**
 * Created by Javid on 17-03-2018.
 */

import java.text.SimpleDateFormat;

public class updateJourney {

    public String startTime;
    public String endTime;
    public String startPlace;
    public String endPlace;
    public boolean entry;

    public updateJourney() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public updateJourney( boolean userEntry,String place ) {
        this.entry = userEntry;

        if (entry) {
            startTime = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new java.util.Date());
            startPlace = place;
        } else {
            endTime = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new java.util.Date());
            endPlace = place;
        }
    }
}
