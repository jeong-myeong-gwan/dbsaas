package mj.dbsaas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgentEventSearchDTO {

    private Long instanceId;
    private String type;

    
}