package za.co.sbs.akhani.biometrics.repositories;


import org.springframework.test.context.ActiveProfiles;
import za.co.sbs.akhani.biometrics.configuration.RepositoryConfiguration;
import za.co.sbs.akhani.biometrics.domain.Finger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RepositoryConfiguration.class})
@ActiveProfiles({"it"})
public class FingerRepositoryTest {

    private FingerRepository fingerRepository;

    @Autowired
    public void setFingerRepository(FingerRepository fingerRepository) {
        this.fingerRepository = fingerRepository;
    }

    @Test
    public void testSaveFinger(){
        //setup finger
        Finger finger = new Finger();
        finger.setFingerprint("WWW+==");
        finger.setIdNumber("01");
        finger.setFingerIndex(2);


        //save finger, verify has ID value after save
        assertNull(finger.getId()); //null before save
        fingerRepository.save(finger);
        assertNotNull(finger.getId()); //not null after save
        //fetch from DB
        Finger fetchedFinger = fingerRepository.findById(finger.getId()).orElse(null);
        //should not be null
        assertNotNull(fetchedFinger);
        //should equal
        assertEquals(finger.getId(), fetchedFinger.getId());
        assertEquals(finger.getIdNumber(), fetchedFinger.getIdNumber());

        fetchedFinger.setIdNumber("3333");
        fingerRepository.save(fetchedFinger);
        //get from DB, should be updated
        Finger fetchedUpdatedFinger = fingerRepository.findById(fetchedFinger.getId()).orElse(null);
        assertEquals(fetchedFinger.getIdNumber(), fetchedUpdatedFinger.getIdNumber());
        //verify count of fingers in DB
        long productCount = fingerRepository.count();
        assertEquals(productCount, 1);
        //get all products, list should only have one
        Iterable<Finger> fingers = fingerRepository.findAll();
        int count = 0;
        for(Finger p : fingers){
            count++;
        }
        assertEquals(count, 1);
    }
}
