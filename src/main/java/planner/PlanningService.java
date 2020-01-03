package planner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlanningService {
    private final Logger logger = LoggerFactory.getLogger(PlanningService.class);
    private PlanningDao planningDao;

    public PlanningService(PlanningDao planningDao) {
        this.planningDao = planningDao;
    }

    public void addPlan(Plan plan) {
        logger.info("Saving plan: {}", plan);
        planningDao.savePlan(plan);
    }
}
