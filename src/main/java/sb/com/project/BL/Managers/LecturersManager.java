package sb.com.project.BL.Managers;

import sb.com.project.BL.IEntity;

import java.util.ArrayList;
import java.util.List;

public class LecturersManager implements Manager {

    private List<IEntity> lecturerList;

    public LecturersManager(){
        lecturerList = new ArrayList<>();
    }

    @Override
    public IEntity find(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update(int id) {
        return false;
    }

    @Override
    public boolean add(IEntity IEntity) {
        return false;
    }
}
