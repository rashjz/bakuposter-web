/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.app.bp.service;

import rashjz.info.app.bp.dao.*;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rashjz.info.app.bp.domain.Location;

/**
 *
 * @author Rashad Javadov
 */
@Service
public class LocationServiceImpl implements Serializable, LocationService {

    @Autowired
    LocationDao locationDao;

    @Override
    public List<Location> getAllLocation() {
        return locationDao.getAllLocation();
    }

    @Override
    public Location addLocation(Location location) {
        return locationDao.addLocation(location);
    }

    @Override
    public Location getLocationByID(Integer id) {
          return locationDao.getLocationByID(id);
    }
}
