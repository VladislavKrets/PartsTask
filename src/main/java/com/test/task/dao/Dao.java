package com.test.task.dao;

import com.test.task.entities.Filter;
import com.test.task.entities.PartEntity;

import java.util.List;

/**
 * This interface makes a structure for classes which will implement it
 */
public interface Dao {
    List<PartEntity> getPartsByFilter(Filter filter);
}
