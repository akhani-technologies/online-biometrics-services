package za.co.sbs.akhani.biometrics.api.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Api(value="akhani online biometrics services request", description="SBS Akhani online biometrics services  request")
public class FingerprintStatusRequest extends  FingerprintStatus{
    @ApiModelProperty(notes = "The base-64 raw fingerprint data")
    private String fingerPrintData;
}
