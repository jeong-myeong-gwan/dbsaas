package mj.dbsaas.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import mj.dbsaas.model.AgentEvent;

import java.util.ArrayList;
import java.util.List;

public class NdjsonParser {

    private final ObjectMapper om = new ObjectMapper();

    public List<AgentEvent> parse(byte[] data) throws Exception {

        String text = new String(data);

        String[] lines = text.split("\n");

        List<AgentEvent> list = new ArrayList<>();

        for(String l : lines){

            if(l.isBlank())
                continue;

            AgentEvent ev = om.readValue(l,AgentEvent.class);

            list.add(ev);

        }

        return list;
    }
}