package mj.dbsaas.dto;

import java.sql.Timestamp;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgentEventDTO {

    private long id;
    private long tenantId;
    private long instanceId;
    private String instanceName;
    private String agentId;

    private long ts;
    private long seq;
    private String eventType;

    private String payload;

    private Timestamp createdAt;

    
}