package za.co.sbs.akhani.biometrics.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class FingerprintStatus {
    @ApiModelProperty(notes = "The Id Number of the client")
    protected String idNumber;
    @ApiModelProperty(notes = "The user action, ENROL or VERIFY the  fingerprint")
    protected FingerprintAction action ;

    public static  enum  FingerprintAction{
        ENROL,VERIFY
    }
}
