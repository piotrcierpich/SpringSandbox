package planner.dataAccess;

import org.slf4j.Logger;
import planner.Plan;

import java.util.List;

public class NullPlanningDao implements PlanningDao {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(NullPlanningDao.class);

    public List<Plan> getPlans() {
        log.info("getting plans by null dao");
        return null;
    }

    public void savePlan(Plan plan) {
        log.info("Saving plan: {} by null dao", plan);
    }
}
