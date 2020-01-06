import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import planner.Member;
import planner.Plan;
import planner.PlanningService;
import planner.dataAccess.DbPlanningDao;
import planner.dataAccess.NullPlanningDao;
import planner.dataAccess.PlanningDao;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.*;

public class ContainerTests {
    @Test
    public void beanIsConfiguredFromXml() {
        ApplicationContext applicationContext = getClassPathXmlApplicationContext();
        PlanningService planningService = applicationContext.getBean(PlanningService.class);
        assertNotNull(planningService);
        Plan plan = getPlan();
        planningService.addPlan(plan);
    }

    @Test
    public void getBeanByTypeAndNameIsSame() {
        ApplicationContext applicationContext = getClassPathXmlApplicationContext();
        PlanningService beanByType = applicationContext.getBean(PlanningService.class);
        PlanningService beanByName = (PlanningService)applicationContext.getBean("planningService");
        assertEquals(beanByType, beanByName);
    }

    @Test
    public void getBeanByNameAndFromFactoryIsSame() {
        ApplicationContext applicationContext = getClassPathXmlApplicationContext();
        PlanningService beanByName = (PlanningService)applicationContext.getBean("planningService");
        PlanningService beanFromFactory = (PlanningService)applicationContext.getAutowireCapableBeanFactory()
                .getBean("planningService");
        assertEquals(beanFromFactory, beanByName);
    }

    @Test
    public void getAllBeansByType() {
        ApplicationContext applicationContext = getClassPathXmlApplicationContext();
        Map<String, PlanningDao> beansOfType = applicationContext.getBeansOfType(PlanningDao.class);
        assertTrue(beansOfType.containsKey("nullPlanningDao"));
        assertTrue(beansOfType.get("nullPlanningDao") instanceof NullPlanningDao);
        assertTrue(beansOfType.containsKey("dbPlanningDao"));
        assertTrue(beansOfType.get("dbPlanningDao") instanceof DbPlanningDao);
    }

    @Test
    public void getAllBeansFromObjectProvider() {
        ApplicationContext applicationContext = getClassPathXmlApplicationContext();
        List<Class<? extends PlanningDao>> planningDaoClasses = applicationContext.getAutowireCapableBeanFactory()
                .getBeanProvider(PlanningDao.class)
                .stream()
                .map(PlanningDao::getClass)
                .collect(toList());
        assertThat(planningDaoClasses, contains(NullPlanningDao.class, DbPlanningDao.class));
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
