
package io.argoproj.workflow.component.model;

import io.argoproj.workflow.models.Arguments;
import io.argoproj.workflow.models.Inputs;
import io.argoproj.workflow.models.Outputs;

/**
 * @author ezonghu
 * @date 2022/08/09
 */
public class ComponentInstance {

    private String id;

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
