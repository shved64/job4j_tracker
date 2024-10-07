package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class JobTest {

    @Test
    public void jobAskByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 5),
                new Job("Fix bug", 7),
                new Job("X task", 2)
        );
        Collections.sort(jobs);

        List<Job> expected = Arrays.asList(
                new Job("X task", 2),
                new Job("Fix bug", 5),
                new Job("Fix bug", 7)
        );
        assertEquals(jobs, expected);
    }

    @Test
    public void jobDescByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 5),
                new Job("Fix bug", 7),
                new Job("X task", 2)
        );
        jobs.sort(new JobDescByName());

        List<Job> expected = Arrays.asList(
                new Job("X task", 2),
                new Job("Fix bug", 5),
                new Job("Fix bug", 7)
        );
        assertEquals(jobs, expected);
    }

    @Test
    public void jobAskByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 5),
                new Job("Fix bug", 7),
                new Job("X task", 2)
        );
        Collections.sort(jobs);

        List<Job> expected = Arrays.asList(
                new Job("X task", 2),
                new Job("Fix bug", 5),
                new Job("Fix bug", 7)
        );
        assertEquals(jobs, expected);
    }

    @Test
    public void jobDescByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 5),
                new Job("Fix bug", 7),
                new Job("X task", 2)
        );
        jobs.sort(new JobDescByPriority());

        List<Job> expected = Arrays.asList(
                new Job("Fix bug", 7),
                new Job("Fix bug", 5),
                new Job("X task", 2)
        );
        assertEquals(jobs, expected);
    }

    @Test
    public void whenComparatorByNameAndPriorityDesc() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByNameAndPriorityAsk() {
        Comparator<Job> cmpNamePriority = new JobAskByName().thenComparing(new JobAskByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 0)
        );
        assertThat(rsl).isLessThan(0);
    }
}