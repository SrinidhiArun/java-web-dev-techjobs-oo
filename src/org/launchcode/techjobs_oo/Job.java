package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job(){
        id = nextId;
        nextId++;
    }
    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        if(name == null && employer == null && location == null && positionType == null && coreCompetency == null){
           return "OOPS! This job does not seem to exist.";
        }else{
            StringBuilder job = new StringBuilder();
            job.append("\n"+"ID: " + id + "\n");
            job.append("Name: ");
            if(name.isEmpty()){
                job.append("Data not available");
            }else{
                job.append(name);
            }
            job.append("\n"+"Employer: ");
            job.append(checkIfEmpty(employer));
            job.append("\n"+"Location: ");
            job.append(checkIfEmpty(location));
            job.append("\n"+"Position Type: ");
            job.append(checkIfEmpty(positionType));
            job.append("\n"+"Core Competency: ");
            job.append(checkIfEmpty(coreCompetency));
            job.append("\n");
            return job.toString();
        }
    }

    public String checkIfEmpty(JobField jobField){
        if(jobField.getValue().isBlank()){
            return "Data not available";
        }
        return jobField.toString();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }
}
