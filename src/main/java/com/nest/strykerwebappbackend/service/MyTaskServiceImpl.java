package com.nest.strykerwebappbackend.service;

import com.nest.strykerwebappbackend.entity.ToolSet;
import com.nest.strykerwebappbackend.exception.ResourceNotFoundException;
import com.nest.strykerwebappbackend.repository.ToolSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyTaskServiceImpl implements MyTaskService {

    @Autowired
    private ToolSetRepository toolSetRepository;
    @Lazy
    @Autowired
    private MyTaskService myTaskService;

    @Override
    public String createToolset(ToolSet toolSet) {
        if (toolSetRepository.existsByName(toolSet.getName())) {
            return toolSet.getName() + "already exists";
//            throw new IllegalArgumentException(toolSet.getName() + " as a name already exist");
        } else {
            ToolSet saved = toolSetRepository.save(toolSet);
            return toolSet.getName() + "saved";
        }
    }

    @Override
    public List<ToolSet> view() {
        return  toolSetRepository.findByDeletedFalse();
    }

    @Override
    public ToolSet getById(long id) {
        ToolSet toolSet = toolSetRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Toolset dont exist with id: " + id));
        return toolSet;
    }

    @Override
    public void delete(long id) {
        ToolSet toolSet = toolSetRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Toolset dont exist with id: " + id));
        toolSet.setDeleted(1);
        toolSetRepository.save(toolSet);
    }

    @Override
    public ToolSet updateTool(ToolSet existingToolSet, ToolSet updatedToolSet) {
        existingToolSet.setName(updatedToolSet.getName());
        existingToolSet.setQuantity(updatedToolSet.getQuantity());
        existingToolSet.setDescription(updatedToolSet.getDescription());
        existingToolSet.setCategory(updatedToolSet.getCategory());
        existingToolSet.setStatus(updatedToolSet.getStatus());
        existingToolSet.setToolset(updatedToolSet.getToolset());
        toolSetRepository.save(existingToolSet);
        return existingToolSet;
    }

    @Override
    public List<String> category() {
        return toolSetRepository.fetchCategory();
    }
}
