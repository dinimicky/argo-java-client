package io.argoproj.workflow.component.model;

import io.argoproj.workflow.models.Arguments;
import io.argoproj.workflow.models.Inputs;
import io.argoproj.workflow.models.Outputs;
import io.argoproj.workflow.models.Template;

/**
 * @author ezonghu
 * @date 2022/08/09
 */
public class Component {

    private Inputs inputs;

    private Outputs outputs;

    private Arguments arguments;

    private String version = "v0.0.0";

    // type: exec | conf
    private String type = "exec";

    private String name;

    public Inputs getInputs() {
        return inputs;
    }

    public void setInputs(Inputs inputs) {
        this.inputs = inputs;
    }

    public Outputs getOutputs() {
        return outputs;
    }

    public void setOutputs(Outputs outputs) {
        this.outputs = outputs;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Arguments getArguments() {
        return arguments;
    }

    public void setArguments(Arguments arguments) {
        this.arguments = arguments;
    }
}
