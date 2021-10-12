package sb.com.project.BL.Managers;

import sb.com.project.BL.IEntity;

public interface Manager {
    IEntity find(int id);
    boolean delete(int id);
    boolean update(int id);
    boolean add(IEntity IEntity);
}
