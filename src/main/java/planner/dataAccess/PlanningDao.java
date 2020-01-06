package planner.dataAccess;

import planner.Plan;

import java.util.List;

public interface PlanningDao {
    List<Plan> getPlans();
    void savePlan(Plan plan);
}
