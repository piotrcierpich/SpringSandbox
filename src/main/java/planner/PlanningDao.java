package planner;

import org.slf4j.Logger;

import java.util.List;

public class PlanningDao {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(PlanningDao.class);

    public List<Plan> getPlans() {
        return null;
    }

    public void savePlan(Plan plan) {
        log.info("Saving plan: {}", plan);
    }
}
