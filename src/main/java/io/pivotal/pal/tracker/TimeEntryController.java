package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {
    TimeEntryRepository timeEntryRepository;
    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository=timeEntryRepository;
    }
    @GetMapping("{timeEntryId}")
    public ResponseEntity<TimeEntry> read(@PathVariable long timeEntryId) {
        TimeEntry found =  timeEntryRepository.find(timeEntryId);
        if(found==null)
            return new ResponseEntity(timeEntryId, HttpStatus.NOT_FOUND);
        else
        return new ResponseEntity(found, HttpStatus.OK);
    }
    @PutMapping("{timeEntryId}")
    public ResponseEntity update(@PathVariable long timeEntryId, @RequestBody TimeEntry expected) {


        expected=timeEntryRepository.update(timeEntryId,expected);
        if(expected!=null)
        return new ResponseEntity(expected,HttpStatus.OK);
        else
            return new ResponseEntity(expected,HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("{timeEntryId}")
    public ResponseEntity delete(@PathVariable long timeEntryId) {
        timeEntryRepository.delete(timeEntryId);
        return new ResponseEntity(timeEntryId,HttpStatus.NO_CONTENT);
    }
    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
        return new ResponseEntity( timeEntryRepository.list(),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {
        TimeEntry creted =  timeEntryRepository.create(timeEntryToCreate);
        return new ResponseEntity(creted, HttpStatus.CREATED);
    }
}
