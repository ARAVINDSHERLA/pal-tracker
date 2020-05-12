package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {

    TimeEntry find(long id);

    TimeEntry create(TimeEntry timeEntry);
    
    List list();

    TimeEntry update(long id, TimeEntry timeEntry);

    void delete(long id);
}
