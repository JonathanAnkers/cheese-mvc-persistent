package org.launchcode.models.data;


import org.launchcode.models.Menu;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.*;
import javax.transaction.Transactional;

/**
 * Created by Beast on 4/13/17.
 */
@Repository
@Transactional
public interface MenuDao extends CrudRepository<Menu, Integer> {
}
