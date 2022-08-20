package io.argoproj.workflow.component.model.customization;

import io.argoproj.workflow.component.model.customization.subcomponent.TrainBasic;
import io.argoproj.workflow.component.model.customization.subcomponent.TrainResource;
import io.argoproj.workflow.component.model.customization.subcomponent.TrainRun;
import io.argoproj.workflow.component.model.customization.subcomponent.TrainSuper;

/**
 * @author ezonghu
 * @date 2022/08/20
 */
public class Train {

    private TrainRun trainRun;

    private TrainBasic trainBasic;

    private TrainResource trainResource;

    private TrainSuper trainSuper;

}
