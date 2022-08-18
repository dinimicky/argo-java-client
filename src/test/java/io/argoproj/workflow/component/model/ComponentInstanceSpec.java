
package io.argoproj.workflow.component.model;

/**
 * @author ezonghu
 * @date 2022/08/09
 */
public class ComponentInstanceSpec {

    private String id;

    private String description;

    private Component component;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

}
