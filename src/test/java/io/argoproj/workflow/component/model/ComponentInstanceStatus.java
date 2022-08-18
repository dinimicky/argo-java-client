
package io.argoproj.workflow.component.model;

import java.util.List;

import io.argoproj.workflow.models.Inputs;
import io.argoproj.workflow.models.Outputs;

/**
 * @author ezonghu
 * @date 2022/08/09
 */
public class ComponentInstanceStatus extends BaseStatus{

    private List<String> children;

    private Inputs inputs;

    private Outputs outputs;

}
