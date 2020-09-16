package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {
    TimeEntry create(TimeEntry any);

    TimeEntry find(Long id);

    List<TimeEntry> list();

    TimeEntry update(Long eq, TimeEntry timeEntry);

    void delete(Long timeEntryId);
}
