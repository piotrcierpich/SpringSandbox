import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import planner.Member;
import planner.Plan;
import planner.PlanningService;


public class XmlConfigurationContainer {

    public static void setup() {
        ApplicationContext applicationContext = getClassPathXmlApplicationContext();
        PlanningService planningService = applicationContext.getBean(PlanningService.class);
        PlanningService planningService2 = (PlanningService)applicationContext.getBean("planningService");
        Plan plan = getPlan();
        planningService.addPlan(plan);
    }

    private static ClassPathXmlApplicationContext getClassPathXmlApplicationContext() {
        return new ClassPathXmlApplicationContext("services.xml");
    }

    private static Plan getPlan() {
        Plan plan = new Plan("plan 1");
        Member member = new Member("Jon", "B");
        plan.addMember(member);
        return plan;
    }
}
