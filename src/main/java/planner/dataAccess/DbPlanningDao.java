package planner.dataAccess;

import org.slf4j.Logger;
import planner.Plan;

import java.util.List;

public class DbPlanningDao implements PlanningDao {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(DbPlanningDao.class);

    @Override
    public List<Plan> getPlans() {
        log.info("getting plans from db");
        return null;
    }

    @Override
    public void savePlan(Plan plan) {
        log.info("saving plan {} to db", plan);
    }
}
