package com.test.task.dao;

import com.test.task.entities.Filter;
import com.test.task.entities.PartEntity;

import java.util.List;

/**
 * Created by lollipop on 29.06.2018.
 */
public interface Dao {
    List<PartEntity> getPartsByFilter(Filter filter);
}
