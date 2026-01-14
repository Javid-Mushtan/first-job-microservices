package com.javid.jobs.job.impl;

import com.javid.jobs.job.Job;
import com.javid.jobs.job.JobRepository;
import com.javid.jobs.job.JobService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    public final JobRepository jobRepository;

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public Job updateJob(Long id, Job job) {
        Job newJob = findJobById(id);
        newJob.setId(job.getId());
        newJob.setDescription(job.getDescription());
        newJob.setLocation(job.getLocation());
        newJob.setTitle(job.getTitle());
        newJob.setMaxSalary(job.getMaxSalary());
        newJob.setMinSalary(job.getMinSalary());
        return jobRepository.save(newJob);
    }

    @Override
    public Job findJobById(Long id) {
        return jobRepository.findById(id)
                .orElseThrow();

    }
}
