package za.co.sbs.akhani.biometrics.api.controllers;


import lombok.extern.slf4j.Slf4j;
import za.co.sbs.akhani.biometrics.api.dto.FingerprintStatusRequest;
import za.co.sbs.akhani.biometrics.api.dto.FingerprintStatusResponse;
import za.co.sbs.akhani.biometrics.services.FingerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@RestController
@RequestMapping(path = FingerprintBiometricsController.REQUEST_MAPPING)
@Api(value="akhani online biometrics services", description="SBS Akhani online biometrics services")
@Slf4j
public class FingerprintBiometricsController {
    final static String REQUEST_MAPPING = "/api";

    @Autowired
    private FingerService service;

    @ApiOperation(value = "Verify or Enrol the fingerprint for user of the given Id")
    @PostMapping(path = "/fingerprint/enrol-verify")
    @ResponseBody
    public FingerprintStatusResponse doEnrolVerify(
            @RequestBody
            @Valid
            final FingerprintStatusRequest request) throws Exception {
        log.info("Verifying or Enrolling the Client >>>   ");
        return service.enrolVerify(request);
    }
}
