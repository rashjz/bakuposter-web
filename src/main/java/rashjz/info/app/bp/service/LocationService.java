/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.app.bp.service;

import java.util.List;
import rashjz.info.app.bp.domain.Location;

/**
 *
 * @author Mobby
 */
public interface LocationService {

    public List<Location> getAllLocation();

    public Location getLocationByID(Integer id);

    public Location addLocation(Location location);
}
