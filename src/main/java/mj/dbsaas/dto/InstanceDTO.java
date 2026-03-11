package mj.dbsaas.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InstanceDTO {

    private long instanceId;
    private long tenantId;
    private String instanceName;

    
}