/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.app.bp.dao;

import java.util.List;
import rashjz.info.app.bp.domain.Location;

/**
 *
 * @author Mobby
 */
public interface LocationDao {

    public List<Location> getAllLocation();

    public Location getLocationByID(Integer id);

    public Location addLocation(Location location);
}
