package DataAccess.Helpers;

import DataAccess.aaDTOs.aaExoBotDTO;
import java.util.ArrayList;
import java.util.List;

//Refactorización
public class DataHelperSQLiteDAO {
    private List<aaExoBotDTO> aaExobots;
    
    public DataHelperSQLiteDAO() {
        aaExobots = new ArrayList<>();
        // Datos iniciales
        aaExobots.add(new aaExoBotDTO("ExoInfanteria"));
        aaExobots.add(new aaExoBotDTO("ExoAsalto"));
    }
    
    public List<aaExoBotDTO> readAll() {
        return new ArrayList<>(aaExobots);
    }
    
    public boolean create(aaExoBotDTO entity) {
        return aaExobots.add(entity);
    }
    
    public boolean update(aaExoBotDTO entity) {
        for (int i = 0; i < aaExobots.size(); i++) {
            if (aaExobots.get(i).getAaIdExoBot() == entity.getAaIdExoBot()) {
                aaExobots.set(i, entity);
                return true;
            }
        }
        return false;
    }
}