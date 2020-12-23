package Test;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
    Job job1;
    Job job2;
    @Before
    public void dataSetUp(){
         job1 = new Job();
         job2 = new Job();
    }
    @Test
    public void testSettingJobId(){
        assertFalse(job1.getId() == job2.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields(){
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(job.getName(),"Product tester");
        assertTrue(job.getEmployer() instanceof  Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(job.getPositionType() instanceof  PositionType);
    }
    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job1.equals(job2));
    }
}
