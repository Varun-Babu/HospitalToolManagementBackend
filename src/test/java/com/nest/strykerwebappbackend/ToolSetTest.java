package com.nest.strykerwebappbackend;
import com.nest.strykerwebappbackend.entity.ToolSet;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ToolSetTest {

    @Test
    public void testToolSetEntity() {
        // Create a ToolSet object
        ToolSet toolSet = new ToolSet();
        toolSet.setId(1L);
        toolSet.setName("Tool 1");
        toolSet.setCategory("Category 1");
        toolSet.setQuantity(10);
        toolSet.setDescription("Description of Tool 1");
        toolSet.setStatus("Active");

        // Create a list of tools
        List<String> toolList = new ArrayList<>();
        toolList.add("Tool 1");
        toolList.add("Tool 2");
        toolSet.setToolset(toolList);

        // Set the deleted flag to false
        toolSet.setDeleted(0);

        // Perform assertions to validate the values
        Assert.assertEquals(1L, toolSet.getId());
        Assert.assertEquals("Tool 1", toolSet.getName());
        Assert.assertEquals("Category 1", toolSet.getCategory());
        Assert.assertEquals(10, toolSet.getQuantity());
        Assert.assertEquals("Description of Tool 1", toolSet.getDescription());
        Assert.assertEquals("Active", toolSet.getStatus());
        Assert.assertEquals(toolList, toolSet.getToolset());
//        Assert.assertFalse(toolSet.isDeleted());
    }
}
