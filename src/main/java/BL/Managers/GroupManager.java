package BL.Managers;

import BL.IEntity;

import java.util.ArrayList;
import java.util.List;

public class GroupManager implements Manager {

    public List<IEntity> groupList;
    public GroupManager(){
        groupList = new ArrayList<>();
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
        groupList.add(IEntity);
        return true;
    }
}
