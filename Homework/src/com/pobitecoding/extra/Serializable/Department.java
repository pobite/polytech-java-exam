package com.pobitecoding.Serializable;

import java.io.Serializable;

public class Department implements Serializable {
    String name;
    Employee leader;
    
    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getLeader() {
        return leader;
    }

    public void setLeader(Employee leader) {
        this.leader = leader;
    }

    @Override
    public String toString() {
        return "Department [name=" + name + ", leader=" + leader + "]";
    }
}
