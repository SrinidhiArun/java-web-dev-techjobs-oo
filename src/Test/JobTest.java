package Test;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
    Job job1;
    Job job2;
    Job job3;
    Job job4;
    Job job5;
    @Before
    public void dataSetUp(){
         job1 = new Job();
         job2 = new Job();
         job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
         job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
         job5 = new Job("Product tester", new Employer(" "), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

    }
    @Test
    public void testSettingJobId(){
        assertFalse(job1.getId() == job2.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields(){
        assertEquals(job3.getName(),"Product tester");
        assertTrue(job3.getEmployer() instanceof  Employer);
        assertTrue(job3.getLocation() instanceof Location);
        assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(job3.getPositionType() instanceof  PositionType);
    }
    @Test
    public void testJobsForEquality(){
        assertFalse(job3.equals(job4));
    }
    @Test
    public void testToStringForBlankLine(){
        String jobDescription = job3.toString();
        String[] jobFirstLine = jobDescription.split("ID:");
        int lastLine = jobDescription.lastIndexOf("\n");
        assertEquals("\n",jobFirstLine[0]);
        assertEquals(jobDescription.length()-1,lastLine);
    }
    @Test
    public void testToStringForFields(){
        String jobDescription = job3.toString();
        String[] jobFields = (jobDescription.trim()).split("\n");
        assertEquals(6,jobFields.length);

        String[] fieldNames = new String[]{"ID","Name","Employer","Location","Position Type","Core Competency"};
        for(int i=0; i<jobFields.length; i++) {
            String[] idField = jobFields[i].split(":");
            assertEquals(fieldNames[i], idField[0]);
            assertFalse(idField[1].isBlank());
        }

    }
    @Test
    public void testToStringForEmptyFields(){
        String jobDetails = job5.toString();
        String[] jobFields = (jobDetails.trim()).split("\n");
        String[] employerField = jobFields[2].split(":");
        assertEquals(" Data not available",employerField[1]);

    }
    @Test
    public void testToStringForJobWithOnlyId(){
        String jobDetails = job1.toString();
        assertEquals("OOPS! This job does not seem to exist.",jobDetails);
    }
}
