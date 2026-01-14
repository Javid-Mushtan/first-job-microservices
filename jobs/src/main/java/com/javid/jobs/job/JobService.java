package com.javid.jobs.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    Job createJob(Job job);
    Job updateJob(Long id,Job job);
    Job findJobById(Long id);
}
