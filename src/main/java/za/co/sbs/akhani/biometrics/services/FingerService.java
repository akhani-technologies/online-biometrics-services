package za.co.sbs.akhani.biometrics.services;


import za.co.sbs.akhani.biometrics.api.dto.FingerprintStatus;
import za.co.sbs.akhani.biometrics.api.dto.FingerprintStatusRequest;
import za.co.sbs.akhani.biometrics.api.dto.FingerprintStatusResponse;
import za.co.sbs.akhani.biometrics.domain.Finger;
import za.co.sbs.akhani.biometrics.repositories.FingerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class FingerService {

    @Autowired
    private FingerRepository fingerRepository;


    public String getFingerprint(final String idNumber){

        Finger finger = fingerRepository
                .findByIdNumber(idNumber)
                .orElseThrow(() -> new UsernameNotFoundException(idNumber + " not found in records"));

        return  finger.getFingerprint();
    }

    public FingerprintStatusResponse enrolVerify(final FingerprintStatusRequest request){
        Finger finger;

        FingerprintStatusResponse response = new FingerprintStatusResponse();
        response.setAction(request.getAction());
        response.setIdNumber(request.getIdNumber());

        if (request.getAction() == FingerprintStatus.FingerprintAction.ENROL){
            finger = new Finger();
            finger.setIdNumber(request.getIdNumber());
//            finger.setFingerIndex(request.getFingerIndex);
            finger.setFingerIndex(1);
            finger.setFingerprint(request.getFingerPrintData());

            fingerRepository.save(finger);

            response.setSuccess(true);
        }
        else {

        }

        return  response;
    }

    public FingerprintStatusResponse verifyClient(final FingerprintStatusRequest request){

        return  null;
    }

    public FingerprintStatusResponse enrolClient( final FingerprintStatusRequest request){

        return  null;
    }
}
