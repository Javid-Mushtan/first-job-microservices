package com.javid.jobs.job;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jobs")
public class JobController {
    private final JobService jobService;

    @GetMapping
    public ResponseEntity<List<Job>> findAll() {
        return ResponseEntity.ok(jobService.findAll());
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable Long id ,@RequestBody Job job) {
        return ResponseEntity.ok(jobService.updateJob(id,job));
    }

    @PostMapping
    public ResponseEntity<Job> save(@RequestBody Job job) {
        return ResponseEntity.ok(jobService.createJob(job));
    }
}
