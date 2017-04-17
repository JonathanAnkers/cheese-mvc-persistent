package org.launchcode.models.data;

import org.springframework.stereotype.Repository;
import org.launchcode.models.Category;
import org.springframework.data.repository.*;
import javax.transaction.Transactional;

/**
 * Created by Beast on 4/12/17.
 */
@Repository
@Transactional
public interface CategoryDao extends CrudRepository<Category, Integer> {
}
