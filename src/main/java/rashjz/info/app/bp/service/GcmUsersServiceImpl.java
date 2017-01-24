package rashjz.info.app.bp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rashjz.info.app.bp.dao.GcmUsersDao;
import rashjz.info.app.bp.domain.GcmUsers;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Mobby on 1/24/2017.
 */
@Service
public class GcmUsersServiceImpl implements Serializable, GcmUsersService {
    @Autowired
    private GcmUsersDao gcmUsersDao;

    @Override
    public List<GcmUsers> getAllGcmUsers() {

        return gcmUsersDao.getAllGcmUsers();
    }
}
