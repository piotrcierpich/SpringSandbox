package planner;

import java.util.ArrayList;
import java.util.List;

public class Plan {
    private final String name;
    private final List<Member> members;

    public Plan(String name) {
        this.name = name;
        members = new ArrayList<Member>();
    }

    public void addMember(Member member) {
        members.add(member);
    }

    @Override
    public String toString() {
        return "Plan{" +
                "name='" + name + '\'' +
                ", members=" + members +
                '}';
    }
}
