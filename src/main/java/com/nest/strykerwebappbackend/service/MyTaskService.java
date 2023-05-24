package com.nest.strykerwebappbackend.service;

import com.nest.strykerwebappbackend.entity.ToolSet;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MyTaskService {

    String createToolset(ToolSet toolSet);
    List<ToolSet> view();
    ToolSet getById(long id);
    void delete(long id);
    ToolSet updateTool(ToolSet existingToolSet, ToolSet updatedToolSet);
    List<String> category();


}
