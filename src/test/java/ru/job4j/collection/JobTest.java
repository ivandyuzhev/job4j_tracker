package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {

    @Test
    public void whenComparatorAscByPriority() {
        Comparator<Job> cmpPriority = new JobAscByPriority();
        int rsl = cmpPriority.compare(
                new Job("Artem Artemov", 0),
                new Job("Ivan Ivanov", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorDescByName() {
        Comparator<Job> cmpName = new JobDescByName();
        int rsl = cmpName.compare(
                new Job("Ivan Ivanov", 1),
                new Job("Artem Artemov", 0)

        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorDescByPriority() {
        Comparator<Job> cmpPriority = new JobDescByPriority();
        int rsl = cmpPriority.compare(
                new Job("Artem Artemov", 1),
                new Job("Ivan Ivanov", 0)

        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompareAscByNameAndAscByPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Artem Artemov", 0),
                new Job("Artem Artemov", 1)

        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompareAscByNameAndDescByPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Artem Artemov", 1),
                new Job("Ivan Ivanov", 0)

        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompareAscByPriorityAndDescByName() {
        Comparator<Job> cmpNamePriority = new JobAscByPriority().thenComparing(new JobDescByName());
        int rsl = cmpNamePriority.compare(
                new Job("Ivan Ivanov", 0),
                new Job("Artem Artemov ", 1)

        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompareDescByPriorityAndDescByName() {
        Comparator<Job> cmpNamePriority = new JobDescByPriority().thenComparing(new JobDescByName());
        int rsl = cmpNamePriority.compare(
                new Job("Ivan Ivanov", 1),
                new Job("Artem Artemov", 0)

        );
        assertThat(rsl).isLessThan(0);
    }

}
