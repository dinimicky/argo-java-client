package io.argoproj.workflow.component.model;

import java.util.Map;

import io.argoproj.workflow.models.Arguments;

/**
 * @author ezonghu
 * @date 2022/08/09
 */
public class ComponentGraph {

    private String name;

    private String description;

    private Map<String, ComponentInstance> componentInstanceMap;

    private Arguments arguments;

    /**
     * component argument key format:
     * <NodeType>.<NodeName>.<AttrType>.<subAttrType>.<attrName>
     * eg.
     * {{tasks.flip-coin.outputs.result}}
     *
     */
    private Map<String, String> componentArgumentRelationship;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, ComponentInstance> getComponentInstanceMap() {
        return componentInstanceMap;
    }

    public void setComponentInstanceMap(
        Map<String, ComponentInstance> componentInstanceMap) {
        this.componentInstanceMap = componentInstanceMap;
    }

    public Arguments getArguments() {
        return arguments;
    }

    public void setArguments(Arguments arguments) {
        this.arguments = arguments;
    }

    public Map<String, String> getComponentArgumentRelationship() {
        return componentArgumentRelationship;
    }

    public void setComponentArgumentRelationship(Map<String, String> componentArgumentRelationship) {
        this.componentArgumentRelationship = componentArgumentRelationship;
    }
}
