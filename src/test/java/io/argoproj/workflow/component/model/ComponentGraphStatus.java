package io.argoproj.workflow.component.model;

import java.time.LocalDateTime;
import java.util.Map;

import io.argoproj.workflow.models.Arguments;

/**
 * @author ezonghu
 * @date 2022/08/09
 */
public class ComponentGraphStatus extends BaseStatus{

    private Map<String, ComponentInstanceStatus> componentInstanceStatusMap;
}
