/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.app.bp.web;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import rashjz.info.app.bp.domain.Location;
import rashjz.info.app.bp.service.LocationService;

/**
 *
 * @author RashadJavad
 */
@Controller
public class LocationController implements Serializable {

    private static final Logger LOG = Logger.getLogger(LocationController.class.getName());

    @Autowired
    LocationService locationService;

    @RequestMapping(value = "/location", method = RequestMethod.GET)
    public String getAllLocations(Model model) {
        List<Location> list = locationService.getAllLocation();
        model.addAttribute("listLocation", list);
        return "admin/location";
    }

    @ResponseBody
    @RequestMapping(value = "/newlocation/{title}/{latitude:.*}/{longitude:.*}", method = RequestMethod.GET)
    public Location createNewLocation(@PathVariable(value = "title") String title,
            @PathVariable(value = "latitude") String latitude, @PathVariable(value = "longitude") String longitude) {
        LOG.info("title " + title + " latitude " + latitude + " longitude " + longitude);

        Location location = new Location();
        location.setTitle(title);
        location.setLatitude(new Float(latitude));
        location.setLongitude(new Float(longitude));
        location.setInsDate(new Date());
        location.setStatus("a");
        locationService.addLocation(location);
//        location.setNote("here we are in controller ");
        return location;
    }

    @RequestMapping(value = "/mylocation", method = RequestMethod.GET)
    public ResponseEntity<Location> createMylocation() {
        Location location = new Location(); 
        try {

            location.setLatitude(Float.valueOf("40.38401663182168"));
            location.setLongitude(Float.valueOf("40.38401663182168"));
            location.setStatus("a");
            location.setTitle("TEST");
            location.setInsDate(new Date());
            location.setRecId(1);
            location.setNote("123");
            LOG.info("location " + location);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return new ResponseEntity<Location>(location, HttpStatus.OK);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Location createNewLocationTest() {
        Location location = new Location();

        location.setLatitude(Float.valueOf("40.38401663182168"));
        location.setLongitude(Float.valueOf("40.38401663182168"));
        location.setStatus("a");
        location.setTitle("TEST");
        location.setInsDate(new Date());
        location.setRecId(1);
        location.setNote("123");
        LOG.info("location " + location);
        return location;
    }
}
