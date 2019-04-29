package za.co.sbs.akhani.biometrics.api.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Api(value="akhani online biometrics services response", description="SBS Akhani online biometrics services response")
public class FingerprintStatusResponse extends  FingerprintStatus{
    @ApiModelProperty(notes = "The status of the action performed by User on the client ")
    private boolean success;
}
