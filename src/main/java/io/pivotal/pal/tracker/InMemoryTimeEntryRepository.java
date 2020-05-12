package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{
    Hashtable<Long,TimeEntry> repo=new Hashtable();
    long counter=1;
  @Override
    public TimeEntry find(long id) {
        return repo.get(id);
    }

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
      timeEntry.setId(counter);
        repo.put(timeEntry.getId(),timeEntry);
        counter++;
        return timeEntry;
    }

    @Override
    public List list() {
    return new ArrayList(repo.values());
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {

    if(repo.containsKey(id)){
        timeEntry.setId(id);
        repo.put(timeEntry.getId(),timeEntry);
    }
     else {
       timeEntry=null;
    }
     return timeEntry;
    }

    @Override
    public void delete(long id) {
         repo.remove(id);
    }
}
