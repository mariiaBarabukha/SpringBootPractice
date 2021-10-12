package sb.com.project.BL.Managers;

import sb.com.project.BL.IEntity;
import sb.com.project.BL.Subject;

import java.util.ArrayList;
import java.util.List;

public class SubjectsManager implements Manager {
    private List<Subject> subjectList;

    public SubjectsManager(){
        subjectList = new ArrayList<>();
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
